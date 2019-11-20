package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] kvP;
    String[] kvQ;
    Class[] kvR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.kvP = clsArr;
        this.kvQ = strArr;
        this.kvR = clsArr2;
    }

    public Class[] cNj() {
        if (this.kvP == null) {
            this.kvP = Do(3);
        }
        return this.kvP;
    }

    public Class[] cNk() {
        if (this.kvR == null) {
            this.kvR = Do(5);
        }
        return this.kvR;
    }
}
