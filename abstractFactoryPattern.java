/*
    Just like a factory pattern!
            BUT!
    The parts required to create the enemy are also abstracted and
    decided on Run Time!!
*/

/* So we are doing a few things here

And we have different factories for different enemyTypes, their components
and finally choosing which factoryToCall,i.e, what type of enemyToCraete ona given Input
*/


// The TYPES of parts required for our EnemyShip
public interface EnemyShipWeapon{
    // will be implemented later while defining the enemyTypeClass
    public String toString();
}

public interface EnemyShipEngine{
    public String toString();
}
// Just two parts are enough

public abstract class EnemyShip {
    private String name;

    EnemyShipWeapon weapon;
    EnemyShipEngine engine;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // abstract methods are to defined when being extended by subclasses
    abstract void makeShip();

    public String toString(){
        return (this.name + " has top speed of " + this.engine + " and an attack power of " + this.weapon);
    }

    public void followHeroShip(){
        System.out.println(this.getName() + " is following Hero Ship with engine" + engine);
    }

    public void displayEnemyShip(){
        System.out.println(this.getName() + " is on the screen");

    }
    public void enemyShipShoots(){
        System.out.println(this.getName() + " hit the Hero by " + this.getDamage() + " using " + weapon);
    }

}

// Components which we'll use to build our enemies!
public class UFOLaser implements EnemyShipWeapon{
    public String toString(){
        return "66 damage";
    }
}

public class UFOArmstrongGun implements EnemyShipWeapon{
    public String toString(){
        return "500 damage";
    }
}

public class RocketMissile implements EnemyShipWeapon{
    public String toString(){
        return "85 damage";
    }
}

public class UFOEngine implements EnemyShipEngine{
    public String toString(){
        return "1000 Km/h";
    }
}

public class UFOHyperDriveEngine implements EnemyShipWeapon{
    public String toString(){
        return "99999999999999999999999 Km/h"
    }
}

public class RocketEngine implements EnemyShipEngine{
    public String toString(){
        return "255 Km/h"
    }
}

public class RocketSlowEngine implements EnemyShipEngine{
    public String toString(){
        return "10 Km/h";
    }
}
// thats all the components we need

// the things an Enemy Ship Factory MUST DO
public interface EnemyShipFactory {
    public EnemyShipWeapon addWeapon();
    public EnemyShipEngine addShipEngine();
}
// this are used to implement all the EnemyShipFactoryTypes


// Next we implement the different Types of EnemyCreatingFactories
public class UFOEnemyShipFactory implements EnemyShipFactory {

    public EnemyShipWeapon addWeapon(){
        return new UFOLaser();
    }
    public EnemyShipEngine addEngine(){
        return new UFOEngine();
    }
}

public class UFOBossEnemyShipFactory implements EnemyShipFactory{
    public EnemyShipWeapon addWeapon(){
        return new UFOArmstrongGun();
    }

    public EnemyShipEngine addEngine(){
        return new UFOHyperDriveEngine();
    }
}

public class PunyRocketFactory implements EnemyShipFactory{
    public EnemyShipWeapon addWeapon(){
        return new RocketMissile();
    }

    public EnemyShipEngine addEngine(){
        return new RocketSlowEngine();
    }
}

public class RocketFactory implements EnemyShipFactory{
    public EnemyShipWeapon addWeapon(){
        return new RocketMissile();
    }

    public EnemyShipEngine addEngine(){
        return new RocketEngine();
    }
}
// All the enemy Factories are created



public abstract class EnemyShipDesigner {
    //This will be implemented while defining the UFO and RocketShipDesigner
    protected abstract EnemyShip makeEnemyShip(String shipType);

    public EnemyShip designNewShip(String enemyShipType){
        EnemyShip enemy = makeEnemyShip(enemyShipType);

        enemy.makeShip();
        enemy.displayEnemyShip();
        enemy.followHeroShip();
        enemy.enemyShipShoots();

        return enemy;

    }
}

// Designer for our two classes of Enemy Ships
public class UFOEnemyShipDesigner extends EnemyShipDesigner {
    protected EnemyShip makeEnemyShip(String shipType){
        EnemyShip enemy = null;

        if(shipType.equals("UFO")){
            EnemyShipFactory shipComponentFactory = new UFOEnemyShipFacotry();
            enemy = new UFOEnemyShip(shipComponentFactory);
            enemy.setName("UFO grunt ship!");
        } else if (shipType.equals("UFO BOSS"){
            EnemyShipFactory shipComponentFactory = new UFOBossEnemyShipFactory();
            enemy = new UFOBossEnemyShip(shipComponentFactory);
            enemy.setName("UFO BOSS Enemy Ship");
        }
        return enemy;


    }

public class RocketEnemyShipDesigner extends EnemyShipDesigner {
    protected EnemyShip makeEnemyShip(String shipType){
        EnemyShip enemy = null;

        if(shipType.equals("Puny Rocket"){
            EnemyShipFactory shipComponentFactory = new PunyRocketFactory();
            enemy.setName("Puny Rocket Ship!");
        } else if(shipType.equals("Rocket") {
            EnemyShipFactory shipComponentFactory = new RocketFactory();
            enemy.setName("Rocket Ship!");
        }
        return enemy;

    }
}
// We can create another factory that chooses between these two
public static void main(){
    EnemyShipDesigner MakeUFOs = new UFOEnemyShipDesigner();
    EnemyShipDesigner MakeRockets = new RocketEnemyShipDesigner();

    EnemyShip theGrunt = MakeUFOs.makeEnemyShip("UFO");
    System.out.println(theGrunt + '\n');

    EnemyShip punyRocket = MakeRockets.makeEnemyShip("Puny Rocket");
    System.out.println(punyRocket + '\n');

    EnemyShip rocekt = MakeRockets.makeEnemyShip("Rocket");
    System.out.println(rocket + '\n');

    EnemyShip bossBaby = MakeUFOs.makeEnemyShip("UFO BOSS");
    System.out.println(bossBaby + '\n');
}

}
}
