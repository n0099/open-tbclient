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
    private static final Class<?> paF = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int pbG;
    private final BlockingQueue<Runnable> pbH;
    private final a pbI;
    private final AtomicInteger pbJ;
    private final AtomicInteger pbK;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.pbG = i;
        this.pbH = blockingQueue;
        this.pbI = new a();
        this.pbJ = new AtomicInteger(0);
        this.pbK = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.pbH.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.pbH.size());
        }
        int size = this.pbH.size();
        int i = this.pbK.get();
        if (size > i && this.pbK.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(paF, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        epK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void epK() {
        int i = this.pbJ.get();
        while (i < this.pbG) {
            int i2 = i + 1;
            if (this.pbJ.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(paF, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.pbG));
                this.mExecutor.execute(this.pbI);
                return;
            }
            com.facebook.common.c.a.a(paF, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.pbJ.get();
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
                Runnable runnable = (Runnable) b.this.pbH.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.paF, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.pbJ.decrementAndGet();
                if (!b.this.pbH.isEmpty()) {
                    b.this.epK();
                } else {
                    com.facebook.common.c.a.a(b.paF, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.pbJ.decrementAndGet();
                if (!b.this.pbH.isEmpty()) {
                    b.this.epK();
                } else {
                    com.facebook.common.c.a.a(b.paF, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
