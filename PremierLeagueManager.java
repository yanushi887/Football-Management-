
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


import static java.lang.Integer.parseInt;


public class PremierLeagueManager  implements   LeagueManager {
    private final int numberOfClubs; // create a integer value of number of clubs

    private final ArrayList<FootballClub> league; // create a array list get football club details in to league
    private final Scanner scanner;
    private final ArrayList<Match> matches;  // get the matches


    public PremierLeagueManager(int numberOfClubs) throws IOException {
        this.numberOfClubs = numberOfClubs;
        league = new ArrayList<>();
        matches = new ArrayList<>();
        scanner = new Scanner(System.in);


    }


    public void addClub() {
        if (league.size() == numberOfClubs) { // returns the number of elements in this list
            System.out.println("Can't add more clubs to league");
            return;
        }
        FootballClub club = new FootballClub();
        System.out.println("Enter Club Name : ");
        String line = scanner.nextLine();
        club.setClubName(line);  // set name of club

        if (league.contains(club)) { // true if this list contains the specified elements
            System.out.println("This club is add in the league ");
            return;
        }
        System.out.println("Enter Club Location : ");
        line = scanner.nextLine();
        club.setClubLocation(line);
        league.add(club);


    }

    public void deleteClub() {
        System.out.println("Enter club name : ");
        String line = scanner.nextLine();
        for (FootballClub club : league) { // add football club details in to the array
            if (club.getClubName().equals(line)) { // compares this string to the specified object
                league.remove(club); // remove the club in the league
                System.out.println(" Club : " + club.getClubName() + " removed ");
                return;
            }

        }
        System.out.println("No such club is included in the league ");
    }

    public void displayStatistics() {
        System.out.println("Enter Club Name : ");
        String line = scanner.nextLine();
        for (FootballClub club : league) {
            if (club.getClubName().equals(line)) {
                System.out.println(" Club : " + club.getClubName() + " matches won  = " + club.getWinCount());
                System.out.println(" Club : " + club.getClubName() + " matches lost = " + club.getDefeatCount());
                System.out.println(" Club : " + club.getClubName() + " matches draw = " + club.getDrawCount());
                System.out.println(" Club : " + club.getClubName() + " goal scored  = " + club.getGoalScoredCount());
                System.out.println(" Club : " + club.getClubName() + " goal received = " + club.getGoalReceivedCount());
                System.out.println(" Club : " + club.getClubName() + " points    = " + club.getPoints());
                System.out.println(" Club : " + club.getClubName() + " matches played = " + club.getMatchesPlayed());
                return;


            }
        }
        System.out.println("No such club is included in the league");
    }

    public void displayLeagueTable() {
        System.out.println("&&&&&&&& Premier League Table &&&&&&&&");
        System.out.println();
        Collections.sort(league, new SportComparator()); // sort the specified list in descending order
        for (FootballClub club : league) {
            System.out.println(" Club :  " + club.getClubName() + " Won :  " + club.getWinCount() + " Lost :  " + club.getDefeatCount() + " Draw :  " + club.getDrawCount() + " Scored :  " + club.getGoalScoredCount() +
                    " Received :  " + club.getGoalReceivedCount() + " Points :  " + club.getPoints() + " Matches :  " + club.getMatchesPlayed() + " Goal Difference : " + (club.getGoalScoredCount() - club.getGoalReceivedCount()));


        }
    }


    public void addPlayedMatch() {
        System.out.println("Day :");
        int d = scanner.nextInt();
        System.out.println("Month : ");
        int m = scanner.nextInt();
        System.out.println("Year : ");
        int y = scanner.nextInt();

        LocalDate date = LocalDate.of(y, m, d);
        System.out.println(date);
        System.out.println();
        String line;
        scanner.nextLine();

        System.out.println("Enter Home Team : ");
        String line1 = scanner.nextLine();
        FootballClub home = null;
        for (FootballClub club : league) {  // add club objects of details in to the array list
            if (club.getClubName().equals(line1))
                home = club;
        }
        if (home == null) {   // this message will appear if the user enters a club that is not entered
            System.out.println("No such club is included in the league");
            return;
        }
        System.out.println("Enter Away Team : ");
        String line2 = scanner.nextLine();
        FootballClub away = null;
        for (FootballClub club : league) {
            if (club.getClubName().equals(line2))
                away = club;
        }
        if (away == null) {
            System.out.println("No such club is included in the league");
            return;
        }
        System.out.println("Enter Home Team Goals : ");
        line = scanner.nextLine();
        int homeGoals = -1;
        try {
            homeGoals = parseInt(line);
        } catch (Exception e) {

        }
        if (homeGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }
        System.out.println("Enter Away Team Goals : ");
        line = scanner.nextLine();
        int awayGoals = -1;
        try {
            awayGoals = parseInt(line);
        } catch (Exception e) {

        }
        if (awayGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }

        Match match = new Match();
        match.setLocalDatetime(date);
        match.setTeamA(line1);
        match.setTeamB(line2);
        match.setTeamAScore(awayGoals);
        match.setTeamBScore(homeGoals);
        matches.add(match);
        System.out.println(matches);
        home.setGoalScoredCount(home.getGoalScoredCount() + homeGoals);
        away.setGoalScoredCount(away.getGoalScoredCount() + awayGoals);
        home.setGoalReceivedCount(home.getGoalReceivedCount() + awayGoals);
        away.setGoalReceivedCount(away.getGoalReceivedCount() + homeGoals);
        home.setMatchesPlayed(home.getMatchesPlayed() + 1);
        away.setMatchesPlayed(away.getMatchesPlayed() + 1);


        if (homeGoals > awayGoals) {
            home.setPoints(home.getPoints() + 3);
            home.setWinCount(home.getWinCount() + 1);
            away.setDefeatCount(away.getDefeatCount() + 1);

        } else if (homeGoals < awayGoals) {
            away.setPoints(away.getPoints() + 3);
            away.setWinCount(away.getWinCount() + 1);
            home.setDefeatCount(home.getDefeatCount() + 1);

        } else {
            home.setPoints(home.getPoints() + 1);
            away.setPoints(away.getPoints() + 1);
            home.setDrawCount(home.getDrawCount() + 1);
            away.setDrawCount(away.getDrawCount() + 1);


        }

    }

    @Override
    public void saveDataToFile() {
        // write to file
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Details.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(league);
            objectOutputStream.flush();
            objectOutputStream.close();


            System.out.println("All Details have been saved successfully");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void retrieveData() {    // reading the data in to file
        try {
            FileInputStream readData = new FileInputStream("Details.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<FootballClub> data = (ArrayList<FootballClub>) readStream.readObject();
            readStream.close();

            for (FootballClub club : data) {
                league.add(club);
            }
            System.out.println(league.toString());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void viewPoints() {
        Collections.sort(league, (s1, s2) -> Integer.compare(s2.getPoints(), s1.getPoints()));  // sort points descending order
        TableView<FootballClub> table = new TableView<FootballClub>();
        ObservableList<FootballClub> data = FXCollections.observableArrayList(league); // add data into table

        final Label label = new Label(" Premier League Table   (>>>>>>>> Points <<<<<<<<) ");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn clNameCol = new TableColumn("Club Name");
        clNameCol.setMinWidth(100);
        clNameCol.setCellValueFactory(new PropertyValueFactory<FootballClub, String>("clubName"));


        TableColumn winCol = new TableColumn("Win Count");
        winCol.setMinWidth(100);
        winCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("winCount"));

        TableColumn drawCol = new TableColumn(" Draw Count");
        drawCol.setMinWidth(100);
        drawCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("drawCount"));

        TableColumn defCol = new TableColumn("Defeat Count");
        defCol.setMinWidth(100);
        defCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("defeatCount"));

        TableColumn receiveCol = new TableColumn("Received Count");
        receiveCol.setMinWidth(100);
        receiveCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalReceivedCount"));

        TableColumn scoreCol = new TableColumn("Scored Count");
        scoreCol.setMinWidth(100);
        scoreCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalScoredCount"));

        TableColumn pointCol = new TableColumn("Points");
        pointCol.setMinWidth(100);
        pointCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("points"));

        TableColumn matchCol = new TableColumn("Matches Played");
        matchCol.setMinWidth(100);
        matchCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("matchesPlayed"));


        table.getColumns().addAll(clNameCol, winCol, drawCol, defCol, receiveCol, scoreCol, pointCol, matchCol);
        table.setItems(data);
        table.setStyle("-fx-background-color:#000000");


        final VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(20, 20, 30, 20));
        vBox.setStyle("-fx-background-color:#008080");
        vBox.getChildren().addAll(label, table);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vBox);
        Stage stage = new Stage();
        stage.setTitle("Table");
        stage.setWidth(850);
        stage.setHeight(517);


        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void viewWins() {
        Collections.sort(league, (s1, s2) -> Integer.compare(s2.getWinCount(), s1.getWinCount()));  // sort largest number of wins descending order
        TableView<FootballClub> table = new TableView<FootballClub>();
        ObservableList<FootballClub> data = FXCollections.observableArrayList(league); // add data into table

        final Label label = new Label(" Premier League Table  (>>>>>>>>> Largest Number of Wins <<<<<<<<<<<) ");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn clNameCol = new TableColumn("Club Name");
        clNameCol.setMinWidth(100);
        clNameCol.setCellValueFactory(new PropertyValueFactory<FootballClub, String>("clubName"));


        TableColumn winCol = new TableColumn("Win Count");
        winCol.setMinWidth(100);
        winCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("winCount"));

        TableColumn drawCol = new TableColumn(" Draw Count");
        drawCol.setMinWidth(100);
        drawCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("drawCount"));

        TableColumn defCol = new TableColumn("Defeat Count");
        defCol.setMinWidth(100);
        defCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("defeatCount"));

        TableColumn receiveCol = new TableColumn("Received Count");
        receiveCol.setMinWidth(100);
        receiveCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalReceivedCount"));

        TableColumn scoreCol = new TableColumn("Scored Count");
        scoreCol.setMinWidth(100);
        scoreCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalScoredCount"));

        TableColumn pointCol = new TableColumn("Points");
        pointCol.setMinWidth(100);
        pointCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("points"));

        TableColumn matchCol = new TableColumn("Matches Played");
        matchCol.setMinWidth(100);
        matchCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("matchesPlayed"));


        table.getColumns().addAll(clNameCol, winCol, drawCol, defCol, receiveCol, scoreCol, pointCol, matchCol);
        table.setItems(data);
        table.setStyle("-fx-background-color:#000000");


        final VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(20, 20, 30, 20));
        vBox.setStyle("-fx-background-color:#F75D59");
        vBox.getChildren().addAll(label, table);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vBox);
        Stage stage = new Stage();
        stage.setTitle("Table");
        stage.setWidth(850);
        stage.setHeight(517);


        stage.setScene(scene);
        stage.showAndWait(); // show GUI


    }

    @Override
    public void viewGoalScored() {
        Collections.sort(league, (s1, s2) -> Integer.compare(s2.getGoalScoredCount(), s1.getGoalScoredCount())); // sort goal scored descending order
        TableView<FootballClub> table = new TableView<FootballClub>();
        ObservableList<FootballClub> data = FXCollections.observableArrayList(league); // add data into table

        final Label label = new Label(" Premier League Table  (<<<<<<<<<< Goal Scored <<<<<<<<<<) ");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn clNameCol = new TableColumn("Club Name");
        clNameCol.setMinWidth(100);
        clNameCol.setCellValueFactory(new PropertyValueFactory<FootballClub, String>("clubName"));


        TableColumn winCol = new TableColumn("Win Count");
        winCol.setMinWidth(100);
        winCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("winCount"));

        TableColumn drawCol = new TableColumn(" Draw Count");
        drawCol.setMinWidth(100);
        drawCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("drawCount"));

        TableColumn defCol = new TableColumn("Defeat Count");
        defCol.setMinWidth(100);
        defCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("defeatCount"));

        TableColumn receiveCol = new TableColumn("Received Count");
        receiveCol.setMinWidth(100);
        receiveCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalReceivedCount"));

        TableColumn scoreCol = new TableColumn("Scored Count");
        scoreCol.setMinWidth(100);
        scoreCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalScoredCount"));

        TableColumn pointCol = new TableColumn("Points");
        pointCol.setMinWidth(100);
        pointCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("points"));

        TableColumn matchCol = new TableColumn("Matches Played");
        matchCol.setMinWidth(100);
        matchCol.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("matchesPlayed"));


        table.getColumns().addAll(clNameCol, winCol, drawCol, defCol, receiveCol, scoreCol, pointCol, matchCol); // adding elements to table
        table.setItems(data);
        table.setStyle("-fx-background-color:#000000");


        final VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20, 20, 30, 22));
        vBox.setStyle("-fx-background-color:#00FF00");
        vBox.getChildren().addAll(label, table);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vBox);
        Stage stage = new Stage();
        stage.setTitle("Table");
        stage.setWidth(850);
        stage.setHeight(517);


        stage.setScene(scene);
        stage.showAndWait(); // show GUI

    }

    @Override
    public void generateRandomMatch() {
        TableView<Match> table = new TableView<Match>();


        final Label label = new Label(" Premier League Table ");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn tCol = new TableColumn("Date");
        tCol.setMinWidth(200);
        tCol.setCellValueFactory(new PropertyValueFactory<Match, String>("localDatetime"));


        TableColumn t1Col = new TableColumn("Team A");
        t1Col.setMinWidth(250);
        t1Col.setCellValueFactory(new PropertyValueFactory<Match, String>("teamA"));

        TableColumn scCol = new TableColumn(" Team B ");
        scCol.setMinWidth(250);
        scCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamB"));

        TableColumn sc1fCol = new TableColumn("Team A Score");
        sc1fCol.setMinWidth(250);
        sc1fCol.setCellValueFactory(new PropertyValueFactory<Match, Integer>("teamAScore"));

        TableColumn dateCol = new TableColumn("Team B Score");
        dateCol.setMinWidth(250);
        dateCol.setCellValueFactory(new PropertyValueFactory<Match, Integer>("teamBScore"));

        Button btn = new Button("Pick random Player");
        btn.setOnAction(event1 -> {
            Random r1 = new Random();

            int team1 = r1.nextInt(league.size());
            FootballClub team1Name = league.get(team1);
            int team2 = r1.nextInt(league.size());
            FootballClub team2Name = league.get(team2);
            String teamA = team1Name.getClubName();
            String teamB = team2Name.getClubName();
            Random r = new Random();
            int day = r.nextInt(30) + 1;
            int month = r.nextInt(12) + 1;
            int year = r.nextInt(20) + 2005;

            LocalDate randomDate = LocalDate.of(year, month, day);
            System.out.println(randomDate);


            int team1Score = r1.nextInt(16);
            int team2Score = r1.nextInt(16);
            Match match = new Match();
            match.setTeamA(teamA);
            match.setTeamB(teamB);
            match.setTeamAScore(team1Score);
            match.setTeamBScore(team2Score);
            match.setLocalDatetime(randomDate);
            matches.add(match);
            team1Name.setGoalScoredCount(team1Name.getGoalScoredCount() + team1Score);
            team2Name.setGoalScoredCount(team2Name.getGoalScoredCount() + team2Score);
            team1Name.setGoalReceivedCount(team1Name.getGoalReceivedCount() + team2Score);
            team2Name.setGoalReceivedCount(team2Name.getGoalReceivedCount() + team1Score);
            team1Name.setMatchesPlayed(team1Name.getMatchesPlayed() + 1);
            team2Name.setMatchesPlayed(team2Name.getMatchesPlayed() + 1);


            if (team1Score > team2Score) {
                team1Name.setPoints(team1Name.getPoints() + 3);
                team1Name.setWinCount(team1Name.getWinCount() + 1);
                team2Name.setDefeatCount(team2Name.getDefeatCount() + 1);

            } else if (team1Score < team2Score) {
                team2Name.setPoints(team2Name.getPoints() + 3);
                team2Name.setWinCount(team2Name.getWinCount() + 1);
                team1Name.setDefeatCount(team1Name.getDefeatCount() + 1);

            } else {
                team1Name.setPoints(team1Name.getPoints() + 1);
                team2Name.setPoints(team2Name.getPoints() + 1);
                team1Name.setDrawCount(team1Name.getDrawCount() + 1);
                team2Name.setDrawCount(team2Name.getDrawCount() + 1);


            }


            ObservableList<Match> data = FXCollections.observableArrayList(matches);
            table.setItems(data);
        });
        table.getColumns().addAll(tCol, t1Col, scCol, sc1fCol, dateCol); // adding elements to table
        table.setStyle("-fx-background-color:#000000");


        final VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20, 20, 30, 22));
        vBox.setStyle("-fx-background-color:#00FF00");
        vBox.getChildren().addAll(label, table, btn);

        Scene scene = new Scene(new Group(), 1260, 550);
        ((Group) scene.getRoot()).getChildren().addAll(vBox);
        Stage stage = new Stage();
        stage.setTitle("Table");
        stage.setWidth(1260);
        stage.setHeight(550);


        stage.setScene(scene);
        stage.showAndWait(); // show GUI


    }

    @Override
    public void sortDate() {
        Collections.sort(matches, new Comparator<Match>() {
            @Override
            public int compare(Match o1, Match o2) {  // sort the date in descending order
                if (o1.getLocalDatetime() == null || o2.getLocalDatetime() == null)
                    return 0;
                return o1.getLocalDatetime().compareTo(o2.getLocalDatetime());
            }
        });

        TableView<Match> table = new TableView<Match>();


        final Label label = new Label(" Premier League Table  <<<<<<< Sort Date <<<<<<<<< ");
        label.setFont(new Font("Arial", 20));


        table.setEditable(true);

        TableColumn tCol = new TableColumn("Date");
        tCol.setMinWidth(200);
        tCol.setCellValueFactory(new PropertyValueFactory<Match, String>("localDatetime"));


        TableColumn t1Col = new TableColumn("Team A");
        t1Col.setMinWidth(250);
        t1Col.setCellValueFactory(new PropertyValueFactory<Match, String>("teamA"));

        TableColumn scCol = new TableColumn(" Team B");
        scCol.setMinWidth(250);
        scCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamB"));

        TableColumn sc1fCol = new TableColumn("Team A Score");
        sc1fCol.setMinWidth(250);
        sc1fCol.setCellValueFactory(new PropertyValueFactory<Match, Integer>("teamAScore"));

        TableColumn dateCol = new TableColumn("Team B Score");
        dateCol.setMinWidth(200);
        dateCol.setCellValueFactory(new PropertyValueFactory<Match, Integer>("teamBScore"));

        Button btn = new Button("Sort Date");
        btn.setOnAction(event1 -> {


            ObservableList<Match> data = FXCollections.observableArrayList(matches);
            table.setItems(data);
        });


        table.getColumns().addAll(tCol, t1Col, scCol, sc1fCol, dateCol); // adding elements to table
        table.setStyle("-fx-background-color:#000000");


        final VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20, 20, 30, 22));
        vBox.setStyle("-fx-background-color:#FBB917");
        vBox.getChildren().addAll(label, table, btn);

        Scene scene = new Scene(new Group(), 1210, 550);
        ((Group) scene.getRoot()).getChildren().addAll(vBox);
        Stage stage = new Stage();
        stage.setTitle("Table");
        stage.setWidth(1210);
        stage.setHeight(550);


        stage.setScene(scene);
        stage.showAndWait(); // show GUI


        System.out.println(matches);
    }

    public void findMatch() {

        TableView<Match> table = new TableView<Match>();

        final Label label = new Label(" Premier League Table ");
        label.setFont(new Font("Arial", 20));


        table.setEditable(true);

        TableColumn tCol = new TableColumn("Date");
        tCol.setMinWidth(180);
        tCol.setCellValueFactory(new PropertyValueFactory<Match, String>("localDatetime"));


        TableColumn t1Col = new TableColumn("Team A");
        t1Col.setMinWidth(180);
        t1Col.setCellValueFactory(new PropertyValueFactory<Match, String>("teamA"));

        TableColumn scCol = new TableColumn(" Team B");
        scCol.setMinWidth(180);
        scCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamB"));

        TableColumn sc1fCol = new TableColumn("Team A Score");
        sc1fCol.setMinWidth(180);
        sc1fCol.setCellValueFactory(new PropertyValueFactory<Match, Integer>("teamAScore"));

        TableColumn dateCol = new TableColumn("Team B Score");
        dateCol.setMinWidth(180);
        dateCol.setCellValueFactory(new PropertyValueFactory<Match, Integer>("teamBScore"));

        Label message = new Label("Enter Date :");
        message.setFont(new Font("Arial Rounded MT Bold", 12));
        TextField day = new TextField();
        day.setPromptText("Enter Date ");
        day.setPrefColumnCount(5);
        day.setPrefWidth(120);
        day.setMaxWidth(120);


        Button btn = new Button("Search");
        btn.setOnAction(event1 -> {
                    ArrayList<Match> matchDate = new ArrayList<>();

                    LocalDate dateSearch = LocalDate.parse(day.getText());
                    for (Match match : matches) {
                        if (match.getLocalDatetime().equals(dateSearch)) { // find match by given date
                            matchDate.add(match);

                        }else { // execute if any matches hasn't recorded related to the given date
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Invalid Data Alert");
                            alert.setContentText("There aren`t any matches details related to the given date");
                            alert.showAndWait();
                        }

                    }


                    ObservableList<Match> data = FXCollections.observableArrayList(matchDate); // add data in to table
                    table.setItems(data);

        });

            table.getColumns().addAll(tCol, t1Col, scCol, sc1fCol, dateCol); // adding elements to table
            table.setStyle("-fx-background-color:#000000");


            final VBox vBox = new VBox();
            vBox.setSpacing(10);
            vBox.setPadding(new Insets(20, 20, 30, 22));
            vBox.setStyle("-fx-background-color:#6960EC");


            vBox.getChildren().addAll(label, message, day,btn, table);


            Scene scene = new Scene(new Group(), 960, 617);
            ((Group) scene.getRoot()).getChildren().addAll(vBox);
            Stage stage = new Stage();
            stage.setTitle("Table");
            stage.setWidth(960);
            stage.setHeight(617);


            stage.setScene(scene);
            stage.showAndWait(); // show GUI





    }
}







