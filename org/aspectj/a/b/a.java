package org.aspectj.a.b;
/* loaded from: classes6.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] parameterTypes;
    String[] qnh;
    Class[] qni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.parameterTypes = clsArr;
        this.qnh = strArr;
        this.qni = clsArr2;
    }

    public Class[] eMC() {
        if (this.parameterTypes == null) {
            this.parameterTypes = Tw(3);
        }
        return this.parameterTypes;
    }

    public Class[] eMD() {
        if (this.qni == null) {
            this.qni = Tw(5);
        }
        return this.qni;
    }
}
