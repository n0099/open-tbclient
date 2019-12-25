package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> lCO = b.class;
    private volatile int lDQ;
    private final BlockingQueue<Runnable> lDR;
    private final a lDS;
    private final AtomicInteger lDT;
    private final AtomicInteger lDU;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lDQ = i;
        this.lDR = blockingQueue;
        this.lDS = new a();
        this.lDT = new AtomicInteger(0);
        this.lDU = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lDR.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lDR.size());
        }
        int size = this.lDR.size();
        int i = this.lDU.get();
        if (size > i && this.lDU.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lCO, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dij();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dij() {
        int i = this.lDT.get();
        while (i < this.lDQ) {
            int i2 = i + 1;
            if (this.lDT.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lCO, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lDQ));
                this.mExecutor.execute(this.lDS);
                return;
            }
            com.facebook.common.c.a.a(lCO, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lDT.get();
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
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.lDR.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lCO, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lDT.decrementAndGet();
                if (!b.this.lDR.isEmpty()) {
                    b.this.dij();
                } else {
                    com.facebook.common.c.a.a(b.lCO, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lDT.decrementAndGet();
                if (!b.this.lDR.isEmpty()) {
                    b.this.dij();
                } else {
                    com.facebook.common.c.a.a(b.lCO, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
