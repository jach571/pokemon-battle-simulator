import java.util.*;

public class Pokemon{
    private Types type;
    private ArrayList<Moves> moveList = new ArrayList<Moves>();
    private String name;
    private double hp;

    public Pokemon(Types type, ArrayList<Moves> moveList, String name, double hp){
        this.type = type;
        this.moveList = moveList;
        this.name = name;
        this.hp = hp;
    }

    public void dealDamage(Moves move, Types defenseType){
        hp -= move.getATK() * Types.getEffectiveness(move.getMoveType(), defenseType);
    }

    public double damageDealt(Moves move, Types defenseType){
        return move.getATK() * Types.getEffectiveness(move.getMoveType(), defenseType);
    }

    public Types getPokemonType(){
        return type;
    }

    public ArrayList<Moves> getMoveList(){
        return moveList;
    }

    public String getPokemonName(){
        return name;
    }

    public double getHP(){
        return hp;
    }
}