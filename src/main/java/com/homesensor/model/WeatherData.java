package com.homesensor.model;

public class WeatherData {

    private String name;
    private Main main;

    public WeatherData() {}

    public WeatherData(String name, Main main) {
        this.name = name;
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherData that = (WeatherData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return main != null ? main.equals(that.main) : that.main == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (main != null ? main.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "name='" + name + '\'' +
                ", main=" + main +
                '}';
    }
}
