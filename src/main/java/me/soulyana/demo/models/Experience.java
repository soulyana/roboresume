package me.soulyana.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expId;

    @NotNull
    @Size(min = 4)
    private String title;

    @NotNull
    @Size(min = 4)
    private String org;

    @NotNull
    @Size(min = 4)
    private String startTime;
    private String endTime;

    @NotNull
    @Size(min = 4)
    private String duty1;

    @NotNull
    @Size(min = 4)
    private String duty2;


    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long expId) {
        this.expId = expId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuty1() {
        return duty1;
    }

    public void setDuty1(String duty1) {
        this.duty1 = duty1;
    }

    public String getDuty2() {
        return duty2;
    }

    public void setDuty2(String duty2) {
        this.duty2 = duty2;
    }
}
