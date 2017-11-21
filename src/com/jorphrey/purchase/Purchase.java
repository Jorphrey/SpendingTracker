package com.jorphrey.purchase;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Purchase implements Serializable{
    private String name;
    private String type;
    private double cost;
    private LocalDate date;
    private int year;
    private int month;
    private int day;
    private int pos;
    NumberFormat formatter = new DecimalFormat("#0.00");


    public Purchase(String name, String type, double cost, LocalDate date, int pos) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.date = date;
        this.year = year;
        this.month = month;
        this.day = day;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        return pos + ": " + name + " | " + type + " | " + "$" + formatter.format(cost) + " | " + date;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
