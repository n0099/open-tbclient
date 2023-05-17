package org.aspectj.lang.reflect;
/* loaded from: classes10.dex */
public interface DeclareErrorOrWarning {
    AjType getDeclaringType();

    String getMessage();

    PointcutExpression getPointcutExpression();

    boolean isError();
}
