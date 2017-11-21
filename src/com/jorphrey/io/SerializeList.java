package com.jorphrey.io;

import com.jorphrey.purchase.Purchase;

import java.io.*;
import java.util.List;

public class SerializeList {
    private final String file = "src/com/Jorphrey/com.jorphrey.io/PurchaseList.ser";

    public void serialize(List<Purchase> purchases, String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(purchases);
            out.close();
        }catch(Exception e){
            System.out.println("Unable to serialize list.");
            System.out.println(e.getMessage());
        }
    }

    public List<Purchase> deserialize(String fileName){
        List<Purchase> list = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (List<Purchase>)in.readObject();
        }catch (Exception e){
            System.out.println("file not found");
        }

        return list;

    }

    public String getFile() {
        return file;
    }
}
