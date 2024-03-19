package jalkapallo.bookstore.web;

import jalkapallo.bookstore.domain.Jalkapalloilija;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/jalkapalloilijat")
public class JalkapalloilijaController {

    private final List<Jalkapalloilija> jalkapalloilijat = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public String listJalkapalloilijat(Model model) {
        model.addAttribute("jalkapalloilijat", jalkapalloilijat);
        return "jalkapalloilijat";
    }

    @GetMapping("/add")
    public String showAddJalkapalloilijaForm(Model model) {
        model.addAttribute("jalkapalloilija", new Jalkapalloilija());
        return "addJalkapalloilija";
    }

    @PostMapping("/add")
    public String addJalkapalloilija(@ModelAttribute Jalkapalloilija jalkapalloilija) {
        jalkapalloilija.setId(counter.incrementAndGet()); // Aseta yksilöllinen id
        jalkapalloilijat.add(jalkapalloilija);
        return "redirect:/jalkapalloilijat";
    }

    @GetMapping("/delete/{id}")
    public String deleteJalkapalloilija(@PathVariable Long id) {
        jalkapalloilijat.removeIf(jalkapalloilija -> jalkapalloilija.getId().equals(id));
        return "redirect:/jalkapalloilijat";
    }
}
