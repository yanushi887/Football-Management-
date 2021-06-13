import java.util.Comparator;

public class SportComparator implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub t, FootballClub t1){

        if(t.getPoints()> t1.getPoints())
            return -1;
        else
            if(t.getPoints()<t1.getPoints())
                return 1;
            else {
                int goalDif = t.getGoalScoredCount()-t.getGoalReceivedCount();
                int goalDif1 = t.getGoalScoredCount()-t.getGoalReceivedCount();
                if (goalDif > goalDif1)
                    return -1;
                else
                    if (goalDif< goalDif1)
                        return 1;
                    else return 0;
            }
    }


}
