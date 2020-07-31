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
    private static final Class<?> mPx = b.class;
    private final Executor mExecutor;
    private final String mName;
    private final a mQA;
    private final AtomicInteger mQB;
    private final AtomicInteger mQC;
    private volatile int mQy;
    private final BlockingQueue<Runnable> mQz;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mQy = i;
        this.mQz = blockingQueue;
        this.mQA = new a();
        this.mQB = new AtomicInteger(0);
        this.mQC = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.mQz.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mQz.size());
        }
        int size = this.mQz.size();
        int i = this.mQC.get();
        if (size > i && this.mQC.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(mPx, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dCq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCq() {
        int i = this.mQB.get();
        while (i < this.mQy) {
            int i2 = i + 1;
            if (this.mQB.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(mPx, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mQy));
                this.mExecutor.execute(this.mQA);
                return;
            }
            com.facebook.common.c.a.a(mPx, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mQB.get();
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
                Runnable runnable = (Runnable) b.this.mQz.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.mPx, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.mQB.decrementAndGet();
                if (!b.this.mQz.isEmpty()) {
                    b.this.dCq();
                } else {
                    com.facebook.common.c.a.a(b.mPx, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.mQB.decrementAndGet();
                if (!b.this.mQz.isEmpty()) {
                    b.this.dCq();
                } else {
                    com.facebook.common.c.a.a(b.mPx, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
