package org.aspectj.runtime.internal.cflowstack;
/* loaded from: classes9.dex */
public interface ThreadStackFactory {
    ThreadCounter getNewThreadCounter();

    ThreadStack getNewThreadStack();
}
