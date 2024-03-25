package jalkapallo.bookstore.web;

import jalkapallo.bookstore.domain.Jalkapalloilija;
import jalkapallo.bookstore.repository.JalkapalloilijaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid; // Varmista, että tämä on oikea import-lausunta

@Controller
@RequestMapping("/jalkapalloilijat")
public class JalkapalloilijaController {

    private final JalkapalloilijaRepository jalkapalloilijaRepository;

    public JalkapalloilijaController(JalkapalloilijaRepository jalkapalloilijaRepository) {
        this.jalkapalloilijaRepository = jalkapalloilijaRepository;
    }

    @GetMapping
    public String listJalkapalloilijat(Model model) {
        model.addAttribute("jalkapalloilijat", jalkapalloilijaRepository.findAll());
        return "jalkapalloilijat";
    }

    @GetMapping("/add")
    public String showAddJalkapalloilijaForm(Model model) {
        model.addAttribute("jalkapalloilija", new Jalkapalloilija());
        return "addJalkapalloilija";
    }

    @PostMapping("/add")
    public String addJalkapalloilija(@Valid @ModelAttribute Jalkapalloilija jalkapalloilija, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addJalkapalloilija";
        }
        jalkapalloilijaRepository.save(jalkapalloilija);
        return "redirect:/jalkapalloilijat";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Jalkapalloilija jalkapalloilija = jalkapalloilijaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Virheellinen jalkapalloilijan ID: " + id));
        model.addAttribute("jalkapalloilija", jalkapalloilija);
        return "updateJalkapalloilija";
    }

    @PostMapping("/update/{id}")
    public String updateJalkapalloilija(@PathVariable("id") long id, @Valid @ModelAttribute Jalkapalloilija jalkapalloilija, BindingResult result) {
        if (result.hasErrors()) {
            jalkapalloilija.setId(id);
            return "updateJalkapalloilija";
        }

        jalkapalloilijaRepository.save(jalkapalloilija);
        return "redirect:/jalkapalloilijat";
    }

    @GetMapping("/delete/{id}")
    public String deleteJalkapalloilija(@PathVariable Long id) {
        jalkapalloilijaRepository.deleteById(id);
        return "redirect:/jalkapalloilijat";
    }
}
