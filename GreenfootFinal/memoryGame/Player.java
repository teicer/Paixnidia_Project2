import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Player extends Actor {
    private String character;
    private int tries;
    private double score;
    private String slogan;
    private Color backgroundColor = new Color(196,196,196);
    private ArrayList<String> cowSlogan = new ArrayList<>(Arrays.asList(
        "Moo-ving towards victory!",
        "Grass is greener on the winning side!",
        "Udderly unbeatable!"
    ));

    private ArrayList<String> lionSlogan = new ArrayList<>(Arrays.asList(
        "Roar with Confidence!",
        "Unleash the King Within!",
        "Strength and Courage Define Us!"
    ));
    private ArrayList<String> frogSlogan = new ArrayList<>(Arrays.asList(
        "Leaping to greatness!",
        "Hop, skip, and a win!",
        "Ribbit your way to victory!"
    ));

    private ArrayList<String> elephantSlogan = new ArrayList<>(Arrays.asList(
        "Stomping out the competition!",
        "Never forget to win!",
        "Trunk full of triumph!"
    ));
    
    // Constructor
    public Player(int tries) {
        this.tries = tries;
    }
    
    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
        setSlogan(); 
        updateImage();  
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
        updateImage();  // Ενημέρωση της εικόνας όταν αλλάζουν οι προσπάθειες
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
        updateImage();  // Ενημέρωση της εικόνας όταν αλλάζει το σκορ
    }
    
    
    private void setSlogan() {
        Random rand = new Random();
        switch (character.toLowerCase()) {
            case "cow":
                slogan = cowSlogan.get(rand.nextInt(cowSlogan.size()));
                break;
            case "lion":
                slogan = lionSlogan.get(rand.nextInt(lionSlogan.size()));
                break;
            case "frog":
               slogan = frogSlogan.get(rand.nextInt(frogSlogan.size()));
                break;
            case "elephant":
                  slogan = elephantSlogan.get(rand.nextInt(elephantSlogan.size()));
                break;
            default:
                slogan = "";
                break;
        }
    }
    
    public void updateImage() {
        GreenfootImage image = new GreenfootImage(400, 600);
        image.setColor(backgroundColor);
        image.fill();
        GreenfootImage charImage = new GreenfootImage("images/" + character + ".png");
        charImage.scale(80,80);
        GreenfootImage textImage1 = new GreenfootImage("Your Character",24,Color.BLACK, new Color(0, 0, 0, 0));
        image.drawImage(textImage1,image.getWidth()/2 -75,20);
        image.drawImage(charImage, image.getWidth()/2 -25 , 50);
        GreenfootImage textImage2 = new GreenfootImage("Tries: " + tries,24,Color.BLACK, new Color(0, 0, 0, 0));
        image.drawImage(textImage2,image.getWidth()/2 -50,130);
        GreenfootImage textImage3 = new GreenfootImage("Score: " + score,24,Color.BLACK, new Color(0, 0, 0, 0));
        image.drawImage(textImage3,image.getWidth()/2 -50,160);
        GreenfootImage textImage4 = new GreenfootImage(character+" say:",24,Color.DARK_GRAY, new Color(0, 0, 0, 0));
        image.drawImage(textImage4,75,220);
         GreenfootImage textImage5 = new GreenfootImage(slogan,19,Color.DARK_GRAY, new Color(0, 0, 0, 0));
        image.drawImage(textImage5,75,250);
        setImage(image);
    }

    // Act method
    public void act() {
        // Add your action code here.
    }
}