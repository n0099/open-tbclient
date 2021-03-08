package com.bytedance.sdk.openadsdk.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private String f4858a;

    public a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f4858a = null;
        this.f4858a = str;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof g) {
            super.execute(new b((g) runnable, this));
        } else {
            super.execute(new b(new g() { // from class: com.bytedance.sdk.openadsdk.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (e.d() && !TextUtils.isEmpty(this.f4858a) && (queue = getQueue()) != null) {
            String str = this.f4858a;
            char c = 65535;
            switch (str.hashCode()) {
                case 3366:
                    if (str.equals("io")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2993840:
                    if (str.equals("aidl")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (queue.size() >= 8 && getCorePoolSize() != 8) {
                        try {
                            setMaximumPoolSize(e.f4866a + 8);
                            setCorePoolSize(8);
                            u.c("ADThreadPoolExecutor", "execute: increase " + this.f4858a);
                            return;
                        } catch (Exception e) {
                            u.c("ADThreadPoolExecutor", e.getMessage());
                            return;
                        }
                    }
                    return;
                case 1:
                    if (queue.size() >= 4 && getCorePoolSize() != 4) {
                        try {
                            setMaximumPoolSize(e.f4866a + 4);
                            setCorePoolSize(4);
                            u.c("ADThreadPoolExecutor", "execute: increase " + this.f4858a);
                            return;
                        } catch (Exception e2) {
                            u.c("ADThreadPoolExecutor", e2.getMessage());
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r3.equals("io") != false) goto L10;
     */
    @Override // java.util.concurrent.ThreadPoolExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        boolean z = false;
        super.afterExecute(runnable, th);
        if (e.d() && !TextUtils.isEmpty(this.f4858a) && (queue = getQueue()) != null) {
            String str = this.f4858a;
            switch (str.hashCode()) {
                case 3366:
                    break;
                case 2993840:
                    if (str.equals("aidl")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    if (queue.size() < 8 && getCorePoolSize() != 2) {
                        try {
                            setCorePoolSize(2);
                            setMaximumPoolSize(8);
                            u.c("ADThreadPoolExecutor", "execute: reduce " + this.f4858a);
                            return;
                        } catch (Exception e) {
                            u.c("ADThreadPoolExecutor", e.getMessage());
                            return;
                        }
                    }
                    return;
                case true:
                    if (queue.size() < 4 && getCorePoolSize() != 0) {
                        try {
                            setCorePoolSize(0);
                            setMaximumPoolSize(4);
                            u.c("ADThreadPoolExecutor", "execute: reduce " + this.f4858a);
                            return;
                        } catch (Exception e2) {
                            u.c("ADThreadPoolExecutor", e2.getMessage());
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return ("io".equals(this.f4858a) || "aidl".equals(this.f4858a)) ? Collections.emptyList() : super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if (!"io".equals(this.f4858a) && !"aidl".equals(this.f4858a)) {
            super.shutdown();
        }
    }

    public String a() {
        return this.f4858a;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1038a {
        private RejectedExecutionHandler h;

        /* renamed from: a  reason: collision with root package name */
        private String f4861a = "io";
        private int b = 1;
        private long c = 30;
        private TimeUnit d = TimeUnit.SECONDS;
        private int e = 1;
        private BlockingQueue<Runnable> f = null;
        private ThreadFactory g = null;
        private int i = 5;

        public C1038a a(String str) {
            this.f4861a = str;
            return this;
        }

        public C1038a a(int i) {
            this.b = i;
            return this;
        }

        public C1038a a(long j) {
            this.c = j;
            return this;
        }

        public C1038a a(TimeUnit timeUnit) {
            this.d = timeUnit;
            return this;
        }

        public C1038a b(int i) {
            this.e = i;
            return this;
        }

        public C1038a a(BlockingQueue<Runnable> blockingQueue) {
            this.f = blockingQueue;
            return this;
        }

        public C1038a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.g == null) {
                this.g = new h(this.i, this.f4861a);
            }
            if (this.h == null) {
                this.h = e.e();
            }
            if (this.f == null) {
                this.f = new LinkedBlockingQueue();
            }
            return new a(this.f4861a, this.b, this.e, this.c, this.d, this.f, this.g, this.h);
        }
    }
}
