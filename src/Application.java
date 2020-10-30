import Controllers.UserActionController;
import Entities.AvlTree;
import Entities.Pokemon;

import java.io.IOException;
import java.util.ArrayList;

public class Application {

    public static String capitalize(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void main(String[] args) {
        ArrayList<Pokemon> pkmns = new ArrayList<>();

        try {
            pkmns = Pokemon.getFromCsvFile("Resources/pkmn.csv");
        } catch (IOException e) {
            try{
                pkmns = Pokemon.getFromCsvFile("src/resources/pkmn.csv");
            }catch (IOException ex) {
                System.out.println("Arquivo CSV não encontrado");
                System.exit(1);
            }
        }

        AvlTree tree = new AvlTree();

        for(Pokemon pkmn : pkmns) {
            tree.insert(pkmn);
        }

        int id = UserActionController.getUserInputNumber("Digite o ID de um Pokémon (de 1 a 863):");

        if(id < 1 || id > 863){
            System.out.println("Este Pokémon não existe.");
            System.exit(0);
        }

        Pokemon p = tree.search(id);

        System.out.println("O seu Pokémon é o " + capitalize(p.getName()) + "! ^^");
        System.out.println("Status: ");
        System.out.println("Atk: " + p.getAttack());
        System.out.println("Def: " + p.getDefense());
        System.out.println("Speed: " + p.getSpeed());
        System.out.println("HP: " + p.getHp());
        System.out.println("Sp. Atk: " + p.getSpAttack());
        System.out.println("Sp. Def: " + p.getSpDefense());
        System.out.println("Região: " + Pokemon.parseGeneration(p.getGeneration()));
    }
}