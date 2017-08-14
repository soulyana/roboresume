package me.soulyana.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long edId;

    @NotNull
    @Size(min = 4)
    private String university;

    @NotNull
    @Size(min = 4)
    private String degree;

    @NotNull
    @Size(min = 4)
    private String gradYear;

    public Long getEdId() {
        return edId;
    }

    public void setEdId(Long edId) {
        this.edId = edId;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }
}
