package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hyT;
    String[] hyU;
    Class[] hyV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hyT = clsArr;
        this.hyU = strArr;
        this.hyV = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hyT == null) {
            this.hyT = wo(3);
        }
        return this.hyT;
    }

    public Class[] getExceptionTypes() {
        if (this.hyV == null) {
            this.hyV = wo(5);
        }
        return this.hyV;
    }
}
