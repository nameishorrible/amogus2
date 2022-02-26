import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class CodeContest {
	public static final String OPTIONS = "S: Start New Game\nV: View Patch Notes\nQ: Quit";
	public static ArrayList<String> NAMES = new ArrayList<>(Arrays.asList("Payne","Klayman","Croft","Aran","Squee","Spleen","Spoon","Carmack","Romero","Sarkeesian","Civvie","Sax","Sharon-Cassidy","Noita","Tarn","Zach","Castor Troy","Pollux Troy","Robert Goode","Tetsuo","Kanye","Pedro","Gabe","Adrian","Katarn","Ordo","Bindo","Kreia","Onasi","Reznov","Mason","Dragovich","Kravchenko","Steiner","Mastdie","Mario","Luigi","Waluigi","Wario","Peach","Daisy","Toad","Donkey Kong","Snake","Niko","Aloy","Drake","Kratos","Marcus","Calhoun","Freeman","Breen","Skywalker","Organa","Solo","Binks","Fett","Chell","Ketchum","Stromae","Simpson","Kim","Hubert","Apu","Linus","Miku"));
	public static ArrayList<String> WEAPONS = new ArrayList<>(Arrays.asList("butterfly knife","Tec-9", "Buster Sword", "candy colored eyes", "broken flowers", "clown horn","toilet bowl","radioactive lizard","wisdom","thermonuclear warhead","Daikatana","BFG9000","Ion Cannon", "Mk 22 Mod 0 'Hush Puppy'", "M1911A1", "M9", "Mk 23", "AK-47", "curling iron", "frying pan", "golden frying pan (woah!)", "Nova 6 gas", "arsenic poisoning", "Railgun", "Lucille", "Infinity Gauntlet", "black hole generator", "rapid decompression via an airlock", "a den-mother", "a massive space slug", "a loose electrical wire", "an electrified metal desk", "a heart attack", "spontaneous combustion", "a buzzsaw blade", "an intergalactic demon", "old age", "the vacuum of space", "improperly cooked food", "salmonella", "a broken heart :("));
	public static final ArrayList<String> EVENTS = new ArrayList<>(Arrays.asList("The power goes out!", "The air begins to siphon from the medical bay!", "The lights flicker a bit.", "The air becomes extremely hot.", "The air becomes extremely cold.", "Alien lifeforms make contact with the station. They leave gifts and part ways with you peacefully.", "An asteroid field strikes the station's satellite array!", "The security footage is discovered to have been erased!", "The bathroom sink overflows. How devilish!", "A maintenance robot slips on a banana peel. Sparks go everywhere!", "A clown walks into the cafeteria. Honk honk!", "The bartender bot throws a bottle at a rowdy patron.", "The air vent shakes and rattles, as if someone is inside of it.", "A meteor storm splashes across the ship's shields.", "A janitor sprays the floors with disinfectant spray.", "A chef prepares a tray of sandwiches for the crew on board.", "The fire alarm goes off in Sector C!", "An exhaust pipe bursts and sprays hot gas everywhere!", "The scanners warn of a black hole approaching.", "The ship gets too close to a nearby star and nearly overheats!", "Another ship flies by and hails you. Humans on board exchange pleasantries, then go on their merry way.", "A small doggo happily trots down the hallway.", "Someone forgets to lower the lid on the toilet. Yuck.", "Someone opens a window and gets sucked into the vacuum of space.", "A television replays footage from Seinfeld."));
	public static final ArrayList<Object> MINIGAMES = new ArrayList<>(Arrays.asList("Sequence the DNA!", "ACGTATGCTAGCATCG", 10, "Sequence the DNA!", "ATCTACGAGCTGCTAG", 10, "Sequence the DNA!", "TGATCGCTAGCACGTA", 10, "Sequence the DNA!", "CTAGCATCGACGTATG", 10, "Beat up the alien!", "smack smack smack", 5, "Beat up the alien!", "punch punch punch", 7, "Beat up the alien!", "hit hit hit", 3, "Fix the broken solar panels!", "thwack screw pat pat", 5, "Fix the broken solar panels!", "smack pat fix thwack", 5, "Pilot the ship!", "weeeeeeeee woooooooosh wow so fun", 6, "Repair the power cables!", "zip zap zip zap bzzt", 4, "Repair the power cables!", "bzzzt zap zip", 4, "Stabilize the ship's reactor!", "oh dear god dont blow up please", 8, "Stabilize the ship's reactor!", "beep beep boop boop tap tap", 5, "Recalibrate the life support systems!", "type type type inhale exhale sigh", 6)); // Description, command, time in seconds
	public static final String UPDATES = "Update v1.0:\n\t- Added Post Malone to the roster.\n\t- Added Walter White Jr. to the roster.\n\t- New tracks by Billie Eilish added to the game.\n\t- FIX: Free Bird has been removed from the track rotation.\n\t- FIX: Spessmen will no longer attempt to marry the Grim Reaper.\n\t- FIX: I watch you while you sleep.\n\nUpdate v1.1:\n\t- New cheat codes:\n\t\tType 'rosebud' to give your Spessman a cool hat.\n\t\tType 'freeman' to unlock the rare Golden crowbar.\n\t\tType 'thugstools' to give yourself all weapons.\n\t- Added backdoor protection to tier 1 towers during the first minute of the match.\n\t- Removed Necronomicon.\n\t- Strokes have been added to the game.\n\t- FIX: Changed language translation to be entering new standings if creating new level when adding new barriers for character creation.\n\nUpdate v2.0:\n\t- Added Fusion Dance for Imposters.\n\t- Added 1% chance to spawn with Sharingan on character creation.\n\t- FIX: Amoguses should no longer vent right in front of you, then claim to be innocent.\n\nUpdate v7.31\n\t- Removed Techies from the game.\n\t- Added a bunch of junk nobody wants.";
	public static String PLAYER_INPUT = "";
	public static Amogus PLAYER;
	public static Scanner INPUT = new Scanner(System.in);
	public static int MAX_SPESSMEN = 8;
	public static final double CHANCE_IMPOSTER = 0.5;
	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in); // Greet the Player
		System.out.println("Welcome to Amogus: The Squeakuel\n\nThis is a game about deception, trickery, and espionage. Do you have what it takes?\nTake the" + "\u001B[31m" + " Imposter " + "\u001B[0m" + "challenge. Stab your friends 29,998,559,671,349 times in a row!\n\n");
		doMainMenu(input);
	}
	public static void doMainMenu(Scanner input) throws InterruptedException {
		boolean bMainMenuDone = false;
		while (!bMainMenuDone) {
			System.out.println("Select an option below:\n" + OPTIONS);
			char response = input.nextLine().toUpperCase().charAt(0);
			if (response == 'S') {
				printSleep(new String[]{"Starting new game..."}, new int[]{1000});
				bMainMenuDone = doGameStart(input);
			} else if (response == 'R') {
				System.out.println("SECRET: You find a cool hat to wear! Sweet!");
			} else if (response == 'F') {
				System.out.println("SECRET: Golden Crowbar unlocked!");
			} else if (response == 'T') {
				System.out.println("SECRET: All weapons unlocked!");
			} else if (response == 'V') {
				System.out.println("Patch Notes:\n" + UPDATES + "\n");
			} else if (response == 'Q') {
				bMainMenuDone = true;
			} else {
				System.out.println("Invalid option!");
			}
		}
	}
	public static boolean doGameStart(Scanner input) throws InterruptedException {
		ArrayList<Amogus> spessmens = new ArrayList<>();
		ArrayList<Amogus> imposters = new ArrayList<>();
		Random rng = new Random();
		int gameState = 0;
		int round = 0;
		System.out.println("Input your character's name.");	// Get name
		PLAYER = new Amogus(input.nextLine(), Math.random() > CHANCE_IMPOSTER); // Create Player Character
		addSpessman(PLAYER, (PLAYER.isImposter() ? imposters : spessmens));
		printSleep(new String[]{"Greetings, " + PLAYER.getName() + ".\nRolling to determine whether you're an" + "\u001B[31m" + " imposter " + "\u001B[0m" + "or not...", PLAYER.isImposter() ? "You are an \u001B[31m" + "imposter" + "\u001B[0m!" : "You are innocent.", "Please input the number of players you would like to play with. (4-" + NAMES.size() + ")"}, new int[]{3000, 2000, 0});
		MAX_SPESSMEN = input.nextInt();
		generateRandomNPCs(spessmens, imposters, rng); // Create Non-Player Characters
		while (gameState == 0) { // Start game
			printSleep(new String[]{"\n--- ROUND " + ++round + " ---\n"}, new int[]{1500});
			doRound(spessmens, imposters, rng, round, input);
			Thread.sleep(2000);
			if (spessmens.isEmpty()) {
				gameState = 2;
			} else if (imposters.isEmpty()) {
				gameState = 1;
			}
		}
		printSleep(new String[]{gameState == 2 ? "\n\nThere are no more Spessmen. The" + "\u001B[31m" + " Imposters " + "\u001B[0m" + "have taken over the Spessstation.\n\u001B[31m" + "Imposters" + "\u001B[0m Win!" : "\n\nThe \u001B[31m" + "Imposters" + "\u001B[0m have been wiped out. The Spessmen succeed in their mission.\nSpessmen Win!", "Surviving " + ((gameState == 2) ? "\u001B[31mImposters\u001B[0m:" : "Spessmen:")}, new int[]{4000, 1000});
		for (Amogus character : gameState == 2 ? imposters : spessmens) {
			printSleep(new String[]{"\t" + character.getName()}, new int[]{500});
		}
		System.out.println("\nThank you for playing Amogus: The Squeakuel.\nThis game was part of a coding challenge to create a game in under 150 lines of code. I hope you enjoyed the game and that it was worth the wait.\n\n- nameishorrible");
		return true;
	}
	public static void doRound(ArrayList<Amogus> spessmens, ArrayList<Amogus> imposters, Random rng, int round, Scanner input) throws InterruptedException {
		if (round % 2 == 0) {
			boolean bWonMinigame = (PLAYER.isAlive() && doMinigame(PLAYER, rng, input)); // If you win the minigame, roll for a random event OR if you lose, someone dies
			if ((!bWonMinigame && !PLAYER.isImposter()) || (bWonMinigame && PLAYER.isImposter())) {
				System.out.println(killSpessman(spessmens.get(rng.nextInt(spessmens.size())), spessmens, rng).getName() + " was found murdered by " + WEAPONS.get(rng.nextInt(WEAPONS.size())) + "!");
			} else if ((bWonMinigame && !PLAYER.isImposter()) || (!bWonMinigame && PLAYER.isImposter())) {
				Amogus unluckySoul = killSpessman(imposters.get(rng.nextInt(imposters.size())), imposters, rng);
				printSleep(new String[]{unluckySoul.getName() + " is acting sus! A vote is called!", unluckySoul.getName() + " is voted out!"}, new int[]{3500, 3000});
			}
		} else {
			System.out.println(EVENTS.get(rng.nextInt(EVENTS.size())));
		}
		System.out.println("\t\u001B[31mImposters\u001B[0m left: " + imposters.size() + "\n\tInnocents left: " + spessmens.size());
	}
	public static void generateRandomNPCs(ArrayList<Amogus> spessmens, ArrayList<Amogus> imposters, Random rng) throws InterruptedException {
		printSleep(new String[]{"Connecting to game host...", "Verifying integrity of game cache...", "Reticulating splines...", "Sending client info...", "\nConnected to game host! Opening ports for players to join...\n"}, new int[]{2000, 2100, 2500, 4000, 3000});
		for (int i = 1; i < MAX_SPESSMEN; i++) {
			Amogus npc = new Amogus(NAMES.remove(rng.nextInt(NAMES.size())), (imposters.size() < Math.round(MAX_SPESSMEN / 3) - (PLAYER.isImposter() ? - 1 : 0)));
			addSpessman(npc, (npc.isImposter() ? imposters : spessmens));
			printSleep(new String[]{npc.getName() + " has joined the game!" + (i == MAX_SPESSMEN - 1 ? "\n" : "")}, new int[]{MAX_SPESSMEN < 10 ? 750 : 250});
		}
	}
	public static void addSpessman(Amogus character, ArrayList<Amogus> spessmens) {
		spessmens.add(character);
	}
	public static Amogus killSpessman(Amogus character, ArrayList<Amogus> spessmens, Random rng) {	// kill who, from where, and pass rng
		character.setAlive(false);
		spessmens.remove(character);
		return character;
	}
	public static void printSleep(String[] text, int[] time) throws InterruptedException {
		for (int i = 0; i < text.length; i++) {
			System.out.println(text[i]);
			Thread.sleep(time[i]);
		}
	}
	public static boolean doMinigame(Amogus character, Random rng, Scanner input) throws InterruptedException {
		PLAYER_INPUT = "";
		int index = rng.nextInt(MINIGAMES.size() / 3) * 3;
		printSleep(new String[]{"--------------------", "----- MINIGAME -----", "--------------------", "" + MINIGAMES.get(index), "You will have " + MINIGAMES.get(index + 2) + " seconds to type the answer correctly.", "Ready?", "GO!", "Type this phrase out to win the minigame!\n" + MINIGAMES.get(index + 1)}, new int[]{0, 0, 1000, 3000, 3000, 4000, 1000, 0});
		Thread timer = new Thread(new Thread(() -> {
			PLAYER_INPUT = INPUT.nextLine();
		}));
		timer.start();
		for (int i = (int) MINIGAMES.get(index + 2); i > 0; i--) {
			if (PLAYER_INPUT.equals("")) {
				Thread.sleep(1000);
			} else {
				break;
			}
		}
		timer.interrupt();
		System.out.println(PLAYER_INPUT.equals(MINIGAMES.get(index + 1)) ? "Correct! You succeed in your task!" : "Incorrect! You failed your task!\n" + "\tYour answer: " + PLAYER_INPUT + "\n\tCorrect answer: " + MINIGAMES.get(index + 1));
		return PLAYER_INPUT.equals(MINIGAMES.get(index + 1));
	}
}
class Amogus {
	private String name;
	private boolean imposter = false;
	private boolean alive = true;
	public Amogus(String name, boolean imposter) {
		this.name = name;
		this.imposter = imposter;
	}
	public boolean isImposter() {
		return this.imposter;
	}
	public String getName() {
		return name;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}

/*
	Rules:
	The challenge this month is to make a game using 150 lines of code or less! The rules are as follows:

	- No game engines or third party libraries (text-based games are encouraged)
	- Allowed languages are C, C++, C#, Java, JavaScript, and Python
	- For Java, C, C++, C#, and JavaScript, a "line" is defined as a conditional statement or a piece of code that ends with a semicolon (whitespace, comments and brackets do not count)
	- For python, a line is defined by the rules of python, excluding lines that only have comments
	- There are no character limits, so please practice good naming conventions
	- All code has to be your own
	- To submit, put the source code and instructions on how to run the code either in a zip file, Google drive, or a GitHub repo and put it in contest-questions-and-submissions. Make sure your discord username is somewhere obvious in the submission files!
	- Do not submit any executable files due to security risks
	- Submissions are judged by the enjoyment of the game and the cleverness of the code
	
	You have until February 25th to turn in your submission, and all submissions will be judged by our officers and helpers by March 1st. The winner will receive a permanent role for the server!

	one thing that's important to note is that conditional statements also count as a line, so something like if(a) b = c; counts as two lines even though it can fit in one line
*/