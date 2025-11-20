package controllers;

import models.Person;

public class SearchMethods {

    //Verifica si el arreglo está ordenado por nombre 
    public boolean isSortedByName(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            if (people[i].getName().compareToIgnoreCase(people[i + 1].getName()) > 0)
                return false;
        }
        return true;
    }

    // Verifica si el arreglo está ordenado por edad 
    public boolean isSortedByAge(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            if (people[i].getAge() > people[i + 1].getAge())
                return false;
        }
        return true;
    }

    //Busqueda binaria por nombre

    public Person binarySearchByName(Person[] people, String name) {
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int midd = (left + right) / 2;
            int cmp1 = people[midd].getName().compareToIgnoreCase(name);
            if (cmp1 == 0)
                return people[midd];
            if (cmp1 < 0)
                left = midd + 1;
            else
                right = midd- 1;
        }
        return null;
    }

    //Busqueda binaria por edads
        public Person binarySearchByAge(Person[] people, int age) {
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (people[mid].getAge() == age)
                return people[mid];
            if (people[mid].getAge() < age)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }
}
