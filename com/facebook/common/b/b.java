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
    private static final Class<?> oLv = b.class;
    private final Executor mExecutor;
    private final String mName;
    private final AtomicInteger oMA;
    private volatile int oMw;
    private final BlockingQueue<Runnable> oMx;
    private final a oMy;
    private final AtomicInteger oMz;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.oMw = i;
        this.oMx = blockingQueue;
        this.oMy = new a();
        this.oMz = new AtomicInteger(0);
        this.oMA = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.oMx.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.oMx.size());
        }
        int size = this.oMx.size();
        int i = this.oMA.get();
        if (size > i && this.oMA.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(oLv, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        ejU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejU() {
        int i = this.oMz.get();
        while (i < this.oMw) {
            int i2 = i + 1;
            if (this.oMz.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(oLv, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.oMw));
                this.mExecutor.execute(this.oMy);
                return;
            }
            com.facebook.common.c.a.a(oLv, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.oMz.get();
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
                Runnable runnable = (Runnable) b.this.oMx.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.oLv, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.oMz.decrementAndGet();
                if (!b.this.oMx.isEmpty()) {
                    b.this.ejU();
                } else {
                    com.facebook.common.c.a.a(b.oLv, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.oMz.decrementAndGet();
                if (!b.this.oMx.isEmpty()) {
                    b.this.ejU();
                } else {
                    com.facebook.common.c.a.a(b.oLv, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
