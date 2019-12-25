package org.aspectj.a.b;
/* loaded from: classes4.dex */
class g implements org.aspectj.lang.reflect.d {
    String fileName;
    int line;
    Class nai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i) {
        this.nai = cls;
        this.fileName = str;
        this.line = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int dFq() {
        return this.line;
    }

    public String toString() {
        return new StringBuffer().append(getFileName()).append(":").append(dFq()).toString();
    }
}
