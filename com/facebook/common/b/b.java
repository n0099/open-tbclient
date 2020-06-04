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
    private static final Class<?> mls = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int mmt;
    private final BlockingQueue<Runnable> mmu;
    private final a mmv;
    private final AtomicInteger mmw;
    private final AtomicInteger mmx;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mmt = i;
        this.mmu = blockingQueue;
        this.mmv = new a();
        this.mmw = new AtomicInteger(0);
        this.mmx = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.mmu.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mmu.size());
        }
        int size = this.mmu.size();
        int i = this.mmx.get();
        if (size > i && this.mmx.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(mls, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dux();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dux() {
        int i = this.mmw.get();
        while (i < this.mmt) {
            int i2 = i + 1;
            if (this.mmw.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(mls, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mmt));
                this.mExecutor.execute(this.mmv);
                return;
            }
            com.facebook.common.c.a.a(mls, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mmw.get();
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
                Runnable runnable = (Runnable) b.this.mmu.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.mls, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.mmw.decrementAndGet();
                if (!b.this.mmu.isEmpty()) {
                    b.this.dux();
                } else {
                    com.facebook.common.c.a.a(b.mls, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.mmw.decrementAndGet();
                if (!b.this.mmu.isEmpty()) {
                    b.this.dux();
                } else {
                    com.facebook.common.c.a.a(b.mls, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
