package javassist.compiler.ast;

import javassist.compiler.g;
/* loaded from: classes.dex */
public class CallExpr extends Expr {
    private g method;

    private CallExpr(ASTree aSTree, ASTList aSTList) {
        super(67, aSTree, aSTList);
        this.method = null;
    }

    public void setMethod(g gVar) {
        this.method = gVar;
    }

    public g getMethod() {
        return this.method;
    }

    public static CallExpr makeCall(ASTree aSTree, ASTree aSTree2) {
        return new CallExpr(aSTree, new ASTList(aSTree2));
    }

    @Override // javassist.compiler.ast.Expr, javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
