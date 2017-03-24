import java.util.ArrayList;
import java.util.List;

public class Member {
  private String mName;
  private String mJob;
  private String mLanguages;
  private String mFrom;
  private static List<Member> instances = new ArrayList<Member>();
  private int mId;

  public Member(String name, String job, String langauges, String from) {
    mName = name;
    mJob = job;
    mLanguages = langauges;
    mFrom = from;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public String getJob() {
    return mJob;
  }

  public String getLanguages() {
    return mLanguages;
  }

  public String getFrom() {
    return mFrom;
  }

  public static List<Member> all() {
    return instances;
  }

  public static void clearList() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Member find(int id) {
    return instances.get(id - 1);
  }
}
