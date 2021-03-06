package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FireEngine extends Car {
    protected final String REGEX = "\\d[^авекмно] \\d{2}[^авекмно]{2} \\d{2} SPE";
    private String registerCode;
    private double quantityWater;

    FireEngine(String registerCode, String brand, ColorsCar color, Engine engine, int wheels) {
        super(registerCode, brand, color, engine, wheels);
    }

    FireEngine(String brand, ColorsCar color, Engine engine, int wheels) {
        super(brand, color, engine, wheels);
    }

    public void print() {
        System.out.println("\nRegister Code: " + this.registerCode);
        if (this.quantityWater > 0) System.out.println("Количество воды: " + this.quantityWater);
        this.printDefault();
    }

    public void setRegisterCode(String registerCode) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(registerCode);
        while (matcher.find()) {
            this.registerCode = registerCode;
            return;
        }
        System.out.print("Регистрационный номер не верен!");
    }

    public void setQuantityWater(double quantityWater) {
        this.quantityWater = quantityWater;
    }
}
