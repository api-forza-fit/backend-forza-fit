package com.forza.forzafit.service;

import com.forza.forzafit.model.Registro;
import com.forza.forzafit.repository.RegistroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RegistroServiceTest {

    @Mock
    private RegistroRepository registroRepository;

    @InjectMocks
    private RegistroService registroService;

    private Registro registro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        LocalDate local = LocalDate.now();
        java.util.Date fecha = new Date();
        registro = new Registro(0L,"NombrePrueba", "30",fecha);
    }

    @Test
    void findAll(){
        when(registroRepository.findAll()).thenReturn(Arrays.asList(registro));
        assertNotNull(registroService.getAllRegistros());
    }

    @Test
    void createRegistro(){
        when(registroRepository.save(any(Registro.class))).thenReturn(registro);

        // Llamar al método del servicio que crea el registro
        Registro resultado = registroService.createRegistro(registro);

        // Verificar que se llamó al método save del repositorio con el registro correcto
        verify(registroRepository, times(1)).save(eq(registro));

        // Verificar que el resultado no es nulo
        assertNotNull(resultado);
    }

    @Test
    void updateRegistro() {
        // Crear un objeto de prueba
        Registro registro = new Registro(/* proporciona los datos necesarios para el registro */);

        // Configurar el comportamiento esperado del repositorio mock
        when(registroRepository.save(any(Registro.class))).thenReturn(registro);

        // Llamar al método del servicio que actualiza el registro
        Registro resultado = registroService.updateRegistro(registro);

        // Verificar que se llamó al método save del repositorio con el registro correcto
        verify(registroRepository, times(1)).save(eq(registro));

        // Verificar que el resultado no es nulo
        assertNotNull(resultado);
    }

    @Test
    void deleteRegistro() {
        long idRegistro = 1L; // Proporciona el ID del registro que deseas eliminar

        // Llamar al método del servicio que elimina el registro
        registroService.deleteRegistro(idRegistro);

        // Verificar que se llamó al método deleteById del repositorio con el ID correcto
        verify(registroRepository, times(1)).deleteById(eq(idRegistro));
    }

}
