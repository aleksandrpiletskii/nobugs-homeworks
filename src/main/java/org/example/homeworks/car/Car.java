package org.example.homeworks.car;

public class Car implements Drivable {
    private String carBrand;
    private String carModel;
    private int carReleaseDate;

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarBrand() {
        return this.carBrand;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public void setCarReleaseDate(int carReleaseDate) {
        this.carReleaseDate = carReleaseDate;
    }

    public int getCarReleaseDate() {
        return this.carReleaseDate;
    }


    @Override
    public void start() {
        System.out.println("Car " + getCarBrand() + " " + getCarModel() + " " + getCarReleaseDate() + " started.");
    }

    @Override
    public void stop() {
        System.out.println("Car " + getCarBrand() + " " + getCarModel() + " " + getCarReleaseDate() + " stopped.");
    }

    @Override
    public void drive(int distance) {
        System.out.println("The car " + getCarBrand() + " " + getCarModel() + " " + getCarReleaseDate()
                + " traveled " + distance + " km.");
    }
}
