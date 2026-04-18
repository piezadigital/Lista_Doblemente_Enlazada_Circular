import java.util.Scanner;

public class Main {

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Error: debe ingresar un número entero.");
                sc.next(); // limpia entrada incorrecta
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDobleCircular lista = new ListaDobleCircular();
        int opcion, dato;

        do {
            System.out.println("\n==============================================");
            System.out.println("\n LISTA DOBLEMENTE ENLAZADA CIRCULAR      ");
            System.out.println("\n==============================================");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Eliminar al inicio");
            System.out.println("4. Eliminar al final");
            System.out.println("5. Buscar un elemento");
            System.out.println("6. Imprimir lista");
            System.out.println("0. Salir");

            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    dato = leerEntero(sc, "Ingrese el dato: ");
                    lista.insertarAlInicio(dato);
                    lista.imprimir();
                    break;

                case 2:
                    dato = leerEntero(sc, "Ingrese el dato: ");
                    lista.insertarAlFinal(dato);
                    lista.imprimir();
                    break;

                case 3:
                    lista.eliminarAlInicio();
                    lista.imprimir();
                    break;

                case 4:
                    lista.eliminarAlFinal();
                    lista.imprimir();
                    break;

                case 5:
                    dato = leerEntero(sc, "Ingrese el dato: ");
                    lista.buscarElemento(dato);
                    break;

                case 6:
                    lista.imprimir();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
            }

        } while (opcion != 0);

        sc.close();
    }
}