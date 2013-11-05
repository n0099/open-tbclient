package javassist.compiler;

import javassist.compiler.ast.ASTree;
/* loaded from: classes.dex */
public class NoFieldException extends CompileError {
    private ASTree expr;
    private String fieldName;

    public NoFieldException(String str, ASTree aSTree) {
        super("no such field: " + str);
        this.fieldName = str;
        this.expr = aSTree;
    }

    public String getField() {
        return this.fieldName;
    }

    public ASTree getExpr() {
        return this.expr;
    }
}
