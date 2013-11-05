package javassist.compiler.ast;
/* loaded from: classes.dex */
public class Variable extends Symbol {
    protected Declarator declarator;

    public Variable(String str, Declarator declarator) {
        super(str);
        this.declarator = declarator;
    }

    public Declarator getDeclarator() {
        return this.declarator;
    }

    @Override // javassist.compiler.ast.Symbol, javassist.compiler.ast.ASTree
    public String toString() {
        return this.identifier + ":" + this.declarator.getType();
    }

    @Override // javassist.compiler.ast.Symbol, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }
}
