/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;


import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 630610194
 */
@XmlRootElement
public class Shot implements Serializable {
    private int codigo;
    private String latitude, longitude, officerid,address, city, neighbourhood;

    public Shot() {
    }

    public Shot(int codigo, String latitude, String longitude, String address, String neighbourhood, String city, String officerid) {
        this.codigo = codigo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.officerid = officerid;
        this.address = address;
        this.city = city;
        this.neighbourhood = neighbourhood;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOfficerid() {
        return officerid;
    }

    public void setOfficerid(String officerid) {
        this.officerid = officerid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

       
}

