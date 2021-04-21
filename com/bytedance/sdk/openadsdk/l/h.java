package com.bytedance.sdk.openadsdk.l;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadGroup f29472a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f29473b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    public final String f29474c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29475d;

    public h(int i, @NonNull String str) {
        this.f29475d = i;
        this.f29472a = new ThreadGroup("tt_pangle_group_" + str);
        this.f29474c = "tt_pangle_thread_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f29472a;
        Thread thread = new Thread(threadGroup, runnable, this.f29474c + "_" + this.f29473b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f29475d == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
