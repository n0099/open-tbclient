package org.aspectj.a.b;
/* loaded from: classes5.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    Class iCC;
    int line;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.iCC = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int ccY() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(ccY()).toString();
    }
}
