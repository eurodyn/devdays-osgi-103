package com.devdays103;

public class Calculator {

    public int addition(int n1, int n2) {
        return n1 + n2;
    }

    public int subtraction(int n1, int n2) {
        // Let's introduce a deliberate error here, subtracting n1 from n2
        // instead of n2 from n1.
        return n2 - n1;
    }
}
