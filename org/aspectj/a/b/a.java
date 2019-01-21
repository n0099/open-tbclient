package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] iDq;
    String[] iDr;
    Class[] iDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.iDq = clsArr;
        this.iDr = strArr;
        this.iDs = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.iDq == null) {
            this.iDq = zx(3);
        }
        return this.iDq;
    }

    public Class[] getExceptionTypes() {
        if (this.iDs == null) {
            this.iDs = zx(5);
        }
        return this.iDs;
    }
}
