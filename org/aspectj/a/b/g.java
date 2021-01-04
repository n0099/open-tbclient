package org.aspectj.a.b;
/* loaded from: classes6.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class qny;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.qny = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int eMN() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(eMN()).toString();
    }
}
