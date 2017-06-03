package parser.structures;

/**
 * Created by buzhinsky on 3/10/17.
 */
public class Id implements Argument {
    public final String name;

    public Id(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
