package org.aspectj.a.b;
/* loaded from: classes2.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    Class imO;
    int line;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.imO = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int bSh() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(bSh()).toString();
    }
}
