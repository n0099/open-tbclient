package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] pQF;
    Class[] pQG;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.pQF = strArr;
        this.pQG = clsArr2;
    }

    public Class[] eAE() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Rm(3);
        }
        return this.parameterTypes;
    }

    public Class[] eAF() {
        if (this.pQG == null) {
            this.pQG = Rm(5);
        }
        return this.pQG;
    }
}
