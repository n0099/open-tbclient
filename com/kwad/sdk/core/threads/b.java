package com.kwad.sdk.core.threads;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class b {
    public static final int a;
    public static final int b;
    public static final int c;
    public static String d;
    public static Map<String, WeakReference<ExecutorService>> e;

    /* loaded from: classes5.dex */
    public interface a {
        @NonNull
        ExecutorService a();
    }

    /* renamed from: com.kwad.sdk.core.threads.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0546b implements a {
        public C0546b() {
        }

        public /* synthetic */ C0546b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService a() {
            return new ThreadPoolExecutor(b.b, b.c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "diskAndHttp"));
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements ThreadFactory {
        public static final AtomicInteger a = new AtomicInteger(1);
        public final String d;
        public final int e;
        public final AtomicInteger c = new AtomicInteger(1);
        public final ThreadGroup b = Thread.currentThread().getThreadGroup();

        public c(int i, String str) {
            this.e = i;
            this.d = "ksad-" + str + a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.b;
            Thread thread = new Thread(threadGroup, runnable, this.d + this.c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.e);
            return thread;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements a {
        public d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService a() {
            return new ThreadPoolExecutor(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(3, "uil-pool-"));
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements a {
        public e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService a() {
            return new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "lruDiskCache"));
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements a {
        public f() {
        }

        public /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService a() {
            return Executors.newSingleThreadExecutor(new c(3, "report-"));
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements a {
        public g() {
        }

        public /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService a() {
            return new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "videoCache"));
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        int i = availableProcessors > 0 ? availableProcessors + 4 : 9;
        b = i;
        c = i;
        d = "GlobalThreadPools";
        e = new ConcurrentHashMap();
    }

    public static ExecutorService a() {
        return a("lruDiskCache", new e((byte) 0));
    }

    @NonNull
    public static ExecutorService a(@GlobalThreadPools.PoolNames String str, @NonNull a aVar) {
        WeakReference<ExecutorService> weakReference = e.get(str);
        if (weakReference == null || weakReference.get() == null) {
            ExecutorService a2 = aVar.a();
            e.put(str, new WeakReference<>(a2));
            return a2;
        }
        return weakReference.get();
    }

    public static synchronized ExecutorService b() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.b.a(d, "forKsImageLoaderTask");
            a2 = a("ksImageLoaderTask", new d((byte) 0));
        }
        return a2;
    }

    public static synchronized ExecutorService c() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.b.a(d, "forKsImageLoaderCachedImages");
            a2 = a("ksImageLoaderTask", new d((byte) 0));
        }
        return a2;
    }

    public static ExecutorService d() {
        com.kwad.sdk.core.d.b.a(d, "forKsImageLoaderTaskDistributor");
        return a("ksImageLoaderTask", new d((byte) 0));
    }

    public static synchronized ExecutorService e() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.b.a(d, "forBaseBatchReporter");
            a2 = a("report", new f((byte) 0));
        }
        return a2;
    }

    public static synchronized ExecutorService f() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.b.a(d, "forAdReportManager");
            a2 = a("report", new f((byte) 0));
        }
        return a2;
    }

    public static ExecutorService g() {
        com.kwad.sdk.core.d.b.a(d, "forBaseNetwork");
        return a("httpIO", new C0546b((byte) 0));
    }

    public static ExecutorService h() {
        com.kwad.sdk.core.d.b.a(d, "forHttpCacheServer");
        return a("videoCache", new g((byte) 0));
    }

    public static ExecutorService i() {
        com.kwad.sdk.core.d.b.a(d, "forAppStatusHelper");
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.core.threads.b.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService j() {
        com.kwad.sdk.core.d.b.a(d, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.b.2
            @Override // com.kwad.sdk.core.threads.b.a
            @NonNull
            public final ExecutorService a() {
                return new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "async"));
            }
        });
    }

    public static ScheduledExecutorService k() {
        com.kwad.sdk.core.d.b.a(d, "forAsyncSchedule");
        ExecutorService a2 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.b.3
            @Override // com.kwad.sdk.core.threads.b.a
            @NonNull
            public final ExecutorService a() {
                return new ScheduledThreadPoolExecutor(1, new c(5, "async-schedule"));
            }
        });
        return a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : new ScheduledThreadPoolExecutor(1, new c(5, "async-schedule"));
    }
}
