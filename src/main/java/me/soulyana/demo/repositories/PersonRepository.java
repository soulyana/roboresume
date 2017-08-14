package me.soulyana.demo.repositories;

import me.soulyana.demo.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
