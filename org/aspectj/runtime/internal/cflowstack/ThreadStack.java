package org.aspectj.runtime.internal.cflowstack;

import java.util.Stack;
/* loaded from: classes4.dex */
public interface ThreadStack {
    Stack getThreadStack();

    void removeThreadStack();
}
