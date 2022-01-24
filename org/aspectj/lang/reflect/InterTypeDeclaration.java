package org.aspectj.lang.reflect;
/* loaded from: classes5.dex */
public interface InterTypeDeclaration {
    AjType<?> getDeclaringType();

    int getModifiers();

    AjType<?> getTargetType() throws ClassNotFoundException;
}
