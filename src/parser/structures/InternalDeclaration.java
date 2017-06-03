package parser.structures;

import java.util.Collections;
import java.util.List;

/**
 * Created by buzhinsky on 3/10/17.
 */
public class InternalDeclaration {
    public final Id name;
    public final Id type;
    private final List<Argument> argList;

    public List<Argument> argList() {
        return Collections.unmodifiableList(argList);
    }

    public InternalDeclaration(Id name, Id type, List<Argument> argList) {
        this.name = name;
        this.type = type;
        this.argList = argList;
    }

    @Override
    public String toString() {
        return name + " : " + type + argList;
    }
}
