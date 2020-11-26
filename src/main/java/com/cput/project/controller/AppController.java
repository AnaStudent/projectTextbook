package com.cput.project.controller;

import com.cput.project.entity.Textbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.cput.project.service.TextbookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

   @Autowired
   private TextbookService textbookService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Textbook> listTextbooks = textbookService.listAll();
        model.addAttribute("listTextbooks", listTextbooks);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Textbook textbook = new Textbook();
        model.addAttribute("textbook", textbook);

        return "new_textbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTextbook(@ModelAttribute("textbook") Textbook textbook) {
        textbookService.save(textbook);
        return "redirect:/";
    }

    @RequestMapping("/edit/{bookId}")
    public ModelAndView showEditTextbokPage(@PathVariable(name = "bookId") int id) {
        ModelAndView mav = new ModelAndView("edit_textbook");
        Textbook textbook = textbookService.get(id);
        mav.addObject("textbook", textbook);
        return mav;
    }

    @RequestMapping("/delete/{bookId}")
    public String deleteTextbook(@PathVariable(name = "bookId") int id) {
        textbookService.delete(id);
        return "redirect:/";
    }
}
