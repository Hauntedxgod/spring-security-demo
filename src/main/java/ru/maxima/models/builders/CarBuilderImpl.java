package ru.maxima.models.builders;

public class CarBuilderImpl implements CarBuilder{
    private String body;
    private String wheels;
    private String interior;
    private String painting;

    @Override
    public CarBuilder makeBody(String body) {
        System.out.println("We are making body of car");
        this.body = "Body of Ferrari";
        return this;
    }

    @Override
    public CarBuilder makeWheels(String wheels) {
        System.out.println("We are making wheels or car");
        this.wheels = "Wheels or Ferrari";
        return this;
    }

    @Override
    public CarBuilder makeInterior(String interior) {
        System.out.println("We are making interior or car");
        this.interior = "Interior or Ferrari";
        return this;
    }

    @Override
    public CarBuilder makePainting(String painting) {
        System.out.println("We are making painting or car");
        this.painting = "painting or Ferrari";
        return this;
    }

    @Override
    public Car build() {
        Car car = new Car(body , wheels, interior , painting);
        return car;
    }
}
