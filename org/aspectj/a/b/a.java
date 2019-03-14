package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] jTm;
    String[] jTn;
    Class[] jTo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.jTm = clsArr;
        this.jTn = strArr;
        this.jTo = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.jTm == null) {
            this.jTm = Dk(3);
        }
        return this.jTm;
    }

    public Class[] getExceptionTypes() {
        if (this.jTo == null) {
            this.jTo = Dk(5);
        }
        return this.jTo;
    }
}
