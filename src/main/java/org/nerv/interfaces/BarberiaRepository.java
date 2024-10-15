package org.nerv.interfaces;

import org.nerv.domain.Barberia;
import java.util.List;

public interface BarberiaRepository {
    void guardar(Barberia barberia);
    Barberia obtenerPorId(int id);
    List<Barberia> obtenerTodos();
    void actualizar(Barberia barberia);
    void eliminar(int id);
}