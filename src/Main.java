package com.company;

public class Main {

    public static void main(String[] args) {

        Array list = new com.company.Array(new int[]{-10, 10, 12, 16, 14, 128, 125, 130});

        list.printAllArray();
        list.averageArray();
        list.minimum();
        list.maximum();
        list.moduloOdd();
        list.moduloEven();
        list.evenKeys();



        Array list2 = new com.company.Array();
        list2.setArray(11); // here you need to specify the size of the needed array

        list2.printAllArray();
        list2.averageArray();
        list2.minimum();
        list2.maximum();
        list2.moduloOdd();
        list2.moduloEven();
        list2.evenKeys();



    }
}
