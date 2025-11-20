import controllers.*;
import views.ViewConsole;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller(
            new ViewConsole(),
            new SortingMethods(),
            new SearchMethods()
        );
        controller.start();
    }
}
