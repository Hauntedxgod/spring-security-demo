package ru.maxima.models.builders;

public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        Car traktor = carBuilder
                .makeBody("Kuzov trakrot")
                .makeWheels("Wheels 1 meter")
                .makeInterior("Very small interior")
                .makePainting("Blue color")
                .build();

        System.out.println(traktor);

    }
}
