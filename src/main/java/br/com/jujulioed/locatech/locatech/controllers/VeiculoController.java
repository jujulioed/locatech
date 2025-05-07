package br.com.jujulioed.locatech.locatech.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @GetMapping
    public String getVeiculos(){
        return "Hello veiculo!";
    }
}
