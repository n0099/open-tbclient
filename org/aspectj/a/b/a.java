package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] pZZ;
    Class[] parameterTypes;
    Class[] qaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.pZZ = strArr;
        this.qaa = clsArr2;
    }

    public Class[] eEt() {
        if (this.parameterTypes == null) {
            this.parameterTypes = RH(3);
        }
        return this.parameterTypes;
    }

    public Class[] eEu() {
        if (this.qaa == null) {
            this.qaa = RH(5);
        }
        return this.qaa;
    }
}
