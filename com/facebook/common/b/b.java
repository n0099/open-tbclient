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
    private static final Class<?> lGr = b.class;
    private volatile int lHt;
    private final BlockingQueue<Runnable> lHu;
    private final a lHv;
    private final AtomicInteger lHw;
    private final AtomicInteger lHx;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lHt = i;
        this.lHu = blockingQueue;
        this.lHv = new a();
        this.lHw = new AtomicInteger(0);
        this.lHx = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lHu.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lHu.size());
        }
        int size = this.lHu.size();
        int i = this.lHx.get();
        if (size > i && this.lHx.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lGr, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        djm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djm() {
        int i = this.lHw.get();
        while (i < this.lHt) {
            int i2 = i + 1;
            if (this.lHw.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lGr, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lHt));
                this.mExecutor.execute(this.lHv);
                return;
            }
            com.facebook.common.c.a.a(lGr, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lHw.get();
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
                Runnable runnable = (Runnable) b.this.lHu.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lGr, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lHw.decrementAndGet();
                if (!b.this.lHu.isEmpty()) {
                    b.this.djm();
                } else {
                    com.facebook.common.c.a.a(b.lGr, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lHw.decrementAndGet();
                if (!b.this.lHu.isEmpty()) {
                    b.this.djm();
                } else {
                    com.facebook.common.c.a.a(b.lGr, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
