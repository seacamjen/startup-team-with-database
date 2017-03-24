import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mTitle;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;

  public Team(String title) {
    mTitle = title;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public static List<Team> all() {
    return instances;
  }

  public static void clearList() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }
}
