package org.aspectj.a.b;
/* loaded from: classes2.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] hJk;
    String[] hJl;
    Class[] hJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.hJk = clsArr;
        this.hJl = strArr;
        this.hJm = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.hJk == null) {
            this.hJk = we(3);
        }
        return this.hJk;
    }

    public Class[] getExceptionTypes() {
        if (this.hJm == null) {
            this.hJm = we(5);
        }
        return this.hJm;
    }
}
