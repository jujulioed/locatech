package br.com.jujulioed.locatech.locatech.controllers;

import br.com.jujulioed.locatech.locatech.entities.Veiculo;
import br.com.jujulioed.locatech.locatech.services.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }


    // Using query params: http://localhost:8080/veiculos?page=1&size=10 => page = 1, size = 10
    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("Foi acessado o endpoint de veiculos /veiculos");
        var veiculos = this.veiculoService.findAllVeiculos(page, size);
        return ResponseEntity.ok(veiculos);
    }

    // http://localhost:8080/veiculos/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findVeiculo(
            @PathVariable("id") Long id
    ) {
        logger.info("/veiculos/" + id);
        var veiculo = this.veiculoService.findVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }
}


