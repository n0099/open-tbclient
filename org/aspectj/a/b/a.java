package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] jSE;
    String[] jSF;
    Class[] jSG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.jSE = clsArr;
        this.jSF = strArr;
        this.jSG = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.jSE == null) {
            this.jSE = Da(3);
        }
        return this.jSE;
    }

    public Class[] getExceptionTypes() {
        if (this.jSG == null) {
            this.jSG = Da(5);
        }
        return this.jSG;
    }
}
