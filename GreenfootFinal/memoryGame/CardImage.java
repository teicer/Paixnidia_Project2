public class CardImage {
    private int id;
    private String type;
    private int value;

    public CardImage(int id, String type, int value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public String getImageFileName() {
        return value + "_" + type + ".png";
    }
}