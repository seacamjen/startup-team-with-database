import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mTitle;
  private static List<Team> instances = new ArrayList<Team>();

  public Team(String title) {
    mTitle = title;
    instances.add(this);
  }

  public String getTitle() {
    return mTitle;
  }

  public static List<Team> all() {
    return instances;
  }
}
