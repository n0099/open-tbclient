package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] nIP;
    String[] nIQ;
    Class[] nIR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.nIP = clsArr;
        this.nIQ = strArr;
        this.nIR = clsArr2;
    }

    public Class[] dLG() {
        if (this.nIP == null) {
            this.nIP = NQ(3);
        }
        return this.nIP;
    }

    public Class[] dLH() {
        if (this.nIR == null) {
            this.nIR = NQ(5);
        }
        return this.nIR;
    }
}
