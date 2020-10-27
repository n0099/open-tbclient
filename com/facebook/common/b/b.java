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
    private static final Class<?> oAy = b.class;
    private final Executor mExecutor;
    private final String mName;
    private final BlockingQueue<Runnable> oBA;
    private final a oBB;
    private final AtomicInteger oBC;
    private final AtomicInteger oBD;
    private volatile int oBz;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.oBz = i;
        this.oBA = blockingQueue;
        this.oBB = new a();
        this.oBC = new AtomicInteger(0);
        this.oBD = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.oBA.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.oBA.size());
        }
        int size = this.oBA.size();
        int i = this.oBD.get();
        if (size > i && this.oBD.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(oAy, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        egh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egh() {
        int i = this.oBC.get();
        while (i < this.oBz) {
            int i2 = i + 1;
            if (this.oBC.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(oAy, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.oBz));
                this.mExecutor.execute(this.oBB);
                return;
            }
            com.facebook.common.c.a.a(oAy, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.oBC.get();
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
                Runnable runnable = (Runnable) b.this.oBA.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.oAy, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.oBC.decrementAndGet();
                if (!b.this.oBA.isEmpty()) {
                    b.this.egh();
                } else {
                    com.facebook.common.c.a.a(b.oAy, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.oBC.decrementAndGet();
                if (!b.this.oBA.isEmpty()) {
                    b.this.egh();
                } else {
                    com.facebook.common.c.a.a(b.oAy, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
