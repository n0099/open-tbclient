package com.sdk.base.framework.a.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class j implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f38732a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "PriorityExecutor #" + this.f38732a.getAndIncrement());
    }
}
