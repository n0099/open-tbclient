package org.aspectj.lang.reflect;

import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public interface AdviceSignature extends CodeSignature {
    Method getAdvice();

    Class getReturnType();
}
