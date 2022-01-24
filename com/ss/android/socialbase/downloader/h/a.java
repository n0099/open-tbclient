package com.ss.android.socialbase.downloader.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class a implements ThreadFactory {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f60115b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f60116c;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f60115b.incrementAndGet();
        Thread thread = new Thread(runnable, this.a + "-" + incrementAndGet);
        if (!this.f60116c) {
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
        this.f60115b = new AtomicInteger();
        this.a = str;
        this.f60116c = z;
    }
}
