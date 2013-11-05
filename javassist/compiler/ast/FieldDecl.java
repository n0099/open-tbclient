package javassist.compiler.ast;
/* loaded from: classes.dex */
public class FieldDecl extends ASTList {
    public FieldDecl(ASTree aSTree, ASTList aSTList) {
        super(aSTree, aSTList);
    }

    public ASTList getModifiers() {
        return (ASTList) getLeft();
    }

    public Declarator getDeclarator() {
        return (Declarator) tail().head();
    }

    public ASTree getInit() {
        return sublist(2).head();
    }

    @Override // javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
