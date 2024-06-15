package org.example.controller;

import org.example.service.NominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NominaController {

    private final NominaService nominaService;

    @Autowired
    public NominaController(NominaService nominaService) {
        this.nominaService = nominaService;
    }

    @GetMapping("/nextPayDate/{inputDate}")
    public String getNextPayDate(@PathVariable String inputDate) {
        return nominaService.nextPayDate(inputDate);
    }
}