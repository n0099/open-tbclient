package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes19.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> paD = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int pbE;
    private final BlockingQueue<Runnable> pbF;
    private final a pbG;
    private final AtomicInteger pbH;
    private final AtomicInteger pbI;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.pbE = i;
        this.pbF = blockingQueue;
        this.pbG = new a();
        this.pbH = new AtomicInteger(0);
        this.pbI = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.pbF.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.pbF.size());
        }
        int size = this.pbF.size();
        int i = this.pbI.get();
        if (size > i && this.pbI.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(paD, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        epJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void epJ() {
        int i = this.pbH.get();
        while (i < this.pbE) {
            int i2 = i + 1;
            if (this.pbH.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(paD, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.pbE));
                this.mExecutor.execute(this.pbG);
                return;
            }
            com.facebook.common.c.a.a(paD, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.pbH.get();
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
    /* loaded from: classes19.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.pbF.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.paD, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.pbH.decrementAndGet();
                if (!b.this.pbF.isEmpty()) {
                    b.this.epJ();
                } else {
                    com.facebook.common.c.a.a(b.paD, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.pbH.decrementAndGet();
                if (!b.this.pbF.isEmpty()) {
                    b.this.epJ();
                } else {
                    com.facebook.common.c.a.a(b.paD, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
