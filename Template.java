/*
An example of Template method pattern
*/

public abstract class CaffeineBeverage{
  //concrete method specifying the algorithm and which cannot be overridden by subclass
  void prepareBeverage(){
    boilWater();
    brew();
    pourInCup();
    if(customerWantsCondiments()){
      addCondiments();
    }
    boilWater();
  }

  //concrete method
  public void boilWater(){
  }

  abstract void brew();

  public void pourInCup(){
    
  }

  abstract void addCondiments();

  //hook - an optional method, which subclass can specify only if required
  public boolean customerWantsCondiments(){
    return true;
  }
}

public class Coffee extends CaffeineBeverage{
  void brew(){

  }

  void addCondiments(){

  }

  public boolean addCondiments(){

  }
}

public class Tea extends CaffeineBeverage{
  void brew(){

  }

  void addCondiments(){

  }
}
