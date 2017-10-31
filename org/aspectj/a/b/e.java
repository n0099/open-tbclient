package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class hqo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.hqo = cls2;
    }

    public Class getReturnType() {
        if (this.hqo == null) {
            this.hqo = xm(6);
        }
        return this.hqo;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.xp(getModifiers()));
        if (hVar.hxX) {
            stringBuffer.append(hVar.o(getReturnType()));
        }
        if (hVar.hxX) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.e(bOU(), bOV()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, getParameterTypes());
        hVar.c(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }
}
