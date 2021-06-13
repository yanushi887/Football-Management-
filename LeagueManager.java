import java.io.IOException;
import java.text.ParseException;

public interface LeagueManager {
    void addClub();
    void deleteClub();
    void displayStatistics();
    void displayLeagueTable();
    void addPlayedMatch() throws ParseException;
    void saveDataToFile() throws IOException;
    void retrieveData();
    void viewPoints();
    void viewWins();
    void viewGoalScored();
    void generateRandomMatch();
    void sortDate();
    void findMatch();


}
