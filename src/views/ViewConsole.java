package views;

import java.util.Scanner;
import models.Person;

public class ViewConsole {
    private Scanner scanner = new Scanner(System.in);

    //Menu principal
    public int showMenu() {
        System.out.println("☺☺☺☺☺☺ MENU ☺☺☺☺☺");
        System.out.println("[1]. Ingresar personas");
        System.out.println("[2]. Mostrar personas");
        System.out.println("[3]. Ordenar personas");
        System.out.println("[4]. Buscar persona");
        System.out.println("[0]. Salir");
        System.out.print("Ingresar una opción: ");
        return scanner.nextInt();
    }

    //Solicita el ingreso de nombre y edad, y devuelve una nueva Persona.
    public Person inputPerson() {
        scanner.nextLine(); 
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    //Menu de metodos de ordenamiento
    public int selectSortingMethod() {
        System.out.println("☺☺☺☺☺ Métodos de ordenamiento ☺☺☺☺☺☺");
        System.out.println("[1]. Burbuja por nombre");
        System.out.println("[2]. Inserción por edad");
        System.out.println("[3]. Inserción por nombre");
        System.out.println("[4]. Selección descendente por nombre");
        System.out.print("Seleccionar: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("☺☺☺☺☺ Buscar por:");
        System.out.println("[1]. Nombre");
        System.out.println("[2]. Edad");
        System.out.print("Seleccionar: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] people) {
        System.out.println("♣♣♣ Lista de personas ♣♣♣");
        for (Person p : people) {
            System.out.println(p);
        }
    }

    //Muestra el resultado de la búsqueda.
    public void displaySearchResult(Person p) {
        if (p != null) {
            System.out.println("Persona encontrada: " + p);
        } else {
            System.out.println("No se encontró la persona.");
        }
    }

    public String inputName() { //Nombre a buscar
        scanner.nextLine();
        System.out.print("Ingresar el nombre a buscar: ");
        return scanner.nextLine();
    }

    public int inputAge() { //Edad a buscar
        System.out.print("Ingresar la edad a buscar: ");
        return scanner.nextInt();
    }
}
