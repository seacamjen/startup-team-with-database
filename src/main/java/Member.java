import java.util.ArrayList;
import java.util.List;

public class Member {
  private String mName;
  private static List<Member> instances = new ArrayList<Member>();

  public Member(String name) {
    mName = name;
    instances.add(this);
  }

  public String getName() {
    return mName;
  }

  public static List<Member> all() {
    return instances;
  }

  public static void clearList() {
    instances.clear();
  }
}
