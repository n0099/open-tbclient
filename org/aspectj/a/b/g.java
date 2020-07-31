package org.aspectj.a.b;
/* loaded from: classes20.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class ogs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.ogs = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int dWU() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(dWU()).toString();
    }
}
