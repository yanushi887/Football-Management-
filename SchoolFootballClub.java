public class SchoolFootballClub extends SportsClub {
    private String name;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                "name='" + name + '\'' +
                '}';
    }
}
