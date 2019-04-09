package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] jSF;
    String[] jSG;
    Class[] jSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.jSF = clsArr;
        this.jSG = strArr;
        this.jSH = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.jSF == null) {
            this.jSF = Da(3);
        }
        return this.jSF;
    }

    public Class[] getExceptionTypes() {
        if (this.jSH == null) {
            this.jSH = Da(5);
        }
        return this.jSH;
    }
}
