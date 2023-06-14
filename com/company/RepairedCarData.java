package com.company;

public class RepairedCarData extends ReceivedCarData{
    private String repairsDescription;
    public RepairedCarData(ReceivedCarData received, String repairsDescription){
        super(received);
        this.repairsDescription = repairsDescription;
    }

    public String getRepairsDescription() {
        return repairsDescription;
    }

    public void setRepairsDescription(String repairsDescription) {
        this.repairsDescription = repairsDescription;
    }

    @Override
    public String toString() {
        return "Id: "+id+". Samochód: " + car +" | "+ owner +
                ", usterka='" + problem + '\'' + ", co zrobiono='"+repairsDescription+ '\'';
    }
}
