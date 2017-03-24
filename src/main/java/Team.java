import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mTitle;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  private List<Member> mMembers;

  public Team(String title) {
    mTitle = title;
    instances.add(this);
    mId = instances.size();
    mMembers = new ArrayList<Member>();
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

  public static Team find(int id) {
    return instances.get(id - 1);
  }

  public List<Member> getMembers() {
    return mMembers;
  }

  public void addMember(Member member) {
    mMembers.add(member);
  }
}
