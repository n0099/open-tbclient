package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> pnn = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int poq;
    private final BlockingQueue<Runnable> por;
    private final a pot;
    private final AtomicInteger pou;
    private final AtomicInteger pov;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.poq = i;
        this.por = blockingQueue;
        this.pot = new a();
        this.pou = new AtomicInteger(0);
        this.pov = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.por.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.por.size());
        }
        int size = this.por.size();
        int i = this.pov.get();
        if (size > i && this.pov.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(pnn, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        epZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void epZ() {
        int i = this.pou.get();
        while (i < this.poq) {
            int i2 = i + 1;
            if (this.pou.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(pnn, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.poq));
                this.mExecutor.execute(this.pot);
                return;
            }
            com.facebook.common.c.a.c(pnn, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.pou.get();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.por.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.c(b.pnn, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.pou.decrementAndGet();
                if (!b.this.por.isEmpty()) {
                    b.this.epZ();
                } else {
                    com.facebook.common.c.a.a(b.pnn, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.pou.decrementAndGet();
                if (!b.this.por.isEmpty()) {
                    b.this.epZ();
                } else {
                    com.facebook.common.c.a.a(b.pnn, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
