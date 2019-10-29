package org.aspectj.a.b;

import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends a implements org.aspectj.lang.reflect.c {
    Class returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.returnType = cls2;
    }

    public Class cNp() {
        if (this.returnType == null) {
            this.returnType = Do(6);
        }
        return this.returnType;
    }

    @Override // org.aspectj.a.b.f
    protected String b(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.Dq(cNq()));
        if (hVar.kxb) {
            stringBuffer.append(hVar.E(cNp()));
        }
        if (hVar.kxb) {
            stringBuffer.append(HanziToPinyin.Token.SEPARATOR);
        }
        stringBuffer.append(hVar.h(cNr(), cNs()));
        stringBuffer.append(DefaultConfig.TOKEN_SEPARATOR);
        stringBuffer.append(getName());
        hVar.b(stringBuffer, cNl());
        hVar.c(stringBuffer, cNm());
        return stringBuffer.toString();
    }
}
