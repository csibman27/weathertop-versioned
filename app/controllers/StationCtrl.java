package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

public class StationCtrl extends Controller {

  public static void index(Long id) {

    Station station = Station.findById(id);
    Logger.info("Station id = " + id);

    //NEXT TODO IS TO IMPLEMENT THE analytics methods in StationControl
    if (station.readings.size() > 0) {
      Reading lastR = station.readings.get(station.readings.size() - 1);
      station.weather = StationAnalytics.getWeatherCode(lastR.code);
      station.tempC = lastR.temperature;
      station.tempF = StationAnalytics.getTempsInFahrenheit(lastR.temperature);
      station.wind = lastR.windSpeed;
      station.windFeeling = StationAnalytics.getWindFeeling(lastR.windSpeed);
      station.pressure = lastR.pressure;
      station.windDirection = StationAnalytics.getWindDirection(lastR.windDirection);
      station.windChill = StationAnalytics.getWindChill(lastR.temperature, lastR.windSpeed);
    }

    render("station.html", station);
  }

  public static void deleteReading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing" + reading);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, double windDirection, int pressure) {
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    reading.save();
    redirect("/stations/" + id);
  }
}
