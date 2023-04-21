package org.example.Classes.Ihm;

import org.example.Classes.Client;
import org.example.Classes.Evenement;
import org.example.Classes.Lieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ihm {
    protected List<Lieu> listLieu = new ArrayList<>();
    protected List<Client> listCLient = new ArrayList<>();
    protected List<Evenement> listEvenement = new ArrayList<>();

    private Scanner s = new Scanner(System.in);

    public Ihm() {
    }

    public void start() {
        this.menuGenerale();
    }

    public void menuGenerale (){
        try{
            System.out.println("----------menu---------");
            System.out.println("1/ action Lieux");
            System.out.println("2/ action Evenements");
            System.out.println("3/ action client");
            System.out.println("0/ quitter");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            switch (entry){
                case 1:
                    this.menuLieux();
                    break;
                case 2 :
                    this.menuEvenement();
                    break;
                case 3:
                    break;
                case 0 :
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuGenerale();
                    break;
            }

        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.menuGenerale();
        }

    }

    //gestion des lieux

    public void menuLieux (){
        try{
            System.out.println("----------menu Lieux---------");
            System.out.println("1/ ajouter un lieu");
            System.out.println("2/ modifier un lieu");
            System.out.println("3/ supprimer un lieu");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            switch (entry){
                case 1:
                    this.addLieux();
                    break;
                case 2:
                    this.modifLieu();
                    break;
                case 3 :
                    this.suprLieu();
                    break;
                case 0:
                    this.menuGenerale();
                    break;
                default :
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuLieux();
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.menuLieux();
        }
    }

    public void addLieux (){
        try {
            System.out.println("--------ajouter lieu----------");
            System.out.println("entrer le nom du lieu :");
            String nomLieux = s.next();
            System.out.println("entrer l'adresse du lieu :");
            String adresse = s.next();
            int capacite = this.entryCapacity();

            this.listLieu.add(new Lieu(nomLieux,adresse,capacite));
            System.out.println("le lieux a bien ete ajouter :");
            System.out.println(listLieu.get(listLieu.size()-1));
            this.menuLieux();
        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.addLieux();
        }
    }

    public void modifLieu (){
        try{
            try{
                System.out.println("--------modifier lieu----------");
                afficheList(this.listLieu);
                System.out.println("quelle lieux vouler vous modifier : ");
                int entry = s.nextInt();

                System.out.println(this.listLieu.get(entry-1));
                System.out.println("entrer le nouveau nom : ");
                String nom =s.next();
                System.out.println("entrer la nouvelle adresse : ");
                String adresse = s.next();
                int capacite = this.entryCapacity();

                this.listLieu.set(entry-1,new Lieu(nom,adresse,capacite));
                System.out.println(this.listLieu.get(entry-1));
                this.menuLieux();
            }
            catch (IndexOutOfBoundsException e){
                this.menuLieux();
            }
        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.modifLieu();
        }
    }

    public void suprLieu (){
        try{
            System.out.println("--------supr lieu----------");
            afficheList(this.listLieu);
            System.out.println("quelle lieux vouler vous supprimer (0 pour retour) : ");
            int entry = s.nextInt();

            if(entry == 0){
               this.menuLieux();
            }
            else{
                this.listLieu.remove(entry-1);
                System.out.println("le lieux a bien ete supprimer");
                this.menuLieux();
            }
        }
        catch( InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.suprLieu();
        }
    }

    public int entryCapacity (){
        int entry =0;
       do {
           System.out.println("entrer la capacité du lieu :");
           entry = s.nextInt();
       }
       while (entry<=0);

       return entry;
    }



    // gestion des evenements

    public void menuEvenement (){
        try{
            System.out.println("----------menu Evenement---------");
            System.out.println("1/ ajouter un Evenement");
            System.out.println("2/ modifier un Evenement");
            System.out.println("3/ supprimer un Evenement");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            switch (entry){
                case 1:
                    this.addEvenement();
                    break;
                case 2:

                    break;
                case 3 :

                    break;
                case 0:
                    this.menuGenerale();
                    break;
                default :
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuEvenement();
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.menuLieux();
        }
    }

    public void addEvenement (){
        try {
            System.out.println("--------ajouter Evenement----------");

            System.out.println("entrer le nom de l'evenement:");
            String nom = s.next();

            System.out.println("entrer la date de l'evenement (format dd-MM-yyyy):");
            String date_string = s.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);

            System.out.println("entrer l'heure de l'evenement :");
            String heure = s.next();

            System.out.println();
            this.afficheList(listLieu);
            System.out.println("selectionner le lieu de l'evenement :");
            int lieux = s.nextInt();

            System.out.println("entrer le prix du billet");
            float prix = s.nextFloat();


            this.listEvenement.add(new Evenement(nom, date, heure,prix,this.listLieu.get(lieux-1)));
            System.out.println("l'evenement a bien ete ajouter :");
            System.out.println(listEvenement.get(listEvenement.size()-1));
            this.menuEvenement();
        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.addEvenement();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    //fonctions global
    public void afficheList (List list){
        list.forEach(System.out::println);
        System.out.println();
    }


    public void menuCLient (){

    }

}
