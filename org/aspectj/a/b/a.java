package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] nIU;
    String[] nIV;
    Class[] nIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.nIU = clsArr;
        this.nIV = strArr;
        this.nIW = clsArr2;
    }

    public Class[] dLI() {
        if (this.nIU == null) {
            this.nIU = NQ(3);
        }
        return this.nIU;
    }

    public Class[] dLJ() {
        if (this.nIW == null) {
            this.nIW = NQ(5);
        }
        return this.nIW;
    }
}
