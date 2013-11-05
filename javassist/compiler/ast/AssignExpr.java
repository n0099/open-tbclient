package javassist.compiler.ast;
/* loaded from: classes.dex */
public class AssignExpr extends Expr {
    private AssignExpr(int i, ASTree aSTree, ASTList aSTList) {
        super(i, aSTree, aSTList);
    }

    public static AssignExpr makeAssign(int i, ASTree aSTree, ASTree aSTree2) {
        return new AssignExpr(i, aSTree, new ASTList(aSTree2));
    }

    @Override // javassist.compiler.ast.Expr, javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
