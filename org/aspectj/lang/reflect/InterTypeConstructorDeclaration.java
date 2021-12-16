package org.aspectj.lang.reflect;

import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public interface InterTypeConstructorDeclaration extends InterTypeDeclaration {
    AjType<?>[] getExceptionTypes();

    Type[] getGenericParameterTypes();

    AjType<?>[] getParameterTypes();
}
