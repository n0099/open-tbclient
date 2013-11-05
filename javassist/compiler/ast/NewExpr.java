package javassist.compiler.ast;

import javassist.compiler.j;
/* loaded from: classes.dex */
public class NewExpr extends ASTList implements j {
    protected int arrayType;
    protected boolean newArray;

    public NewExpr(ASTList aSTList, ASTList aSTList2) {
        super(aSTList, new ASTList(aSTList2));
        this.newArray = false;
        this.arrayType = 307;
    }

    public NewExpr(int i, ASTList aSTList, ArrayInit arrayInit) {
        super(null, new ASTList(aSTList));
        this.newArray = true;
        this.arrayType = i;
        if (arrayInit != null) {
            append(this, arrayInit);
        }
    }

    public static NewExpr makeObjectArray(ASTList aSTList, ASTList aSTList2, ArrayInit arrayInit) {
        NewExpr newExpr = new NewExpr(aSTList, aSTList2);
        newExpr.newArray = true;
        if (arrayInit != null) {
            append(newExpr, arrayInit);
        }
        return newExpr;
    }

    public boolean isArray() {
        return this.newArray;
    }

    public int getArrayType() {
        return this.arrayType;
    }

    public ASTList getClassName() {
        return (ASTList) getLeft();
    }

    public ASTList getArguments() {
        return (ASTList) getRight().getLeft();
    }

    public ASTList getArraySize() {
        return getArguments();
    }

    public ArrayInit getInitializer() {
        ASTree right = getRight().getRight();
        if (right == null) {
            return null;
        }
        return (ArrayInit) right.getLeft();
    }

    @Override // javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.ast.ASTree
    public String getTag() {
        return this.newArray ? "new[]" : "new";
    }
}
