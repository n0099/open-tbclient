package org.aspectj.lang.reflect;

import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public interface MethodSignature extends CodeSignature {
    Method getMethod();

    Class getReturnType();
}
