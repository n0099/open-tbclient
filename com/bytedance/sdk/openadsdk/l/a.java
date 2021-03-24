package com.bytedance.sdk.openadsdk.l;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public String f29734a;

    /* renamed from: com.bytedance.sdk.openadsdk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0326a {

        /* renamed from: h  reason: collision with root package name */
        public RejectedExecutionHandler f29749h;

        /* renamed from: a  reason: collision with root package name */
        public String f29742a = "io";

        /* renamed from: b  reason: collision with root package name */
        public int f29743b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f29744c = 30;

        /* renamed from: d  reason: collision with root package name */
        public TimeUnit f29745d = TimeUnit.SECONDS;

        /* renamed from: e  reason: collision with root package name */
        public int f29746e = 1;

        /* renamed from: f  reason: collision with root package name */
        public BlockingQueue<Runnable> f29747f = null;

        /* renamed from: g  reason: collision with root package name */
        public ThreadFactory f29748g = null;
        public int i = 5;

        public C0326a a(String str) {
            this.f29742a = str;
            return this;
        }

        public C0326a b(int i) {
            this.f29746e = i;
            return this;
        }

        public C0326a a(int i) {
            this.f29743b = i;
            return this;
        }

        public C0326a a(long j) {
            this.f29744c = j;
            return this;
        }

        public C0326a a(TimeUnit timeUnit) {
            this.f29745d = timeUnit;
            return this;
        }

        public C0326a a(BlockingQueue<Runnable> blockingQueue) {
            this.f29747f = blockingQueue;
            return this;
        }

        public C0326a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.f29749h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.f29748g == null) {
                this.f29748g = new h(this.i, this.f29742a);
            }
            if (this.f29749h == null) {
                this.f29749h = e.f();
            }
            if (this.f29747f == null) {
                this.f29747f = new LinkedBlockingQueue();
            }
            return new a(this.f29742a, this.f29743b, this.f29746e, this.f29744c, this.f29745d, this.f29747f, this.f29748g, this.f29749h);
        }
    }

    public a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f29734a = str;
    }

    public String a() {
        return this.f29734a;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!e.e() || TextUtils.isEmpty(this.f29734a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29734a;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 107332) {
            if (hashCode == 2993840 && str.equals("aidl")) {
                c2 = 0;
            }
        } else if (str.equals(TbConfig.TMP_LOG_DIR_NAME)) {
            c2 = 1;
        }
        if (c2 != 0) {
            if (c2 == 1 && queue.size() >= 4 && getCorePoolSize() != 2) {
                setCorePoolSize(2);
                setMaximumPoolSize(4);
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29734a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() >= 4 || getCorePoolSize() == 0) {
        } else {
            try {
                setCorePoolSize(0);
                setMaximumPoolSize(4);
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29734a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e2) {
                u.c("ADThreadPoolExecutor", e2.getMessage());
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof g) {
            super.execute(new b((g) runnable, this));
        } else {
            super.execute(new b(new g("unknown") { // from class: com.bytedance.sdk.openadsdk.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (!e.e() || TextUtils.isEmpty(this.f29734a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29734a;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 107332) {
            if (hashCode == 2993840 && str.equals("aidl")) {
                c2 = 0;
            }
        } else if (str.equals(TbConfig.TMP_LOG_DIR_NAME)) {
            c2 = 1;
        }
        if (c2 != 0) {
            if (c2 == 1 && queue.size() >= 4 && getCorePoolSize() != 4) {
                setMaximumPoolSize(e.f29766a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29734a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() < 4 || getCorePoolSize() == 4) {
        } else {
            try {
                setMaximumPoolSize(e.f29766a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29734a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e2) {
                u.c("ADThreadPoolExecutor", e2.getMessage());
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.f29734a) || "aidl".equals(this.f29734a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (!"io".equals(this.f29734a) && !"aidl".equals(this.f29734a)) {
            return super.shutdownNow();
        }
        return Collections.emptyList();
    }
}
