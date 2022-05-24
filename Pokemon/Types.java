public class Types{
    private String type;

    public Types(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public static double getEffectiveness(Types attack, Types defense){
        String attackType = attack.getType();
        String defenseType = defense.getType();
        double effectiveness = 1;

        if(attackType == "normal"){
            if(defenseType == "rock"){
                effectiveness *= 0.5;
            } else if(defenseType == "ghost"){
                effectiveness *= 0;
            } else if(defenseType == "steel"){
                effectiveness *= 0.5;
            }
        } else if(attackType == "fire"){
            if(defenseType == "fire"){
                effectiveness *= 0.5;
            } else if(defenseType == "water"){
                effectiveness *= 0.5;
            } else if(defenseType == "grass"){
                effectiveness *= 2;
            } else if(defenseType == "ice"){
                effectiveness *= 2;
            }  else if(defenseType == "bug"){
                effectiveness *= 2;
            } else if(defenseType == "rock"){
                effectiveness *= 0.5;
            } else if(defenseType == "dragon"){
                effectiveness *= 0.5;
            } else if(defenseType == "steel"){
                effectiveness *= 2;
            } 
        } else if(attackType == "water"){
            if(defenseType == "fire"){
                effectiveness *= 2;
            } else if(defenseType == "water"){
                effectiveness *= 0.5;
            } else if(defenseType == "grass"){
                effectiveness *= 0.5;
            } else if(defenseType == "ground"){
                effectiveness *= 2;
            } else if(defenseType == "rock"){
                effectiveness *= 2;
            } else if(defenseType == "dragon"){
                effectiveness *= 0.5;
            } 
        } else if(attackType == "electric"){
            if(defenseType == "water"){
                effectiveness *= 2;
            } else if(defenseType == "electric"){
                effectiveness *= 0.5;
            } else if(defenseType == "grass"){
                effectiveness *= 0.5;
            } else if(defenseType == "ground"){
                effectiveness *= 0;
            } else if(defenseType == "flying"){
                effectiveness *= 2;
            } else if(defenseType == "dragon"){
                effectiveness *= 0.5;
            } 
        } else if(attackType == "grass"){
            if(defenseType == "fire"){
                effectiveness *= 0.5;
            } else if(defenseType == "water"){
                effectiveness *= 2;
            } else if(defenseType == "grass"){
                effectiveness *= 0.5;
            } else if(defenseType == "poison"){
                effectiveness *= 0.5;
            } else if(defenseType == "ground"){
                effectiveness *= 2;
            } else if(defenseType == "flying"){
                effectiveness *= 0.5;
            } else if(defenseType == "bug"){
                effectiveness *= 0.5;
            } else if(defenseType == "rock"){
                effectiveness *= 2;
            } else if(defenseType == "dragon"){
                effectiveness *= 0.5;
            } else if(defenseType == "steel"){
                effectiveness *= 0.5;
            }
        }

        return effectiveness;
    }
}