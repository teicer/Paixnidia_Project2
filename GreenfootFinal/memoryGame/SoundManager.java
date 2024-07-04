import greenfoot.*;
import java.util.Random;

public class SoundManager {
    
    public void animalSound(String animal) {
        String fileName = animal.toLowerCase() + ".wav";
        GreenfootSound sound = new GreenfootSound(fileName);
        sound.play();
    }
    
    public void congratulationsSound(){
        Random rand = new Random();
        GreenfootSound sound = new GreenfootSound("congratulations"+rand.nextInt(1,2)+".wav");
        sound.play();
        Greenfoot.delay(10*60); 
        sound.stop();
    
    }
}