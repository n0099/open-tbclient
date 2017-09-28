package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class hgw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.hgw = cls2;
    }

    public Class getReturnType() {
        if (this.hgw == null) {
            this.hgw = wQ(6);
        }
        return this.hgw;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.wT(getModifiers()));
        if (hVar.hof) {
            stringBuffer.append(hVar.o(getReturnType()));
        }
        if (hVar.hof) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.e(bLF(), bLG()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, getParameterTypes());
        hVar.c(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }
}
