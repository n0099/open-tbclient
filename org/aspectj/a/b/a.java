package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] oJW;
    Class[] oJX;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.oJW = strArr;
        this.oJX = clsArr2;
    }

    public Class[] emT() {
        if (this.parameterTypes == null) {
            this.parameterTypes = OP(3);
        }
        return this.parameterTypes;
    }

    public Class[] emU() {
        if (this.oJX == null) {
            this.oJX = OP(5);
        }
        return this.oJX;
    }
}
