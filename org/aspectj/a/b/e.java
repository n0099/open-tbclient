package org.aspectj.a.b;

import com.baidu.ar.util.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class ilr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.ilr = cls2;
    }

    public Class getReturnType() {
        if (this.ilr == null) {
            this.ilr = zw(6);
        }
        return this.ilr;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.zz(getModifiers()));
        if (hVar.imQ) {
            stringBuffer.append(hVar.o(getReturnType()));
        }
        if (hVar.imQ) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.e(bSc(), bSd()));
        stringBuffer.append(Constants.DOT);
        stringBuffer.append(getName());
        hVar.b(stringBuffer, getParameterTypes());
        hVar.c(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }
}
