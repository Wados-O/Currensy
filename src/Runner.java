
import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(Style.logo);
    Menu.mainMenu(new Converter(), sc);
  }

}
