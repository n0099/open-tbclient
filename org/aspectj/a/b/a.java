package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] kvY;
    String[] kvZ;
    Class[] kwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.kvY = clsArr;
        this.kvZ = strArr;
        this.kwa = clsArr2;
    }

    public Class[] cPe() {
        if (this.kvY == null) {
            this.kvY = ES(3);
        }
        return this.kvY;
    }

    public Class[] cPf() {
        if (this.kwa == null) {
            this.kwa = ES(5);
        }
        return this.kwa;
    }
}
