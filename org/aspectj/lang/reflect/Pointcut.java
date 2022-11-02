package org.aspectj.lang.reflect;
/* loaded from: classes9.dex */
public interface Pointcut {
    AjType getDeclaringType();

    int getModifiers();

    String getName();

    String[] getParameterNames();

    AjType<?>[] getParameterTypes();

    PointcutExpression getPointcutExpression();
}
