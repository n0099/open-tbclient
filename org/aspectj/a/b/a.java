package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] irO;
    String[] irP;
    Class[] irQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.irO = clsArr;
        this.irP = strArr;
        this.irQ = clsArr2;
    }

    public Class[] getParameterTypes() {
        if (this.irO == null) {
            this.irO = yL(3);
        }
        return this.irO;
    }

    public Class[] getExceptionTypes() {
        if (this.irQ == null) {
            this.irQ = yL(5);
        }
        return this.irQ;
    }
}
