package com.company;

// Wymagaqne funkcjonalności warsztatu opisane w interfejsie.
public interface IWorkshop {
    void receiveCarForRepairs(Car car, Owner owner, String problem);
    void repairCar(int id);
    void showRepairedCars();
    void showCarsNeedingRepairs();
    void displayCarProblemAndRepairs(int id);
}
