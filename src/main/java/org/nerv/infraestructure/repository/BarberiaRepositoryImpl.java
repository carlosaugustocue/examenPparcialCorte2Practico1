package org.nerv.infraestructure.repository;

import org.nerv.domain.Barberia;
import org.nerv.interfaces.BarberiaRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BarberiaRepositoryImpl implements BarberiaRepository {
    private static final String ARCHIVO = "barberias.dat";
    private List<Barberia> barberias;

    @SuppressWarnings("unchecked")
    public BarberiaRepositoryImpl() {
        barberias = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            barberias = (List<Barberia>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardar(Barberia barberia) {
        barberias.add(barberia);
        guardarEnArchivo();
    }

    @Override
    public Barberia obtenerPorId(int id) {
        return barberias.stream()
                .filter(barberia -> barberia.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Barberia> obtenerTodos() {
        return new ArrayList<>(barberias);
    }

    @Override
    public void actualizar(Barberia barberiaActualizada) {
        Barberia barberia = obtenerPorId(barberiaActualizada.getId());
        if (barberia != null) {
            barberia.setNombre(barberiaActualizada.getNombre());
            barberia.setDireccion(barberiaActualizada.getDireccion());
            guardarEnArchivo();
        }
    }

    @Override
    public void eliminar(int id) {
        barberias.removeIf(barberia -> barberia.getId() == id);
        guardarEnArchivo();
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(barberias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
