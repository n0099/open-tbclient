package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] ksA;
    Class[] ksB;
    Class[] ksz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.ksz = clsArr;
        this.ksA = strArr;
        this.ksB = clsArr2;
    }

    public Class[] cNX() {
        if (this.ksz == null) {
            this.ksz = EM(3);
        }
        return this.ksz;
    }

    public Class[] cNY() {
        if (this.ksB == null) {
            this.ksB = EM(5);
        }
        return this.ksB;
    }
}
