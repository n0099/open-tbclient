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
    public String f29690a;

    /* renamed from: com.bytedance.sdk.openadsdk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0317a {

        /* renamed from: h  reason: collision with root package name */
        public RejectedExecutionHandler f29705h;

        /* renamed from: a  reason: collision with root package name */
        public String f29698a = "io";

        /* renamed from: b  reason: collision with root package name */
        public int f29699b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f29700c = 30;

        /* renamed from: d  reason: collision with root package name */
        public TimeUnit f29701d = TimeUnit.SECONDS;

        /* renamed from: e  reason: collision with root package name */
        public int f29702e = 1;

        /* renamed from: f  reason: collision with root package name */
        public BlockingQueue<Runnable> f29703f = null;

        /* renamed from: g  reason: collision with root package name */
        public ThreadFactory f29704g = null;

        /* renamed from: i  reason: collision with root package name */
        public int f29706i = 5;

        public C0317a a(String str) {
            this.f29698a = str;
            return this;
        }

        public C0317a b(int i2) {
            this.f29702e = i2;
            return this;
        }

        public C0317a a(int i2) {
            this.f29699b = i2;
            return this;
        }

        public C0317a a(long j) {
            this.f29700c = j;
            return this;
        }

        public C0317a a(TimeUnit timeUnit) {
            this.f29701d = timeUnit;
            return this;
        }

        public C0317a a(BlockingQueue<Runnable> blockingQueue) {
            this.f29703f = blockingQueue;
            return this;
        }

        public C0317a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.f29705h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.f29704g == null) {
                this.f29704g = new h(this.f29706i, this.f29698a);
            }
            if (this.f29705h == null) {
                this.f29705h = e.f();
            }
            if (this.f29703f == null) {
                this.f29703f = new LinkedBlockingQueue();
            }
            return new a(this.f29698a, this.f29699b, this.f29702e, this.f29700c, this.f29701d, this.f29703f, this.f29704g, this.f29705h);
        }
    }

    public a(String str, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i3, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f29690a = str;
    }

    public String a() {
        return this.f29690a;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!e.e() || TextUtils.isEmpty(this.f29690a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29690a;
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
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29690a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() >= 4 || getCorePoolSize() == 0) {
        } else {
            try {
                setCorePoolSize(0);
                setMaximumPoolSize(4);
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f29690a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
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
        if (!e.e() || TextUtils.isEmpty(this.f29690a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f29690a;
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
                setMaximumPoolSize(e.f29724a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29690a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() < 4 || getCorePoolSize() == 4) {
        } else {
            try {
                setMaximumPoolSize(e.f29724a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f29690a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e2) {
                u.c("ADThreadPoolExecutor", e2.getMessage());
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.f29690a) || "aidl".equals(this.f29690a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (!"io".equals(this.f29690a) && !"aidl".equals(this.f29690a)) {
            return super.shutdownNow();
        }
        return Collections.emptyList();
    }
}
