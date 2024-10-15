package org.nerv.application.service;

import org.nerv.domain.Barberia;
import org.nerv.interfaces.BarberiaRepository;

import java.util.List;

public class BarberiaServiceImpl implements BarberiaService {
    private BarberiaRepository barberiaRepository;

    public BarberiaServiceImpl(BarberiaRepository barberiaRepository) {
        this.barberiaRepository = barberiaRepository;
    }

    @Override
    public void registrarBarberia(Barberia barberia) {
        barberiaRepository.guardar(barberia);
    }

    @Override
    public Barberia buscarBarberia(int id) {
        return barberiaRepository.obtenerPorId(id);
    }

    @Override
    public List<Barberia> listarBarberias() {
        return barberiaRepository.obtenerTodos();
    }

    @Override
    public void modificarBarberia(Barberia barberia) {
        barberiaRepository.actualizar(barberia);
    }

    @Override
    public void eliminarBarberia(int id) {
        barberiaRepository.eliminar(id);
    }
}
