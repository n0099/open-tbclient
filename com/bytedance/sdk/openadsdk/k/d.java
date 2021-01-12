package com.bytedance.sdk.openadsdk.k;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f7325a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private final ThreadGroup f7326b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    private final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i, String str) {
        this.e = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.f7326b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (TextUtils.isEmpty(str)) {
            this.d = "ttbackground-" + f7325a.getAndIncrement() + "-thread-";
        } else {
            this.d = str + f7325a.getAndIncrement() + "-thread-";
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f7326b, runnable, this.d + this.c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.e == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
