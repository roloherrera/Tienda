package com.tiendaI.controller;

import com.tiendaI.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");

        var articulos = articuloService.getArticulos(true);

        model.addAttribute("articulos", articulos);

        return "index";
    }  
}
