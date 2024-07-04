import greenfoot.*; 
import java.util.ArrayList;

public class Card extends Actor {
    private int id;
    private String type;
    private int value;
    private boolean opened;
    private boolean selected;
    private CardImage cardImage;

    private static ArrayList<Card> cards = new ArrayList<>();

    public Card(int id, String type, int value) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.opened = false;
        this.selected = false;
        this.cardImage = new CardImage(id, type, value);
        updateImage();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
        updateImage();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        updateImage();
    }

     private void updateImage() {
        if (opened) {
            String fileName = cardImage.getImageFileName();
            GreenfootImage img = new GreenfootImage("images/" + fileName);
            img.scale(200, 160);  
            setImage(img);
        } else {
            GreenfootImage img = new GreenfootImage("card_back.png");
            img.scale(200, 160);  
            setImage(img);
        }
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            handleClick();
        }
    }

    private void handleClick() {
        if (!opened) {
            setOpened(true);
            setSelected(true);
            //openedCards.add(this);
            MemoryWorld world = (MemoryWorld) getWorld();
            world.updateSelectedCards(this);
         
        }
    }

}

