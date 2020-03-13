package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nJX;
    Class[] nJY;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nJX = strArr;
        this.nJY = clsArr2;
    }

    public Class[] dMY() {
        if (this.parameterTypes == null) {
            this.parameterTypes = NT(3);
        }
        return this.parameterTypes;
    }

    public Class[] dMZ() {
        if (this.nJY == null) {
            this.nJY = NT(5);
        }
        return this.nJY;
    }
}
