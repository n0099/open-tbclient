package org.aspectj.runtime.reflect;

import java.lang.reflect.Constructor;
import org.aspectj.lang.reflect.ConstructorSignature;
/* loaded from: classes9.dex */
public class ConstructorSignatureImpl extends CodeSignatureImpl implements ConstructorSignature {
    public Constructor constructor;

    @Override // org.aspectj.runtime.reflect.SignatureImpl, org.aspectj.lang.Signature
    public String getName() {
        return "<init>";
    }

    public ConstructorSignatureImpl(int i, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, "<init>", cls, clsArr, strArr, clsArr2);
    }

    public ConstructorSignatureImpl(String str) {
        super(str);
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public String createToString(StringMaker stringMaker) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(stringMaker.makeModifiersString(getModifiers()));
        stringBuffer.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
        stringMaker.addSignature(stringBuffer, getParameterTypes());
        stringMaker.addThrows(stringBuffer, getExceptionTypes());
        return stringBuffer.toString();
    }

    @Override // org.aspectj.lang.reflect.ConstructorSignature
    public Constructor getConstructor() {
        if (this.constructor == null) {
            try {
                this.constructor = getDeclaringType().getDeclaredConstructor(getParameterTypes());
            } catch (Exception unused) {
            }
        }
        return this.constructor;
    }
}
