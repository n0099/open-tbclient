package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> mPz = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int mQA;
    private final BlockingQueue<Runnable> mQB;
    private final a mQC;
    private final AtomicInteger mQD;
    private final AtomicInteger mQE;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mQA = i;
        this.mQB = blockingQueue;
        this.mQC = new a();
        this.mQD = new AtomicInteger(0);
        this.mQE = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.mQB.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mQB.size());
        }
        int size = this.mQB.size();
        int i = this.mQE.get();
        if (size > i && this.mQE.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(mPz, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dCr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCr() {
        int i = this.mQD.get();
        while (i < this.mQA) {
            int i2 = i + 1;
            if (this.mQD.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(mPz, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mQA));
                this.mExecutor.execute(this.mQC);
                return;
            }
            com.facebook.common.c.a.a(mPz, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mQD.get();
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
    /* loaded from: classes12.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.mQB.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.mPz, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.mQD.decrementAndGet();
                if (!b.this.mQB.isEmpty()) {
                    b.this.dCr();
                } else {
                    com.facebook.common.c.a.a(b.mPz, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.mQD.decrementAndGet();
                if (!b.this.mQB.isEmpty()) {
                    b.this.dCr();
                } else {
                    com.facebook.common.c.a.a(b.mPz, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
