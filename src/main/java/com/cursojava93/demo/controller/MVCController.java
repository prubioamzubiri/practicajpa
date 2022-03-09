package com.cursojava93.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/mvc")
public class MVCController {
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private final List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
    @GetMapping()
    public String main(Model model) {
        String cadena = "Valor Cadena";
        model.addAttribute("cadena", cadena);
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }

    @GetMapping("/params/{id}")
    public String cogeParametros(@PathVariable("id") String id, Model model){
        model.addAttribute("id",id);
        return "params";
    }
    @GetMapping("/params/{id}/{otro}")
    public String cogeDosParametros(
            @PathVariable("id") String id,
            @PathVariable("otro") Long otro,
            Model model){
        model.addAttribute("id",id);
        model.addAttribute("numero",otro);
        return "dosparams";
    }
    @PostMapping()
    public String miPost(Model model, @RequestParam("id") String id){
        model.addAttribute("id",id);
        return "params";
    }
}
