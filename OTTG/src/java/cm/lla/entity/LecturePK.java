/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lla.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Lorenzo Lemetice Alberto
 */
@Embeddable
public class LecturePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idlecture", nullable = false)
    private int idlecture;
    @Basic(optional = false)
    @Column(name = "timetable_idtimetable", nullable = false)
    private int timetableIdtimetable;
    @Basic(optional = false)
    @Column(name = "lecturer_user_iduser", nullable = false)
    private int lecturerUserIduser;

    public LecturePK() {
    }

    public LecturePK(int idlecture, int timetableIdtimetable, int lecturerUserIduser) {
        this.idlecture = idlecture;
        this.timetableIdtimetable = timetableIdtimetable;
        this.lecturerUserIduser = lecturerUserIduser;
    }

    public int getIdlecture() {
        return idlecture;
    }

    public void setIdlecture(int idlecture) {
        this.idlecture = idlecture;
    }

    public int getTimetableIdtimetable() {
        return timetableIdtimetable;
    }

    public void setTimetableIdtimetable(int timetableIdtimetable) {
        this.timetableIdtimetable = timetableIdtimetable;
    }

    public int getLecturerUserIduser() {
        return lecturerUserIduser;
    }

    public void setLecturerUserIduser(int lecturerUserIduser) {
        this.lecturerUserIduser = lecturerUserIduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlecture;
        hash += (int) timetableIdtimetable;
        hash += (int) lecturerUserIduser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LecturePK)) {
            return false;
        }
        LecturePK other = (LecturePK) object;
        if (this.idlecture != other.idlecture) {
            return false;
        }
        if (this.timetableIdtimetable != other.timetableIdtimetable) {
            return false;
        }
        if (this.lecturerUserIduser != other.lecturerUserIduser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.LecturePK[ idlecture=" + idlecture + ", timetableIdtimetable=" + timetableIdtimetable + ", lecturerUserIduser=" + lecturerUserIduser + " ]";
    }
    
}
