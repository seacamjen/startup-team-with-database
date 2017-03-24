import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String title = request.queryParams("title");
      Team newTeam = new Team(title);
      model.put("template", "templates/team-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id1")));
      model.put("title", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id1/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id1")));
      model.put("title", team);
      model.put("template", "templates/team-member-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/members", (request, reponse) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Team team = Team.find(Integer.parseInt(request.queryParams("teamId")));

      String name = request.queryParams("name");
      String job = request.queryParams("job");
      String languages = request.queryParams("languages");
      String from = request.queryParams("from");
      Member newMember = new Member(name, job, languages, from);

      team.addMember(newMember);

      model.put("title", team);
      model.put("template", "templates/team-member-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id1/members/:id2", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id1")));
      Member member = Member.find(Integer.parseInt(request.params(":id2")));
      model.put("name", member);
      model.put("title", team);
      model.put("member", Member.all());
      model.put("template", "templates/team-member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/eventinfo", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/event-info.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }
}
