package com.galai.galai.Controller;

import com.galai.galai.Entity.Commande;
import com.galai.galai.Service.CommandeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("commande")
public class CommandeController {
    @Autowired
    private final CommandeService CS;

    public CommandeController(CommandeService cs) {
        CS = cs;
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Commande commande) {
        System.out.println(commande);
        try {
            return ResponseEntity.ok().body(CS.save(commande));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            CS.delete(CS.getById(id).getId());
            return ResponseEntity.ok().body("Commande : " + id + " supprimée avec succées");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCommande() {
        try {
            return ResponseEntity.ok().body(CS.getAllCommande());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/getByNom")
    public ResponseEntity<?> getCommandeByNom(@RequestParam("nom") String nom) {
        try {
            return ResponseEntity.ok().body(CS.getCommandeByNom(nom));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
