package org.aspectj.a.b;
/* loaded from: classes3.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] qko;
    Class[] qkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.qko = strArr;
        this.qkp = clsArr2;
    }

    public Class[] eJq() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Sf(3);
        }
        return this.parameterTypes;
    }

    public Class[] eJr() {
        if (this.qkp == null) {
            this.qkp = Sf(5);
        }
        return this.qkp;
    }
}
