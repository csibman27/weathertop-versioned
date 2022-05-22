package utils;

import models.Station;
import org.w3c.dom.ranges.Range;

import java.util.HashMap;


public class StationAnalytics {


  //Latest weather method working with switch statement
  public static String getWeatherCode(int code) {
    String weather = "No data available"; //or null

    switch (code) {
      case 100:
        weather = "Clear";
        break;
      case 200:
        weather = "Partial clouds";
        break;
      case 300:
        weather = "Cloudy";
        break;
      case 400:
        weather = "Light Showers";
        break;
      case 500:
        weather = "Heavy Showers";
        break;
      case 600:
        weather = "Rain";
        break;
      case 700:
        weather = "Snow";
        break;
      case 800:
        weather = "Thunder";
        break;
      default:
        weather = "N/A";
        break;
    }
    return weather;
  }

  //Temperature for celsius to fahrenheit
  public static double getTempsInFahrenheit(double tempC) {

    double tempF = (tempC * 9 / 5) + 32;
    return tempF;
  }

  //Windspeed method in beaufort conversion
  public static String getWindFeeling(double bft) {

    String windSpeed = null;
    if (bft >= 0 && bft < 1) {
      windSpeed = "Calm";
    } else if (bft >= 1 && bft < 2) {
      windSpeed = "Light Air";
    } else if (bft >= 2 && bft < 3) {
      windSpeed = "Light Breeze";
    } else if (bft >= 3 && bft < 4) {
      windSpeed = "Gentle Breeze";
    } else if (bft >= 4 && bft < 5) {
      windSpeed = "Moderate Breeze";
    } else if (bft >= 5 && bft < 6) {
      windSpeed = "Fresh Breeze";
    } else if (bft >= 6 && bft < 7) {
      windSpeed = "Strong Breeze";
    } else if (bft >= 7 && bft < 8) {
      windSpeed = "Near Gale";
    } else if (bft >= 8 && bft < 9) {
      windSpeed = "Gale";
    } else if (bft >= 9 && bft < 10) {
      windSpeed = "Sever Gale";
    } else if (bft >= 10 && bft < 11) {
      windSpeed = "Strong Storm";
    } else if (bft >= 11 && bft < 12) {
      windSpeed = "Violent Storm";
    } else windSpeed = "N/A";
    return windSpeed;
  }

  //windspeed calculation method (extra)
  public static double windSpeedToBFT(double windSpeed) {

    double bft = 0; //basic value is Calm
    if (windSpeed > 0 && windSpeed <= 1) {
      bft = 0;
    } else if (windSpeed > 1 && windSpeed <= 5) {
      bft = 1;
    } else if (windSpeed > 6 && windSpeed <= 11) {
      bft = 2;
    } else if (windSpeed > 12 && windSpeed <= 19) {
      bft = 3;
    } else if (windSpeed > 20 && windSpeed <= 28) {
      bft = 4;
    } else if (windSpeed > 29 && windSpeed <= 38) {
      bft = 5;
    } else if (windSpeed > 39 && windSpeed <= 49) {
      bft = 6;
    } else if (windSpeed > 50 && windSpeed <= 61) {
      bft = 7;
    } else if (windSpeed > 62 && windSpeed <= 74) {
      bft = 8;
    } else if (windSpeed > 75 && windSpeed <= 88) {
      bft = 9;
    } else if (windSpeed > 89 && windSpeed <= 102) {
      bft = 10;
    } else if (windSpeed > 103 && windSpeed <= 117) {
      bft = 11;
    }
    return bft;
  }

  //wind direction method with if else statement
  public static String getWindDirection(double windDirection) {
    String compassDirection = null;
    if ((windDirection >= 348.75) && (windDirection <= 360) ||
        (windDirection >= 0) && (windDirection <= 11.25)) {
      compassDirection = "N";
    } else if ((windDirection >= 11.25) && (windDirection <= 33.75)) {
      compassDirection = "NNE";
    } else if ((windDirection >= 33.75) && (windDirection <= 56.25)) {
      compassDirection = "NE";
    } else if ((windDirection >= 56.25) && (windDirection <= 78.75)) {
      compassDirection = "ENE";
    } else if ((windDirection >= 78.75) && (windDirection <= 101.25)) {
      compassDirection = "E";
    } else if ((windDirection >= 101.25) && (windDirection <= 123.75)) {
      compassDirection = "ESE";
    } else if ((windDirection >= 123.75) && (windDirection <= 146.25)) {
      compassDirection = "SE";
    } else if ((windDirection >= 146.25) && (windDirection <= 168.75)) {
      compassDirection = "SSE";
    } else if ((windDirection >= 168.75) && (windDirection <= 191.25)) {
      compassDirection = "S";
    } else if ((windDirection >= 191.25) && (windDirection <= 213.75)) {
      compassDirection = "SSW";
    } else if ((windDirection >= 213.75) && (windDirection <= 236.25)) {
      compassDirection = "SW";
    } else if ((windDirection >= 236.25) && (windDirection <= 258.75)) {
      compassDirection = "WSW";
    } else if ((windDirection >= 258.75) && (windDirection <= 281.25)) {
      compassDirection = "W";
    } else if ((windDirection >= 281.25) && (windDirection <= 303.75)) {
      compassDirection = "WNW";
    } else if ((windDirection >= 303.75) && (windDirection <= 326.25)) {
      compassDirection = "NW";
    } else if ((windDirection >= 326.25) && (windDirection <= 348.75)) {
      compassDirection = "NNW";
    } else {
      compassDirection = "?";
    }

    return compassDirection;
  }

  //method for wind feels like
  public static double getWindChill(double t, double v) {
    return 13.12 + (0.6215 * t) - 11.37 * (Math.pow(v, 0.16)) + 0.3965 * t * (Math.pow(v, 0.16));

  }

}

