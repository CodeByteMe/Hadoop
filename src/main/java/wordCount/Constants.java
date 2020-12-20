package wordCount;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 12:17
 */
public enum Constants {
    ADDRESS("ADDRESS"),
    USER("USER"),
    INPUT_FILE("INPUT_FILE"),
    OUTPUT_FILE("OUTPUT_FILE"),
    CONTEXT_CLASS("CONTEXT_CLASS");

    private String value;
    Constants(String value)
    {
        this.value=value;
    }
    public String getValue()
    {
        return this.value;
    }
}
