package javassist.compiler;

import java.util.HashMap;
import javassist.compiler.ast.Declarator;
/* loaded from: classes.dex */
public final class SymbolTable extends HashMap {
    private SymbolTable parent;

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable symbolTable) {
        this.parent = symbolTable;
    }

    public SymbolTable getParent() {
        return this.parent;
    }

    public Declarator lookup(String str) {
        Declarator declarator = (Declarator) get(str);
        if (declarator == null && this.parent != null) {
            return this.parent.lookup(str);
        }
        return declarator;
    }

    public void append(String str, Declarator declarator) {
        put(str, declarator);
    }
}
