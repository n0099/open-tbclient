package javassist.compiler.ast;
/* loaded from: classes.dex */
public class ASTList extends ASTree {
    private ASTree left;
    private ASTList right;

    public ASTList(ASTree aSTree, ASTList aSTList) {
        this.left = aSTree;
        this.right = aSTList;
    }

    public ASTList(ASTree aSTree) {
        this.left = aSTree;
        this.right = null;
    }

    public static ASTList make(ASTree aSTree, ASTree aSTree2, ASTree aSTree3) {
        return new ASTList(aSTree, new ASTList(aSTree2, new ASTList(aSTree3)));
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
        this.right = (ASTList) aSTree;
    }

    public ASTree head() {
        return this.left;
    }

    public void setHead(ASTree aSTree) {
        this.left = aSTree;
    }

    public ASTList tail() {
        return this.right;
    }

    public void setTail(ASTList aSTList) {
        this.right = aSTList;
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.b(this);
    }

    @Override // javassist.compiler.ast.ASTree
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(<");
        stringBuffer.append(getTag());
        stringBuffer.append('>');
        while (this != null) {
            stringBuffer.append(' ');
            ASTree aSTree = this.left;
            stringBuffer.append(aSTree == null ? "<null>" : aSTree.toString());
            this = this.right;
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public int length() {
        return length(this);
    }

    public static int length(ASTList aSTList) {
        int i = 0;
        if (aSTList != null) {
            while (aSTList != null) {
                aSTList = aSTList.right;
                i++;
            }
        }
        return i;
    }

    public ASTList sublist(int i) {
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                this = this.right;
                i = i2;
            } else {
                return this;
            }
        }
    }

    public boolean subst(ASTree aSTree, ASTree aSTree2) {
        while (this != null) {
            if (this.left != aSTree2) {
                this = this.right;
            } else {
                this.left = aSTree;
                return true;
            }
        }
        return false;
    }

    public static ASTList append(ASTList aSTList, ASTree aSTree) {
        return concat(aSTList, new ASTList(aSTree));
    }

    public static ASTList concat(ASTList aSTList, ASTList aSTList2) {
        if (aSTList != null) {
            ASTList aSTList3 = aSTList;
            while (aSTList3.right != null) {
                aSTList3 = aSTList3.right;
            }
            aSTList3.right = aSTList2;
            return aSTList;
        }
        return aSTList2;
    }
}
