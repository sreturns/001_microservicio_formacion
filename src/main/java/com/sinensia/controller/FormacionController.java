package com.sinensia.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.model.Formacion;
import com.sinensia.service.FormacionService;

/**
 * RestController para realizar nuestros metodos Http
 *
 * @author Sergio
 * @see com.sinensia.dto.CursoDTO
 * @see com.sinensia.service.FormacionServiceImpl
 * @see com.sinensia.service.FormacionService
 * @see com.sinensia.inicio.Application
 */
@RestController
public class FormacionController {

    /**
     * Inyectamos nuestra interfaz del servicio
     */
    @Autowired
    FormacionService service;

    /**
     * @return List<Formacion>
     */
    @GetMapping(value = "formacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formacion>> getAll() {
        List<Formacion> formaciones = service.getAll();

        if (formaciones.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(formaciones);
    }

    /**
     * @param formacion
     * @return List<Formacion>
     */
    @PostMapping(value = "formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formacion>> save(@RequestBody Formacion formacion) {
        try {
            List<Formacion> formaciones = service.save(formacion);
            return ResponseEntity.ok(formaciones);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonList(new Formacion("No valido (null)", 0, 0)));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
