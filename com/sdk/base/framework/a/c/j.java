package com.sdk.base.framework.a.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class j implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f4469a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "PriorityExecutor #" + this.f4469a.getAndIncrement());
    }
}
