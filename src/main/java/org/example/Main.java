package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                ArrayList<cabinaTelefonica>cabinas = new ArrayList<>();
                int opcion;

                do {
                    System.out.println("1. Crear cabina telefónica");
                    System.out.println("2. Registrar llamada");
                    System.out.println("3. Mostrar información de cabina");
                    System.out.println("4. Mostrar consolidado total");
                    System.out.println("5. Reiniciar cabina");
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            cabinas.add(new cabinaTelefonica(cabinas.size() + 1));
                            System.out.println("Cabina creada\n");
                            break;
                        case 2:
                            if (cabinas.isEmpty()) {
                                System.out.println("No hay cabinas disponibles\n");
                                break;
                            }
                            System.out.print("Seleccione la cabina (1 - " + cabinas.size() + "): ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            if (id < 1 || id > cabinas.size()) {
                                System.out.println("Cabina no válida\n");
                                break;
                            }
                            System.out.print("Ingrese tipo de llamada (local, larga distancia, celular): ");
                            String tipo = scanner.nextLine();
                            System.out.print("Ingrese duración en minutos: ");
                            int minutos = scanner.nextInt();
                            cabinas.get(id - 1).registrarLlamada(tipo, minutos);
                            System.out.println("Llamada registrada\n");
                            break;
                        case 3:
                            if (cabinas.isEmpty()) {
                                System.out.println("No hay cabinas registradas\n");
                                break;
                            }
                            System.out.print("Seleccione la cabina (1 - " + cabinas.size() + "): ");
                            int cabinaId = scanner.nextInt();
                            if (cabinaId < 1 || cabinaId > cabinas.size()) {
                                System.out.println("Cabina no válida\n");
                                break;
                            }
                            cabinas.get(cabinaId - 1).mostrarInformacion();
                            break;
                        case 4:
                            int totalCosto = 0, totalMinutos = 0, totalLlamadas = 0;
                            for (cabinaTelefonica c : cabinas) {
                                totalCosto += c.calcularCostoTotal();
                                totalMinutos += c.getTotalMinutos();
                                totalLlamadas += c.getTotalLlamadas();
                            }
                            System.out.println("registro total:");
                            System.out.println("Total llamadas: " + totalLlamadas);
                            System.out.println("Total minutos: " + totalMinutos);
                            System.out.println("Costo total: " + totalCosto + "\n");
                            break;
                        case 5:
                            System.out.print("Seleccione la cabina a reiniciar (1 - " + cabinas.size() + "): ");
                            int reinicioId = scanner.nextInt();
                            if (reinicioId < 1 || reinicioId > cabinas.size()) {
                                System.out.println("Cabina no válida\n");
                                break;
                            }
                            cabinas.get(reinicioId - 1).reiniciarCabina();
                            System.out.println("Cabina reiniciada con éxito\n");
                            break;

                        default:
                            System.out.println("Opción no válida\n");
                    }
                } while (opcion != 5);
                scanner.close();
    }
}