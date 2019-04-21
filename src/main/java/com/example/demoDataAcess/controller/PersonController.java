package com.example.demoDataAcess.controller;

import com.example.demoDataAcess.Dao.PersonRepository;
import com.example.demoDataAcess.entity.Person;
import com.example.demoDataAcess.service.IPersonService;
import com.example.demoDataAcess.service.UserServiceImpl;
import com.example.demoDataAcess.service.base.IPersonBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
   private PersonRepository personRepository;

    @Autowired
    UserServiceImpl userService;
//    @Autowired
//    private IPersonBaseService personBaseService;
    @Autowired
    private IPersonService personService;

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

        Person person = personRepository.findById(id).orElse(null);
        Person person1 = personRepository.findPersonById(id);
//        Person person2 = personBaseService.findById(id);
        Person person3 = personService.queryById(id);
        Person p = personRepository.getOne(id);
        p.setPassword(newpass);
        personRepository.save(p);
        return "redirect:/person/all";

    }
}
