package org.aspectj.lang.reflect;

import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public interface AdviceSignature extends CodeSignature {
    Method getAdvice();

    Class getReturnType();
}
