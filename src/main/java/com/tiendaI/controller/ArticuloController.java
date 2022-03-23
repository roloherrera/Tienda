package com.tiendaI.controller;

import com.tiendaI.domain.Articulo;
import com.tiendaI.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);

        model.addAttribute("articulos", articulos);

        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo) {

        return "/articulo/modifica";
    }
    
    
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
    articulo = articuloService.getArticulo(articulo);
    model.addAttribute("articulo",articulo);
    return "articulo/modifica";
}
    
        @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo, Model model) {
     articuloService.delete(articulo);
    return "redirect:/articulo/listado";

}
    
}
