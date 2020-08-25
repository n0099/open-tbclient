package org.aspectj.a.b;
/* loaded from: classes10.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] oAa;
    String[] ozZ;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.ozZ = strArr;
        this.oAa = clsArr2;
    }

    public Class[] eiN() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Ok(3);
        }
        return this.parameterTypes;
    }

    public Class[] eiO() {
        if (this.oAa == null) {
            this.oAa = Ok(5);
        }
        return this.oAa;
    }
}
