package org.aspectj.runtime.internal.cflowstack;
/* loaded from: classes10.dex */
public interface ThreadStackFactory {
    ThreadCounter getNewThreadCounter();

    ThreadStack getNewThreadStack();
}
