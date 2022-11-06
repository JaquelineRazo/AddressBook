import java.util.Scanner;
import java.util.HashMap;

public class AddressBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // La clase AddressBook deberá tener un atributo de tipo HashMap que almacene
        // los contactos, HashMap será un Map<String, String>, el primer atributo String
        // utilizará el número telefónico como llave.
        HashMap<String, String> myContact = new HashMap<String, String>();
        Scanner input = new Scanner(System.in);

        int opciones = 0;
        String telefono, nombre;
        System.out.println("\n---- AGENDA DE CONTACTOS ----\n");

        do {

            System.out.println("\nMenu de opciones:\n");
            System.out.println("[1] - Cargar los contactos de la agenda");
            System.out.println("[2] - Mostrar de la agenda");
            System.out.println("[3] - Agregar nuevo numero");
            System.out.println("[4] - Guardar los cambios de la agenda");
            System.out.println("[5] - Borrar contacto");
            System.out.println("[6] - Salir");

            opciones = input.nextInt();

            /// Menu de opciones
            switch (opciones) {
                case 1:
                    Metodos.load(myContact);
                    break;

                case 2:
                    Metodos.list(myContact);
                    break;

                case 3:

                    System.out.println("Ingrese el nuevo telefono: ");
                    telefono = input.next();
                    System.out.println("Ingrese el nombre del contacto: ");
                    nombre = input.next();
                    Metodos.create(myContact, telefono, nombre);
                    break;

                case 4:
                    Metodos.save(myContact);
                    break;

                case 5:

                    System.out.println("Inserte el nombre del contacto a eliminar: ");
                    nombre = input.next();

                    Metodos.delete(myContact, nombre);
                    break;

                case 6:
                    System.out.println("Saliendo\n");
                    break;
            }
        } while (opciones != 6);

    }

}