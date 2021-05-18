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
    public String f29576a;

    /* renamed from: com.bytedance.sdk.openadsdk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0311a {

        /* renamed from: h  reason: collision with root package name */
        public RejectedExecutionHandler f29591h;

        /* renamed from: a  reason: collision with root package name */
        public String f29584a = "io";

        /* renamed from: b  reason: collision with root package name */
        public int f29585b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f29586c = 30;

        /* renamed from: d  reason: collision with root package name */
        public TimeUnit f29587d = TimeUnit.SECONDS;

        /* renamed from: e  reason: collision with root package name */
        public int f29588e = 1;

        /* renamed from: f  reason: collision with root package name */
        public BlockingQueue<Runnable> f29589f = null;

        /* renamed from: g  reason: collision with root package name */
        public ThreadFactory f29590g = null;

        /* renamed from: i  reason: collision with root package name */
        public int f29592i = 5;

        public C0311a a(String str) {
            this.f29584a = str;
            return this;
        }

        public C0311a b(int i2) {
            this.f29588e = i2;
            return this;
        }

        public C0311a a(int i2) {
            this.f29585b = i2;
            return this;
        }

        public C0311a a(long j) {
            this.f29586c = j;
            return this;
        }

        public C0311a a(TimeUnit timeUnit) {
            this.f29587d = timeUnit;
            return this;
        }

        public C0311a a(BlockingQueue<Runnable> blockingQueue) {
            this.f29589f = blockingQueue;
            return this;
        }

        public C0311a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.f29591h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.f29590g == null) {
                this.f29590g = new h(this.f29592i, this.f29584a);
            }
            if (this.f29591h == null) {
                this.f29591h = e.f();
            }
            if (this.f29589f == null) {
                this.f29589f = new LinkedBlockingQueue();
            }
            return new a(this.f29584a, this.f29585b, this.f29588e, this.f29586c, this.f29587d, this.f29589f, this.f29590g, this.f29591h);
        }
    }

    public a(String str, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i3, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f29576a = str;
    }

    public String a() {
        return this.f29576a;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!e.e() || TextUtils.isEmpty(this.f29576a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29576a;
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
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29576a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() >= 4 || getCorePoolSize() == 0) {
        } else {
            try {
                setCorePoolSize(0);
                setMaximumPoolSize(4);
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29576a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
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
        if (!e.e() || TextUtils.isEmpty(this.f29576a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29576a;
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
                setMaximumPoolSize(e.f29610a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29576a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() < 4 || getCorePoolSize() == 4) {
        } else {
            try {
                setMaximumPoolSize(e.f29610a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29576a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e2) {
                u.c("ADThreadPoolExecutor", e2.getMessage());
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.f29576a) || "aidl".equals(this.f29576a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (!"io".equals(this.f29576a) && !"aidl".equals(this.f29576a)) {
            return super.shutdownNow();
        }
        return Collections.emptyList();
    }
}
