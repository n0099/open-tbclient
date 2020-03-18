package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> lIR = b.class;
    private volatile int lJT;
    private final BlockingQueue<Runnable> lJU;
    private final a lJV;
    private final AtomicInteger lJW;
    private final AtomicInteger lJX;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lJT = i;
        this.lJU = blockingQueue;
        this.lJV = new a();
        this.lJW = new AtomicInteger(0);
        this.lJX = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lJU.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lJU.size());
        }
        int size = this.lJU.size();
        int i = this.lJX.get();
        if (size > i && this.lJX.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lIR, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dkZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkZ() {
        int i = this.lJW.get();
        while (i < this.lJT) {
            int i2 = i + 1;
            if (this.lJW.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lIR, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lJT));
                this.mExecutor.execute(this.lJV);
                return;
            }
            com.facebook.common.c.a.a(lIR, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lJW.get();
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
    /* loaded from: classes13.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.lJU.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lIR, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lJW.decrementAndGet();
                if (!b.this.lJU.isEmpty()) {
                    b.this.dkZ();
                } else {
                    com.facebook.common.c.a.a(b.lIR, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lJW.decrementAndGet();
                if (!b.this.lJU.isEmpty()) {
                    b.this.dkZ();
                } else {
                    com.facebook.common.c.a.a(b.lIR, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
