package org.aspectj.a.b;
/* loaded from: classes10.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class oAq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.oAq = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int eiY() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(eiY()).toString();
    }
}
