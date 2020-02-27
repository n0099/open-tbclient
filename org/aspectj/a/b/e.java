package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class dMZ() {
        if (this.returnType == null) {
            this.returnType = NS(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.NU(dNa()));
        if (hVar.nKe) {
            stringBuffer.append(hVar.N(dMZ()));
        }
        if (hVar.nKe) {
            stringBuffer.append(HanziToPinyin.Token.SEPARATOR);
        }
        stringBuffer.append(hVar.k(dNb(), dNc()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        hVar.b(stringBuffer, dMV());
        hVar.c(stringBuffer, dMW());
        return stringBuffer.toString();
    }
}
