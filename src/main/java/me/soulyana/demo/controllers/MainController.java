package me.soulyana.demo.controllers;

import me.soulyana.demo.models.Education;
import me.soulyana.demo.models.Experience;
import me.soulyana.demo.models.Person;
import me.soulyana.demo.models.Skills;
import me.soulyana.demo.repositories.EducationRepository;
import me.soulyana.demo.repositories.ExperienceRepository;
import me.soulyana.demo.repositories.PersonRepository;
import me.soulyana.demo.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    ExperienceRepository experienceRepository;


    @GetMapping("/")
    public String home() {
        return "Welcome to your Robo Resume!";
    }

    @GetMapping("/addperson")
    public String addPerson(Model model) {
        if (personRepository.count() >= 1) {
            return "limit";
        }

        model.addAttribute("newperson", new Person());
        return "addperson";
    }

    @PostMapping("/addperson")
    public String postperson(@Valid @ModelAttribute("newperson") Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addperson";
        }

        personRepository.save(person);
        return "displayperson";
    }

    @GetMapping("/addeducation")
    public String addEducation(Model model) {
        System.out.println(educationRepository.count());

        if (educationRepository.count() >= 10) {
            return "limit";
        }

        model.addAttribute("neweducation", new Education());
        return "addeducation";
    }

    @PostMapping("/addeducation")
    public String postEducation(@Valid @ModelAttribute("neweducation") Education education, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addeducation";
        }

        educationRepository.save(education);
        return "dispalyeducation";
    }

    @GetMapping("/addskill")
    public String addSkill(Model model) {
        System.out.println(skillsRepository.count());

        if (skillsRepository.count() >= 20) {
            return "limit";
        }

        model.addAttribute("newskill", new Skills());
        return "addskill";
    }

    @PostMapping("/addskill")
    public String postSkill(@Valid @ModelAttribute("newskill") Skills skills, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addskill";
        }

        skillsRepository.save(skills);
        return "dispalyskill";
    }

    @GetMapping("/addexperience")
    public String addExperience(Model model) {
        System.out.println(experienceRepository.count());

        if (experienceRepository.count() >= 10) {
            return "limit";
        }

        model.addAttribute("newexperience", new Experience());
        return "addexperience";
    }

    @PostMapping("/addexperience")
    public String postExperience(@Valid @ModelAttribute("newexperience") Experience experience, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addexperience";
        }

        experienceRepository.save(experience);
        return "dispalyexperience";
    }

    @GetMapping("/displayall")
    public String getAll(Model model) {
        if (personRepository.count() == 0) {
            return "/addperson";
        }

        if (educationRepository.count() == 0) {
            return "/addeducation";
        }

        if (skillsRepository.count() == 0) {
            return "/addskill";
        }

        if (experienceRepository.count() == 0) {
            return "/addexperience";
        }

        Person person = new Person();
        Iterable<Person> allpersons = personRepository.findAll();
        model.addAttribute("person", allpersons);

        Iterable<Education> alleducation = educationRepository.findAll();
        ArrayList<Education> educationArrayList = new ArrayList<>();
        educationArrayList = (ArrayList<Education>) alleducation;
        person.setEd(educationArrayList);
        model.addAttribute("alleducation", person.getEd());

        Iterable<Experience> allexperience = experienceRepository.findAll();
        ArrayList<Experience> experienceArrayList = new ArrayList<>();
        experienceArrayList = (ArrayList<Experience>) allexperience;
        person.setExp(experienceArrayList);
        model.addAttribute("allexperience", person.getExp());

        Iterable<Skills> allskills = skillsRepository.findAll();
        ArrayList<Skills> skillsArrayList = new ArrayList<>();
        skillsArrayList = (ArrayList<Skills>) allskills;
        person.setSkills(skillsArrayList);
        model.addAttribute("allskills", person.getSkills());

        return "displayall";
    }
}