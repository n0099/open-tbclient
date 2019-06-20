package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] kla;
    String[] klb;
    Class[] klc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.kla = clsArr;
        this.klb = strArr;
        this.klc = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.kla == null) {
            this.kla = Ed(3);
        }
        return this.kla;
    }

    public Class[] getExceptionTypes() {
        if (this.klc == null) {
            this.klc = Ed(5);
        }
        return this.klc;
    }
}
