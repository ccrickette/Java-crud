/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclesofinterestdesktop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "VEHICLE_OF_INTEREST", catalog = "", schema = "VEHICLESOFINTEREST")
@NamedQueries({
    @NamedQuery(name = "VehicleOfInterest.findAll", query = "SELECT v FROM VehicleOfInterest v")
    , @NamedQuery(name = "VehicleOfInterest.findByLicensePlate", query = "SELECT v FROM VehicleOfInterest v WHERE v.licensePlate = :licensePlate")
    , @NamedQuery(name = "VehicleOfInterest.findByReason", query = "SELECT v FROM VehicleOfInterest v WHERE v.reason = :reason")
    , @NamedQuery(name = "VehicleOfInterest.findByMake", query = "SELECT v FROM VehicleOfInterest v WHERE v.make = :make")
    , @NamedQuery(name = "VehicleOfInterest.findByModel", query = "SELECT v FROM VehicleOfInterest v WHERE v.model = :model")
    , @NamedQuery(name = "VehicleOfInterest.findByVehYear", query = "SELECT v FROM VehicleOfInterest v WHERE v.vehYear = :vehYear")
    , @NamedQuery(name = "VehicleOfInterest.findByColor", query = "SELECT v FROM VehicleOfInterest v WHERE v.color = :color")
    , @NamedQuery(name = "VehicleOfInterest.findByOwnersName", query = "SELECT v FROM VehicleOfInterest v WHERE v.ownersName = :ownersName")
    , @NamedQuery(name = "VehicleOfInterest.findByOwnersPhone", query = "SELECT v FROM VehicleOfInterest v WHERE v.ownersPhone = :ownersPhone")})
public class VehicleOfInterest implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LICENSE_PLATE")
    private String licensePlate;
    @Basic(optional = false)
    @Column(name = "REASON")
    private String reason;
    @Basic(optional = false)
    @Column(name = "MAKE")
    private String make;
    @Basic(optional = false)
    @Column(name = "MODEL")
    private String model;
    @Column(name = "VEH_YEAR")
    private String vehYear;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "OWNERS_NAME")
    private String ownersName;
    @Column(name = "OWNERS_PHONE")
    private String ownersPhone;

    public VehicleOfInterest() {
    }

    public VehicleOfInterest(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleOfInterest(String licensePlate, String reason, String make, String model) {
        this.licensePlate = licensePlate;
        this.reason = reason;
        this.make = make;
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        String oldLicensePlate = this.licensePlate;
        this.licensePlate = licensePlate;
        changeSupport.firePropertyChange("licensePlate", oldLicensePlate, licensePlate);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        String oldReason = this.reason;
        this.reason = reason;
        changeSupport.firePropertyChange("reason", oldReason, reason);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        String oldMake = this.make;
        this.make = make;
        changeSupport.firePropertyChange("make", oldMake, make);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        String oldModel = this.model;
        this.model = model;
        changeSupport.firePropertyChange("model", oldModel, model);
    }

    public String getVehYear() {
        return vehYear;
    }

    public void setVehYear(String vehYear) {
        String oldVehYear = this.vehYear;
        this.vehYear = vehYear;
        changeSupport.firePropertyChange("vehYear", oldVehYear, vehYear);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        changeSupport.firePropertyChange("color", oldColor, color);
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        String oldOwnersName = this.ownersName;
        this.ownersName = ownersName;
        changeSupport.firePropertyChange("ownersName", oldOwnersName, ownersName);
    }

    public String getOwnersPhone() {
        return ownersPhone;
    }

    public void setOwnersPhone(String ownersPhone) {
        String oldOwnersPhone = this.ownersPhone;
        this.ownersPhone = ownersPhone;
        changeSupport.firePropertyChange("ownersPhone", oldOwnersPhone, ownersPhone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licensePlate != null ? licensePlate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleOfInterest)) {
            return false;
        }
        VehicleOfInterest other = (VehicleOfInterest) object;
        if ((this.licensePlate == null && other.licensePlate != null) || (this.licensePlate != null && !this.licensePlate.equals(other.licensePlate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vehiclesofinterestdesktop.VehicleOfInterest[ licensePlate=" + licensePlate + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    

}
