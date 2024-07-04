import greenfoot.*; 

public class SelectLevelScreen extends World {
    private Player player;
    private SoundManager soundManager;

    public SelectLevelScreen(Player player) {
        super(1200, 800, 1);
        this.player = player;
        this.soundManager = new SoundManager(); 
        getBackground().setColor(Color.GRAY);
        getBackground().fill();
        showText("Select a Level:", getWidth() / 2, 50);
        
        
        int imageWidth = 250;
        int imageHeight = 250;
        int spacingX = 50; 
        int spacingY = 50; 
        int startX = (getWidth() - (3 * imageWidth + 2 * spacingX)) / 2 + imageWidth / 2;
        int startY = 200;
        String animalName = player.getCharacter();
        soundManager.animalSound(animalName);
        
       
        for (int i = 1; i <= 6; i++) {
            LevelImage levelImage = new LevelImage(i, player);
            int x = startX + (i - 1) % 3 * (imageWidth + spacingX);
            int y = startY + (i - 1) / 3 * (imageHeight + spacingY);
            addObject(levelImage, x, y);
        }
    }
}