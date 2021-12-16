package org.aspectj.lang;
/* loaded from: classes4.dex */
public interface Signature {
    Class getDeclaringType();

    String getDeclaringTypeName();

    int getModifiers();

    String getName();

    String toLongString();

    String toShortString();

    String toString();
}
