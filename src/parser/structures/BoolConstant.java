package parser.structures;

/**
 * Created by buzhinsky on 3/10/17.
 */
public class BoolConstant extends Constant {
    public final boolean value;

    public BoolConstant(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
