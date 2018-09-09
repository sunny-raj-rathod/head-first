/*
Example for Decorator pattern
*/

public abstract class Beverage{
  string description;
  void getDescription();
  abstract double getCost();
}

public class HouseBlend extends Beverage{
  HouseBlend(){

  }

  double getCost(){

  }
}

public class DarkRoast extends Beverage{
  DarkRoast(){

  }

  double getCost(){

  }
}

public class Expresso extends Beverage{
  Expresso(){

  }
  double getCost(){

  }
}

public abstract class CondimentDecorator extends Beverage{
  public abstract string getDescription();
}

public class Mocha extends CondimentDecorator{
  Beverage beverage;

  Mocha(Beverage beverage){
    this.beverage = beverage;
  }

  void getDescription(){

  }
  void getCost(){

  }
}

public class Soy extends CondimentDecorator{
  Beverage beverage;

  Soy(Beverage beverage){
    this.beverage = beverage;
  }
  void getDescription(){

  }
  void getCost(){

  }
}

public class Whip extends CondimentDecorator{
  Beverage beverage;

  Whip(Beverage beverage){
    this.beverage = beverage;
  }

  void getDescription(){

  }
  void getCost(){

  }
}

//client
Beverage newB = new DarkRoast();
newB = new Mocha(newB);
newB = new Soy(newB);
newB = new Whip(newB);
newB.getCost();
