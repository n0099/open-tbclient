package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> ntL = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int nuN;
    private final BlockingQueue<Runnable> nuO;
    private final a nuP;
    private final AtomicInteger nuQ;
    private final AtomicInteger nuR;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.nuN = i;
        this.nuO = blockingQueue;
        this.nuP = new a();
        this.nuQ = new AtomicInteger(0);
        this.nuR = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.nuO.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.nuO.size());
        }
        int size = this.nuO.size();
        int i = this.nuR.get();
        if (size > i && this.nuR.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(ntL, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dSy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSy() {
        int i = this.nuQ.get();
        while (i < this.nuN) {
            int i2 = i + 1;
            if (this.nuQ.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(ntL, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.nuN));
                this.mExecutor.execute(this.nuP);
                return;
            }
            com.facebook.common.c.a.a(ntL, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.nuQ.get();
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
    /* loaded from: classes17.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.nuO.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.ntL, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.nuQ.decrementAndGet();
                if (!b.this.nuO.isEmpty()) {
                    b.this.dSy();
                } else {
                    com.facebook.common.c.a.a(b.ntL, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.nuQ.decrementAndGet();
                if (!b.this.nuO.isEmpty()) {
                    b.this.dSy();
                } else {
                    com.facebook.common.c.a.a(b.ntL, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
