package org.aspectj.a.b;
/* loaded from: classes4.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] qoP;
    Class[] qoQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.qoP = strArr;
        this.qoQ = clsArr2;
    }

    public Class[] eNg() {
        if (this.parameterTypes == null) {
            this.parameterTypes = TM(3);
        }
        return this.parameterTypes;
    }

    public Class[] eNh() {
        if (this.qoQ == null) {
            this.qoQ = TM(5);
        }
        return this.qoQ;
    }
}
