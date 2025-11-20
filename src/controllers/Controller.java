package controllers;

import models.Person;
import views.ViewConsole;
import java.util.ArrayList;


public class Controller {
    private ViewConsole view;
    private SortingMethods sorter;
    private SearchMethods searcher;
    private ArrayList<Person> personList = new ArrayList<>();

    public Controller(ViewConsole view, SortingMethods sorter, SearchMethods searcher) {
        this.view = view;
        this.sorter = sorter;
        this.searcher = searcher;
    }

   //Menu principal
    public void start() {
        while (true) {
            int option = view.showMenu();
            switch (option) {
                case 1:
                    inputPersons();
                    break;
                case 2:
                    view.displayPersons(personList.toArray(new Person[0]));
                    break;
                case 3:
                    sortPersons();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return; // Se sale del metodo Start
                default:
                    System.out.println("ERROR...Intente de nuevo");
            }
        }
    }

    //Ingresar personas
    private void inputPersons() {
        System.out.print("¿Cuántas personas deseas ingresar?: ");
        int count = new java.util.Scanner(System.in).nextInt();
        for (int i = 0; i < count; i++) {
            personList.add(view.inputPerson());
        }
    }

    //Ordena por el metodo
    private void sortPersons() {
        int opt = view.selectSortingMethod();
        Person[] array = personList.toArray(new Person[0]);
        switch (opt) {
            case 1:
                sorter.sortByNameWithBubble(array);
                break;
            case 2:
                sorter.sortByAgeWithInsertion(array);
                break;
            case 3:
                sorter.sortByNameWithInsertion(array);
                break;
            case 4:
                sorter.sortByNameWithSelectionDes(array);
                break;
            default:
                System.out.println("ERROR...Opcion invalida");
                return;
        }
        personList = new ArrayList<>(java.util.Arrays.asList(array));
        System.out.println("**Lista Ordenada**");
    }

   
    //Verifica si el arreglo esta ordenado
    //Busca a una persona por su nombre o su edad
    private void searchPerson() {
        Person[] array = personList.toArray(new Person[0]);
        int opt = view.selectSearchCriterion();

        switch (opt) {
            case 1:
                if (!searcher.isSortedByName(array)) {
                    System.out.println("El arreglo por nombre esta desordenado, ahora ordenare...");
                    sorter.sortByNameWithInsertion(array);
                }
                String name = view.inputName();
                view.displaySearchResult(searcher.binarySearchByName(array, name));
                break;

            case 2:
                if (!searcher.isSortedByAge(array)) {
                    System.out.println("El arreglo por edad esta desordenado, ahora ordenare...");
                    sorter.sortByAgeWithInsertion(array);
                }
                int age = view.inputAge();
                view.displaySearchResult(searcher.binarySearchByAge(array, age));
                break;

            default:
                System.out.println("Esa Busqueda no se encontro");
        }
    }
}
