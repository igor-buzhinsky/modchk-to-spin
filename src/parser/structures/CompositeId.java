package parser.structures;

/**
 * Created by buzhinsky on 3/10/17.
 */
public class CompositeId implements Argument {
    public final Id moduleName;
    public final Id varName;

    public CompositeId(Id moduleName, Id varName) {
        this.moduleName = moduleName;
        this.varName = varName;
    }

    @Override
    public String toString() {
        return moduleName + "." + varName;
    }
}
