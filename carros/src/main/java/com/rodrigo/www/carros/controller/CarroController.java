package com.rodrigo.www.carros.controller;

import com.rodrigo.www.carros.model.Carro;
import com.rodrigo.www.carros.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CarroController {

    private final CarroService service;
    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Carro> listar(){
        return service.listarCarros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<Carro> optional = service.buscarPorId(id);
        if (optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Carro carro, BindingResult result){
        if (result.hasErrors()){
            return validarErrores(result);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(carro));
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Carro carro, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()){
            return validarErrores(result);
        }
        Optional<Carro> optional = service.buscarPorId(id);
        if (optional.isPresent()){
            Carro carroData = optional.get();
            carroData.setMarca(carro.getMarca());
            carroData.setModelo(carro.getModelo());
            carroData.setAno(carro.getAno());
            carroData.setColor(carro.getColor());

            return ResponseEntity.status(HttpStatus.OK).body(service.guardar(carro));

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Carro> optional = service.buscarPorId(id);
        if (optional.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Metodo para validar errores
    private static ResponseEntity<Map<String, String>> validarErrores (BindingResult result) {
        Map<String, String> errores = result.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

        return ResponseEntity.badRequest().body(errores);
    }
} // fin de la clase
