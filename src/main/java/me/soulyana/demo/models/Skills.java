package me.soulyana.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skills {

    @Id
    @GeneratedValue
    private Long skillId;

    @NotNull
    @Size(min = 4)
    private String skillName;

    @NotNull
    @Size(min = 4)
    private String skillRating;

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillRating() {
        return skillRating;
    }

    public void setSkillRating(String skillRating) {
        this.skillRating = skillRating;
    }
}
