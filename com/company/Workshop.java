package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Workshop implements IWorkshop {
    static int idCount = 101;
    private static final String name ="Auto Service Loch" ;
    private final List<ReceivedCarData> carsNeedingRepairs = new ArrayList<>();
    private final List<RepairedCarData> carsRepaired = new ArrayList<>();

    public void showCarsNeedingRepairs() {
        for (ReceivedCarData carData : carsNeedingRepairs) {
            System.out.println(" - " + carData.toString());
        }
    }
    //Przeciążenie
    public void showCarsNeedingRepairs(String brand) {
        List<String> foundCars = new ArrayList<>();
        for (ReceivedCarData carData : carsNeedingRepairs) {
            if (carData.car.getBrand().equals(brand)) {
                foundCars.add(" - " + carData + "\n");
            }
        }
        if(foundCars.isEmpty())
        System.out.println("Nie znaleziono samochodu marki "+brand+"\n");
        else System.out.println("Znaleziono samochody marki " + brand + "\n" + foundCars);
    }
    public void findOwnersCar(String surname) {
        for (ReceivedCarData carData : carsNeedingRepairs) {
            if (carData.owner.getSurname().equals(surname)) {
                System.out.println("Znaleziono w katalogu samochodów czekających na naprawę " + carData);
                return;
            }
        }
        for (RepairedCarData carData : carsRepaired) {
            if (carData.owner.getSurname().equals(surname)) {
                System.out.println("Znaleziono w katalogu samochodów naprawionych " + carData);
                return;
            }
        }
        System.out.println("Nie znaleziono samochodu właściciela\n");
    }

    public Workshop() {
    }

    public void receiveCarForRepairs(Car car, Owner owner, String problem) {
        carsNeedingRepairs.add(new ReceivedCarData(car, owner, problem, idCount++));
    }

    public void repairCar(int id){
        for (int i = 0; i < carsNeedingRepairs.size(); i++) {
            if(carsNeedingRepairs.get(i).getId()==id){
                System.out.println("Opisz co zostało zrobione / co naprawiono: \n");
                Scanner scanner = new Scanner(System.in);
                String repairsDescription = scanner.nextLine();
                RepairedCarData newRepair = new RepairedCarData(carsNeedingRepairs.get(i),repairsDescription);
                carsNeedingRepairs.remove(i);
                carsRepaired.add(newRepair);
                System.out.println("Pomyślnie dodano do katalogu samochodów naprawionych");
                return;
            }
        }
        System.out.println("Nie znaleziono samochodu o tym id.");
    }
    public void showRepairedCars() {
        for (ReceivedCarData carData : carsRepaired) {
            System.out.println(" - " + carData.toString());
        }
    }
    //Przeciążenie
    public void showRepairedCars(String brand) {
        List<String> foundCars = new ArrayList<>();
        for (ReceivedCarData carData : carsRepaired) {
            if (carData.car.getBrand().equals(brand)) {
                foundCars.add(" - " + carData + "\n");
            }
        }
        if(foundCars.isEmpty())
            System.out.println("Nie znaleziono samochodu marki "+brand+"\n");
        else System.out.println("Znaleziono samochody marki " + brand + "\n" + foundCars);
    }
    public void displayCarProblemAndRepairs(int id){
        for (RepairedCarData repaired:carsRepaired) {
            if(repaired.getId()==id){
                System.out.println("Samochód o ID "+id+" miał usterkę '"+repaired.getProblem() +"' , co zrobiono: "+repaired.getRepairsDescription());
                return;
            }
        }
        System.out.println("Nie znaleziono samochodu o tym id.");
    }
    public void saveData(){

        String savedData = "";
        savedData += "Samochody oddane do naprawy:\n";
        for (ReceivedCarData carData:
             carsNeedingRepairs) {
            savedData+=carData+"\n";
        }
        savedData += "Samochody naprawione:\n";
        for (RepairedCarData carData:
                carsRepaired) {
            savedData+=carData+"\n";
        }

        try{

            BufferedWriter writer = new BufferedWriter(new FileWriter(name+".txt"));
            writer.write(savedData);
            writer.close();
            System.out.println("Poprawnie zapisano dane");
        }
        catch(IOException exception){
            System.out.println("Błąd w zapisie pliku.");
        }
    }
}
