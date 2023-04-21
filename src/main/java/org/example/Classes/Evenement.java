package org.example.Classes;

import java.util.Date;

public class Evenement {
    private String nom;
    private Date date;
    private String heure;
    private Lieu lieu;
    private  float prix;
    private int nbrBilletVendu=0;

    public Evenement(String nom, Date date, String heure, float prix, Lieu lieu){
        this.nom = nom;
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        this.prix = prix;
    }

    public boolean verifDIspoBillet (){
        return this.nbrBilletVendu < this.lieu.getCapacite();
    }

    public boolean vendreBillet (){
        if(verifDIspoBillet()){
            this.nbrBilletVendu ++;
            System.out.println("un billet a ete acheter il reste "+(this.lieu.getCapacite()-this.nbrBilletVendu)+" places disponible.");
            return true;
        }
        else {
            System.out.println("il n'y a plus de billets disponible");
            return false;
        }
    }

    public boolean annulerBillet(){
        if(this.nbrBilletVendu == 0){
            System.out.println("il n'y a eu aucun billet vendu pour cette evenement");
            return false;
        }
        else{
            this.nbrBilletVendu --;
            System.out.println("le billet a bien ete annuler");
            return true;
        }
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNbrBilletVendu() {
        return nbrBilletVendu;
    }

    public void setNbrBilletVendu(int nbrBilletVendu) {
        this.nbrBilletVendu = nbrBilletVendu;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "nom='" + nom + '\'' +
                ", date=" + date +
                ", heure='" + heure + '\'' +
                ", lieu=" + lieu +
                ", prix=" + prix +
                ", nbrBilletVendu=" + nbrBilletVendu +
                '}';
    }


}
