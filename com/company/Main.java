package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Workshop w = new Workshop();
        w.receiveCarForRepairs(new Car("Giulia", "Alfa Romeo", 2011), new Owner("Adam", "Kowalski"), "Awaria hamulców");
        w.receiveCarForRepairs(new Car("Stelvio", "Alfa Romeo", 2013), new Owner("Jan", "Cwik"), "Awaria silnika");
        int choice = 1;
        System.out.println("Wybierz opcję 0 by wyjść.");
        while (choice != 0) {
            System.out.println("\nWybierz numer opcji:\n 1.Oddaj samochód do naprawy\n 2.Wypisz samochody czekające na naprawę\n 3.Znajdź samochód właściciela\n 4.Napraw samochód\n 5.Wypisz samochody naprawione \n 6.Wyświetl dane problemu i naprawy samochodu \n 7.Zapisz dane \n");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Podaj poprawny numer opcji");
                choice = 12; // Pomin opcje
            }
            // Switch
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Podaj dane samochodu - Model: \n");
                        String model = scanner.nextLine();
                        System.out.println("Podaj dane samochodu - Marka: \n");
                        String brand = scanner.nextLine();
                        System.out.println("Podaj dane samochodu - Rok: \n");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.println("Podaj dane wlasciciela - Imie: \n");
                        String name = scanner.nextLine();
                        System.out.println("Podaj dane wlasciciela - Nazwisko: \n");
                        String surname = scanner.nextLine();
                        System.out.println("Podaj usterke: \n");
                        String problem = scanner.nextLine();
                        w.receiveCarForRepairs(new Car(model, brand, year), new Owner(name, surname), problem);
                        System.out.println("Dodano do katalogu samochodow do naprawy");
                    } catch (Exception e) {
                        System.out.println("Niepoprawne dane.");
                    }
                    break;
                case 2:
                    System.out.println("Podaj nazwę marki lub wciśnij ENTER by pokazać wszystkie samochody");
                    String brandNotRepaired = scanner.nextLine();
                    if(brandNotRepaired.isBlank()) w.showCarsNeedingRepairs();
                    else w.showCarsNeedingRepairs(brandNotRepaired);
                    break;
                case 3:
                    System.out.println("Podaj nazwisko właściciela: \n");
                    String surname = scanner.nextLine();
                    w.findOwnersCar(surname);
                    break;
                case 4:
                    System.out.println("Podaj id samochodu do naprawy: \n");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        w.repairCar(id);
                    }catch(Exception e){
                        System.out.println("Niepoprawne id.");
                    }
                    break;
                case 5:
                    System.out.println("Podaj nazwę marki lub wciśnij ENTER by pokazać wszystkie samochody");
                    String brandRepaired = scanner.nextLine();
                    if(brandRepaired.isBlank()) w.showRepairedCars();
                    else w.showRepairedCars(brandRepaired);
                    break;
                case 6:
                    try {
                        System.out.println("Podaj id naprawionego samochodu.");
                        int id = Integer.parseInt(scanner.nextLine());
                        w.displayCarProblemAndRepairs(id);
                    }catch(Exception e){
                        System.out.println("Niepoprawne id.");
                    }
                    break;
                case 7:
                    w.saveData();
                    break;

                default:
            }
        }
    }
}
