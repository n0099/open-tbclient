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
    private static final Class<?> pxC = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int pyD;
    private final BlockingQueue<Runnable> pyE;
    private final a pyF;
    private final AtomicInteger pyG;
    private final AtomicInteger pyH;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.pyD = i;
        this.pyE = blockingQueue;
        this.pyF = new a();
        this.pyG = new AtomicInteger(0);
        this.pyH = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.pyE.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.pyE.size());
        }
        int size = this.pyE.size();
        int i = this.pyH.get();
        if (size > i && this.pyH.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(pxC, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        ess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ess() {
        int i = this.pyG.get();
        while (i < this.pyD) {
            int i2 = i + 1;
            if (this.pyG.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(pxC, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.pyD));
                this.mExecutor.execute(this.pyF);
                return;
            }
            com.facebook.common.c.a.c(pxC, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.pyG.get();
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
                Runnable runnable = (Runnable) b.this.pyE.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.c(b.pxC, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.pyG.decrementAndGet();
                if (!b.this.pyE.isEmpty()) {
                    b.this.ess();
                } else {
                    com.facebook.common.c.a.a(b.pxC, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.pyG.decrementAndGet();
                if (!b.this.pyE.isEmpty()) {
                    b.this.ess();
                } else {
                    com.facebook.common.c.a.a(b.pxC, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
