package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] qur;
    Class[] qus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.qur = strArr;
        this.qus = clsArr2;
    }

    public Class[] eLG() {
        if (this.parameterTypes == null) {
            this.parameterTypes = SA(3);
        }
        return this.parameterTypes;
    }

    public Class[] eLH() {
        if (this.qus == null) {
            this.qus = SA(5);
        }
        return this.qus;
    }
}
