import java.util.HashMap;
import java.util.Iterator;
import java.io.*;

// En la clase AddressBook se implementarán los métodos para la lectura y escritura de los contactos en un archivo de texto.

public class Metodos {

     // load: cargará los contactos del archivo.
    public static void load(HashMap<String, String> agenda)
     {
         String inputFilename = "input.csv";
         String a [];                /// array auxiliar
         
         BufferedReader bufferedReader = null;
 
         try {
             bufferedReader = new BufferedReader(new FileReader(inputFilename));
 
             String line;
             while ((line = bufferedReader.readLine()) != null) {
                 a = line.split(",");       
                 agenda.put(a[0],a[1]);           
             }
         } catch(IOException e) {
             System.out.println("IOException catched while reading: " + e.getMessage());
         } finally {
             try {
                 if (bufferedReader != null) {
                     bufferedReader.close();
                     System.out.println("\nContactos cargados");
                 }
             } catch (IOException e) {
                 System.out.println("IOException catched while closing: " + e.getMessage());
             }
         }
 
     }

    //save: guardará los cambios en el archivo.
    public static void save(HashMap<String, String> agenda)
    {
        Iterator<String> iterator = agenda.keySet().iterator();
        String inputFilename = "input.csv"; 
        
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(inputFilename));
           
           while(iterator.hasNext())                               
        {
            String llave = iterator.next();                     
            

            bufferedWriter.write(llave+","+agenda.get(llave)+"\n");   
        }
           
            }
         catch(IOException e) {
            System.out.println("IOException catched while writing: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    System.out.println("\nCambios guardados");
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
    
    //  Se implementarán tres métodos para modificar la información de los contactos.

    // 1. list: mostrar los contactos de la agenda.

    public static void list(HashMap<String, String> myContact)
    {
        System.out.println("Listado");
        for (HashMap.Entry<String,String> entry : myContact.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            
            System.out.println(value+": "+key);
        }    
        
    }
    
    // create: crear un nuevo contacto.
    public static void create(HashMap<String, String> myContact, String tel, String nom)
    {           
        if(myContact.containsKey(tel))
            {
                System.out.println("\nError!\nNo se puede registrar dos veces el mismo telefono\n"); 
            }
            
            else
            {
                myContact.put(tel, nom); 
                System.out.println("\nContacto agregado");
            }
        
    }
    
    // delete: borrar un contacto.
    public static void delete(HashMap<String, String> myContact, String nom)
    {
        
        
        if(myContact.containsValue(nom))        
        {  
            System.out.println("\nContacto eliminado: ");
            //myContact.remove(nom);
            myContact.entrySet()
            .removeIf(entry -> entry.getValue().equals(nom));
        }
        else
            System.out.println("\nEl Telefono no existe\n");
    }

}
