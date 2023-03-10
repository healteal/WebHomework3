package com.example.webhomework3.controllers;

import com.example.webhomework3.models.Phrase;
import com.example.webhomework3.enums.TypeOfPhrase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class MainController {

    List<Phrase> phrases = new ArrayList<>();

    {
        phrases.add(new Phrase("Я никогда не позволял школе вмешиваться в моё образование.",
                TypeOfPhrase.EDUCATION));
        phrases.add(new Phrase("Именно там, где мы не можем изменить ситуацию, мы призваны измениться сами.",
                TypeOfPhrase.PERSONAL_GROW));
        phrases.add(new Phrase("Любовь это лучшее, что может с нами случиться. Если в твоей жизни есть это чувство можешь считать, что тебе повезло.",
                TypeOfPhrase.RELATION));
        phrases.add(new Phrase("Лучшее, что нам даёт история, — это возбуждаемый ею энтузиазм.",
                TypeOfPhrase.HISTORY));
    }

    @GetMapping("/")
    public String mainPage(Model model,
                           @RequestParam(name = "choice", required = false) String choice) {
        if (choice != null) {
            model.addAttribute("phrase", phrases.stream()
                    .filter(phrase -> phrase.getTypeOfPhrase().toString().equalsIgnoreCase(choice))
                    .findAny()
                    .orElseThrow()
                    .getPhrase());
        } else {
            model.addAttribute("phrase", phrases.get(ThreadLocalRandom.current().nextInt(0, 3 + 1)).getPhrase());
        }
        return "main-page";
    }
}
