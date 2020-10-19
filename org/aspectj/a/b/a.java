package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] oZk;
    Class[] oZl;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.oZk = strArr;
        this.oZl = clsArr2;
    }

    public Class[] eqG() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Pv(3);
        }
        return this.parameterTypes;
    }

    public Class[] eqH() {
        if (this.oZl == null) {
            this.oZl = Pv(5);
        }
        return this.oZl;
    }
}
