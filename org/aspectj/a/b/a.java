package org.aspectj.a.b;
/* loaded from: classes4.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] mZP;
    String[] mZQ;
    Class[] mZR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.mZP = clsArr;
        this.mZQ = strArr;
        this.mZR = clsArr2;
    }

    public Class[] dFf() {
        if (this.mZP == null) {
            this.mZP = MW(3);
        }
        return this.mZP;
    }

    public Class[] dFg() {
        if (this.mZR == null) {
            this.mZR = MW(5);
        }
        return this.mZR;
    }
}
