package com.rodrigo.www.carros.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "concesionaria", url = "localhost:8000")
public interface ClientFeign {
}
