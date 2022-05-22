package controllers;

import models.Member;
import models.Reading;
import models.Station;
import utils.StationAnalytics;
import play.Logger;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Admin");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    /*
    using for each loop to loop through every station in dashboard - each type of Station called station in
    an array list called stations
    size -1 is the last reading
     */
    //NEXT TODO IS TO IMPLEMENT THE analytics methods in Dashboard controller
    for (Station station : stations) {
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
    }
    render("dashboard.html", stations);
  }

  public static void addStation(String name, double latitude, double longitude) {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    member.stations.add(station);
    Logger.info("Adding Station" + name);
    member.save();
    redirect("/dashboard");
  }

  public static void deleteStation(Long id) {
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    Logger.info("Removing a station");
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect("/dashboard");
  }
}
