import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CharacterImage extends Actor {
    private String characterName;
    private boolean selected;

    public CharacterImage(String characterName) {
        this.characterName = characterName;
        this.selected = false;
        updateImage();
    }

    public String getCharacterName() {
        return characterName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage("images/" + characterName + ".png");
        image.scale(220, 220);
        if (!selected) {
            image.setTransparency(100);
        } else {
            image.setTransparency(255);
        }
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            StartScreen world = (StartScreen) getWorld();
            world.selectCharacter(this);
        }
    }
}
