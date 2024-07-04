import greenfoot.*;
import java.util.Collections;
import java.util.ArrayList;

public class MemoryWorld extends World {
   private Card[][] board;
    private int level;
    private int score;
    private int tries;
    private MathOperation[] mathQuestions;
    private int currentQuestionIndex;
    private ArrayList<Card> selectedCards;
    private LevelManager levelManager;
    private Player player;
    private SoundManager soundManager;
    private boolean openedCards= true;
    private Button backButton;
    
    public MemoryWorld(int level, Player player) {
        super(1200, 800, 1);
        getBackground().setColor(Color.GRAY);
        getBackground().fill();
        this.level = level;
        this.score = 0;
        this.currentQuestionIndex = 0;
        this.selectedCards = new ArrayList<>();
        this.levelManager = new LevelManager(this, player);
        this.soundManager = new SoundManager();
        this.player = player;
        prepare();
    }

    public int getLevel() {
        return level;
    }

    public void updateSelectedCards(Card card) {
        if (card.isSelected()) {
            selectedCards.add(card);
        } else {
            selectedCards.remove(card);
        }
    }

    public void setMathQuestions(MathOperation[] mathQuestions) {
        this.mathQuestions = mathQuestions;
    }

    private void prepare() {
        tries = 0;
        player.setTries(0);
        levelManager.setupLevel(level);
        
        addObject(player, 150, 800);
        player.updateImage();    
       
        backButton = new Button("Back") {
           @Override
            protected void handleClick() {
                Greenfoot.setWorld(new SelectLevelScreen(player));
            }
        };
        addObject(backButton, getWidth() - 120, 50);
    }
    
        private void openCards(){
        
           for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != null) {
                        board[i][j].setOpened(true);
                    }
                }
            }
        }
        private void showAllCardsTemporarily() {
        board = levelManager.getBoard();
       
    
        int delayTime;
        if (level == 4) {
            delayTime = 40;
            openCards();
        } else if (level == 5 || level == 6) {
            delayTime = 70;
            openCards();
        } else {
            delayTime = 0;
        }
        Greenfoot.delay(delayTime);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    board[i][j].setOpened(false);
                }
            }
        }
    }

    public void showQuestion() {
        if (currentQuestionIndex < mathQuestions.length) {
            MathOperation currentQuestion = mathQuestions[currentQuestionIndex];
            addObject(currentQuestion, 150, 100);
        }
    }

    private void nextQuestion() {
        removeObjects(getObjects(MathOperation.class));
        currentQuestionIndex++;
        showQuestion();
    }

    private void selectedCardCleaner() {
        for (int i = 0; i < selectedCards.size(); i++) {
            selectedCards.get(i).setSelected(false);
            selectedCards.get(i).setOpened(false);
        }
        selectedCards.clear();
    }

    private void triesUpdate() {
        tries = tries + 1;
        int playerTries = tries;
        player.setTries(playerTries);
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int getTries() {
        return tries;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void settingScore() {
        int bestTries = levelManager.getBestTries();
        int tries = player.getTries();

        if (tries == 0) {
            player.setScore(0);
        } else {
            int newScore = (bestTries * 100) / tries;
            int finalScore = (int) player.getScore() + newScore;
            player.setScore(finalScore);
        }
    }
      
    public void act() {
        
       
        if(openedCards){
            openedCards=false;
            showAllCardsTemporarily();
        
        }
        if (mathQuestions != null && currentQuestionIndex < mathQuestions.length) {
            MathOperation currentQuestion = mathQuestions[currentQuestionIndex];

             if (selectedCards.size() == 2) {
                Card card1 = selectedCards.get(0);
                Card card2 = selectedCards.get(1);
            
                    if (card1.getId() == card2.getId() && card1.getId() == currentQuestion.getId()) {
                        card1.setOpened(true);
                        card2.setOpened(true);
                        score++;
                        triesUpdate();
                        currentQuestion.setAnsweredCorrectly(true);
                        
                        Greenfoot.delay(30);
                       
                        selectedCards.clear();
                        nextQuestion();
                    } else {
                        Greenfoot.delay(30);
                        selectedCardCleaner();
                        triesUpdate();
                        
                        Greenfoot.delay(10);
                    }
                    selectedCardCleaner();
            }
                
                if (selectedCards.size() > 2) {
                    selectedCardCleaner();
                    triesUpdate();
                
            }

            if (selectedCards.size() > 2) {
                selectedCardCleaner();
                triesUpdate();
               GreenfootSound sound = new GreenfootSound("wrong.wav");
                 sound.play();
            }

            if (score == mathQuestions.length) {
                int playerTries = player.getTries();
                int levelScore = (int) (((double)score / playerTries) * 100);
               
                showText("You completed Level " + level, getWidth() / 2, getHeight() / 2);
                showText("You got " + levelScore +" points! in level "+level+"!",getWidth() / 2, getHeight() / 2+50);
                soundManager.congratulationsSound();
                Greenfoot.delay(200);
                settingScore();
                Greenfoot.setWorld(new SelectLevelScreen(player));

            }
        }
       
    }
}
