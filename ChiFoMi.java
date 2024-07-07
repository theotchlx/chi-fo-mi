import java.util.Random;
import java.util.Scanner;

public class ChiFoMi {
    public static void main(String[] args) throws InterruptedException {  // Added InterruptedException for Thread.sleep() (else it doesn't work. I don't explicitely catch the exceptions though)
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
		
		System.out.println("---- Chi-Fo-Mi: Chapter One: An ancient cave ----");
		Thread.sleep(4000);

		System.out.print("Time feels distorted. "); Thread.sleep(2500);
		System.out.print("You can't tell if you entered this wretched cave hours or days ago"); Thread.sleep(3000);
		printScaryDots();
		System.out.println(" Thirst is slowly killing you in this dark cave."); Thread.sleep(4000);
		System.out.print("The air is damp and cold. "); Thread.sleep(3500);
		System.out.print("You hear a booming voice echoing in the distance."); Thread.sleep(4000);
		System.out.println("");  // Just like System.out.print("\n");

        Thread.sleep(200);
		System.out.println(""); Thread.sleep(200);
		System.out.print("---"); Thread.sleep(200);  // It's all for dramatic effect, really.
		System.out.println(""); Thread.sleep(1000);
		
		System.out.println("\n\"So you want to play \"Un deux trois pierre-feuille-ciseaux\"?\""); Thread.sleep(4500);
		System.out.println("\"Do you want to play against the cold, unfeeling machine (type 'm') ; or against a fellow fleshy friend? (type 'f').\"\n\"To leave this place for a better world, type 'q'\"");

		String gameChoice = "";
		while (!gameChoice.equalsIgnoreCase("q")) {

			System.out.print("> ");
			gameChoice = scanner.nextLine();
			System.out.println(""); Thread.sleep(1000);

			switch (gameChoice.toLowerCase()) {  // Mainly for readability here. Could be done with if-else statements.
				case "m":
					System.out.println("The machine welcomes you."); Thread.sleep(2000);
					gameChoice = playAgainstMachine();
					break;
				case "f":
					System.out.println("You feel a presence behind you. You turn around and see a figure. It's a human, like you. It's you."); Thread.sleep(4000);
					printScaryDots(); System.out.println(""); Thread.sleep(200);
					System.out.println("Oh wait. There's a mirror here. It's just a reflection, it doesn't want to play with you."); Thread.sleep(4000);
					break;
				case "q":
					System.out.print("It said \"Leave!\""); Thread.sleep(1000);
					System.out.print(", and with no control over your body, you left."); Thread.sleep(2000);
					System.out.println(" You are now free.. at last."); Thread.sleep(1000);
					break;
				default:
					System.out.println("There is a rumble. You feel the rules of this world bending. The universe does not acknowledge your answer.");Thread.sleep(4000);
					System.out.println("\"Try again mortal, if you dare.\""); Thread.sleep(1000);
			}

		}

        scanner.close();
        System.out.println("Thanks for everything."); Thread.sleep(1000);
    }

	private static String playAgainstMachine() throws InterruptedException {  // Added InterruptedException for Thread.sleep()
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String userMove = "";
		while (!userMove.equalsIgnoreCase("q")) {
			System.out.println("What is your move? (Rock: 'r', Paper: 'p', Scissors: 's'). To abandon your stance, type 'q'.");
		
			System.out.print("> ");
			userMove = scanner.nextLine();
			System.out.println(""); Thread.sleep(1000);

			switch (userMove.toLowerCase()) {
				case "q":
					System.out.println("You stop playing. The machine never moves again. You're stuck in here, forever."); Thread.sleep(4000);
					break;
				case "r":
				case "p":
				case "s":
					// Send cute emoji message (with unicode)
					Thread.sleep(1000);
					if (userMove.equalsIgnoreCase("r")) {
						System.out.println("You raise your hand and choose Rock " + "\u270A");
					} else if (userMove.equalsIgnoreCase("p")) {
						System.out.println("You raise your hand and choose Paper " + "\u270B");
					} else {
						System.out.println("You raise your hand and choose Scissors " + "\u270C");
					}

					// Make computer play its move
					int randIndex = random.nextInt(3);
					String[] options = {"r", "p", "s"};
					String computerMove = options[randIndex];

					// Send not-so-cute emoji messages for the machine move (with unicode)
					Thread.sleep(2000);
					if (computerMove.equalsIgnoreCase("r")) {
						System.out.println("The machine looks at you firmly");
						Thread.sleep(1500);
						System.out.print("It chose:");
						printScaryDots();
						System.out.println(" Rock " + "\u270A");
					} else if (computerMove.equalsIgnoreCase("p")) {
						System.out.println("The machine looks at you sharply");
						Thread.sleep(1500);
						System.out.print("It chose:");
						printScaryDots();
						System.out.println(" Paper " + "\u270B");
					} else {
						System.out.println("The machine snaps its robotic members at you");
						Thread.sleep(1500);
						System.out.print("It chose:");
						printScaryDots();
						System.out.println(" Scissors " + "\u270C");
					}

					Thread.sleep(800);  // user be like: ç_ç !!

					// Compare move with computer's. Implementation of the game rules.
					if (userMove.equalsIgnoreCase(computerMove)) {
						System.out.print("It's a tie! ");
						printScaryDots();
						System.out.println(" You're still lost in a cave.\n");
					} else if ((userMove.equalsIgnoreCase("r") && computerMove.equalsIgnoreCase("s")) || (userMove.equalsIgnoreCase("p") && computerMove.equalsIgnoreCase("r")) || (userMove.equalsIgnoreCase("s") && computerMove.equalsIgnoreCase("p"))) {
						System.out.print("You win! ");
						printScaryDots();
						System.out.println(" Well, you don't really win anything. You're still lost in a cave. Heh.\n");
					} else {
						System.out.print("You lose! ");
						printScaryDots();
						System.out.println(" But what did you lose? You're in a cave. You're already lost.");
					}
					Thread.sleep(3000);

					break;
				default:
					printScaryDots();
					System.out.println("");
					System.out.print("The rusty machine turns to you. "); Thread.sleep(2000);
					System.out.println("It feels... Insulted? Somehow."); Thread.sleep(1000);
					continue;
			}
		}
		return "q";  // To break out of the main loop.
	}

	private static void printScaryDots() throws InterruptedException{
		for (int i = 0; i < 3; i++) {
			Thread.sleep(750);
			System.out.print(".");
		}
		Thread.sleep(750);
	}


}

