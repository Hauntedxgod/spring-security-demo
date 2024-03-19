package ru.maxima.models.builders;

public interface CarBuilder {
    public CarBuilder makeBody(String body);

    public CarBuilder makeWheels(String wheels);
    public CarBuilder makeInterior(String interior);
    public CarBuilder makePainting(String painting);

    public Car build();

}
