package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] iqd;
    String[] iqe;
    Class[] iqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.iqd = clsArr;
        this.iqe = strArr;
        this.iqf = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.iqd == null) {
            this.iqd = ys(3);
        }
        return this.iqd;
    }

    public Class[] getExceptionTypes() {
        if (this.iqf == null) {
            this.iqf = ys(5);
        }
        return this.iqf;
    }
}
