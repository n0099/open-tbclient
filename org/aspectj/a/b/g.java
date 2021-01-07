package org.aspectj.a.b;
/* loaded from: classes4.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class qpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.qpg = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int eNr() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(eNr()).toString();
    }
}
