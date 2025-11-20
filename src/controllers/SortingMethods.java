package controllers;

import models.Person;

public class SortingMethods {

    //Ordena por nombre con metodo burbuja
    public void sortByNameWithBubble(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - i - 1; j++) {
                if (people[j].getName().compareToIgnoreCase(people[j + 1].getName()) > 0) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    //Ordenq por edad con Insercion
    public void sortByAgeWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person clave= people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getAge() > clave.getAge()) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = clave;
        }
    }

    //Ordena por nombre con metodo Insercion
    public void sortByNameWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = key;
        }
    }

    //Ordena los nombres por seleccion descendiente
    public void sortByNameWithSelectionDes(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < people.length; j++) {
                if (people[j].getName().compareToIgnoreCase(people[maxIdx].getName()) > 0) {
                    maxIdx = j;
                }
            }
            Person temp = people[i];
            people[i] = people[maxIdx];
            people[maxIdx] = temp;
        }
    }
}
