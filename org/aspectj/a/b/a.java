package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] ido;
    String[] idp;
    Class[] idq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.ido = clsArr;
        this.idp = strArr;
        this.idq = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.ido == null) {
            this.ido = zG(3);
        }
        return this.ido;
    }

    public Class[] getExceptionTypes() {
        if (this.idq == null) {
            this.idq = zG(5);
        }
        return this.idq;
    }
}
