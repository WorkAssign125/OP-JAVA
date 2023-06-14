package com.company;

public class ReceivedCarData {
    protected int id;
    protected Car car;
    protected Owner owner;
    protected String problem;

    public ReceivedCarData(Car car, Owner owner, String problem, int id) {
        this.id = id;
        this.car = car;
        this.owner = owner;
        this.problem = problem;
    }
    public ReceivedCarData(ReceivedCarData received){
        this.id= received.id;
        this.car = received.car;
        this.owner = received.owner;
        this.problem = received.problem;
    }

    public int getId() {
        return id;
    }

    protected String getProblem() {
        return problem;
    }

    protected void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return
                "Id: "+id+". Samochód: " + car +" | "+ owner +
                ", usterka='" + problem + '\'';
    }
}
