package users.irfan.re_sep4_android.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OfficeModel implements Serializable {
    private String name;
    private double area;
    private java.time.LocalDateTime dateTime;
    private double temperature;
    private double RH;
    private double CO2;

    public OfficeModel(String name, double area, java.time.LocalDateTime dateTime, double temperature, double RH, double CO2){
        this.name = name;
        this.area = area;
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.RH = RH;
        this.CO2 = CO2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getRH() {
        return RH;
    }

    public void setRH(double RH) {
        this.RH = RH;
    }

    public double getCO2() {
        return CO2;
    }

    public void setCO2(double CO2) {
        this.CO2 = CO2;
    }
}
