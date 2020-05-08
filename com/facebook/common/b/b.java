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
    private static final Class<?> lQq = b.class;
    private volatile int lRr;
    private final BlockingQueue<Runnable> lRs;
    private final a lRt;
    private final AtomicInteger lRu;
    private final AtomicInteger lRv;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lRr = i;
        this.lRs = blockingQueue;
        this.lRt = new a();
        this.lRu = new AtomicInteger(0);
        this.lRv = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lRs.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lRs.size());
        }
        int size = this.lRs.size();
        int i = this.lRv.get();
        if (size > i && this.lRv.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lQq, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dmP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmP() {
        int i = this.lRu.get();
        while (i < this.lRr) {
            int i2 = i + 1;
            if (this.lRu.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lQq, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lRr));
                this.mExecutor.execute(this.lRt);
                return;
            }
            com.facebook.common.c.a.a(lQq, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lRu.get();
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
                Runnable runnable = (Runnable) b.this.lRs.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lQq, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lRu.decrementAndGet();
                if (!b.this.lRs.isEmpty()) {
                    b.this.dmP();
                } else {
                    com.facebook.common.c.a.a(b.lQq, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lRu.decrementAndGet();
                if (!b.this.lRs.isEmpty()) {
                    b.this.dmP();
                } else {
                    com.facebook.common.c.a.a(b.lQq, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
