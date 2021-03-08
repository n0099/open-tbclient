package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> pAh = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int pBi;
    private final BlockingQueue<Runnable> pBj;
    private final a pBk;
    private final AtomicInteger pBl;
    private final AtomicInteger pBm;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.pBi = i;
        this.pBj = blockingQueue;
        this.pBk = new a();
        this.pBl = new AtomicInteger(0);
        this.pBm = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.pBj.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.pBj.size());
        }
        int size = this.pBj.size();
        int i = this.pBm.get();
        if (size > i && this.pBm.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(pAh, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        esJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void esJ() {
        int i = this.pBl.get();
        while (i < this.pBi) {
            int i2 = i + 1;
            if (this.pBl.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(pAh, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.pBi));
                this.mExecutor.execute(this.pBk);
                return;
            }
            com.facebook.common.c.a.a(pAh, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.pBl.get();
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
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.pBj.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.pAh, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.pBl.decrementAndGet();
                if (!b.this.pBj.isEmpty()) {
                    b.this.esJ();
                } else {
                    com.facebook.common.c.a.a(b.pAh, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.pBl.decrementAndGet();
                if (!b.this.pBj.isEmpty()) {
                    b.this.esJ();
                } else {
                    com.facebook.common.c.a.a(b.pAh, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
