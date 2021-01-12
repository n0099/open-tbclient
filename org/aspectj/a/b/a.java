package org.aspectj.a.b;
/* loaded from: classes3.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] qkn;
    Class[] qko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.qkn = strArr;
        this.qko = clsArr2;
    }

    public Class[] eJq() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Sf(3);
        }
        return this.parameterTypes;
    }

    public Class[] eJr() {
        if (this.qko == null) {
            this.qko = Sf(5);
        }
        return this.qko;
    }
}
