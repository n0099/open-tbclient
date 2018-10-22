package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] iqe;
    String[] iqf;
    Class[] iqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.iqe = clsArr;
        this.iqf = strArr;
        this.iqg = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.iqe == null) {
            this.iqe = ys(3);
        }
        return this.iqe;
    }

    public Class[] getExceptionTypes() {
        if (this.iqg == null) {
            this.iqg = ys(5);
        }
        return this.iqg;
    }
}
