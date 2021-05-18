package com.bytedance.sdk.openadsdk.l;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadGroup f29622a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f29623b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    public final String f29624c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29625d;

    public h(int i2, @NonNull String str) {
        this.f29625d = i2;
        this.f29622a = new ThreadGroup("tt_pangle_group_" + str);
        this.f29624c = "tt_pangle_thread_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f29622a;
        Thread thread = new Thread(threadGroup, runnable, this.f29624c + "_" + this.f29623b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f29625d == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
