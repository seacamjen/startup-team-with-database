import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberTest {

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member myMember = new Member("Jeff");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_String() {
    Member myMember = new Member("Jeff");
    assertEquals("Jeff", myMember.getName());
  }

  @Test
  public void all_returnsAllInstancesOfMembers_true() {
    Member firstMember = new Member("Jeff");
    Member secondMember = new Member("Charlie");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }

  @Test
  public void clearList_emptiesAllMembersFromArrayList_0() {
    Member myMember = new Member("Jeff");
    Member.clearList();
    assertEquals(0, Member.all().size());
  }

  @Test
  public void getId_memberinstantiatesWithId_1() {
    Member.clearList();
    Member myMember = new Member("Jeff");
    assertEquals(1, myMember.getId());
  }
}
