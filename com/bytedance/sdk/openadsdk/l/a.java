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
    public String f30331a;

    /* renamed from: com.bytedance.sdk.openadsdk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0324a {

        /* renamed from: h  reason: collision with root package name */
        public RejectedExecutionHandler f30346h;

        /* renamed from: a  reason: collision with root package name */
        public String f30339a = "io";

        /* renamed from: b  reason: collision with root package name */
        public int f30340b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f30341c = 30;

        /* renamed from: d  reason: collision with root package name */
        public TimeUnit f30342d = TimeUnit.SECONDS;

        /* renamed from: e  reason: collision with root package name */
        public int f30343e = 1;

        /* renamed from: f  reason: collision with root package name */
        public BlockingQueue<Runnable> f30344f = null;

        /* renamed from: g  reason: collision with root package name */
        public ThreadFactory f30345g = null;

        /* renamed from: i  reason: collision with root package name */
        public int f30347i = 5;

        public C0324a a(String str) {
            this.f30339a = str;
            return this;
        }

        public C0324a b(int i2) {
            this.f30343e = i2;
            return this;
        }

        public C0324a a(int i2) {
            this.f30340b = i2;
            return this;
        }

        public C0324a a(long j) {
            this.f30341c = j;
            return this;
        }

        public C0324a a(TimeUnit timeUnit) {
            this.f30342d = timeUnit;
            return this;
        }

        public C0324a a(BlockingQueue<Runnable> blockingQueue) {
            this.f30344f = blockingQueue;
            return this;
        }

        public C0324a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.f30346h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.f30345g == null) {
                this.f30345g = new h(this.f30347i, this.f30339a);
            }
            if (this.f30346h == null) {
                this.f30346h = e.f();
            }
            if (this.f30344f == null) {
                this.f30344f = new LinkedBlockingQueue();
            }
            return new a(this.f30339a, this.f30340b, this.f30343e, this.f30341c, this.f30342d, this.f30344f, this.f30345g, this.f30346h);
        }
    }

    public a(String str, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i3, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f30331a = str;
    }

    public String a() {
        return this.f30331a;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!e.e() || TextUtils.isEmpty(this.f30331a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f30331a;
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
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f30331a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() >= 4 || getCorePoolSize() == 0) {
        } else {
            try {
                setCorePoolSize(0);
                setMaximumPoolSize(4);
                u.b("ADThreadPoolExecutor", "afterExecute: reduce ", this.f30331a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
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
        if (!e.e() || TextUtils.isEmpty(this.f30331a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.f30331a;
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
                setMaximumPoolSize(e.f30365a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f30331a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            }
        } else if (queue.size() < 4 || getCorePoolSize() == 4) {
        } else {
            try {
                setMaximumPoolSize(e.f30365a + 4);
                setCorePoolSize(4);
                u.b("ADThreadPoolExecutor", "execute: increase poolType =  ", this.f30331a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
            } catch (Exception e2) {
                u.c("ADThreadPoolExecutor", e2.getMessage());
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.f30331a) || "aidl".equals(this.f30331a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (!"io".equals(this.f30331a) && !"aidl".equals(this.f30331a)) {
            return super.shutdownNow();
        }
        return Collections.emptyList();
    }
}
