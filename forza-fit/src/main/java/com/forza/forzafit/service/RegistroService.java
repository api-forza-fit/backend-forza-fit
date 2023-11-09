package com.forza.forzafit.service;

import com.forza.forzafit.model.Registro;
import com.forza.forzafit.repository.RegistroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public Registro createRegistro(Registro registro) {
        return this.registroRepository.save(registro);
    }

    public List<Registro> getAllRegistros(){
        return registroRepository.findAll();
    }

    public void deleteRegistro(Long id){
        this.registroRepository.deleteById(id);
    }

}
