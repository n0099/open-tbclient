package javassist.compiler.ast;
/* loaded from: classes.dex */
public class BinExpr extends Expr {
    private BinExpr(int i, ASTree aSTree, ASTList aSTList) {
        super(i, aSTree, aSTList);
    }

    public static BinExpr makeBin(int i, ASTree aSTree, ASTree aSTree2) {
        return new BinExpr(i, aSTree, new ASTList(aSTree2));
    }

    @Override // javassist.compiler.ast.Expr, javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
