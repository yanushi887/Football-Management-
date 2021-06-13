import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable {
    private int winCount;
    private int drawCount;
    private int defeatCount;
    private int goalReceivedCount;
    private int goalScoredCount;
    private int points;
    private int matchesPlayed;

    public int getWinCount() {
        return winCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public int getDefeatCount() {
        return defeatCount;
    }

    public int getGoalReceivedCount() {
        return goalReceivedCount;
    }

    public int getGoalScoredCount() {
        return goalScoredCount;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    public void setDefeatCount(int defeatCount) {
        this.defeatCount = defeatCount;
    }

    public void setGoalReceivedCount(int goalReceivedCount) {
        this.goalReceivedCount = goalReceivedCount;
    }

    public void setGoalScoredCount(int goalScoredCount) {
        this.goalScoredCount = goalScoredCount;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    @Override
    public String toString() {
        return "\n \nFootballClub ------ {" +
                "\n   clubName = "+ getClubName() +
                "\n   location = " + getClubLocation() +
                "\n   winCount = " + winCount +
                "\n   drawCount =  " + drawCount +
                "\n   defeatCount  =  " + defeatCount +
                "\n   goalReceivedCount  =  " + goalReceivedCount +
                "\n   goalScoredCount  =  " + goalScoredCount +
                "\n   points  = " + points +
                "\n   matchesPlayed =  " + matchesPlayed +
                "}\n";
    }
}