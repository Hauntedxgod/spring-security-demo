package ru.maxima.models.builders;

public class Car {

    private String body;
    private String wheels;
    private String interior;
    private String painting;

    public Car() {
    }

    public Car(String body, String wheels, String interior, String painting) {
        this();
        this.body = body;
        this.wheels = wheels;
        this.interior = interior;
        this.painting = painting;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getPainting() {
        return painting;
    }

    public void setPainting(String painting) {
        this.painting = painting;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body='" + body + '\'' +
                ", wheels='" + wheels + '\'' +
                ", interior='" + interior + '\'' +
                ", painting='" + painting + '\'' +
                '}';
    }
}
