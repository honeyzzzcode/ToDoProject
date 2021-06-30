public class Text extends Record {

    private String text;
public Text(){}
    public Text(int id, String text) {
        super();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        var str = super.toString();
        return String.format("%s Text: %s", str, text);
    }

    @Override
    public void askData() {
        text = InputUtils.askString("Put text:");
    }
    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || text.toLowerCase().contains(substr)

                ;
    }

}

