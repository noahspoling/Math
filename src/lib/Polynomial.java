package lib;

public class Polynomial extends Term {

  //Private field values
  private double coefficent, exponent;
  private char variable;
  
  //Polynomial constructor with 3 overloaded constructors for multivarible support and default field values if not provided
  public Polynomial() {
    this.coefficent = 1;
    this.exponent = 1;
    this.variable = 'x';
  }
  public Polynomial(char variable){
    this.coefficent = 1;
    this.exponent = 1;
    this.variable = variable;
  }
  public Polynomial(double coefficent, double exponent){
    this.coefficent = coefficent;
    this.exponent = exponent;
    this.variable = 'x';
  }
  public Polynomial(double coefficent, double exponent, char variable){
    this.coefficent = coefficent;
    this.exponent = exponent;
    this.variable = variable;
  }

  //Public get set methods for fields with private access modifiers
  public double getCoefficent() {
      return coefficent;
  }
  public void setCoefficent(double coefficent) {
      this.coefficent = coefficent;
  }
  public double getExponent() {
      return exponent;
  }
  public void setExponent(double exponent) {
      this.exponent = exponent;
  }
  public char getVariable() {
      return variable;
  }
  public void setVariable(char variable) {
      this.variable = variable;
  }

  //
  public Polynomial derivative() {
    if(this.exponent == 1) {

    }
    return null;

  }

  //toString() method to change the print instances of the class
  public String toString() {
    String output;
    if(this.coefficent == 1 && this.exponent == 1) {
      output = "" + this.variable;
      return output;
    }
    else if(this.coefficent == 1 && this.exponent != 1){
      output = "" + this.variable + "^" + this.exponent;
      return output;
    }
    else if(this.coefficent != 1 && this.exponent == 1){
      output = "" + this.coefficent + this.variable;
      return output;
    }
    else {
      output = "" + this.coefficent + this.variable + "^" + this.exponent;
      return output;
    }
  }
}
