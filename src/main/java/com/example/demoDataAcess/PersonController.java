package com.example.demoDataAcess;

import com.example.demoDataAcess.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
   private PersonRepository personRepository;

    @Autowired
    UserServiceImpl userService;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @RequestMapping("/all")
    public String list(Model model){
        //List<Person> personList = personRepository.findAll();
        //分页查找
        Page<Person> personList = personRepository.findAll(PageRequest.of(0, 10));
        model.addAttribute("persons",personList);
        return "list";
    }
    @RequestMapping("/person1")
    public String person(Model model){
        Person p = userService.getOne(1);
        model.addAttribute("persons",p);
        return "list";
    }
    @RequestMapping(value = "/addnew",method = RequestMethod.GET)
    public String addnew(){
        return "addnew";
    }
    @RequestMapping(value = "/addnew",method = RequestMethod.POST)
    public String addnew(Person person){
        personRepository.save(person);
        return "redirect:/person/all";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(){
        return "delete";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(int id){
        personRepository.deleteById(id);
        return "redirect:/person/all";
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(){
        return "update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Integer id,String newpass){
        Person p = personRepository.getOne(id);
        p.setPassword(newpass);
        personRepository.save(p);
        return "redirect:/person/all";

    }
}
