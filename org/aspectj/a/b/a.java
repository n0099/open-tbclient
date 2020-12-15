package org.aspectj.a.b;
/* loaded from: classes16.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] pLE;
    Class[] pLF;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.pLE = strArr;
        this.pLF = clsArr2;
    }

    public Class[] eEu() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Sd(3);
        }
        return this.parameterTypes;
    }

    public Class[] eEv() {
        if (this.pLF == null) {
            this.pLF = Sd(5);
        }
        return this.pLF;
    }
}
