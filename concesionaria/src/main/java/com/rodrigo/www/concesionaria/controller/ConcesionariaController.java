package com.rodrigo.www.concesionaria.controller;

import com.rodrigo.www.concesionaria.entity.Concesionaria;
import com.rodrigo.www.concesionaria.service.ConcesionariaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ConcesionariaController {

    private final ConcesionariaService service;
    public ConcesionariaController(ConcesionariaService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Concesionaria> listar() {
        return service.listarTodo();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<Concesionaria> optional = service.BuscarPorId(id);
        if (optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/buscar")
    public ResponseEntity<?> buscaroPorNombre(@RequestParam String nombre) {
        Optional<Concesionaria> optional = service.findConcesionariasByName(nombre);
        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Concesionaria concesionaria, BindingResult result){
        if (result.hasErrors()){
            return validarErrores(result);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(concesionaria));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Concesionaria concesionaria, BindingResult result, @PathVariable Long id){
        if (result.hasErrors()){
            return validarErrores(result);
        }
        Optional<Concesionaria> optional = service.BuscarPorId(id);
        if(optional.isPresent()){
            Concesionaria concesionariaData = optional.get();
            concesionariaData.setName(concesionaria.getName());

            return ResponseEntity.status(HttpStatus.OK).body(service.guardar(concesionariaData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Concesionaria> optional = service.BuscarPorId(id);
        if (optional.isPresent()){
            service.eliminar(id);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // metodo para buscar errores
    private static ResponseEntity<Map<String, String>> validarErrores (BindingResult result) {
        Map<String, String> errores = result.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

        return ResponseEntity.badRequest().body(errores);
    }
} // fin de la clase
