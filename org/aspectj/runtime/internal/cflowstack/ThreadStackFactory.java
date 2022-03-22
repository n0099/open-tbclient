package org.aspectj.runtime.internal.cflowstack;
/* loaded from: classes8.dex */
public interface ThreadStackFactory {
    ThreadCounter getNewThreadCounter();

    ThreadStack getNewThreadStack();
}
