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
/* loaded from: classes8.dex */
public final class b {
    public static String TAG;
    public static final int adA;
    public static Map<String, WeakReference<ExecutorService>> adB;
    public static final int ady;
    public static final int adz;

    /* loaded from: classes8.dex */
    public interface a {
        @NonNull
        ExecutorService vu();
    }

    /* renamed from: com.kwad.sdk.core.threads.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0637b implements a {
        public C0637b() {
        }

        public /* synthetic */ C0637b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService vu() {
            return new ThreadPoolExecutor(b.adz, b.adA, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "diskAndHttp"));
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements ThreadFactory {
        public static final AtomicInteger poolNumber = new AtomicInteger(1);
        public final String namePrefix;
        public final int threadPriority;
        public final AtomicInteger threadNumber = new AtomicInteger(1);
        public final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public c(int i, String str) {
            this.threadPriority = i;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements a {
        public d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService vu() {
            return new ThreadPoolExecutor(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(3, "uil-pool-"));
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements a {
        public e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService vu() {
            return new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "lruDiskCache"));
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements a {
        public f() {
        }

        public /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService vu() {
            return Executors.newSingleThreadExecutor(new c(3, "report-"));
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements a {
        public g() {
        }

        public /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService vu() {
            return new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "videoCache"));
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ady = availableProcessors;
        int i = availableProcessors > 0 ? availableProcessors + 4 : 9;
        adz = i;
        adA = i;
        TAG = "GlobalThreadPools";
        adB = new ConcurrentHashMap();
    }

    @NonNull
    public static ExecutorService a(@GlobalThreadPools.PoolNames String str, @NonNull a aVar) {
        WeakReference<ExecutorService> weakReference = adB.get(str);
        if (weakReference == null || weakReference.get() == null) {
            ExecutorService vu = aVar.vu();
            adB.put(str, new WeakReference<>(vu));
            return vu;
        }
        return weakReference.get();
    }

    public static ExecutorService vh() {
        return a("lruDiskCache", new e((byte) 0));
    }

    public static synchronized ExecutorService vi() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.e.b.d(TAG, "forKsImageLoaderTask");
            a2 = a("ksImageLoaderTask", new d((byte) 0));
        }
        return a2;
    }

    public static synchronized ExecutorService vj() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.e.b.d(TAG, "forKsImageLoaderCachedImages");
            a2 = a("ksImageLoaderTask", new d((byte) 0));
        }
        return a2;
    }

    public static ExecutorService vk() {
        com.kwad.sdk.core.e.b.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("ksImageLoaderTask", new d((byte) 0));
    }

    public static synchronized ExecutorService vl() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.e.b.d(TAG, "forBaseBatchReporter");
            a2 = a("report", new f((byte) 0));
        }
        return a2;
    }

    public static synchronized ExecutorService vm() {
        ExecutorService a2;
        synchronized (b.class) {
            com.kwad.sdk.core.e.b.d(TAG, "forAdReportManager");
            a2 = a("report", new f((byte) 0));
        }
        return a2;
    }

    public static ExecutorService vn() {
        com.kwad.sdk.core.e.b.d(TAG, "forBaseNetwork");
        return a("httpIO", new C0637b((byte) 0));
    }

    public static ExecutorService vo() {
        com.kwad.sdk.core.e.b.d(TAG, "forHttpCacheServer");
        return a("videoCache", new g((byte) 0));
    }

    public static ExecutorService vp() {
        com.kwad.sdk.core.e.b.d(TAG, "forAppStatusHelper");
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.core.threads.b.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService vq() {
        com.kwad.sdk.core.e.b.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.b.2
            @Override // com.kwad.sdk.core.threads.b.a
            @NonNull
            public final ExecutorService vu() {
                return new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(5, "async"));
            }
        });
    }

    public static ScheduledExecutorService vr() {
        com.kwad.sdk.core.e.b.d(TAG, "forAsyncSchedule");
        ExecutorService a2 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.b.3
            @Override // com.kwad.sdk.core.threads.b.a
            @NonNull
            public final ExecutorService vu() {
                return new ScheduledThreadPoolExecutor(1, new c(5, "async-schedule"));
            }
        });
        return a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : new ScheduledThreadPoolExecutor(1, new c(5, "async-schedule"));
    }
}
