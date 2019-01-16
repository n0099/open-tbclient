package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] iDp;
    String[] iDq;
    Class[] iDr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.iDp = clsArr;
        this.iDq = strArr;
        this.iDr = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.iDp == null) {
            this.iDp = zx(3);
        }
        return this.iDp;
    }

    public Class[] getExceptionTypes() {
        if (this.iDr == null) {
            this.iDr = zx(5);
        }
        return this.iDr;
    }
}
