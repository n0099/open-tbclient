package org.aspectj.a.b;
/* loaded from: classes20.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] ogb;
    Class[] ogc;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.ogb = strArr;
        this.ogc = clsArr2;
    }

    public Class[] dWJ() {
        if (this.parameterTypes == null) {
            this.parameterTypes = LH(3);
        }
        return this.parameterTypes;
    }

    public Class[] dWK() {
        if (this.ogc == null) {
            this.ogc = LH(5);
        }
        return this.ogc;
    }
}
