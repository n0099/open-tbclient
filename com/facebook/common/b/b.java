package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> oJR = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int oKS;
    private final BlockingQueue<Runnable> oKT;
    private final a oKU;
    private final AtomicInteger oKV;
    private final AtomicInteger oKW;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.oKS = i;
        this.oKT = blockingQueue;
        this.oKU = new a();
        this.oKV = new AtomicInteger(0);
        this.oKW = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.oKT.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.oKT.size());
        }
        int size = this.oKT.size();
        int i = this.oKW.get();
        if (size > i && this.oKW.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(oJR, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        ejW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejW() {
        int i = this.oKV.get();
        while (i < this.oKS) {
            int i2 = i + 1;
            if (this.oKV.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(oJR, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.oKS));
                this.mExecutor.execute(this.oKU);
                return;
            }
            com.facebook.common.c.a.a(oJR, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.oKV.get();
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
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.oKT.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.oJR, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.oKV.decrementAndGet();
                if (!b.this.oKT.isEmpty()) {
                    b.this.ejW();
                } else {
                    com.facebook.common.c.a.a(b.oJR, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.oKV.decrementAndGet();
                if (!b.this.oKT.isEmpty()) {
                    b.this.ejW();
                } else {
                    com.facebook.common.c.a.a(b.oJR, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
