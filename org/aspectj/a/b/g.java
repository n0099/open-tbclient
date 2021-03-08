package org.aspectj.a.b;
/* loaded from: classes3.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class qvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.qvK = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int eLH() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(eLH()).toString();
    }
}
