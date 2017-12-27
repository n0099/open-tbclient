package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class idE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.idE = cls2;
    }

    public Class getReturnType() {
        if (this.idE == null) {
            this.idE = zF(6);
        }
        return this.idE;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.zI(getModifiers()));
        if (hVar.idO) {
            stringBuffer.append(hVar.n(getReturnType()));
        }
        if (hVar.idO) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.e(bQL(), bQM()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, getParameterTypes());
        hVar.c(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }
}
