package org.aspectj.runtime.internal.cflowstack;
/* loaded from: classes4.dex */
public interface ThreadStackFactory {
    ThreadCounter getNewThreadCounter();

    ThreadStack getNewThreadStack();
}
