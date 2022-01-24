package org.aspectj.lang.reflect;
/* loaded from: classes5.dex */
public interface SourceLocation {
    int getColumn();

    String getFileName();

    int getLine();

    Class getWithinType();
}
