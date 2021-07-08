package org.aspectj.lang.reflect;
/* loaded from: classes9.dex */
public interface SourceLocation {
    int getColumn();

    String getFileName();

    int getLine();

    Class getWithinType();
}
