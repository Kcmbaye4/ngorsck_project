package sn.kcmbaye4.dev.appisi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sn.kcmbaye4.dev.appisi.entities.Product;
import sn.kcmbaye4.dev.appisi.service.AppIsiService;

import javax.validation.Valid;

@Controller
public class AppisiController {

    @Autowired
    private AppIsiService appIsiService;

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "size", defaultValue = "3") int size,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Product> prods = appIsiService.findAllProdsByKeyword(keyword, PageRequest.of(page, size));
        model.addAttribute("products", prods.getContent());
        model.addAttribute("nbPages", new int[prods.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("kw", keyword);
        return "home";
    }

    @GetMapping("/formProd")
    public String formPat(Model model){
        model.addAttribute("product", new Product());
        return "formProd";
    }

    @GetMapping("/editProd")
    public String editPat(Model model, Long id, int page, String keyword){
        Product product = appIsiService.findProductById(id);
        if(product==null) throw new RuntimeException("Produit intouvable!");
        model.addAttribute("product", product);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "editProd";
    }

    @GetMapping("/deleteProd")
    public String deletePat(Long id, int page, @RequestParam(name = "keyword", defaultValue = "") String keyword){
        appIsiService.deleteProduct(id);
        return "redirect:/home?page="+page+"&keyword="+keyword;
    }

    @PostMapping("/add")
    public String addPat(Model model, @Valid Product product, BindingResult bindingResult, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "keyword", defaultValue = "") String keyword){
        if (bindingResult.hasErrors()) return "formProd";
        appIsiService.addProduct(product);
        return "redirect:/home?page="+page+"&keyword="+keyword;
    }


}
