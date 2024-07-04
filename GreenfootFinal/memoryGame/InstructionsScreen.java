import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionsScreen extends World {
    public InstructionsScreen() {
        super(1200, 800, 1);
        GreenfootImage background = new GreenfootImage("instructions_background.png");
        background.setTransparency(255);
        setBackground(background);
        
        GreenfootImage title = new GreenfootImage("Game Instructions", 48, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(title, (getWidth() - title.getWidth()) / 2, 50);

        String instructions = "1. Select a character.\n" +
                              "2. Click the 'Explore' button to start.\n" +
                              "3. Follow the game prompts to complete the levels.\n" +
                              "4. Solve the mathmemorized problems. \n"+
                              "5. Pick up as many points as you can. \n"+
                              "6. Have Fun!";
        GreenfootImage instructionsImage = new GreenfootImage(instructions, 24, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(instructionsImage, (getWidth() - instructionsImage.getWidth()) / 2, 200);

        Button backButton = new Button("Back");
        addObject(backButton, getWidth() / 2, getHeight() - 100);
    }

    public void act() {
        if (Greenfoot.mouseClicked(getObjects(Button.class).get(0))) {
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
