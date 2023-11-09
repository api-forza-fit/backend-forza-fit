package com.forza.forzafit.service;

import com.forza.forzafit.model.Registro;
import com.forza.forzafit.repository.RegistroRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public Registro createRegistro(Registro registro) {
        return this.registroRepository.save(registro);
    }


}
