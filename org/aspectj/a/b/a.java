package org.aspectj.a.b;
/* loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] quR;
    Class[] quS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.quR = strArr;
        this.quS = clsArr2;
    }

    public Class[] eLO() {
        if (this.parameterTypes == null) {
            this.parameterTypes = SB(3);
        }
        return this.parameterTypes;
    }

    public Class[] eLP() {
        if (this.quS == null) {
            this.quS = SB(5);
        }
        return this.quS;
    }
}
