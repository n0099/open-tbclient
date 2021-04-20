package com.kwad.sdk.glide.load.engine.b;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class a implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    public static final long f35748a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f35749b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f35750c;

    /* renamed from: com.kwad.sdk.glide.load.engine.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class ThreadFactoryC0432a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final b f35751a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35752b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35753c;

        /* renamed from: d  reason: collision with root package name */
        public int f35754d;

        public ThreadFactoryC0432a(String str, b bVar, boolean z) {
            this.f35753c = str;
            this.f35751a = bVar;
            this.f35752b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-" + this.f35753c + "-thread-" + this.f35754d) { // from class: com.kwad.sdk.glide.load.engine.b.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    if (ThreadFactoryC0432a.this.f35752b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        ThreadFactoryC0432a.this.f35751a.a(th);
                    }
                }
            };
            this.f35754d = this.f35754d + 1;
            return thread;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f35756a = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.1
            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final b f35757b = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.2
            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable(GlideExecutor.TAG, 6)) {
                    return;
                }
                Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", th);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public static final b f35758c = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.3
            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final b f35759d = f35757b;

        void a(Throwable th);
    }

    @VisibleForTesting
    public a(ExecutorService executorService) {
        this.f35750c = executorService;
    }

    public static a a() {
        return a(1, GlideExecutor.DEFAULT_DISK_CACHE_EXECUTOR_NAME, b.f35759d);
    }

    public static a a(int i, b bVar) {
        return new a(new ThreadPoolExecutor(0, i, f35748a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0432a("animation", bVar, true)));
    }

    public static a a(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0432a(str, bVar, true)));
    }

    public static a b() {
        return b(e(), "source", b.f35759d);
    }

    public static a b(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0432a(str, bVar, false)));
    }

    public static a c() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f35748a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0432a(GlideExecutor.DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, b.f35759d, false)));
    }

    public static a d() {
        return a(e() >= 4 ? 2 : 1, b.f35759d);
    }

    public static int e() {
        if (f35749b == 0) {
            f35749b = Math.min(4, com.kwad.sdk.glide.load.engine.b.b.a());
        }
        return f35749b;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) {
        return this.f35750c.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f35750c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.f35750c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return this.f35750c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return (T) this.f35750c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return (T) this.f35750c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f35750c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f35750c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f35750c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f35750c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f35750c.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f35750c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f35750c.submit(callable);
    }

    public String toString() {
        return this.f35750c.toString();
    }
}
