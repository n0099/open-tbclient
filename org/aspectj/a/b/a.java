package org.aspectj.a.b;
/* loaded from: classes3.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] qvt;
    Class[] qvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.qvt = strArr;
        this.qvu = clsArr2;
    }

    public Class[] eLw() {
        if (this.parameterTypes == null) {
            this.parameterTypes = SA(3);
        }
        return this.parameterTypes;
    }

    public Class[] eLx() {
        if (this.qvu == null) {
            this.qvu = SA(5);
        }
        return this.qvu;
    }
}
