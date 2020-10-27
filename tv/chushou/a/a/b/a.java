package tv.chushou.a.a.b;

import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public final class a {
    private static volatile a qcF;
    private final ExecutorService executorService = new b(new C1089a(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 30, TimeUnit.SECONDS, new SynchronousQueue(), new tv.chushou.a.a.b.b("DefaultTaskExecutor", 0)));

    public static a eDJ() {
        if (qcF != null) {
            return qcF;
        }
        synchronized (a.class) {
            if (qcF == null) {
                qcF = new a();
            }
        }
        return qcF;
    }

    private a() {
    }

    public Future<?> M(@NonNull Runnable runnable) {
        return this.executorService.submit(runnable);
    }

    /* loaded from: classes6.dex */
    private static class b extends AbstractExecutorService {
        private final ExecutorService e;

        b(ExecutorService executorService) {
            this.e = (ExecutorService) tv.chushou.a.a.a.c.checkNotNull(executorService);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.e.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Shoule never call this on the single instance");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Shoule never call this on the single instance");
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            throw new UnsupportedOperationException("Shoule never call this on the single instance");
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        @NonNull
        public Future<?> submit(Runnable runnable) {
            return this.e.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        @NonNull
        public <T> Future<T> submit(Callable<T> callable) {
            return this.e.submit(callable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        @NonNull
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.e.submit(runnable, t);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        @NonNull
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.e.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        @NonNull
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.e.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        @NonNull
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return (T) this.e.invokeAny(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.e.invokeAny(collection, j, timeUnit);
        }
    }

    /* renamed from: tv.chushou.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C1089a extends ThreadPoolExecutor {
        C1089a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                try {
                    ((Future) runnable).get();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (CancellationException e2) {
                    th = e2;
                } catch (ExecutionException e3) {
                    th = e3.getCause();
                }
            }
            if (th != null) {
                tv.chushou.a.a.c.a.eDK().e(null, "DefaultTaskExecutor: Running task appeared exception! Thread [" + Thread.currentThread().getName() + "]", th);
            }
        }
    }
}
