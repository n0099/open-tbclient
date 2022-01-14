package com.ss.android.socialbase.downloader.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a implements ThreadFactory {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f60070b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f60071c;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f60070b.incrementAndGet();
        Thread thread = new Thread(runnable, this.a + "-" + incrementAndGet);
        if (!this.f60071c) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public a(String str, boolean z) {
        this.f60070b = new AtomicInteger();
        this.a = str;
        this.f60071c = z;
    }
}
