package org.aspectj.lang.reflect;

import java.lang.reflect.Type;
/* loaded from: classes9.dex */
public interface InterTypeConstructorDeclaration extends InterTypeDeclaration {
    AjType<?>[] getExceptionTypes();

    Type[] getGenericParameterTypes();

    AjType<?>[] getParameterTypes();
}
