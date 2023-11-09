package com.forza.forzafit.controller;

import com.forza.forzafit.exception.ValidationException;
import com.forza.forzafit.model.Registro;
import com.forza.forzafit.service.RegistroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RegistroController {


    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    //Endpoint: http://localhost:8080/api/v1/registros
    //Method: POST
    @PostMapping("/registros")
    public ResponseEntity<Registro> createRegistro(@RequestBody Registro registro) {
        validateCreate(registro);
        return new ResponseEntity<Registro>(this.registroService.createRegistro(registro), HttpStatus.CREATED);
    }

    private void validateCreate(Registro registro) {
        if (registro.getName() == null || registro.getName().trim().isEmpty())
            throw new ValidationException("El nombre del alimento es obligatorio");
        if (registro.getName().length() > 30)
            throw new ValidationException("El nombre del empleado no debe exceder los 30 caracteres");
        if (registro.getCantidad() == null || registro.getCantidad().trim().isEmpty())
            throw new ValidationException("Debe ingresar una cantidad obligatoria");
    }


    //Endopint (url): http://localhost:8080/api/v1/registros
    //Method: GET
    @GetMapping("/registros")
    public ResponseEntity<List<Registro>> getAllRegistros() {
        return new ResponseEntity<List<Registro>>(this.registroService.getAllRegistros(), HttpStatus.OK);
    }

    //Endopint (url): http://localhost:8080/api/v1/registros
    //Method: GET
    @DeleteMapping("/registros/{id}")
    public ResponseEntity<?> deteleRegistro(@PathVariable Long id) {
        this.registroService.deleteRegistro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
