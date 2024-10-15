package org.nerv;

import org.nerv.application.service.BarberiaService;
import org.nerv.application.service.BarberiaServiceImpl;
import org.nerv.domain.Barberia;
import org.nerv.infraestructure.repository.BarberiaRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        BarberiaService barberiaService = new BarberiaServiceImpl(new BarberiaRepositoryImpl());

        // Registrar nuevas barberías
        Barberia barberia1 = new Barberia(1, "Barbería Central", "Calle Principal 123");
        Barberia barberia2 = new Barberia(2, "Barbería Moderna", "Avenida 45");

        barberiaService.registrarBarberia(barberia1);
        barberiaService.registrarBarberia(barberia2);

        // Listar todas las barberías
        System.out.println("Lista de todas las barberías:");
        barberiaService.listarBarberias().forEach(System.out::println);

        // Buscar una barbería por ID
        System.out.println("\nBuscar barbería con ID 1:");
        System.out.println(barberiaService.buscarBarberia(1));

        // Modificar una barbería
        barberia1.setDireccion("Nueva Calle 456");
        barberiaService.modificarBarberia(barberia1);

        // Eliminar una barbería
        barberiaService.eliminarBarberia(2);

        // Listar barberías después de la eliminación
        System.out.println("\nLista de barberías después de eliminar la barbería con ID 2:");
        barberiaService.listarBarberias().forEach(System.out::println);
    }
}