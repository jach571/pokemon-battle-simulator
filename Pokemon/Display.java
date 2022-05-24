import java.util.*;

public class Display{
    public Display(){
    }

    public void play(){
        Types water = new Types("water");
        Types fire = new Types("fire");
        Types grass = new Types("grass");
        Types normal = new Types("normal");

        ArrayList<Moves> charmanderMoves = new ArrayList<Moves>();
        ArrayList<Moves> squirtleMoves = new ArrayList<Moves>();
        ArrayList<Moves> bulbasaurMoves = new ArrayList<Moves>();
        ArrayList<Moves> eeveeMoves = new ArrayList<Moves>();
        Moves Flamethrower = new Moves(fire, 15, 9, "Flamethrower");
        Moves Inferno = new Moves(fire, 5, 10, "Inferno");
        Moves SolarBeam = new Moves(grass, 10, 12, "Solar Beam");
        Moves Surf = new Moves(water, 15, 9, "Surf");
        Moves HyperBeam = new Moves(normal, 15, 6, "Hyper Beam");
        Moves HydroPump = new Moves(water, 5, 11, "Hydro Pump");

        charmanderMoves.add(Flamethrower);
        charmanderMoves.add(Inferno);
        charmanderMoves.add(SolarBeam);
        charmanderMoves.add(Surf);

        squirtleMoves.add(Surf);
        squirtleMoves.add(HyperBeam);
        squirtleMoves.add(HydroPump);
        squirtleMoves.add(Flamethrower);

        bulbasaurMoves.add(SolarBeam);
        bulbasaurMoves.add(HyperBeam);
        bulbasaurMoves.add(Surf);
        bulbasaurMoves.add(Flamethrower);

        eeveeMoves.add(HyperBeam);
        eeveeMoves.add(Flamethrower);
        eeveeMoves.add(SolarBeam);
        eeveeMoves.add(HydroPump);

        Pokemon Charmander = new Pokemon(fire, charmanderMoves, "Charmander", 100);
        Pokemon Squirtle = new Pokemon(water, squirtleMoves, "Squirtle", 100);
        Pokemon Bulbasaur = new Pokemon(grass, bulbasaurMoves, "Bulbasaur", 100);
        Pokemon Eevee = new Pokemon(normal, eeveeMoves, "Eevee", 100);

        ArrayList<Pokemon> playerTeam = new ArrayList<Pokemon>();
        playerTeam.add(Charmander);
        playerTeam.add(Bulbasaur);
        ArrayList<Pokemon> enemyTeam = new ArrayList<Pokemon>();
        enemyTeam.add(Squirtle);
        enemyTeam.add(Eevee);

        battleLoop(playerTeam, enemyTeam);
    }

    public void battleLoop(ArrayList<Pokemon> pT, ArrayList<Pokemon> eT){
        Scanner scan = new Scanner(System.in);
        boolean valid = true;
        String playerMove = "";
        String playerAttack = "";
        ArrayList<Pokemon> playerTeam = pT;
        int playerIndex = 0;
        ArrayList<Pokemon> enemyTeam = eT;
        int enemyIndex = 0;
        Pokemon currentPlayerPokemon = playerTeam.get(0);
        Pokemon currentEnemyPokemon = enemyTeam.get(0);
        Moves playerMove1 = currentPlayerPokemon.getMoveList().get(0);
        Moves playerMove2 = currentPlayerPokemon.getMoveList().get(1);
        Moves playerMove3 = currentPlayerPokemon.getMoveList().get(2);
        Moves playerMove4 = currentPlayerPokemon.getMoveList().get(3);
        Moves playerMoveChoice = playerMove1;
        Moves enemyMoveChoice = currentEnemyPokemon.getMoveList().get(0);

        System.out.println("You have been challenged to a Pokemon battle!");
        System.out.println("You send out " + currentPlayerPokemon.getPokemonName());
        System.out.println("Your opponent sends out " + currentEnemyPokemon.getPokemonName());

        while(valid == true){
            currentPlayerPokemon = playerTeam.get(0);
            currentEnemyPokemon = enemyTeam.get(0);

            System.out.println("\n" + currentPlayerPokemon.getPokemonName() + "'s HP: " + currentPlayerPokemon.getHP());
            System.out.println(currentEnemyPokemon.getPokemonName() + "'s HP: " + currentEnemyPokemon.getHP());
            System.out.println("\nDo you want to fight, bag, party, or run?");
            playerMove = scan.nextLine();
            if(playerMove.toLowerCase().equals("fight")){
                boolean moveValid = true;
                System.out.println("\n" + currentPlayerPokemon.getPokemonName() + "'s moves:");
                for(int i = 0; i < 4; i++){
                    Moves move = currentPlayerPokemon.getMoveList().get(i);
                    System.out.println(move.getMoveName() + " / ATK: " + move.getATK() + " / Type: " + move.getMoveType().getType() + " / PP: " + move.getPP());
                }
                System.out.println("Pick a move to use: ");
                playerAttack = scan.nextLine();
                
                while(moveValid == true){
                    moveValid = false;
                    enemyMoveChoice = currentEnemyPokemon.getMoveList().get((int)(Math.random() * 4));

                    if((playerAttack.toLowerCase().equals(playerMove1.getMoveName().toLowerCase())) && playerMoveChoice.getPP() != 0){
                        playerMoveChoice = playerMove1;
                    } else if((playerAttack.toLowerCase().equals(playerMove2.getMoveName().toLowerCase())) && playerMoveChoice.getPP() != 0){
                        playerMoveChoice = playerMove2;
                    } else if((playerAttack.toLowerCase().equals(playerMove3.getMoveName().toLowerCase())) && playerMoveChoice.getPP() != 0){
                        playerMoveChoice = playerMove3;
                    } else if((playerAttack.toLowerCase().equals(playerMove4.getMoveName().toLowerCase())) && playerMoveChoice.getPP() != 0){
                        playerMoveChoice = playerMove4;
                    } else{
                        System.out.println("Please enter a valid move\n");
                        for(int i = 0; i < 4; i++){
                            Moves move = currentPlayerPokemon.getMoveList().get(i);
                            System.out.println(move.getMoveName() + " / ATK: " + move.getATK() + " / Type: " + move.getMoveType().getType() + " / PP: " + move.getPP());
                        }
                        System.out.println("Pick a move to use: ");
                        playerAttack = scan.nextLine();
                        moveValid = true;
                    }
                    playerMoveChoice.usePP();
                    System.out.println("\n" + currentPlayerPokemon.getPokemonName() + " hit " + currentEnemyPokemon.getPokemonName() + " with " + playerMoveChoice.getMoveName());
                    currentEnemyPokemon.dealDamage(playerMoveChoice, currentEnemyPokemon.getPokemonType());
                    System.out.println(currentEnemyPokemon.getPokemonName() + " took " + currentEnemyPokemon.damageDealt(playerMoveChoice, currentEnemyPokemon.getPokemonType()) + " damage");
                    System.out.println(currentEnemyPokemon.getPokemonName() + " has " + currentEnemyPokemon.getHP() + " HP left");
                    
                    System.out.println("\n" + currentEnemyPokemon.getPokemonName() + " hit " + currentPlayerPokemon.getPokemonName() + " with " + enemyMoveChoice.getMoveName());
                    currentPlayerPokemon.dealDamage(enemyMoveChoice, currentPlayerPokemon.getPokemonType());
                    System.out.println(currentPlayerPokemon.getPokemonName() + " took " + currentPlayerPokemon.damageDealt(enemyMoveChoice, currentPlayerPokemon.getPokemonType()) + " damage");
                    System.out.println(currentPlayerPokemon.getPokemonName() + " has " + currentPlayerPokemon.getHP() + " HP left");
                }
            } else if(playerMove.toLowerCase().equals("bag")){
                System.out.println("\nYou have no items left");
            } else if(playerMove.toLowerCase().equals("party")){
                System.out.println("\nCurrent party:");
                for(int i = 0; i < playerTeam.size(); i++){
                    System.out.println(playerTeam.get(i).getPokemonName() + " / Type: " + playerTeam.get(i).getPokemonType().getType());
                }
            } else if(playerMove.toLowerCase().equals("run")){
                break;
            } else{
                System.out.println("\nPlease enter a valid input");
            }

            if(currentPlayerPokemon.getHP() <= 0){
                System.out.println(currentPlayerPokemon.getPokemonName() + " has fainted");
                playerTeam.remove(playerIndex);
            }
            if(currentEnemyPokemon.getHP() <= 0){
                System.out.println(currentEnemyPokemon.getPokemonName() + " has fainted");
                enemyTeam.remove(enemyIndex);
            }

            if(playerTeam.size() == 0 || enemyTeam.size() == 0){
                valid = false;
            }
        }
        System.out.println("Battle is over!");
        scan.close();
    }
}