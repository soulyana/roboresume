package me.soulyana.demo.repositories;

import me.soulyana.demo.models.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Long> {
}
