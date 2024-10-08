package com.mycompany.cg22079.poo.guia02;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        // Configurar la consola para usar UTF-8 y mostrar caracteres especiales
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("No se pudo configurar la consola para UTF-8: " + e.getMessage());
        }

        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int option;

        do {
            System.out.println("=== GESTIÓN DE PRODUCTOS ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Modificar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    agregarProducto(manager, scanner);
                    break;
                case 2:
                    manager.showAllProducts();
                    break;
                case 3:
                    modificarProducto(manager, scanner);
                    break;
                case 4:
                    eliminarProducto(manager, scanner);
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de gestión de productos!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (option != 5);
        manager.closeWriter();
        scanner.close();
    }

    public static void agregarProducto(ProductManager manager, Scanner scanner) {
        System.out.println("Seleccione el tipo de producto a agregar:");
        System.out.println("1. Producto Fresco");
        System.out.println("2. Producto Refrigerado");
        System.out.println("3. Producto Congelado por Agua");
        System.out.println("4. Producto Congelado por Aire");
        System.out.println("5. Producto Congelado por Nitrógeno");
        System.out.println("6. Producto Envasado");
        int tipoProducto = obtenerEntero(scanner, "Opción: ");

        switch (tipoProducto) {
            case 1:
                manager.addFreshProducts(1);
                break;
            case 2:
                manager.addRefrigeratedProducts(1);
                break;
            case 3:
                manager.addFrozenByWaterProducts(1);
                break;
            case 4:
                manager.addFrozenByAirProducts(1);
                break;
            case 5:
                manager.addFrozenByNitrogenProducts(1);
                break;
            case 6:
                manager.addPackagedProducts(1);
                break;
            default:
                System.out.println("Tipo de producto no válido.");
                break;
        }
    }

    public static void modificarProducto(ProductManager manager, Scanner scanner) {
        int id = obtenerEntero(scanner, "Ingrese el ID del producto a modificar: ");
        manager.updateProduct(id, scanner);
    }

    public static void eliminarProducto(ProductManager manager, Scanner scanner) {
        int id = obtenerEntero(scanner, "Ingrese el ID del producto a eliminar: ");
        manager.deleteProduct(id);
    }

    // Método auxiliar para obtener un entero con validación
    private static int obtenerEntero(Scanner scanner, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea restante
                break;
            } else {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }
        return valor;
    }

    
}
