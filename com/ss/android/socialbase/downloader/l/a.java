package com.ss.android.socialbase.downloader.l;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f13209a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f13210b;
    private final boolean c;

    public a(String str) {
        this(str, false);
    }

    public a(String str, boolean z) {
        this.f13210b = new AtomicInteger();
        this.f13209a = str;
        this.c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f13209a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f13210b.incrementAndGet());
        if (!this.c) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }
}
