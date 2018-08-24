// Abstract Enemy Blueprint
public abstract class EnemyShip {
    private String name;
    private double amtDamage;

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public double getDamage() { return this.amtDamage; }
    public void setDamage(double damageDone) { this.amtDamage = damageDone; }

    public void followHeroShip(){
        System.out.println(this.getName() + " is following Hero Ship");

    }

    public void displayEnemyShip(){
        System.out.println(this.getName() + " is on the screen");

    }
    public void enemyShipShoots(){
        System.out.println(this.getName() + " hit the Hero by " + this.getDamage());

    }
}

// Enemy Type 1 (UFO)
public class UFOEnemyShip extends EnemyShip {
    public UFOEnemyShip(){
        setName("UFO EnemyShip");
        setDamage(66);
    }

}

//Ememy Type 2 (Rocket)
public class rocketEnemyShip extends EnemyShip{
    public rocketEnemyShip(){
        setName("Rocket EnemyShip");
        setDamage(50);
    }
}

//Enemy Factory
public class EnemyShipFactory{
    public EnemyShip makeEnemyShip(String newShipType){
        EnemyShip newShip  = null;

        if(newShipType == "U"){
            return new UFOEnemyShip();
        }
        else if (newShipType == "R"){
            return new rocketEnemyShip()
        }
        else {
            return null;
        }
    }
}

// Our Playground
public class EnemyShipTesting {
  // What Enemy Must do after creation
    public static void doStuffEnemy(EnemyShip enemy){
        if (enemy != null){
        enemy.displayEnemyShip();
        enemy.followHeroShip();
        enemy.enemyShipShoots();
        }
    }
    // main function creating random Ships and doing stuff with them
    public static void main(){
        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip enemy = null;
        enemyShipChoices = ["U", "R"]
        int enemyShipTypePicker = new Random().nextInt(enemyShipChoices.length);
        enemy = shipFactory.makeEnemyShip(enemyShipChoices[enemyShipTypePicker]);
        doStuffEnemy(enemy);
    }

}
