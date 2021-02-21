package com.kwad.sdk.glide.load.engine.b;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
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
/* loaded from: classes3.dex */
public final class a implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private static final long f10181a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f10182b;
    private final ExecutorService c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kwad.sdk.glide.load.engine.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class ThreadFactoryC1133a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final b f10183a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f10184b;
        private final String c;
        private int d;

        ThreadFactoryC1133a(String str, b bVar, boolean z) {
            this.c = str;
            this.f10183a = bVar;
            this.f10184b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-" + this.c + "-thread-" + this.d) { // from class: com.kwad.sdk.glide.load.engine.b.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    if (ThreadFactoryC1133a.this.f10184b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        ThreadFactoryC1133a.this.f10183a.a(th);
                    }
                }
            };
            this.d++;
            return thread;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f10186a = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.1
            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final b f10187b = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.2
            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        };
        public static final b c = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.3
            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        public static final b d = f10187b;

        void a(Throwable th);
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.c = executorService;
    }

    public static a a() {
        return a(1, "disk-cache", b.d);
    }

    public static a a(int i, b bVar) {
        return new a(new ThreadPoolExecutor(0, i, f10181a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC1133a("animation", bVar, true)));
    }

    public static a a(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC1133a(str, bVar, true)));
    }

    public static a b() {
        return b(e(), "source", b.d);
    }

    public static a b(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC1133a(str, bVar, false)));
    }

    public static a c() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f10181a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC1133a("source-unlimited", b.d, false)));
    }

    public static a d() {
        return a(e() >= 4 ? 2 : 1, b.d);
    }

    public static int e() {
        if (f10182b == 0) {
            f10182b = Math.min(4, com.kwad.sdk.glide.load.engine.b.b.a());
        }
        return f10182b;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) {
        return this.c.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return this.c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return (T) this.c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return (T) this.c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.c.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.c.submit(callable);
    }

    public String toString() {
        return this.c.toString();
    }
}
