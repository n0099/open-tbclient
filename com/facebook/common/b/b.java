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
    private static final Class<?> lHa = b.class;
    private volatile int lIc;
    private final BlockingQueue<Runnable> lId;
    private final a lIe;
    private final AtomicInteger lIf;
    private final AtomicInteger lIg;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lIc = i;
        this.lId = blockingQueue;
        this.lIe = new a();
        this.lIf = new AtomicInteger(0);
        this.lIg = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lId.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lId.size());
        }
        int size = this.lId.size();
        int i = this.lIg.get();
        if (size > i && this.lIg.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lHa, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dkB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkB() {
        int i = this.lIf.get();
        while (i < this.lIc) {
            int i2 = i + 1;
            if (this.lIf.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lHa, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lIc));
                this.mExecutor.execute(this.lIe);
                return;
            }
            com.facebook.common.c.a.a(lHa, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lIf.get();
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
                Runnable runnable = (Runnable) b.this.lId.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lHa, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lIf.decrementAndGet();
                if (!b.this.lId.isEmpty()) {
                    b.this.dkB();
                } else {
                    com.facebook.common.c.a.a(b.lHa, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lIf.decrementAndGet();
                if (!b.this.lId.isEmpty()) {
                    b.this.dkB();
                } else {
                    com.facebook.common.c.a.a(b.lHa, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
