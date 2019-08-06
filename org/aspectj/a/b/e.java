package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class cOw() {
        if (this.returnType == null) {
            this.returnType = EN(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.EP(cOx()));
        if (hVar.kua) {
            stringBuffer.append(hVar.G(cOw()));
        }
        if (hVar.kua) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.i(cOy(), cOz()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, cOs());
        hVar.c(stringBuffer, cOt());
        return stringBuffer.toString();
    }
}
