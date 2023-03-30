import lib.*;

public class Start{
  public static void main(String[] args){
    /*
    Polynomial p1 = new Polynomial();
    Polynomial p2 = new Polynomial('y');
    Polynomial p3 = new Polynomial(1.2, 2.3, 'z');
    Polynomial p4 = new Polynomial(1, 2.5);
    Polynomial p5 = new Polynomial(1.2, 1);
    System.out.println("P1: " + p1);
    System.out.println("P2: " + p2);
    System.out.println("P3: " + p3);
    System.out.println("P4: " + p4);
    System.out.println("P5: " + p5);

    int number = 232323983;
    System.out.println("Original Number: " + number);
    int i = 1;
    while(number > 10){
      int value = number % 10;
      number = (number - value ) / 10;
      System.out.println("Digit #" + i + ": " + value);
      i++;
    }
    */
    BigNumber n0 = new BigNumber("0");
    BigNumber n1 = new BigNumber("11212.212");
    BigNumber n2 = new BigNumber("+11212.22382387238723872312");
    BigNumber n3 = new BigNumber("-112238892382928392382938293829382398239239283923892382938293829382323832283728372827382212.212");
    BigNumber n4 = new BigNumber("+11212");
    BigNumber n5 = new BigNumber("-11212");
    BigNumber n6 = new BigNumber("-0.23");
    BigNumber n7 = new BigNumber("-.23");
    System.out.println(n0);
    System.out.println(n1);
    System.out.println(n2);
    System.out.println(n3);
    System.out.println(n4);
    System.out.println(n5);
    System.out.println(n6);
    System.out.println(n7);
    //System.out.println(n8);

    System.out.println(Math.pow(121333232, 323233223));

    //BigNumber output = BigNumber.addition(null, null);
  }
}
