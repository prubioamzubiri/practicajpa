package com.cursojava93.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.cursojava93.demo.dominio.Alumno;
import com.cursojava93.demo.dominio.Nota;
import com.cursojava93.demo.persistencia.AlumnoJPARepository;
import com.cursojava93.demo.persistencia.NotaJpaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {

    Logger logger = LoggerFactory.getLogger(AlumnoController.class);

    @Autowired
    private AlumnoJPARepository alumnoRepository;

    @Autowired
    private NotaJpaRepository notaRepository;

    @GetMapping()
    public String lista(Model modelo) {
        List<Alumno> alumnos = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", alumnos);
        return "alumnos/listado";

    }

    @PostMapping("/create")
    public String newCreateUser(@Valid Alumno persona, BindingResult result, Model model) {
        model.addAttribute("alumno", persona);
        String template = "";
        if (result.hasErrors()){
            template  =  "form";
        }else {
            template  = "alumnoReady";
        }
        return template;
    }

    @GetMapping("/insert")
    public String insert(Model modelo) {
        Integer actualSize= alumnoRepository.findAll().size();
        logger.trace("/mvc/insert: actualSize="+actualSize);
        if ( actualSize.equals(0)){

            Alumno alumno = new Alumno();
            alumno.setNombre("Terry Pratchett");
            //autorRepository.save(autor);
           Nota nota = new Nota();
            nota.setAsignatura("El color de la magia");
            nota.setAño(2020);
            nota.setNota(5);
            //libroRepository.save(libro);
            alumno.getNotas().add(nota);
            alumnoRepository.save(alumno);
            System.out.println("/mvc/insert: alumno="+alumno);
        }
        List<Alumno> listado = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", listado);
        return "alumnos/listado";

    }

    // @GetMapping("/show/{id}")
    // public String insert(Model modelo, @PathVariable("id") Long id) {
    //     Optional<Autor> autor = this.autorRepository.findById(id);
    //     if (autor.isPresent()){
    //         Autor autorRegistry = autor.get();
    //         logger.trace(autorRegistry.toString());
    //         modelo.addAttribute("autor", autor.get());
    //     }else{
    //         modelo.addAttribute("autor", new Autor());
    //     }

    //     return "autores/show";

    // }

    // @GetMapping("/update/{id}")
    // public String udpate(Model modelo, @PathVariable("id") Long id) {
    //     Optional<Autor> autor = this.autorRepository.findById(id);
    //     if (autor.isPresent()){
    //         Autor autorRegistry = autor.get();
    //         logger.trace(autorRegistry.toString());
    //         autorRegistry.setNombre("Neil Gayman");
    //         autorRegistry.getLibros().get(0).setTitle("Buenos Presagios");
    //         autorRepository.save(autorRegistry);
    //         modelo.addAttribute("autor", autorRegistry);
    //     }else{
    //         modelo.addAttribute("autor", new Autor());
    //     }
    //     return "autores/show";

    // }

    // @GetMapping("/delete/{id}")
    // public String delete(Model modelo, @PathVariable("id") Long id) {
    //     Optional<Autor> autor = this.autorRepository.findById(id);

    //     if (autor.isPresent()){
    //         Autor autorRegistry = autor.get();
    //         logger.trace(autorRegistry.toString());
    //         autorRepository.delete(autorRegistry);
    //         modelo.addAttribute("autor", autorRegistry);
    //     }else{
    //         modelo.addAttribute("autor", new Autor());
    //     }

    //     return "autores/show";

    // }



    
}
