package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hyK;
    String[] hyL;
    Class[] hyM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hyK = clsArr;
        this.hyL = strArr;
        this.hyM = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hyK == null) {
            this.hyK = xr(3);
        }
        return this.hyK;
    }

    public Class[] getExceptionTypes() {
        if (this.hyM == null) {
            this.hyM = xr(5);
        }
        return this.hyM;
    }
}
