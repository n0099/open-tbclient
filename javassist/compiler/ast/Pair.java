package javassist.compiler.ast;
/* loaded from: classes.dex */
public class Pair extends ASTree {
    protected ASTree left;
    protected ASTree right;

    public Pair(ASTree aSTree, ASTree aSTree2) {
        this.left = aSTree;
        this.right = aSTree2;
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }

    @Override // javassist.compiler.ast.ASTree
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(<Pair> ");
        stringBuffer.append(this.left == null ? "<null>" : this.left.toString());
        stringBuffer.append(" . ");
        stringBuffer.append(this.right == null ? "<null>" : this.right.toString());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    @Override // javassist.compiler.ast.ASTree
    public ASTree getLeft() {
        return this.left;
    }

    @Override // javassist.compiler.ast.ASTree
    public ASTree getRight() {
        return this.right;
    }

    @Override // javassist.compiler.ast.ASTree
    public void setLeft(ASTree aSTree) {
        this.left = aSTree;
    }

    @Override // javassist.compiler.ast.ASTree
    public void setRight(ASTree aSTree) {
        this.right = aSTree;
    }
}
