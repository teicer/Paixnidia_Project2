import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MathOperation extends Actor {
    private int id;
    private String type1;
    private int value1;
    private String type2;
    private int value2;
    private int result;
    private String operator;
    private String question;
    private boolean answeredCorrectly;
    private String op1;
    private String op2;
    private int val1;
    private int val2;
    private Color backgroundColor = new Color(196,196,196);
    public MathOperation(int id, String type1, int value1, String type2, int value2, String operator,String question) {
        this.id = id;
        this.type1 = type1;
        this.value1 = value1;
        this.type2 = type2;
        this.value2 = value2;
        this.operator = operator;
        this.question = question;
        this.result = calculateResult();
        updateImage();
        this.answeredCorrectly = false;
    }
   public MathOperation(int id, String type1, int value1, int val1, String op1, String type2, int value2, int val2, String op2, String operator, String question) {
        this.id = id;
        this.type1 = type1;
        this.value1 = value1;
        this.op1 = op1;
        this.val1 = val1;
        this.type2 = type2;
        this.value2 = value2;
        this.op2 = op2;
        this.val2 = val2;
        this.operator = operator;
        this.question = question; 
        int resOp1 = calculateResultOp1();
        int resOp2 = calculateResultOp2();
       // System.out.println("VALUE2: " + value2 + " / VAL2: " + val2 + " = " + resOp2);
        updateImage2(resOp1, resOp2);
    }
    public int getId() {
        return id;
    }
    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }
    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }
    private int calculateResult() {
        switch (operator) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                if (value2 != 0) {
                    return value1 / value2;
                } else {
                    return 0; // Avoid division by zero
                }
            default:
                return 0;
        }
    }
    
   private int calculateResultOp1() {
    switch (op1) {
        case "+":
            return val1 + value1;
        case "-":
            return value1- val1;
        case "*":
            return value1 * val1;
        case "/":
            if (value1 != 0) {
                return val1 / value1;
            } else {
                return 0; 
            }
        default:
            return 0;
    }
}

private int calculateResultOp2() {
    switch (op2) {
        case "+":
            return val2 + value2;
        case "-":
            return value2 - val2;
        case "*":
            return value2 * val2;
        case "/":
            if (val2 != 0) {
                return value2 / val2;
            } else {
                return 0;
            }
        default:
            return 0;
    }
}
    
    private void updateImage() {
        GreenfootImage background = new GreenfootImage(400, 800);
        background.setColor(backgroundColor);
        background.fill();

        GreenfootImage textImage1 = new GreenfootImage("Pick the Correct Images", 24, Color.BLACK, new Color(0, 0, 0, 0));
        background.drawImage(textImage1,70,350);

        
        GreenfootImage textImage2 = new GreenfootImage(question, 18, Color.BLACK, new Color(0, 0, 0, 0));
        background.drawImage(textImage2,70, 400);

        int xOffset = 160;
        int yOffset = 390;
        int counter = 0;

        // Προσθήκη των εικόνων του αποτελέσματος
        GreenfootImage resultImage = new GreenfootImage("images/" + type1 + ".png");
        resultImage.scale(50, 50);
        for (int i = 0; i < result; i++) {
            background.drawImage(resultImage, xOffset + (counter % 4) * 50, yOffset + (counter / 4) * 50);
            counter++;
        }

        setImage(background);
    }
    
  private void updateImage2(int res1, int res2) {
        GreenfootImage background = new GreenfootImage(400, 800);
        background.setColor(backgroundColor);
        background.fill();
        
        GreenfootImage textImage1 = new GreenfootImage("Pick the Correct Images", 24, Color.BLACK, new Color(0, 0, 0, 0));
        background.drawImage(textImage1, 70, 350);
    
        GreenfootImage textImage2 = new GreenfootImage(question, 18, Color.BLACK, new Color(0, 0, 0, 0));
        background.drawImage(textImage2, 70, 400);
        
        int xOffset1 = 165;
        int yOffset1 = 390;
        int counter1 = 0;
        
        GreenfootImage resultImage1 = new GreenfootImage("images/" + type1 + ".png");
        resultImage1.scale(40, 40);
        for (int i = 0; i < res1; i++) {
            background.drawImage(resultImage1, xOffset1 + (counter1 % 4) * 50, yOffset1 + (counter1 / 4) * 50);
            counter1++;
        }
    
        int rowsResultImage1 = (counter1 + 3) / 4; 
        int yOffset2 = yOffset1 + rowsResultImage1 * 50 + 5;  
        int counter2 = 0;
    
        GreenfootImage resultImage2 = new GreenfootImage("images/" + type2 + ".png");
        resultImage2.scale(40, 40);
        for (int i = 0; i < res2; i++) {
            background.drawImage(resultImage2, xOffset1 + (counter2 % 4) * 50, yOffset2 + (counter2 / 4) * 50);
            counter2++;
        }
    
        setImage(background);
    }

}
