package com.kwad.sdk.core.i;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache;
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
public class b {
    public static String a = "GlobalThreadPools";
    public static Map<String, WeakReference<ExecutorService>> b = new ConcurrentHashMap();

    /* loaded from: classes5.dex */
    public static class a implements InterfaceC0309b {
        public a() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
        @NonNull
        public ExecutorService a() {
            return Executors.newSingleThreadExecutor();
        }
    }

    /* renamed from: com.kwad.sdk.core.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0309b {
        @NonNull
        ExecutorService a();
    }

    /* loaded from: classes5.dex */
    public static class c implements InterfaceC0309b {
        public c() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp"));
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements ThreadFactory {
        public static final AtomicInteger a = new AtomicInteger(1);
        public final String d;
        public final int e;
        public final AtomicInteger c = new AtomicInteger(1);
        public final ThreadGroup b = Thread.currentThread().getThreadGroup();

        public d(int i, String str) {
            this.e = i;
            this.d = DiskLruCache.KS_THREAD_PREFIX + str + a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
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
    public static class e implements InterfaceC0309b {
        public e() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(3, "uil-pool-"));
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements InterfaceC0309b {
        public f() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache"));
        }
    }

    /* loaded from: classes5.dex */
    public static class g {
        public static String a = "lruDiskCache";
        public static String b = "ksImageLoaderTask";
        public static String c = "report";
        public static String d = "appInstallManager";
        public static String e = "diskAndHttpIO";
        public static String f = "async";
        public static String g = "async-schedule";
        public static String h = "videoCache";
    }

    /* loaded from: classes5.dex */
    public static class h implements InterfaceC0309b {
        public h() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
        @NonNull
        public ExecutorService a() {
            return Executors.newSingleThreadExecutor(new d(3, "report-"));
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements InterfaceC0309b {
        public i() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, g.h));
        }
    }

    public static ExecutorService a() {
        com.kwad.sdk.core.d.a.a(a, "forDiskLruCache");
        return a(g.a, new f());
    }

    @NonNull
    public static ExecutorService a(String str, @NonNull InterfaceC0309b interfaceC0309b) {
        if (str == null) {
            return interfaceC0309b.a();
        }
        WeakReference<ExecutorService> weakReference = b.get(str);
        if (weakReference == null || weakReference.get() == null) {
            ExecutorService a2 = interfaceC0309b.a();
            b.put(str, new WeakReference<>(a2));
            return a2;
        }
        return weakReference.get();
    }

    public static ExecutorService b() {
        return a(g.a, new f());
    }

    public static synchronized ExecutorService c() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.a.a(a, "forKsImageLoaderTask");
            a2 = a(g.b, new e());
        }
        return a2;
    }

    public static synchronized ExecutorService d() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.a.a(a, "forKsImageLoaderCachedImages");
            a2 = a(g.b, new e());
        }
        return a2;
    }

    public static ExecutorService e() {
        com.kwad.sdk.core.d.a.a(a, "forKsImageLoaderTaskDistributor");
        return a(g.b, new e());
    }

    public static synchronized ExecutorService f() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.a.a(a, "forBaseBatchReporter");
            a2 = a(g.c, new h());
        }
        return a2;
    }

    public static synchronized ExecutorService g() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.a.a(a, "forAdReportManager");
            a2 = a(g.c, new h());
        }
        return a2;
    }

    public static ExecutorService h() {
        com.kwad.sdk.core.d.a.a(a, "forBaseNetwork");
        return a(g.e, new c());
    }

    public static ExecutorService i() {
        com.kwad.sdk.core.d.a.a(a, "forFileHelper");
        return a(g.e, new c());
    }

    public static ExecutorService j() {
        com.kwad.sdk.core.d.a.a(a, "forAppCacheManager");
        return a(g.d, new a());
    }

    public static ExecutorService k() {
        com.kwad.sdk.core.d.a.a(a, "forAppInstallCheckManager");
        return a(g.d, new a());
    }

    public static ExecutorService l() {
        com.kwad.sdk.core.d.a.a(a, "forHttpCacheServer");
        return a(g.h, new i());
    }

    public static ExecutorService m() {
        com.kwad.sdk.core.d.a.a(a, "forAppStatusHelper");
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.core.i.b.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService n() {
        com.kwad.sdk.core.d.a.a(a, "forAsync");
        return a(g.f, new InterfaceC0309b() { // from class: com.kwad.sdk.core.i.b.2
            @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
            @NonNull
            public ExecutorService a() {
                return new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, g.f));
            }
        });
    }

    public static ScheduledExecutorService o() {
        com.kwad.sdk.core.d.a.a(a, "forAsyncSchedule");
        ExecutorService a2 = a(g.g, new InterfaceC0309b() { // from class: com.kwad.sdk.core.i.b.3
            @Override // com.kwad.sdk.core.i.b.InterfaceC0309b
            @NonNull
            public ExecutorService a() {
                return new ScheduledThreadPoolExecutor(1, new d(5, g.g));
            }
        });
        return a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : new ScheduledThreadPoolExecutor(1, new d(5, g.g));
    }
}
