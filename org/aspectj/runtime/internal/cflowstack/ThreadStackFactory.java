package org.aspectj.runtime.internal.cflowstack;
/* loaded from: classes5.dex */
public interface ThreadStackFactory {
    ThreadCounter getNewThreadCounter();

    ThreadStack getNewThreadStack();
}
