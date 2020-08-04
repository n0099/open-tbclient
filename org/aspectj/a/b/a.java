package org.aspectj.a.b;
/* loaded from: classes20.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] ogd;
    Class[] oge;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.ogd = strArr;
        this.oge = clsArr2;
    }

    public Class[] dWK() {
        if (this.parameterTypes == null) {
            this.parameterTypes = LH(3);
        }
        return this.parameterTypes;
    }

    public Class[] dWL() {
        if (this.oge == null) {
            this.oge = LH(5);
        }
        return this.oge;
    }
}
