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
/* loaded from: classes5.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public String f29428a;

    /* renamed from: com.bytedance.sdk.openadsdk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0331a {

        /* renamed from: h  reason: collision with root package name */
        public RejectedExecutionHandler f29443h;

        /* renamed from: a  reason: collision with root package name */
        public String f29436a = "io";

        /* renamed from: b  reason: collision with root package name */
        public int f29437b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f29438c = 30;

        /* renamed from: d  reason: collision with root package name */
        public TimeUnit f29439d = TimeUnit.SECONDS;

        /* renamed from: e  reason: collision with root package name */
        public int f29440e = 1;

        /* renamed from: f  reason: collision with root package name */
        public BlockingQueue<Runnable> f29441f = null;

        /* renamed from: g  reason: collision with root package name */
        public ThreadFactory f29442g = null;
        public int i = 5;

        public C0331a a(String str) {
            this.f29436a = str;
            return this;
        }

        public C0331a b(int i) {
            this.f29440e = i;
            return this;
        }

        public C0331a a(int i) {
            this.f29437b = i;
            return this;
        }

        public C0331a a(long j) {
            this.f29438c = j;
            return this;
        }

        public C0331a a(TimeUnit timeUnit) {
            this.f29439d = timeUnit;
            return this;
        }

        public C0331a a(BlockingQueue<Runnable> blockingQueue) {
            this.f29441f = blockingQueue;
            return this;
        }

        public C0331a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.f29443h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.f29442g == null) {
                this.f29442g = new h(this.i, this.f29436a);
            }
            if (this.f29443h == null) {
                this.f29443h = e.f();
            }
            if (this.f29441f == null) {
                this.f29441f = new LinkedBlockingQueue();
            }
            return new a(this.f29436a, this.f29437b, this.f29440e, this.f29438c, this.f29439d, this.f29441f, this.f29442g, this.f29443h);
        }
    }

    public a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f29428a = str;
    }

    public String a() {
        return this.f29428a;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!e.e() || TextUtils.isEmpty(this.f29428a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29428a;
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
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29428a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() >= 4 || getCorePoolSize() == 0) {
        } else {
            try {
                setCorePoolSize(0);
                setMaximumPoolSize(4);
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29428a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
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
        if (!e.e() || TextUtils.isEmpty(this.f29428a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29428a;
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
                setMaximumPoolSize(e.f29460a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29428a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() < 4 || getCorePoolSize() == 4) {
        } else {
            try {
                setMaximumPoolSize(e.f29460a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29428a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e2) {
                u.c("ADThreadPoolExecutor", e2.getMessage());
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.f29428a) || "aidl".equals(this.f29428a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (!"io".equals(this.f29428a) && !"aidl".equals(this.f29428a)) {
            return super.shutdownNow();
        }
        return Collections.emptyList();
    }
}
