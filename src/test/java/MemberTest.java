import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberTest {

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member myMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_String() {
    Member myMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    assertEquals("Jeff", myMember.getName());
  }

  @Test
  public void Member_instantiatesWithJob_String() {
    Member myMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    assertEquals("Oracle", myMember.getJob());
  }

  @Test
  public void Member_instantiatesWithLanguages_String() {
    Member myMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    assertEquals("Java, Javascript", myMember.getLanguages());
  }

  @Test
  public void Member_instantiatesWithFrom_String() {
    Member myMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    assertEquals("SLO", myMember.getFrom());
  }

  @Test
  public void all_returnsAllInstancesOfMembers_true() {
    Member firstMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    Member secondMember = new Member("Charlie", "Tapestry", "Python", "Paso");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }

  @Test
  public void clearList_emptiesAllMembersFromArrayList_0() {
    Member myMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    Member.clearList();
    assertEquals(0, Member.all().size());
  }

  @Test
  public void getId_memberinstantiatesWithId_1() {
    Member.clearList();
    Member myMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    assertEquals(1, myMember.getId());
  }

  @Test
  public void find_returnMemberWithSameId_secondMember() {
    Member firstMember = new Member("Jeff", "Oracle", "Java, Javascript", "SLO");
    Member secondMember = new Member("Charlie", "Tapestry", "Python", "Paso");
    assertEquals(secondMember, Member.find(secondMember.getId()));
  }
}
