package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] iCi;
    String[] iCj;
    Class[] iCk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.iCi = clsArr;
        this.iCj = strArr;
        this.iCk = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.iCi == null) {
            this.iCi = zv(3);
        }
        return this.iCi;
    }

    public Class[] getExceptionTypes() {
        if (this.iCk == null) {
            this.iCk = zv(5);
        }
        return this.iCk;
    }
}
