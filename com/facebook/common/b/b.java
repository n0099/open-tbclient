package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> prR = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int psS;
    private final BlockingQueue<Runnable> psT;
    private final a psU;
    private final AtomicInteger psV;
    private final AtomicInteger psW;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.psS = i;
        this.psT = blockingQueue;
        this.psU = new a();
        this.psV = new AtomicInteger(0);
        this.psW = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.psT.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.psT.size());
        }
        int size = this.psT.size();
        int i = this.psW.get();
        if (size > i && this.psW.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(prR, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        etT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void etT() {
        int i = this.psV.get();
        while (i < this.psS) {
            int i2 = i + 1;
            if (this.psV.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(prR, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.psS));
                this.mExecutor.execute(this.psU);
                return;
            }
            com.facebook.common.c.a.c(prR, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.psV.get();
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
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.psT.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.c(b.prR, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.psV.decrementAndGet();
                if (!b.this.psT.isEmpty()) {
                    b.this.etT();
                } else {
                    com.facebook.common.c.a.a(b.prR, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.psV.decrementAndGet();
                if (!b.this.psT.isEmpty()) {
                    b.this.etT();
                } else {
                    com.facebook.common.c.a.a(b.prR, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
