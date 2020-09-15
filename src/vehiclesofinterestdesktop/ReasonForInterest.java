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
@Table(name = "REASON_FOR_INTEREST", catalog = "", schema = "VEHICLESOFINTEREST")
@NamedQueries({
    @NamedQuery(name = "ReasonForInterest.findAll", query = "SELECT r FROM ReasonForInterest r")
    , @NamedQuery(name = "ReasonForInterest.findByReason", query = "SELECT r FROM ReasonForInterest r WHERE r.reason = :reason")
    , @NamedQuery(name = "ReasonForInterest.findByDescription", query = "SELECT r FROM ReasonForInterest r WHERE r.description = :description")})
public class ReasonForInterest implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REASON")
    private String reason;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;

    public ReasonForInterest() {
    }

    public ReasonForInterest(String reason) {
        this.reason = reason;
    }

    public ReasonForInterest(String reason, String description) {
        this.reason = reason;
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        String oldReason = this.reason;
        this.reason = reason;
        changeSupport.firePropertyChange("reason", oldReason, reason);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reason != null ? reason.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReasonForInterest)) {
            return false;
        }
        ReasonForInterest other = (ReasonForInterest) object;
        if ((this.reason == null && other.reason != null) || (this.reason != null && !this.reason.equals(other.reason))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vehiclesofinterestdesktop.ReasonForInterest[ reason=" + reason + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
