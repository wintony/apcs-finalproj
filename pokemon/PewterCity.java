import java.io.*;
import java.util.*;

public class PewterCity {

    private String s;
    private Battle battle = new Battle();
    Scanner scan = new Scanner(System.in);
    Random r = new Random();

    public String routine(Player player) {
	player.setLocation("Pewter City");	
	System.out.println("You have reached PEWTER CITY");
	walk(player,"street");
	return "";
    }

    public String pokemoncenter(Player player) {
	System.out.println("NURSE: Hello! Welcome to the POKEMON CENTER. We restore your POKEMON to full health, free of charge. Our health care system sure is great. Here, let me take care of your POKEMON.");
	for (int i=0;i<player.getPokemon().length &&
		 player.getPokemon()[i] != null;i++) {
	    player.getPokemon()[i].setHealth(player.getPokemon()[i].getMaxHealth());
	    player.getPokemon()[i].setPP(0,player.getPokemon()[i].getMaxPP()[0]);
	    if (player.getPokemon()[i].getMaxPP()[1] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[1]);
	    }
	    if (player.getPokemon()[i].getMaxPP()[2] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[2]);
	    }
	    if (player.getPokemon()[i].getMaxPP()[3] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[3]);
	    }
	}
	System.out.println("~healing music~");
	System.out.println("NURSE: All healed up!");
	walk(player,"pokemon center");
	return "";
    }

    public String pokemart(Player player) {
	System.out.println("CASHIER: Welcome to the POKEMART! We sell all kinds of goods here. What would you like to purchase?");
	System.out.println(player + "'s money: $" + player.getMoney());  
	System.out.println("POKEBALL $50");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("pokeball")) {
	    System.out.println("And how many POKEBALLS would you like to purchase?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    int p = Integer.parseInt(s);
	    if (player.getMoney() >= 50 * p) {
		//add confirmation
		player.setBag("POKEBALL",0);
		player.setBagNum(p,0);
		player.setMoney(player.getMoney() - 50);
		System.out.println("CASHIER: Thank you for your purchase!");
	    }
	}
	walk(player,"pokemart");
	return "";
    }

    public String training(Player player) {
	int meters = 0;
	System.out.println("You enter the ROCKY ROCK TRAINING PLACE, an area with rocky terrain. A sign reads, ROCKY ROCK TRAINING PLACE: THE 72ND TOUGHEST PLACE ON EARTH.");
	System.out.println("Do you want to WALK FORWARDS or WALK BACKWARDS (to PEWTER CITY)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (meters >= 300) {
	    System.out.println("OUCH. There is a large, rocky mountain in your way. How did you miss that?");
	}
	if (s.equals("walk forwards") && meters < 300) {
	    meters =  meters + 50;
	    System.out.println("You walked 50 meters.");
	    System.out.println("You are " + meters + " meters from PEWTER CITY.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		//BLAH BLAH BLAH 
	    }
	    training(player);
	}
	if (s.equals("walk backwards")) {
	    meters = meters - 50;
	    System.out.println("You walked 50 meters.");
	    if (meters <= 0) {
		System.out.println("You have reached PEWTER CITY.");
		//STUFF 
		walk(player,"BLAH BLAH BLAH");
	    }
	    System.out.println("You are " + meters + " meters from PEWTER CITY.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		//BLAH BLAH BLAH
	    }
	    training(player);;
	}
        if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    routine(player);
	} 
	if (s.equals("exit game")) {
		System.exit(0);
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    routine(player);
	}
	return "";
    }

    public String gym(Player player) {
	/*
	if (player.getBadges()[0].equals("BOULDER BADGE")) {
	    
	} else {
	*/
	    System.out.println("BROCK: Hello there! I'm BROCK, the leader of the PEWTER CITY GYM!");
	    System.out.println("BROCK: Rock POKEMON exemplify what we should strive to be: tough, determined, made of minerals and small sand particles - er, forget that last part.");
	    System.out.println("BROCK: Do you think you have what it takes to earn the BOULDER BADGE? Are you hardy enough to take me on?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("yes")) {
		System.out.println("BROCK: Alright then! Let's go! I'll pound you! - er, I mean - let's just battle.");
		Player brock = new Player("BROCK");
		Geodude geodude0 = new Geodude();
		Geodude geodude1 = new Geodude();
		geodude0.setLevel(5);
		geodude0.setMaxHealth(25);
		geodude0.setHealth(geodude1.getMaxHealth());
		geodude0.setMaxSpeed(10);
		geodude0.setSpeed(geodude1.getMaxSpeed());
		geodude0.setMaxDefense(10);
		geodude0.setDefense(geodude1.getMaxDefense());
		geodude0.setMaxAttack(10);
		geodude0.setAttack(geodude1.getMaxAttack());
		geodude0.setMove(1,"ROCK THROW");
		geodude0.setPP(1,15);
		geodude0.setMaxPP(1,15);
		geodude1.setLevel(5);
		geodude1.setMaxHealth(25);
		geodude1.setHealth(geodude1.getMaxHealth());
		geodude1.setMaxSpeed(10);
		geodude1.setSpeed(geodude1.getMaxSpeed());
		geodude1.setMaxDefense(10);
		geodude1.setDefense(geodude1.getMaxDefense());
		geodude1.setMaxAttack(10);
		geodude1.setAttack(geodude1.getMaxAttack());
		geodude1.setMove(1,"ROCK THROW");
		geodude1.setPP(1,15);
		geodude1.setMaxPP(1,15);
		brock.setPokemon(geodude0,0);
		brock.setPokemon(geodude1,1);
		battle.trainerRoutine(player,brock);
		if (player.getPokemon()[0].getHealth() > 0) {
		    System.out.println("BROCK: Wow, you beat me! You ready are strong. Here, take the BOULDER BADGE!");
		    player.setBadges("BOULDER BADGE",0);
		    System.out.println("BROCK: Don't stop training, kid! You'll go far.");
		}
		walk(player,"brock's gym");
	    } else {
		System.out.println("BROCK: I'll see you next time then, when you HARD-en up to it. Har har har!");
		walk(player,"brock's gym");
	    }
	    //	}
	return "";
    }

    public String walk(Player player, String source) {
	if (source.equals("street")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   POKEMART   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	}
	if (source.equals("brock's gym")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   POKEMART   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	}
	if (source.equals("pokemon center")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMART   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY   SAVE");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	    if (s.equals("brock's gym")) {
		gym(player);
	    }
	    if (s.equals("pallet town")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("save")) {
		try {
		    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.dat"));
		    oos.writeObject(player);
		    oos.close();
		    System.out.println("GAME SAVED");
		    walk(player,source);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	    }
	    if (s.equals(player)) {
		System.out.println("Money: " + player.getMoney());
	    }
	    if (s.equals("pokemon")) {
		System.out.println(player.getPokemonStatus());
		walk(player,source);
	    } 
	    if (s.equals("exit game")) {
		System.exit(0);
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	if (source.equals("pokemart")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pallet town")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("pokemon")) {
		System.out.println(player.getPokemonStatus());
		walk(player,source);
	    } 
	    if (s.equals("exit game")) {
		System.exit(0);
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	return "";
    }

}
