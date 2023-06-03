package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.MemberSignature;
/* loaded from: classes2.dex */
public abstract class MemberSignatureImpl extends SignatureImpl implements MemberSignature {
    public MemberSignatureImpl(int i, String str, Class cls) {
        super(i, str, cls);
    }

    public MemberSignatureImpl(String str) {
        super(str);
    }
}
