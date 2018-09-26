package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class hRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.hRS = cls2;
    }

    public Class getReturnType() {
        if (this.hRS == null) {
            this.hRS = wC(6);
        }
        return this.hRS;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.wF(getModifiers()));
        if (hVar.hSb) {
            stringBuffer.append(hVar.y(getReturnType()));
        }
        if (hVar.hSb) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.d(bNG(), bNH()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, getParameterTypes());
        hVar.c(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }
}
