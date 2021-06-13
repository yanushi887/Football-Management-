import java.time.LocalDate;

public class Match {
      private String teamA;
      private String teamB;
      private int teamAScore;
      private int teamBScore;
      private LocalDate localDatetime;

      public Match() {
            this.teamA = null;
            this.teamB = null;
            this.teamAScore = 0;
            this.teamBScore = 0;

      }

      public String getTeamA() {
            return teamA;
      }

      public String getTeamB() {
            return teamB;
      }

      public int getTeamAScore() {
            return teamAScore;
      }

      public int getTeamBScore() {
            return teamBScore;
      }

      public LocalDate getLocalDatetime() {
            return localDatetime;
      }

      public void setTeamA(String teamA) {
            this.teamA = teamA;
      }

      public void setTeamB(String teamB) {
            this.teamB = teamB;
      }

      public void setTeamAScore(int teamAScore) {
            this.teamAScore = teamAScore;
      }

      public void setTeamBScore(int teamBScore) {
            this.teamBScore = teamBScore;
      }

      public void setLocalDatetime(LocalDate localDatetime) {
            this.localDatetime = localDatetime;
      }

      @Override
      public String toString() {
            return "Match{" +
                    "teamA=" + teamA +
                    ", teamB=" + teamB +
                    ", teamAScore=" + teamAScore +
                    ", teamBScore=" + teamBScore +
                    ", date=" + localDatetime +
                    '}';
      }
}
