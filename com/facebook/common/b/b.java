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
    private static final Class<?> lGY = b.class;
    private volatile int lIa;
    private final BlockingQueue<Runnable> lIb;
    private final a lIc;
    private final AtomicInteger lId;
    private final AtomicInteger lIe;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lIa = i;
        this.lIb = blockingQueue;
        this.lIc = new a();
        this.lId = new AtomicInteger(0);
        this.lIe = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lIb.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lIb.size());
        }
        int size = this.lIb.size();
        int i = this.lIe.get();
        if (size > i && this.lIe.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lGY, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dkz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkz() {
        int i = this.lId.get();
        while (i < this.lIa) {
            int i2 = i + 1;
            if (this.lId.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lGY, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lIa));
                this.mExecutor.execute(this.lIc);
                return;
            }
            com.facebook.common.c.a.a(lGY, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lId.get();
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
                Runnable runnable = (Runnable) b.this.lIb.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lGY, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lId.decrementAndGet();
                if (!b.this.lIb.isEmpty()) {
                    b.this.dkz();
                } else {
                    com.facebook.common.c.a.a(b.lGY, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lId.decrementAndGet();
                if (!b.this.lIb.isEmpty()) {
                    b.this.dkz();
                } else {
                    com.facebook.common.c.a.a(b.lGY, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
