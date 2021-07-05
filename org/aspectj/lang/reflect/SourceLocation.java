package org.aspectj.lang.reflect;
/* loaded from: classes10.dex */
public interface SourceLocation {
    int getColumn();

    String getFileName();

    int getLine();

    Class getWithinType();
}
