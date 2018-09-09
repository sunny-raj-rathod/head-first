/*
An example for Factory Pattern, Factory method pattern and Abstract Factory pattern
*/

public abstract class Pizza{
  string name;
  Dough dough;
  Sauce sauce;
  ArrayList toppings;

  //with default implementations
  void prepare(){};
  void bake(){};
  void cut(){};
  void box(){};
}

/*
We want to create a simple PizzaOrder class which can prepare any type of Pizza and return the Pizza object
*/
public class PizzaStore{
  Pizza orderPizza(string type){
    Pizza pizza;
    if (type == 'cheese')
      pizza = new CheesePizza();
    else if (type == 'pepperoni')
      pizza = new PepperoniPizza();
    else if (type == 'veggie')
        pizza = new VeggiePizza();

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }
}


/*
 Above implementation is not closed for modification. Hence we need to abstract out details that vary.
 This can be done by delegating pizza creation to another class which is a factory for product(pizza) creation
 And this is what is a simple Factory pattern
*/

public class SimplePizzaFactory{
  public Pizza createPizza(string type){
    if (type == 'cheese')
      pizza = new CheesePizza();
    else if (type == 'pepperoni')
      pizza = new PepperoniPizza();
    else if (type == 'veggie')
        pizza = new VeggiePizza();

    return pizza;
  }
}

public class PizzaStore{
  SimplePizzaFactory pizzaFactory;
  PizzaStore(SimplePizzaFactory pizzaFactory){
    this.pizzaFactory = pizzaFactory;
  }

  Pizza orderPizza(string type){
    Pizza pizza = pizzaFactory.createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }
}

/*
Lets say we want to create franchise for the PizzaStore in different regions, but different regions would like to create their own Pizzas.
Hence looking at the above solution, most easy way to do this is to have multiple PizzaFactory, one for each region.
So that client can use the classes like the example below:
*/
NyPizzaFactory nyPizzaFactory = new NyPizzaFactory();
PizzaStore pizzaStore = new PizzaStore(nyPizzaFactory);
pizzaStore.orderPizza("veggie");

ChicagoPizzaFactory chicagoPizzaFactory = new ChicagoPizzaFactory();
PizzaStore pizzaStore = new PizzaStore(chicagoPizzaFactory);
pizzaStore.orderPizza("veggie");

/*
What we can also do, it tie the pizza creation and store together and yet allow things to remain flexible.
We can have a base class PizzaStore and let the subclasses decide how to create pizza.
This is factory method pattern.
This way we are localizing all the pizza making activities in PizzaStore but yet give franchises freedom for their style.
*/
public abstract class PizzaStore{
  abstract public Pizza createPizza(string type);

  Pizza orderPizza(string type){
    Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }
}

public class NyPizzaStore extends PizzaStore{
  public Pizza createPizza(string type){
    Pizza pizza;
    if (type == 'cheese')
      pizza = new NyCheesePizza();
    else if (type == 'pepperoni')
      pizza = new NyPepperoniPizza();
    else if (type == 'veggie')
        pizza = new NyVeggiePizza();
    return pizza;
  }
}

public class ChicagoPizzaStore extends PizzaStore{
  public Pizza createPizza(string type){
    Pizza pizza;
    if (type == 'cheese')
      pizza = new ChicagoCheesePizza();
    else if (type == 'pepperoni')
      pizza = new ChicagoPepperoniPizza();
    else if (type == 'veggie')
        pizza = new ChicagoVeggiePizza();
    return pizza;
  }
}

/*
Assume that each Region want to prepare pizza in their own way using ingredients of their choice.
We will have to create a Factory for ingredients as well, but we want to let the different specific regions to decide how they want to prepare ingredients.
Hence we can create an Abstract Factory here, so that we decouple the code from actual factory that creates the product.
*/

public interface PizzaIngredientFactory(){
  Dough dough;
  Sauce sauce;
  void prepareDough();
  void prepareSauce();
}

public NyPizzaIngredientFactory implements PizzaIngredientFactory(){
  void prepareDough(){

  }
}

public ChicagoPizzaIngredientFactory implements PizzaIngredientFactory(){
  void prepareDough(){

  }
}

public abstract class Pizza{
  string name;
  Dough dough;
  Sauce sauce;
  ArrayList toppings;

  abstract void prepare();
  void bake(){};
  void cut(){};
  void box(){};
}

public class CheesePizza extends Pizza {
  PizzaIngredientFactory pizzaIngredientFactory;
  CheesePizza(PizzaIngredientFactory pizzaIngredientFactory){
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  void prepare(){
    dough = pizzaIngredientFactory.prepareDough();
    sauce = pizzaIngredientFactory.prepareSauce();
  }
}

public class NyPizzaStore extends PizzaStore{
  public Pizza createPizza(string type){
    Pizza pizza;
    PizzaIngredientFactory pizzaIngredientFactory = new NyPizzaIngredientFactory();
    if (type == 'cheese')
      pizza = new CheesePizza(pizzaIngredientFactory);
    else if (type == 'pepperoni')
      pizza = new NyPepperoniPizza(pizzaIngredientFactory);
    else if (type == 'veggie')
        pizza = new NyVeggiePizza(pizzaIngredientFactory);
    return pizza;
  }
}
