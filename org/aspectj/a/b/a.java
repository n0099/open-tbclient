package org.aspectj.a.b;
/* loaded from: classes10.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    String[] oAr;
    Class[] oAs;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.oAr = strArr;
        this.oAs = clsArr2;
    }

    public Class[] eiW() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Ok(3);
        }
        return this.parameterTypes;
    }

    public Class[] eiX() {
        if (this.oAs == null) {
            this.oAs = Ok(5);
        }
        return this.oAs;
    }
}
