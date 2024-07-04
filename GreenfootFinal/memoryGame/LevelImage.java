import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

class LevelImage extends Actor {
    private int level;
    private Player player;

    public LevelImage(int level, Player player) {
        this.level = level;
        this.player = player;
        GreenfootImage image = new GreenfootImage("images/" + level + "_level.png");
        image.scale(280, 250);
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MemoryWorld(level, player));
        }
    }
}
