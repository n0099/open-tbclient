package org.aspectj.a.b;
/* loaded from: classes7.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] nJK;
    Class[] nJL;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.nJK = strArr;
        this.nJL = clsArr2;
    }

    public Class[] dMV() {
        if (this.parameterTypes == null) {
            this.parameterTypes = NT(3);
        }
        return this.parameterTypes;
    }

    public Class[] dMW() {
        if (this.nJL == null) {
            this.nJL = NT(5);
        }
        return this.nJL;
    }
}
