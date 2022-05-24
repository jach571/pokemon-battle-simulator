public class Moves{
    private Types type;
    private int pp;
    private int atk;
    private String name;

    public Moves(Types type, int pp, int atk, String name){
        this.type = type;
        this.pp = pp;
        this.atk = atk;
        this.name = name;
    }

    public void usePP(){
        pp -= 1;
    }

    public Types getMoveType(){
        return type;
    }

    public int getPP(){
        return pp;
    }

    public int getATK(){
        return atk;
    }

    public String getMoveName(){
        return name;
    }
}