package org.aspectj.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class hJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.hJy = cls2;
    }

    public Class getReturnType() {
        if (this.hJy == null) {
            this.hJy = wd(6);
        }
        return this.hJy;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.wg(getModifiers()));
        if (hVar.hJH) {
            stringBuffer.append(hVar.v(getReturnType()));
        }
        if (hVar.hJH) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.d(bKP(), bKQ()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, getParameterTypes());
        hVar.c(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }
}
