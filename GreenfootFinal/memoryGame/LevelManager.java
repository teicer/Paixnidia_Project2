import greenfoot.*;
import java.util.ArrayList;
import java.util.Collections;

public class LevelManager {
    private MemoryWorld world;
    private Player player;
    private int bestTries;
    private Card[][] board;
    public LevelManager(MemoryWorld world, Player player) {
        this.world = world;
        this.player = player;
    }
    
    public void setupLevel(int level) {
        switch(level) {
            case 1:
                setupLevel1();
                break;
            case 2:
               setupLevel2();
                break;
             case 3:
               setupLevel3();
                break;
            case 4:
                setupLevel4();
                break;
            case 5:
                setupLevel5();
                break;
            case 6:
                setupLevel6();
                break;
            default:
                setupLevel1();
        }
    }
    
    public Card[][] getBoard() {
        return board;
    }

    public int getBestTries(){
            return bestTries;
    }
    
    public void setBestTries(int bestTries){
        this.bestTries = bestTries;
    }
    
        private void setupLevel1() {
        
        board = new Card[2][2];
        board[0][0] = new Card(1, "cow", 2);
        board[0][1] = new Card(2, "frog", 2);
        board[1][0] = new Card(1, "cow", 3);
        board[1][1] = new Card(2, "frog", 5);
        
         MathOperation[] mathQuestions = new MathOperation[] {
            new MathOperation(1, "cow", 2, "cow", 3, "+","? + ? ="),
            new MathOperation(2, "frog", 2, "frog", 5, "+","? + ? ="),
            // Προσθήκη περισσότερων ερωτήσεων εδώ
        };
        //format 3x3 και 4χ4
        ArrayList<Card> cards = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                cards.add(board[row][col]);
            }
        }
        Collections.shuffle(cards);
        int index = 0;
        int cardWidth = 205;
        int cardHeight = 155;
         int startX = 800;
        int startY = 200;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = cards.get(index);
                world.addObject(board[row][col], startX + col * cardWidth, startY + row * cardHeight);
                index++;
            }
        }

        // Δημιουργία μαθηματικών ερωτήσεων
      
        world.setMathQuestions(mathQuestions);
        world.showQuestion();
        
        int bestTries = 2;
        setBestTries(2);
    
        }

        private void setupLevel2() {
        
      
        board = new Card[2][2];
        board[0][0] = new Card(1, "lion", 2);
        board[0][1] = new Card(1, "lion", 3);
        board[1][0] = new Card(2, "elephant", 2);
        board[1][1] = new Card(2, "elephant", 4);
        
         MathOperation[] mathQuestions = new MathOperation[] {
            new MathOperation(1, "lion", 2, "lion", 3, "*","? + ? ="),
            new MathOperation(2, "elephant", 4, "elephant", 2, "/","? + ? ="),
            // Προσθήκη περισσότερων ερωτήσεων εδώ
        };
        
        ArrayList<Card> cards = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                cards.add(board[row][col]);
            }
        }
        Collections.shuffle(cards);
        int index = 0;
        int cardWidth = 205;
        int cardHeight = 155;
         int startX = 800;
        int startY = 200;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = cards.get(index);
                world.addObject(board[row][col], startX + col * cardWidth, startY + row * cardHeight);
                index++;
            }
        }

        // Δημιουργία μαθηματικών ερωτήσεων
      
        world.setMathQuestions(mathQuestions);
        world.showQuestion();
        
        int bestTries = 2;
        setBestTries(2);
    
        }
         private void setupLevel3() {
        
        
        board = new Card[2][4];
        board[0][0] = new Card(1, "bird", 4);
        board[0][1] = new Card(1, "bird", 1);
        board[0][2] = new Card(2, "kangaroo", 3);
        board[0][3] = new Card(2, "kangaroo", 4);
        board[1][0] = new Card(3, "elephant", 4);
        board[1][1] = new Card(3, "lion", 2);
        board[1][2] = new Card(4, "frog", 2);
        board[1][3] = new Card(4, "frog", 4);
        
         MathOperation[] mathQuestions = new MathOperation[] {
            new MathOperation(1, "bird", 4, "bird", 1, "-","? - ? ="),
            new MathOperation(2, "kangaroo", 3, "kangaroo", 4, "*","? * ? ="),
           
            new MathOperation(3, "elephant",4,1,"-","lion",2,2,"*","+","?-1 + ?*2 ="),
            new MathOperation(4, "frog", 2, "frog", 4, "+","? + ? ="),
        };
        
       
        //format 3x3 και 4χ4
        ArrayList<Card> cards = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                cards.add(board[row][col]);
            }
        }
        Collections.shuffle(cards);
        int index = 0;
        int cardWidth = 205;
        int cardHeight = 155;
        int startX = (world.getWidth() - (board[0].length * cardWidth)) + cardWidth / 2 -10;
        int startY = (world.getHeight() - (board.length * cardHeight)) - 180;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = cards.get(index);
                world.addObject(board[row][col], startX + col * cardWidth, startY + row * cardHeight);
                index++;
            }
        }

        // Δημιουργία μαθηματικών ερωτήσεων
      
        world.setMathQuestions(mathQuestions);
        world.showQuestion();
         int bestTries = 2;
        setBestTries(2);
    }
     private void setupLevel4() {
        
        
        board = new Card[3][4];
        board[0][0] = new Card(1, "cow", 5);
        board[0][1] = new Card(1, "cow", 1);
        board[0][2] = new Card(2, "frog", 4);
        board[0][3] = new Card(2, "frog", 2);
        board[1][0] = new Card(3, "lion", 4);
        board[1][1] = new Card(3, "lion", 4);
        board[1][2] = new Card(4, "lion", 2);
        board[1][3] = new Card(4, "bird", 3);
        board[2][0] = new Card(5, "elephant", 1);
        board[2][1] = new Card(5, "elephant", 2);
        board[2][2] = new Card(6, "kangaroo", 2);
        board[2][3] = new Card(6, "bird", 1);

        
        MathOperation[] mathQuestions = new MathOperation[] {
        new MathOperation(1, "cow", 5, "cow", 1, "+","? + ? ="),
        new MathOperation(2, "frog", 4, "frog", 2, "-","? - ? ="),
        new MathOperation(3, "lion", 4, "lion", 4, "+","? + ? ="),
        new MathOperation(4, "lion",2,2,"*","bird",3,1,"/","+","2*? + ?/1 ="),
        new MathOperation(5, "elephant", 1, "elephant", 2, "+","? + ? ="),
        new MathOperation(6, "kangaroo",2,2,"*","bird",1,1,"/","+","2*? + ?/1 ="),
        };
        //format 3x3 και 4χ4
        ArrayList<Card> cards = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                cards.add(board[row][col]);
            }
        }
        Collections.shuffle(cards);
        int index = 0;
        int cardWidth = 205;
        int cardHeight = 155;
        int startX = (world.getWidth() - (board[0].length * cardWidth)) + cardWidth / 2 -10;
        int startY = (world.getHeight() - (board.length * cardHeight)) - 120;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = cards.get(index);
                world.addObject(board[row][col], startX + col * cardWidth, startY + row * cardHeight);
                index++;
            }
        }
      
        world.setMathQuestions(mathQuestions);
        world.showQuestion();
         int bestTries = 2;
        setBestTries(2);
    }
     private void setupLevel5() {
        
        
        board = new Card[4][4];
        board[0][0] = new Card(1, "elephant", 2);
        board[0][1] = new Card(1, "elephant", 3);
        board[0][2] = new Card(2, "cow", 3);
        board[0][3] = new Card(2, "cow", 5);
        //
        board[1][0] = new Card(3, "kangaroo", 1);
        board[1][1] = new Card(3, "kangaroo", 5);
        board[1][2] = new Card(4, "bird", 2);
        board[1][3] = new Card(4, "bird", 4);
        //
        board[2][0] = new Card(7, "lion", 2);
        board[2][1] = new Card(7, "lion", 2);
        board[2][2] = new Card(8, "frog", 1);
        board[2][3] = new Card(8, "frog", 4);
        //
        board[3][0] = new Card(5, "lion", 3);
        board[3][1] = new Card(5, "cow", 4);
        board[3][2] = new Card(6, "bird", 1);
        board[3][3] = new Card(6, "elephant", 4);
        
        MathOperation[] mathQuestions = new MathOperation[] {
           new MathOperation(1, "elephant", 2, "elephant", 3, "+", "? + ? = "),
           new MathOperation(2, "cow", 5, "cow", 3, "-", "? - ? = "),
           new MathOperation(3, "kangaroo", 5, "kangaroo", 1, "*", "? * ? = "),
           new MathOperation(4, "bird", 4, "bird", 2, "-", "? - ? = "),
           new MathOperation(5, "lion",3,3,"*","cow",4,2,"/","+","3*? + ?/2 ="),
           new MathOperation(6, "bird",1,3,"*","elephant",4,2,"-","+","3*? + ?-2 ="),
           new MathOperation(7, "lion", 2, "lion", 2, "*", "? * ? = "),
           new MathOperation(8, "frog", 4, "frog", 1, "+", "? + ? = "),
        };
        //format 3x3 και 4χ4
        ArrayList<Card> cards = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                cards.add(board[row][col]);
            }
        }
        Collections.shuffle(cards);
        int index = 0;
        int cardWidth = 205;
        int cardHeight = 155;
        int startX = (world.getWidth() - (board[0].length * cardWidth)) + cardWidth / 2;
        int startY = (world.getHeight() - (board.length * cardHeight)) + cardHeight / 4;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = cards.get(index);
                world.addObject(board[row][col], startX + col * cardWidth, startY + row * cardHeight);
                index++;
            }
        }

       
       
        world.setMathQuestions(mathQuestions);
        world.showQuestion();
         int bestTries = 2;
        setBestTries(2);
    }
     private void setupLevel6() {
        
        
        board = new Card[4][4];
        board[0][0] = new Card(1, "kangaroo",2 );
        board[0][1] = new Card(1, "bird", 5);
        board[0][2] = new Card(2, "lion", 3);
        board[0][3] = new Card(2, "frog", 5);
        //
        board[1][0] = new Card(3, "cow", 4);
        board[1][1] = new Card(3, "elephant", 5);
        board[1][2] = new Card(4, "bird",2 );
        board[1][3] = new Card(4, "lion", 4);
        //
        board[2][0] = new Card(5, "kangaroo", 3);
        board[2][1] = new Card(5, "cow",3 );
        board[2][2] = new Card(6, "elephant",4 );
        board[2][3] = new Card(6, "elephant",3 );
        //
        board[3][0] = new Card(7, "kangaroo",4 );
        board[3][1] = new Card(7, "kangaroo", 2);
        board[3][2] = new Card(8, "lion", 1);
        board[3][3] = new Card(8, "lion", 1);
        
        MathOperation[] mathQuestions = new MathOperation[] {
           new MathOperation(1, "kangaroo",2,2,"+","bird",5,1,"/","+","2+? + ?/1 ="),
           new MathOperation(2, "lion",3,3,"/","frog",5,3,"*","+","?/3 + ?*3 ="),
           new MathOperation(3, "cow",4,2,"-","elephant",5,2,"*","+","4-2 + ?*2 ="),
           new MathOperation(4, "bird",2,2,"/","lion",4,2,"/","+","?/2 + ?/2 ="),
           new MathOperation(5, "kangaroo",3,6,"*","cow",3,4,"*","+","?*6 + ?*4 ="),
           new MathOperation(6, "elephant",4,3,"*","cow",3,3,"-","+","?*4 + 3-? ="),
           new MathOperation(7, "kangaroo", 4, "kangaroo", 2, "+", "? + ? = "),
           new MathOperation(8, "lion", 1, "lion", 1, "+", "? + ? = "),
        };
        //format 3x3 και 4χ4
        ArrayList<Card> cards = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                cards.add(board[row][col]);
            }
        }
        Collections.shuffle(cards);
        int index = 0;
        int cardWidth = 205;
        int cardHeight = 155;
        int startX = (world.getWidth() - (board[0].length * cardWidth)) + cardWidth / 2;
        int startY = (world.getHeight() - (board.length * cardHeight)) + cardHeight / 4;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = cards.get(index);
                world.addObject(board[row][col], startX + col * cardWidth, startY + row * cardHeight);
                index++;
            }
        }

       
       
        world.setMathQuestions(mathQuestions);
        world.showQuestion();
         int bestTries = 2;
        setBestTries(2);
    }
}
