import java.io.Serializable;

public abstract class SportsClub implements Serializable {

        private String clubName;
        private String clubLocation;
        private String statistics;

      @Override
      public boolean equals(Object o){
          return this.clubName.equals(((SportsClub)o).clubName);
      }




    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                '}';
    }
}


