package com.ss.android.socialbase.downloader.l;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f7866a;
    private final AtomicInteger b;
    private final boolean c;

    public a(String str) {
        this(str, false);
    }

    public a(String str, boolean z) {
        this.b = new AtomicInteger();
        this.f7866a = str;
        this.c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f7866a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.b.incrementAndGet());
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
