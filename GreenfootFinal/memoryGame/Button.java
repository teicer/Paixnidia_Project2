import greenfoot.*; 

public class Button extends Actor {
    public Button(String text) {
        GreenfootImage image = new GreenfootImage(200, 40);
        image.setColor(Color.LIGHT_GRAY);
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 199, 39);
        image.drawString(text, 75, 25);
        setImage(image);
    }
     public void act() {
        if (Greenfoot.mouseClicked(this)) {
            handleClick();
        }
    }

    protected void handleClick() {
        
    }

}
   