import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Converter implements Style {

  private final Map<String, Double> exchangeRates;
  private static final double COMMISSION_BUY = 0.070;
  private static final double COMMISSION_SELL = 0.045;
  private static final double COMMISSION_CONVERTER = 0.056;


  public Converter() {
    exchangeRates = new HashMap<>();
    exchangeRates.put("USD", 1.110);
    exchangeRates.put("EUR", 1.000);
    exchangeRates.put("GBP", 1.290);
    exchangeRates.put("JPY", 0.007);
    exchangeRates.put("CAD", 0.759);
    exchangeRates.put("AUD", 0.683);
    exchangeRates.put("UAH", 0.025);
    exchangeRates.put("PLZ", 0.252);
    exchangeRates.put("CHF", 1.160);
    exchangeRates.put("RUB", 0.0098);
    exchangeRates.put("RON", 0.2000);
    exchangeRates.put("CZK", 0.0420);
  }

  public void converterCurrency(Scanner sc) {

    System.out.println(GREEN + " [  МЕНЮ ОБМЕНА  ]" + RESET);
    System.out.println("Выберите порядковый номер валюты, которую хотите продать: ");
    printListRate();
    int choiceFrom = Input.readIntLimited(1, getCount());
    String fromCurrency = getRates(choiceFrom);
    System.out.println("Сколько " + fromCurrency + " вы хотите продать?");
    double amountCurrent = Input.readDoubleLimited();

    System.out.println("Выберите порядковый номер валюты, которую хотите купить: ");
    printListRate();
    int choiceTo = Input.readIntLimited(1, getCount());
    String toCurrency = getRates(choiceTo);

    double exchangeFrom = exchangeRates.get(fromCurrency);
    double exchangeTo = exchangeRates.get(toCurrency);
    double commission = amountCurrent * COMMISSION_CONVERTER;
    double result = (amountCurrent - commission) * (exchangeFrom / exchangeTo);

    System.out.printf(
        "Вы продали " + amountCurrent + " " + fromCurrency + " и получили " + String.format("%.2f",
            result) + " " + toCurrency + ". Комиссия за операцию составила = " + String.format(
            "%.2f", commission) + " "
            + fromCurrency);
    System.out.println();
    System.out.println(CYAN + "[         Заходите еще!!!      ]" + RESET);
  }

  public void buyCurrency(Scanner sc) {
    System.out.println(CYAN + " [  МЕНЮ ПОКУПКИ  ]" + RESET);
    System.out.println("Выберите порядковый номер валюты, которую хотите купить: ");
    printListRate();

    int choiceTo = Input.readIntLimited(1, getCount());
    String toCurrency = getRates(choiceTo);
    System.out.println("Сколько " + toCurrency + " вы хотите купить?");
    double amountCurrent = Input.readDoubleLimited();

    double exchangeTo = exchangeRates.get(toCurrency);
    double exchangeEuro = exchangeRates.get("EUR");
    double valueExchangeToUsd = amountCurrent * exchangeTo;
    double resultEuro = valueExchangeToUsd / exchangeEuro;
    double result = resultEuro + COMMISSION_BUY * 100;

    System.out.printf(
        "Для покупки " + amountCurrent + " " + toCurrency + " вам потребуется " + String.format(
            "%.2f", result) + " EUR. В сумму включена комиссия за покупку в размере = "
            + String.format(
            "%.2f", COMMISSION_BUY * 100) + " EUR");
    System.out.println();
    System.out.println(CYAN + "[         Заходите еще!!!      ]" + RESET);
  }

  public void sellCurrency(Scanner sc) {
    System.out.println(YELLOW + " [  МЕНЮ ПРОДАЖИ  ]" + RESET);
    System.out.println("Выберите порядковый номер валюты, которую хотите продать: ");
    printListRate();

    int choiceFrom = Input.readIntLimited(1, getCount());
    String FromCurrency = getRates(choiceFrom);
    System.out.println("Сколько " + FromCurrency + " вы хотите продать?");
    double amountCurrent = Input.readDoubleLimited();

    double exchangeFrom = exchangeRates.get(FromCurrency);
    double exchangeEuro = exchangeRates.get("EUR");
    double valueExchangeToUsd = amountCurrent * exchangeFrom;
    double resultEuro = valueExchangeToUsd / exchangeEuro;
    double result = resultEuro - COMMISSION_SELL * 100;

    System.out.printf(
        "За продажу " + amountCurrent + " " + FromCurrency + " вы получите " + String.format("%.2f",
            result) + " EUR. Итоговая сумма за минусом комиссии за продажу в размере = "
            + String.format(
            "%.2f", COMMISSION_SELL * 100) + " EUR");
    System.out.println();
    System.out.println(CYAN + "[         Заходите еще!!!      ]" + RESET);
  }

  public void addExchangeRate(Scanner sc) {
    System.out.println(CYAN + " [ МЕНЮ ДОБАВЛЕНИЯ ]" + RESET);
    System.out.println("Введите код валюты, которую хотите добавить: ");
    String code = Input.readStringLimited(1, 3).toUpperCase();
    if (exchangeRates.containsKey(code)) {
      System.out.println("Валюта " + code + " уже существует!");
    }
    System.out.println("Ведите курс для валюты " + code);
    double rateExchange = Input.readDoubleLimited();
    exchangeRates.put(code, rateExchange);
    System.out.println(
        "Валюта " + code + " по курсу " + rateExchange + " добавлена в лист валют для обмена!!!");
  }

  public void removeRate(Scanner sc) {
    System.out.println(RED + " [  МЕНЮ УДАЛЕНИЯ  ]" + RESET);
    System.out.println("Выберите порядковый номер валюты, которую хотите удалить: ");
    printListRate();

    int choiceFrom = Input.readIntLimited(1, getCount());
    String code = getRates(choiceFrom);
    exchangeRates.remove(code);
    System.out.println("Валюта " + code + " успешно удалена!!! ");
  }

  public void setExchangeRates(Scanner sc) {
    printListRate();
    System.out.println(
        "Введите номер в списке валюты,\n у которой необходимо задать новое значение курса: ");
    int code = Input.readIntLimited(1, getCount());
    for (String currency : exchangeRates.keySet()) {
      String currencyForChange = getRates(code);
      if (currency.equals(currencyForChange)) {
        System.out.print("Введите новое значение курса для валюты: ");
        double exchangeRates = Input.readDoubleLimited();
        this.exchangeRates.replace(currency, this.exchangeRates.get(currency), exchangeRates);
        break;
      }
    }

    System.out.println("Новое значения присвоено!!! ");
  }


  public void showRates(Scanner sc) {
    System.out.println(BLUE + "    [* КУРС  ВАЛЮТ *]           " + RESET);
    System.out.println();
    for (String currency : exchangeRates.keySet()) {
      double exchangeRate = exchangeRates.get(currency);
      System.out.println(
          "    " + GREEN + currency + RESET + RED + "    |    " + RESET + String.format("%.3f",
              exchangeRate));
    }
  }

  private void printListRate() {
    int i = 1;
    for (String currency : exchangeRates.keySet()) {
      System.out.println("    " + GREEN + currency + RESET + RED + "    |    " + RESET + i);
      i++;
    }
  }

  private int getCount() {
    int count = 0;
    for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
      String key = entry.getKey();
      Double value = entry.getValue();
      count++;
    }
    return count;

  }

  private String getRates(int choice) {
    int i = 1;
    for (String currency : exchangeRates.keySet()) {
      if (i == choice) {
        return currency;
      }
      i++;
    }
    return null;
  }

}
