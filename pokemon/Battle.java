import java.util.*;import java.io.*;public class Battle {    private boolean notRun = true;    private boolean notCaught = true;    private boolean notSwitch = true;    private Player o = new Player();    public String blackout(Player player) {	if (player.getLocation().equals("Route 1")) {	    player.setLocation("Pallet Town");	    System.out.println(player + " blacked out!");	    HomeTown hometown = new HomeTown();	    hometown.home(player);	}	if (player.getLocation().equals("Pewter City")) {	    System.out.println(player + " blacked out!");	    PewterCity pewtercity = new PewterCity();	    pewtercity.pokemoncenter(player);	}	return "";    }    public int canContinue(Player player) {	for (int i=0;i<player.getPokemon().length && 		 player.getPokemon()[i] != null;i++) {	    if (player.getPokemon()[i].getHealth() > 0) {		return i;	    }	}	return -1;    }    public String trainerRoutine(Player player, Player opponent) {	o = opponent;	System.out.println("Foe " + opponent + " wants to battle!");	while (canContinue(player) != -1 && canContinue(opponent) != -1 &&	       notSwitch) {	    routine(player,		    opponent.getPokemon()[canContinue(opponent)],		    false,canContinue(player));	}	if (canContinue(player) != -1 && notSwitch) {	    System.out.println(player + "  won!");	} else if (!notSwitch) {	    notSwitch = true;	} else {	    System.out.println(player + "  has no more usable POKEMON!");	    blackout(player);	}	return "";    }    public String wildRoutine(Player player, BaseChar opponent) {	System.out.println("Foe " + opponent + " wants to battle!");	while (canContinue(player) != -1 && opponent.getHealth() > 0 	       && notRun && notCaught && notSwitch) {	    routine(player,opponent,true,canContinue(player));	}	if (canContinue(player) != -1 && notRun && notCaught && notSwitch) {	    System.out.println(player + "  won!");	} else if (!notRun) {	    notRun = true;	    System.out.println(player + " ran away!");	} else if (!notCaught) {	    notCaught = true;	} else if (!notSwitch) {	    notSwitch = true;	} else {	    System.out.println(player + "  has no more usable POKEMON!");	    blackout(player);	}	return "";    }    public boolean routine(Player trainer,BaseChar opponent,			   boolean wild,int place) {	Scanner scan = new Scanner(System.in);	Random r = new Random();	BaseChar player = trainer.getPokemon()[place];	boolean fight = true;	boolean turn = true;	if(opponent.getSpeed() > player.getSpeed()){   	    //whoever's speed is faster gets to go first	    turn = false;  	}	//BASIC fight sequence 		while (fight && !opponent.getCaught()){	    //opponents stats	    System.out.println("\nFoe LVL. " + opponent.getLevel()  + " " +			       opponent.toString() + "'s health: " +			       + opponent.getHealth() +			       "/" + opponent.getMaxHealth());	    	    //player's stats	    System.out.println("LVL. " + player.getLevel() + " " +			       player.toString() + "'s health: " + 			       player.getHealth() +			       "/" + player.getMaxHealth() + "\n");	    //*********************THE PLAYER'S TURN*************************	    while(fight && turn && !opponent.getCaught()){		//Selection of PLAYER's move		System.out.println("What do you want to do?\n" +				   player.moveset() + "\n" +				   "VIEW POKEMON" + "\n" +				   "BAG" 				   );		if (wild) {		    System.out.println("RUN");		}		String move;		move = scan.nextLine();		move = move.toLowerCase();			if (move.equals("go 2")) {		    if (trainer.getPokemon()[1].getHealth() > 0) {			System.out.println(player + ", come back! Go, " + 				       trainer.getPokemon()[1] + "!");			routine(trainer,opponent,wild,1);			notSwitch = false;					    } else {			System.out.println(trainer.getPokemon()[1] + " has no heath left!");		    }		} else if (move.equals("go 3")) {		    if (trainer.getPokemon()[2].getHealth() > 0) {			System.out.println(player + ", come back! Go, " + 					   trainer.getPokemon()[2] + "!");			routine(trainer,opponent,wild,2);			notSwitch = false;		    } else {			System.out.println(trainer.getPokemon()[2] + " has no heath left!");		    }		} else if (move.equals("go 4")) {		    if (trainer.getPokemon()[3].getHealth() > 0) {			System.out.println(player + ", come back! Go, " + 					   trainer.getPokemon()[3] + "!");			routine(trainer,opponent,wild,3);			notSwitch = false;		    } else {			System.out.println(trainer.getPokemon()[3] + " has no heath left!");		    }		} else if (move.equals("go 5")) {		    if (trainer.getPokemon()[4].getHealth() > 0) {			System.out.println(player + ", come back! Go, " + 					   trainer.getPokemon()[4] + "!");			routine(trainer,opponent,wild,4);			notSwitch = false;		    } else {			System.out.println(trainer.getPokemon()[4] + " has no heath left!");		    }		} else if (move.equals("go 6")) {		    if (trainer.getPokemon()[5].getHealth() > 0) {			System.out.println(player + ", come back! Go, " + 					   trainer.getPokemon()[5] + "!");			routine(trainer,opponent,wild,5);			notSwitch = false;		    } else {			System.out.println(trainer.getPokemon()[3] + " has no heath left!");		    }		} else if (move.equals("view pokemon")) {		    System.out.println(trainer.getPokemonStatus());		}		else if (move.equals("bag")) {		    for (int i=0;i<trainer.getBag().length &&			     trainer.getBag()[i] != null;i++) {			System.out.println(trainer.getBag()[i] + " " + 					   trainer.getBagNum()[i]);		    }		    if (trainer.getBag()[0] == null) {			System.out.println("Your bag is empty!");		    }		} else if(move.equals("pokeball") && wild) {		    int n = 0;		    if (trainer.getBag()[n] == null) {			System.out.println("You have no POKEBALLS!");		    } else {			while (n<trainer.getBag().length && 			       !trainer.getBag()[n].equals("POKEBALL")) {			    n = n + 1;			}			if (trainer.getBag()[n].equals("POKEBALL") && 			    trainer.getBagNum()[n] > 0) {			    trainer.setBagNum(trainer.getBagNum()[n]-1,n);			    System.out.println(trainer + " threw a POKEBALL!");			    if (trainer.getBagNum()[n] == 0) {				trainer.setBag(null,n);				trainer.setBagNum(0,n);				for (int k=n+1;k<trainer.getBag().length && 					 trainer.getBag()[k] != null;k++) {				    trainer.setBagNum(trainer.getBagNum()[k],k-1);				}			    }			    int catchrate = (7 * opponent.getHealth() * 100)				/(10 * opponent.getMaxHealth());			    int determiner = r.nextInt(100);			    if (catchrate < determiner) {				System.out.println(opponent + " was caught!");				int j = 0;				while (j<trainer.getPokemon().length &&				       trainer.getPokemon()[j] != null) {				    j = j + 1;				}				if (j <= 5) {				    trainer.setPokemon(opponent,j);				    opponent.setCaught(true);				    notCaught = false;				    return true;				} else {				    System.out.println(opponent + " was sent to your PC!");				    trainer.addPC(opponent);				    opponent.setCaught(true);				    notCaught = false;				    return true;				}			    } else if (catchrate - 10 < determiner) {				//add system.waits for dramatic effect				System.out.println(opponent + " broke free! Shoot, it was so close, too!");				turn = false;			    } else if (catchrate - 20 < determiner) {				System.out.println("Aww, " + opponent + " broke free! It appeared to be caught!");				turn = false;			    } else {				System.out.println("Darn, " + opponent + " broke free!");				turn = false;			    } 			    turn = false;			} else {			    System.out.println("You have no POKEBALLS!");			}		    }		} else if (move.equals("run") && wild) {		    notRun = false;		    return true;		} else if (move.equals("tackle")) {		    System.out.println("\n" + player.tackle(opponent));		    turn = false;		} else if (player.useMove(move,opponent)) {		    turn = false;		    }		    /*		      else if (move.equals("recover")) {		      System.out.println("\n" + player.recover());		      turn = false;		      } 		    */		else {		    System.out.println(player.toString() + " can't do that!");		}		if(opponent.getHealth() <= 0){		    opponent.setHealth(0);		    System.out.println("Foe " + opponent + 				       " has fainted!");		    int exp = 1 + (player.getLevel() * opponent.getLevel())/3;		    player.setExperience(player.getExperience() + exp);		    System.out.println(player + " gained " + 				       exp + " experience!");		    if (player.getExperience() >			(player.getLevel() * player.getLevel())) {			int leftover = (player.getLevel() * player.getLevel()) -			    player.getExperience();			player.setLevel(player.getLevel() + 1);			System.out.println(player + " leveled up!");			System.out.println(player + " is now level " +					   player.getLevel() + "!");			player.setMaxHealth(player.getMaxHealth() + player.getStage() + r.nextInt(4));			player.setMaxSpeed(player.getMaxSpeed() + player.getStage() + r.nextInt(4));			player.setMaxAttack(player.getMaxAttack() + player.getStage() + r.nextInt(4));			player.setMaxDefense(player.getMaxDefense() + player.getStage() + r.nextInt(4));			player.setSpeed(player.getMaxSpeed());			player.setAttack(player.getMaxAttack());			player.setDefense(player.getMaxDefense());			System.out.println(player.status());			player.learnMoves();			player.evolve(trainer);		    }		    if (canContinue(o) != -1) {			System.out.println("Go, " + o.getPokemon()[canContinue(o)] + "!");			routine(trainer,o.getPokemon()[canContinue(o)],wild,canContinue(trainer));		    }		    return true;		}	    }	    //*********************THE OPPONENT'S TURN************************	    while(fight && !turn){		//dumb opponent's move selection (random)		String[] moves = opponent.getMoves();		int rand = r.nextInt(opponent.nummoves());		String move = moves[rand];		move = move.toLowerCase();		if (move.equals("tackle")) {		    System.out.println("\n" + opponent.tackle(player));		} else {		    opponent.useMove(move,player);		}		/*		if (move == "RECOVER") {		    System.out.println(opponent.recover());		}		*/		if(player.getHealth() <= 0 ){		    player.setHealth(0);		    System.out.println(player + " has fainted.");		    if (canContinue(trainer) != -1) {			System.out.println("Go, " + trainer.getPokemon()[canContinue(trainer)] + "!");			routine(trainer,opponent,wild,canContinue(trainer));			notSwitch = false;		    }		    return false;		}		turn = true;	    }	}	return true;    }}