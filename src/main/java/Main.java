import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
//import waiters.ShiftDays;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());

        get("/", (req,  res) -> {
            Map<String, Object> model= new HashMap<> ();
            return new HandlebarsTemplateEngine ().render (new ModelAndView (model,"index.handlebars"));
        });

//        post("/", (req,  res) -> {
//            NameReturn nameReturn = new NameReturn ();
//            Map<String, Object> model= new HashMap<> ();
//            return new HandlebarsTemplateEngine ().render (new ModelAndView (model,"index.handlebars"));
//        });
    }

}
