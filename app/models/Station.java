package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Reading;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.transform.sax.SAXResult;

import play.db.jpa.Model;

@Entity
public class Station extends Model {

  public String name;
  public HashMap<String, String> weatherAssociation;
  public String weather;
  public double tempC;
  public double tempF;
  public double wind;
  public String windFeeling;
  public String windDirection;
  public int pressure;
  public double windChill;
  public double latitude;
  public double longitude;


  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();


  public Station(String name, double latitude, double longitude) {

    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;

  }
}
