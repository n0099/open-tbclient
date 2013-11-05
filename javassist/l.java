package javassist;
/* loaded from: classes.dex */
public abstract class l {
    l b = null;
    protected h c;

    protected abstract void a(StringBuffer stringBuffer);

    public abstract int b();

    public abstract String e();

    public abstract String i();

    /* JADX INFO: Access modifiers changed from: protected */
    public l(h hVar) {
        this.c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l j() {
        return this.b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getName());
        stringBuffer.append("@");
        stringBuffer.append(Integer.toHexString(hashCode()));
        stringBuffer.append("[");
        stringBuffer.append(v.h(b()));
        a(stringBuffer);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public h c() {
        return this.c;
    }
}
