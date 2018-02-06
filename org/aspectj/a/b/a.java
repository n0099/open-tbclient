package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] imi;
    String[] imj;
    Class[] imk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.imi = clsArr;
        this.imj = strArr;
        this.imk = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.imi == null) {
            this.imi = zw(3);
        }
        return this.imi;
    }

    public Class[] getExceptionTypes() {
        if (this.imk == null) {
            this.imk = zw(5);
        }
        return this.imk;
    }
}
