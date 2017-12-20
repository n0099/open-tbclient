package org.aspectj.a.b;
/* loaded from: classes2.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    Class hNi;
    int line;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.hNi = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int bSR() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(bSR()).toString();
    }
}
