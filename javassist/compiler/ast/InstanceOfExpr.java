package javassist.compiler.ast;
/* loaded from: classes.dex */
public class InstanceOfExpr extends CastExpr {
    public InstanceOfExpr(ASTList aSTList, int i, ASTree aSTree) {
        super(aSTList, i, aSTree);
    }

    public InstanceOfExpr(int i, int i2, ASTree aSTree) {
        super(i, i2, aSTree);
    }

    @Override // javassist.compiler.ast.CastExpr, javassist.compiler.ast.ASTree
    public String getTag() {
        return "instanceof:" + this.castType + ":" + this.arrayDim;
    }

    @Override // javassist.compiler.ast.CastExpr, javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
