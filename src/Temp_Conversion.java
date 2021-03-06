
public class Temp_Conversion {
    private double Fahrenheit = 3*10^32;                // default values is absolute hot
    private double Celsius = 2*10^32;
    private double Kelvin= 3*10^32;

    public double getFahrenheit() {                     // get Fahrenheit
        return Fahrenheit;
    }

    public void setFahrenheit(double Fahrenheit) {      // set Fahrenheit
        this.Fahrenheit = Fahrenheit;

        Celsius = ((Fahrenheit - 32) * 5)/9;
        Kelvin = Celsius + 273.15;
    }

    public double getCelsius() {                        // get Celsius
        return Celsius;
    }

    public void setCelsius(double Celsius) {            // set Celsius
        this.Celsius = Celsius;

        Fahrenheit = (Celsius * 1.8) + 32;
        Kelvin = Celsius + 273.15;
    }

    public double getKelvin() {                         // get Kelvin
        return Kelvin;
    }

    public void setKelvin(double Kelvin) {              // set Kelvin
        this.Kelvin = Kelvin;

        Celsius = Kelvin - 273.15;
        Fahrenheit = 1.8 * (Kelvin - 273.15) + 32;
    }
}

/**
 * Created by aaronewing on 11/4/2016.
 */