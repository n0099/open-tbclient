package org.aspectj.lang.reflect;
/* loaded from: classes8.dex */
public interface DeclareErrorOrWarning {
    AjType getDeclaringType();

    String getMessage();

    PointcutExpression getPointcutExpression();

    boolean isError();
}
