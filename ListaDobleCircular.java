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
            head = nuevoNodo;
        } else {
            Nodo tail = head.anterior;
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = tail;
            tail.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
            head = nuevoNodo; // Actualizar el head al nuevo nodo
        }
    }

    //Insertar al final
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            head = nuevoNodo;
        } else {
            Nodo tail = head.anterior;
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = tail;
            tail.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
        }
    }

    //Eliminar al inicio
    public boolean eliminarAlInicio() {
        if (estaVacia()) {
            return false;
        }
        if (head.siguiente == head) { // Solo un nodo
            head = null;
        } else {
            Nodo tail = head.anterior;
            head = head.siguiente;
            head.anterior = tail;
            tail.siguiente = head;
        }
        return true;
    }

    //Eliminar al final
    public boolean eliminarAlFinal() {
        if (estaVacia()) {
            return false;
        }
        if (head.siguiente == head) { // Solo un nodo
            head = null;
        } else {
            Nodo tail = head.anterior;
            Nodo penultimo = tail.anterior;
            penultimo.siguiente = head;
            head.anterior = penultimo;
        }
        return true;
    }

    //Buscar un elemento
    public boolean buscarElemento(int dato) {
        if (estaVacia()) {
            return false;
        }
        Nodo actual = head;
        do {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != head);
        return false;
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