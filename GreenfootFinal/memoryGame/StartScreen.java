import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScreen extends World {
    private Button submitButton;
    private Button instructionsButton;
    private Player player;
    private CharacterImage selectedCharacter;

    public StartScreen() {    
        super(1200, 800, 1);
        showText("Player Character:", getWidth() / 2, 50);
        getBackground().setColor(Color.GRAY);
        getBackground().fill();

        player = new Player(0);
        
        CharacterImage frog = new CharacterImage("frog");
        CharacterImage elephant = new CharacterImage("elephant");
        CharacterImage lion = new CharacterImage("lion");
        CharacterImage cow = new CharacterImage("cow");

        addObject(frog, 300, 200);
        addObject(elephant, 500, 200);
        addObject(lion, 700, 200);
        addObject(cow, 900, 200);

        submitButton = new Button("Explore");
        addObject(submitButton, getWidth() / 2, 600);
        
        instructionsButton = new Button("Instructions");
        addObject(instructionsButton, getWidth() - 120, getHeight() - 50);
    }

    public void act() {
        if (Greenfoot.mouseClicked(submitButton)) {
            if (selectedCharacter != null) {
                player.setCharacter(selectedCharacter.getCharacterName());
                Greenfoot.setWorld(new SelectLevelScreen(player));
            } else {
                showText("Please select a character before exploring!", getWidth() / 2, 700);
            }
        }
        
        if (Greenfoot.mouseClicked(instructionsButton)) {
            Greenfoot.setWorld(new InstructionsScreen());
        }
    }

    public void selectCharacter(CharacterImage characterImage) {
        if (selectedCharacter != null) {
            selectedCharacter.setSelected(false);
        }
        selectedCharacter = characterImage;
        selectedCharacter.setSelected(true);
    }
}
