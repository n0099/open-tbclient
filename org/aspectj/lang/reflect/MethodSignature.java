package org.aspectj.lang.reflect;

import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public interface MethodSignature extends CodeSignature {
    Method getMethod();

    Class getReturnType();
}
