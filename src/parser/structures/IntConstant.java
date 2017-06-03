package parser.structures;

/**
 * Created by buzhinsky on 3/10/17.
 */
public class IntConstant extends Constant {
    public final int value;

    public IntConstant(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
