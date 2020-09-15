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
@Table(name = "VEHICLE_MODEL", catalog = "", schema = "VEHICLESOFINTEREST")
@NamedQueries({
    @NamedQuery(name = "VehicleModel.findAll", query = "SELECT v FROM VehicleModel v")
    , @NamedQuery(name = "VehicleModel.findByModel", query = "SELECT v FROM VehicleModel v WHERE v.model = :model")
    , @NamedQuery(name = "VehicleModel.findByMake", query = "SELECT v FROM VehicleModel v WHERE v.make = :make")})
public class VehicleModel implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @Column(name = "MAKE")
    private String make;

    public VehicleModel() {
    }

    public VehicleModel(String model) {
        this.model = model;
    }

    public VehicleModel(String model, String make) {
        this.model = model;
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        String oldModel = this.model;
        this.model = model;
        changeSupport.firePropertyChange("model", oldModel, model);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        String oldMake = this.make;
        this.make = make;
        changeSupport.firePropertyChange("make", oldMake, make);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (model != null ? model.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleModel)) {
            return false;
        }
        VehicleModel other = (VehicleModel) object;
        if ((this.model == null && other.model != null) || (this.model != null && !this.model.equals(other.model))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vehiclesofinterestdesktop.VehicleModel[ model=" + model + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
