package org.aspectj.lang.reflect;
/* loaded from: classes8.dex */
public interface SourceLocation {
    int getColumn();

    String getFileName();

    int getLine();

    Class getWithinType();
}
