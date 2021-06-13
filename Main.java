
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class Main extends Application {

    public static void main(String[] args) throws IOException {
      Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        PremierLeagueManager plm = new PremierLeagueManager(10);
        Scanner scanner = new Scanner(System.in);


        while (true){ // view menu and call relevant method based on the user input
            System.out.println();
            System.out.println("Welcome!!!");
            System.out.println("Here are the available options in this program");
            System.out.println();
            System.out.println(" ^^^^^^^^^^^^ Premier League Manager ^^^^^^^^^^^^^ ");
            System.out.println();
            System.out.println("Enter '1' for create new club and add it to league");
            System.out.println("Enter '2' for delete and exiting club");
            System.out.println("Enter '3' for view statistics  ");
            System.out.println("Enter '4' for display premier league table");
            System.out.println("Enter '5' for Add a Played Match");
            System.out.println("Enter '6' for Save data in to file");
            System.out.println("Enter '7' for load data in to file");
            System.out.println("Enter '8' for View Points");
            System.out.println("Enter '9' for View Largest Number of wins");
            System.out.println("Enter '10' for View Goal Scored");
            System.out.println("Enter '11' for Generate Random Match");
            System.out.println("Enter '12' for Sort Date ");
            System.out.println("Enter '13' for find Match");
            System.out.println("Enter '14' for Quit program");
            System.out.println();


            System.out.print("\nEnter your option here - ");
            String line = scanner.nextLine();
            int command = 0;
            try {
                command = Integer.parseInt(line); // parses are string argument as a signed decimal integer
            }catch (Exception e){

            }
            switch (command) {
                case 1 :
                    plm.addClub(); // call addClub() method
                    break;
                case 2:
                    plm.deleteClub(); // call deleteClub method
                    break;
                case 3:
                    plm.displayStatistics();  // call displayStatistics() method
                    break;
                case 4:
                    plm.displayLeagueTable(); // call displayLeagueTable() method
                    break;
                case 5:
                    plm.addPlayedMatch();  // call addPlayedMatch() method
                    break;
                case 6:
                    plm.saveDataToFile() ; // call saveDataToFile() method
                    break;
                case 7:
                    plm.retrieveData(); // call retrieveData() method
                    break;
                case 8:
                    plm.viewPoints(); // call viewLeagueTable() method
                    break;
                case 9:
                    plm.viewWins(); // call viewWins() method
                    break;
                case 10:
                    plm.viewGoalScored(); // call viewGoalScored() method
                    break;
                case 11:
                    plm.generateRandomMatch(); // call generateRandomMatch() method
                    break;
                case 12:
                    plm.sortDate();  // call sortDate() method
                    break;
                case 13:
                    plm.findMatch(); // call findMatch() method
                    break;
                case 14 :
                    System.out.println("Now you are exiting from the program");
                    System.exit(0); //terminate the program

                default: // execute if there're no matching cases
                    System.out.println("Invalid Command. Please try again");
                    break;
            }

        }

    }


    }

