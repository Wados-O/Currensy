public interface Style {

  String SPACE = "\u2009\u2009";
  String RESET = "\u001B[0m";
  String RED = "\u001B[31m";
  String GREEN = "\u001B[32m";
  String YELLOW = "\u001B[33m";
  String BLUE = "\u001B[34m";
  String PURPLE = "\u001B[35m";
  String CYAN = "\u001B[36m";
  String logo = String.format("""
              
      %s ┌─                  ─┐
      %s═╡│%sCURRENCY CONVERTER%s│╞═══════════━━━━━┅┅┅┅┅┅┄┄%s┄┄┄┈┈┈┈
      %s └─                  ─┘%s
        """, RED, PURPLE, GREEN, YELLOW, RED, YELLOW, RESET);
}

