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
    private static final Class<?> mki = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int mlj;
    private final BlockingQueue<Runnable> mlk;
    private final a mll;
    private final AtomicInteger mlm;
    private final AtomicInteger mln;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mlj = i;
        this.mlk = blockingQueue;
        this.mll = new a();
        this.mlm = new AtomicInteger(0);
        this.mln = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.mlk.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mlk.size());
        }
        int size = this.mlk.size();
        int i = this.mln.get();
        if (size > i && this.mln.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(mki, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        duj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duj() {
        int i = this.mlm.get();
        while (i < this.mlj) {
            int i2 = i + 1;
            if (this.mlm.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(mki, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mlj));
                this.mExecutor.execute(this.mll);
                return;
            }
            com.facebook.common.c.a.a(mki, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mlm.get();
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
                Runnable runnable = (Runnable) b.this.mlk.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.mki, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.mlm.decrementAndGet();
                if (!b.this.mlk.isEmpty()) {
                    b.this.duj();
                } else {
                    com.facebook.common.c.a.a(b.mki, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.mlm.decrementAndGet();
                if (!b.this.mlk.isEmpty()) {
                    b.this.duj();
                } else {
                    com.facebook.common.c.a.a(b.mki, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
