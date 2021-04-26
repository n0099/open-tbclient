package com.bytedance.sdk.openadsdk.l;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadGroup f30377a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f30378b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    public final String f30379c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30380d;

    public h(int i2, @NonNull String str) {
        this.f30380d = i2;
        this.f30377a = new ThreadGroup("tt_pangle_group_" + str);
        this.f30379c = "tt_pangle_thread_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f30377a;
        Thread thread = new Thread(threadGroup, runnable, this.f30379c + "_" + this.f30378b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f30380d == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
