
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements Style {

  public static boolean isRun = true;

  public static void mainMenu(Converter converter, Scanner sc) {
    while (isRun) {
      System.out.println();
      System.out.println(BLUE + "╔══════════════════════════════════════╗" + RESET);
      System.out.println(
          BLUE + "║          " + YELLOW + "ОСНОВНОЕ МЕНЮ" + BLUE + "               ║" + RESET);
      System.out.println(BLUE + "╠══════════════════════════════════════╣" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "1. Просмотреть курс валют" + BLUE + "         ║" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "2. Обменять валюты" + BLUE + "                ║" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "3. Купить валюту" + BLUE + "                  ║" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "4. Продать валюту" + BLUE + "                 ║" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "5. Добавить валюту" + BLUE + "                ║" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "6. Удалить валюту" + BLUE + "                 ║" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "7. Изменить значение курса валюты " + BLUE + "║" + RESET);
      System.out.println(
          BLUE + "║    " + RESET + "8. Выход" + BLUE + "                          ║" + RESET);
      System.out.println(BLUE + "╚══════════════════════════════════════╝" + RESET);
      System.out.println();
      System.out.println(YELLOW + "Выберите номер пункта: " + RESET);
      int choice = Input.readIntLimited(1, 8);
      switch (choice) {
        case 1 -> converter.showRates(sc);
        case 2 -> converter.converterCurrency(sc);
        case 3 -> converter.buyCurrency(sc);
        case 4 -> converter.sellCurrency(sc);
        case 5 -> converter.addExchangeRate(sc);
        case 6 -> converter.removeRate(sc);
        case 7 -> converter.setExchangeRates(sc);
        case 8 -> {
          System.out.println(CYAN + " *       До Свидания !!!      * " + RESET);
          System.out.println(YELLOW + " -===     Заходите еще     ===- " + RESET);
          isRun = false;
        }
      }
    }
  }
}

