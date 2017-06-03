package parser.structures;

/**
 * Created by buzhinsky on 3/10/17.
 */
public class OutputDeclaration {
    public final Id outputName;
    public final CompositeId reference;

    public OutputDeclaration(Id outputName, CompositeId reference) {
        this.outputName = outputName;
        this.reference = reference;
    }

    @Override
    public String toString() {
        return outputName + " := " + reference;
    }
}
