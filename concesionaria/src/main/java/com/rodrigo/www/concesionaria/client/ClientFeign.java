package com.rodrigo.www.concesionaria.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "carros", url = "localhost:8001")
public interface ClientFeign {
}
