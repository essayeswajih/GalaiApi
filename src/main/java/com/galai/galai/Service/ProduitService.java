package com.galai.galai.Service;

import com.galai.galai.Entity.Produit;
import com.galai.galai.Repository.ProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private final ProduitRepository PR;

    public ProduitService(ProduitRepository pr) {
        PR = pr;
    }

    public Produit save(Produit produit) {
        return PR.saveAndFlush(produit);
    }

    public List<Produit> saveAll(List<Produit> articles) {
        return PR.saveAllAndFlush(articles);
    }

    public void delete(Integer id) {
        PR.deleteById(id);
    }

    public List<Produit> getAllProduit() {
        return PR.findAll();
    }

    public Produit getProduitById(Integer id) {

        Optional<Produit> optionalArticle = PR.findById(id);
        return optionalArticle.orElseThrow(() ->new EntityNotFoundException("Product not found"));
    }
}
