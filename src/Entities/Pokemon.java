package Entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Pokemon {
    private Integer id;
    private String name;
    private String[] types;
    private Integer total;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer spAttack;
    private Integer spDefense;
    private Integer speed;
    private Integer generation;
    private Boolean legendary;

    Pokemon(){}

    Pokemon(String[] atts){
        this.id = Integer.valueOf(atts[0]);
        this.name = atts[1];
        this.types = new String[]{atts[2], atts[3]};
        this.total = Integer.valueOf(atts[4]);
        this.hp = Integer.valueOf(atts[5]);
        this.attack = Integer.valueOf(atts[6]);
        this.defense = Integer.valueOf(atts[7]);
        this.spAttack = Integer.valueOf(atts[8]);
        this.spDefense = Integer.valueOf(atts[9]);
        this.speed = Integer.valueOf(atts[10]);
        this.generation = Integer.valueOf(atts[11]);
        this.legendary = atts[12].equals("True");
    }

    public static String parseGeneration(Integer gen){
        switch(gen){
            case 1:
                return "Kanto";
            case 2:
                return "Johto";
            case 3:
                return "Hoenn";
            case 4:
                return "Sinnoh";
            case 5:
                return "Unova";
            case 6:
                return "Kalos";
            case 7:
                return "Alola";
            default:
                return "Galar";
        }
    }

    public static ArrayList<Pokemon> getFromCsvFile(File file) throws IOException {
        if(file == null){
            file = new File("src/Resources/pkmn.csv");
        }

        System.out.println(file.getAbsolutePath());

        Stream<String> reader = new BufferedReader(new FileReader(file.getAbsolutePath())).lines().skip(1);
        ArrayList<Pokemon> pkmns = new ArrayList<>();

        reader.forEach(data -> pkmns.add(new Pokemon(data.split(","))));

        return pkmns;
    }

    public String toString(){

        return "{ id: "+ this.id + ", " + "name :" + this.name + ", " + "types : [" + this.types[0] + "," + this.types[1] + "], " +
                "total :" + this.total + ", " + "hp :" + this.hp + ", " + "attack :" + this.attack + ", "
                + "defense :" +
                this.defense + ", " + "spAttack :" + this.spAttack + ", " + "spDefense :" + this.spDefense + ", " +
                "speed :" + this.speed + ", " + "generation :" + this.generation + ", "
                + "legendary :" + this.legendary +
                " }";
    }

    public Integer getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String[] getTypes() {
        return types;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getSpAttack() {
        return spAttack;
    }

    public Integer getSpDefense() {
        return spDefense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getGeneration() {
        return generation;
    }

    public Boolean getLegendary() {
        return legendary;
    }
}
