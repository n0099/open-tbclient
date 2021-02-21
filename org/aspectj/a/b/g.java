package org.aspectj.a.b;
/* loaded from: classes5.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class qvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.qvi = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int eLZ() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(eLZ()).toString();
    }
}
