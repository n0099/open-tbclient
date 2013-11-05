package javassist.compiler.ast;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class ASTree implements Serializable {
    public abstract void accept(a aVar);

    public ASTree getLeft() {
        return null;
    }

    public ASTree getRight() {
        return null;
    }

    public void setLeft(ASTree aSTree) {
    }

    public void setRight(ASTree aSTree) {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('<');
        stringBuffer.append(getTag());
        stringBuffer.append('>');
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTag() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }
}
