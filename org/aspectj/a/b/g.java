package org.aspectj.a.b;
/* loaded from: classes5.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class nJn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.nJn = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int dLT() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(dLT()).toString();
    }
}
