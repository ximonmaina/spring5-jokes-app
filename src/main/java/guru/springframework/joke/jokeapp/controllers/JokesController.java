package guru.springframework.joke.jokeapp.controllers;

import guru.springframework.joke.jokeapp.services.JokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private JokerService jokerService;

    @Autowired
    public JokesController(JokerService jokerService) {
        this.jokerService = jokerService;
    }

    @RequestMapping({"/", ""}) //map out the context root
    public String showJoke( Model model){
        //append model with a propery for the joke
        //property is from the joke service
        model.addAttribute("joke",jokerService.getJoke());

        //return view name
        return "chucknorris";
    }
}
