package com.win.opensdk;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public final class br implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f8122a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "T#" + this.f8122a.getAndIncrement());
    }
}
