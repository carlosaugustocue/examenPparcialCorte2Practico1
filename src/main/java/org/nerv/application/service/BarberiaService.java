package org.nerv.application.service;

import org.nerv.domain.Barberia;
import java.util.List;

public interface BarberiaService {
    void registrarBarberia(Barberia barberia);
    Barberia buscarBarberia(int id);
    List<Barberia> listarBarberias();
    void modificarBarberia(Barberia barberia);
    void eliminarBarberia(int id);
}