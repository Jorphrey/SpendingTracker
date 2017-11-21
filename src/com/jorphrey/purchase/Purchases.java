package com.jorphrey.purchase;

import com.jorphrey.io.*;
import java.io.Serializable;
import java.util.*;


public class Purchases implements Comparator<Purchase>, Serializable{
    private List<Purchase> purchases;
    private SerializeList serializeList;
    private boolean isEmpty;

    public Purchases(){
        purchases = new ArrayList<>();
        serializeList = new SerializeList();
        isEmpty = true;
    }

    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
        serializeList.serialize(purchases, serializeList.getFile());
        isEmpty = false;
    }

    public List<Purchase> getPurchases(){
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
        isEmpty = false;
    }

    public void sortByName() {
        int i = 1;
        Collections.sort(purchases, Comparator.comparing(Purchase::getName));
        for(Purchase p : purchases){
            p.setPos(i);
            i++;
        }

    }
    public void sortByType(){
        int i = 1;
        Collections.sort(purchases, Comparator.comparing(Purchase::getType));
        for(Purchase p : purchases){
            p.setPos(i);
            i++;
        }
    }

    public void sortByDate(){
        int i = 1;
        Collections.sort(purchases, Comparator.comparing(Purchase::getDate));
        for(Purchase p : purchases){
            p.setPos(i);
            i++;
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public int compare(Purchase o1, Purchase o2) {
        return 0;
    }
}
