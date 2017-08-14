package me.soulyana.demo.repositories;

import me.soulyana.demo.models.Education;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education, Long> {
}
