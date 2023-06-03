package org.aspectj.runtime.reflect;

import com.baidu.tbadk.core.data.SmallTailInfo;
import org.aspectj.lang.reflect.LockSignature;
/* loaded from: classes2.dex */
public class LockSignatureImpl extends SignatureImpl implements LockSignature {
    public Class parameterType;

    public LockSignatureImpl(Class cls) {
        super(8, "lock", cls);
        this.parameterType = cls;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public String createToString(StringMaker stringMaker) {
        if (this.parameterType == null) {
            this.parameterType = extractType(3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lock(");
        stringBuffer.append(stringMaker.makeTypeName(this.parameterType));
        stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
        return stringBuffer.toString();
    }

    public LockSignatureImpl(String str) {
        super(str);
    }

    public Class getParameterType() {
        if (this.parameterType == null) {
            this.parameterType = extractType(3);
        }
        return this.parameterType;
    }
}
