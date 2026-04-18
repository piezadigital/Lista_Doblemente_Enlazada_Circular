public class ListaDobleCircular {

    private Nodo head;

    public ListaDobleCircular() {
        this.head = null;
    }

    public boolean estaVacia() {
        return head == null;
    }

    //Insertar al inicio
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            head = nuevoNodo; // Actualizar el head al nuevo nodo
        } else {
            Nodo ultimo = head.anterior;
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = ultimo;
            ultimo.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
            head = nuevoNodo; // Actualizar el head al nuevo nodo
        }
    }

    //Insertar al final
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            head = nuevoNodo; // Actualizar el head al nuevo nodo
        } else {
            Nodo ultimo = head.anterior;
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = ultimo;
            ultimo.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
        }
    }

    //Eliminar al inicio
    public void eliminarAlInicio() {
        if (estaVacia()) {
            System.out.println("Error: lista vacía.");
            return;
        }
        if (head.siguiente == head) { // Solo un nodo
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            head = head.siguiente;
            head.anterior = ultimo;
            ultimo.siguiente = head;
        }
        return;
    }

    //Eliminar al final
    public void eliminarAlFinal() {
        if (estaVacia()) {
            System.out.println("Error: lista vacía.");
            return;
        }
        if (head.siguiente == head) { // Solo un nodo
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            Nodo penultimo = ultimo.anterior;
            penultimo.siguiente = head;
            head.anterior = penultimo;
        }
        return;
    }

    //Buscar un elemento
    public void buscarElemento(int dato) {
        if (estaVacia()) {
            System.out.println("No encontrado");
            return;
        }
        Nodo actual = head;
        do {
            if (actual.dato == dato) {
                System.out.println("Encontrado");
                return;
            }
            actual = actual.siguiente;
        } while (actual != head);
        System.out.println("No encontrado");
    }

    public void imprimir() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Nodo actual = head;
        System.out.print("Lista: ");
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != head);
        System.out.println("(circular -> " + head.dato + ")");
    }
}