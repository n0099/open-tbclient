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
/* loaded from: classes3.dex */
public class b {
    public static String a = "GlobalThreadPools";

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, WeakReference<ExecutorService>> f58053b = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public static class a implements InterfaceC2088b {
        public a() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
        @NonNull
        public ExecutorService a() {
            return Executors.newSingleThreadExecutor();
        }
    }

    /* renamed from: com.kwad.sdk.core.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2088b {
        @NonNull
        ExecutorService a();
    }

    /* loaded from: classes3.dex */
    public static class c implements InterfaceC2088b {
        public c() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp"));
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements ThreadFactory {
        public static final AtomicInteger a = new AtomicInteger(1);

        /* renamed from: d  reason: collision with root package name */
        public final String f58056d;

        /* renamed from: e  reason: collision with root package name */
        public final int f58057e;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f58055c = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final ThreadGroup f58054b = Thread.currentThread().getThreadGroup();

        public d(int i2, String str) {
            this.f58057e = i2;
            this.f58056d = DiskLruCache.KS_THREAD_PREFIX + str + a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f58054b;
            Thread thread = new Thread(threadGroup, runnable, this.f58056d + this.f58055c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f58057e);
            return thread;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements InterfaceC2088b {
        public e() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(3, "uil-pool-"));
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements InterfaceC2088b {
        public f() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache"));
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static String a = "lruDiskCache";

        /* renamed from: b  reason: collision with root package name */
        public static String f58058b = "ksImageLoaderTask";

        /* renamed from: c  reason: collision with root package name */
        public static String f58059c = "report";

        /* renamed from: d  reason: collision with root package name */
        public static String f58060d = "appInstallManager";

        /* renamed from: e  reason: collision with root package name */
        public static String f58061e = "diskAndHttpIO";

        /* renamed from: f  reason: collision with root package name */
        public static String f58062f = "async";

        /* renamed from: g  reason: collision with root package name */
        public static String f58063g = "async-schedule";

        /* renamed from: h  reason: collision with root package name */
        public static String f58064h = "videoCache";
    }

    /* loaded from: classes3.dex */
    public static class h implements InterfaceC2088b {
        public h() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
        @NonNull
        public ExecutorService a() {
            return Executors.newSingleThreadExecutor(new d(3, "report-"));
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements InterfaceC2088b {
        public i() {
        }

        @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
        @NonNull
        public ExecutorService a() {
            return new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, g.f58064h));
        }
    }

    public static ExecutorService a() {
        com.kwad.sdk.core.d.a.a(a, "forDiskLruCache");
        return a(g.a, new f());
    }

    @NonNull
    public static ExecutorService a(String str, @NonNull InterfaceC2088b interfaceC2088b) {
        if (str == null) {
            return interfaceC2088b.a();
        }
        WeakReference<ExecutorService> weakReference = f58053b.get(str);
        if (weakReference == null || weakReference.get() == null) {
            ExecutorService a2 = interfaceC2088b.a();
            f58053b.put(str, new WeakReference<>(a2));
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
            a2 = a(g.f58058b, new e());
        }
        return a2;
    }

    public static synchronized ExecutorService d() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.a.a(a, "forKsImageLoaderCachedImages");
            a2 = a(g.f58058b, new e());
        }
        return a2;
    }

    public static ExecutorService e() {
        com.kwad.sdk.core.d.a.a(a, "forKsImageLoaderTaskDistributor");
        return a(g.f58058b, new e());
    }

    public static synchronized ExecutorService f() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.a.a(a, "forBaseBatchReporter");
            a2 = a(g.f58059c, new h());
        }
        return a2;
    }

    public static synchronized ExecutorService g() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.d.a.a(a, "forAdReportManager");
            a2 = a(g.f58059c, new h());
        }
        return a2;
    }

    public static ExecutorService h() {
        com.kwad.sdk.core.d.a.a(a, "forBaseNetwork");
        return a(g.f58061e, new c());
    }

    public static ExecutorService i() {
        com.kwad.sdk.core.d.a.a(a, "forFileHelper");
        return a(g.f58061e, new c());
    }

    public static ExecutorService j() {
        com.kwad.sdk.core.d.a.a(a, "forAppCacheManager");
        return a(g.f58060d, new a());
    }

    public static ExecutorService k() {
        com.kwad.sdk.core.d.a.a(a, "forAppInstallCheckManager");
        return a(g.f58060d, new a());
    }

    public static ExecutorService l() {
        com.kwad.sdk.core.d.a.a(a, "forHttpCacheServer");
        return a(g.f58064h, new i());
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
        return a(g.f58062f, new InterfaceC2088b() { // from class: com.kwad.sdk.core.i.b.2
            @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
            @NonNull
            public ExecutorService a() {
                return new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, g.f58062f));
            }
        });
    }

    public static ScheduledExecutorService o() {
        com.kwad.sdk.core.d.a.a(a, "forAsyncSchedule");
        ExecutorService a2 = a(g.f58063g, new InterfaceC2088b() { // from class: com.kwad.sdk.core.i.b.3
            @Override // com.kwad.sdk.core.i.b.InterfaceC2088b
            @NonNull
            public ExecutorService a() {
                return new ScheduledThreadPoolExecutor(1, new d(5, g.f58063g));
            }
        });
        return a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : new ScheduledThreadPoolExecutor(1, new d(5, g.f58063g));
    }
}
