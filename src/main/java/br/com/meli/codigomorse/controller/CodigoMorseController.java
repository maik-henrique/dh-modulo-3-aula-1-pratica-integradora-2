package br.com.meli.codigomorse.controller;

import br.com.meli.codigomorse.service.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/codigo-morse")
public class CodigoMorseController {

    @Autowired
    private CodigoMorseService codigoMorseService;

    @GetMapping
    public ResponseEntity<?> getParalavra(@RequestParam String codigoMorse) {
        String palavra = codigoMorseService.getPalavra(codigoMorse);
        return ResponseEntity.ok(palavra);
    }
}
