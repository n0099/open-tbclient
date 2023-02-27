package org.aspectj.runtime.reflect;

import com.baidu.tbadk.core.data.SmallTailInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.UnlockSignature;
/* loaded from: classes9.dex */
public class UnlockSignatureImpl extends SignatureImpl implements UnlockSignature {
    public Class parameterType;

    public UnlockSignatureImpl(Class cls) {
        super(8, JoinPoint.SYNCHRONIZATION_UNLOCK, cls);
        this.parameterType = cls;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public String createToString(StringMaker stringMaker) {
        if (this.parameterType == null) {
            this.parameterType = extractType(3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unlock(");
        stringBuffer.append(stringMaker.makeTypeName(this.parameterType));
        stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
        return stringBuffer.toString();
    }

    public UnlockSignatureImpl(String str) {
        super(str);
    }

    public Class getParameterType() {
        if (this.parameterType == null) {
            this.parameterType = extractType(3);
        }
        return this.parameterType;
    }
}
