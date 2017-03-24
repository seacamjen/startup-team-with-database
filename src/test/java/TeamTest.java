import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void Team_instantiatesCorrectly_true() {
    Team myTeam = new Team("Cobras");
    assertEquals(true, myTeam instanceof Team);
  }

  @Test
  public void Team_instantiatesWithTitle_String() {
    Team myTeam = new Team("Cobras");
    assertEquals("Cobras", myTeam.getTitle());
  }

  @Test
  public void all_returnsAllInstancesOfTeams_true() {
    Team firstTeam = new Team("Cobras");
    Team secondTeam = new Team("Dolphins");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }

  @Test
  public void clearList_emtiesAllTeamsFromArrayList_0() {
    Team firstTeam = new Team("Cobras");
    Team.clearList();
    assertEquals(0, Team.all().size());
  }

  @Test
  public void getId_teamInstantiatesWithAnId_1() {
    Team.clearList();
    Team myTeam = new Team("Cobras");
    assertEquals(1, myTeam.getId());
  }
}
