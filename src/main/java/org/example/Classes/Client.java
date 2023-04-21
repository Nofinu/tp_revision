package org.example.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    private String nom;
    private String prenom;
    private String email;
    private List<Evenement> listeBillets = new ArrayList<>();

    public Client(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public void acheterBillet (Evenement event){
        if(event.vendreBillet()){
            listeBillets.add(event);
            System.out.println("le billet pour l'evenement "+event+" a bien ete acheter");
        }
    }

    public void annulerBillet (Evenement event){
        if(event.annulerBillet()){
           this.listeBillets = this.listeBillets.stream().filter(e -> e.getNom() != event.getNom()).collect(Collectors.toList());
            System.out.println("le billet pour l'evenement "+event+" a bien ete annuler");
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", listeBillets=" + listeBillets +
                '}';
    }
}
