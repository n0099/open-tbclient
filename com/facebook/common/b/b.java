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
    private static final Class<?> lQm = b.class;
    private volatile int lRn;
    private final BlockingQueue<Runnable> lRo;
    private final a lRp;
    private final AtomicInteger lRq;
    private final AtomicInteger lRr;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lRn = i;
        this.lRo = blockingQueue;
        this.lRp = new a();
        this.lRq = new AtomicInteger(0);
        this.lRr = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lRo.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lRo.size());
        }
        int size = this.lRo.size();
        int i = this.lRr.get();
        if (size > i && this.lRr.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lQm, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dmS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmS() {
        int i = this.lRq.get();
        while (i < this.lRn) {
            int i2 = i + 1;
            if (this.lRq.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lQm, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lRn));
                this.mExecutor.execute(this.lRp);
                return;
            }
            com.facebook.common.c.a.a(lQm, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lRq.get();
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
                Runnable runnable = (Runnable) b.this.lRo.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lQm, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lRq.decrementAndGet();
                if (!b.this.lRo.isEmpty()) {
                    b.this.dmS();
                } else {
                    com.facebook.common.c.a.a(b.lQm, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lRq.decrementAndGet();
                if (!b.this.lRo.isEmpty()) {
                    b.this.dmS();
                } else {
                    com.facebook.common.c.a.a(b.lQm, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
