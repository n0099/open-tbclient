package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T aGC = null;
    @GuardedBy("this")
    private Throwable jTl = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Fx = false;
    @GuardedBy("this")
    private DataSourceStatus jTk = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> jTm = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Fx;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.jTk != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean cCf() {
        return this.aGC != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.aGC;
    }

    public synchronized boolean cCg() {
        return this.jTk == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable cCh() {
        return this.jTl;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean Ab() {
        boolean z = true;
        synchronized (this) {
            if (this.Fx) {
                z = false;
            } else {
                this.Fx = true;
                T t = this.aGC;
                this.aGC = null;
                if (t != null) {
                    aG(t);
                }
                if (!isFinished()) {
                    cCi();
                }
                synchronized (this) {
                    this.jTm.clear();
                }
            }
        }
        return z;
    }

    protected void aG(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.Fx) {
                if (this.jTk == DataSourceStatus.IN_PROGRESS) {
                    this.jTm.add(Pair.create(dVar, executor));
                }
                boolean z = cCf() || isFinished() || cCj();
                if (z) {
                    a(dVar, executor, cCg(), cCj());
                }
            }
        }
    }

    private void cCi() {
        boolean cCg = cCg();
        boolean cCj = cCj();
        Iterator<Pair<d<T>, Executor>> it = this.jTm.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, cCg, cCj);
        }
    }

    private void a(final d<T> dVar, Executor executor, final boolean z, final boolean z2) {
        executor.execute(new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    dVar.e(AbstractDataSource.this);
                } else if (z2) {
                    dVar.b(AbstractDataSource.this);
                } else {
                    dVar.d(AbstractDataSource.this);
                }
            }
        });
    }

    private synchronized boolean cCj() {
        boolean z;
        if (isClosed()) {
            z = isFinished() ? false : true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(@Nullable T t, boolean z) {
        boolean b = b(t, z);
        if (b) {
            cCi();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            cCi();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aW(float f) {
        boolean aX = aX(f);
        if (aX) {
            cCk();
        }
        return aX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=4] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(@Nullable T t, boolean z) {
        boolean z2;
        T t2;
        try {
            try {
                synchronized (this) {
                    try {
                        if (this.Fx || this.jTk != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aG(t);
                            }
                        } else {
                            if (z) {
                                this.jTk = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.aGC != t) {
                                T t3 = this.aGC;
                                try {
                                    this.aGC = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aG(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aG(t2);
                            }
                        }
                        return z2;
                    } catch (Throwable th3) {
                        th = th3;
                        t = null;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                t = null;
                if (t != null) {
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private synchronized boolean u(Throwable th) {
        boolean z;
        if (this.Fx || this.jTk != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.jTk = DataSourceStatus.FAILURE;
            this.jTl = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aX(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Fx && this.jTk == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void cCk() {
        Iterator<Pair<d<T>, Executor>> it = this.jTm.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            final d dVar = (d) next.first;
            ((Executor) next.second).execute(new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.2
                @Override // java.lang.Runnable
                public void run() {
                    dVar.f(AbstractDataSource.this);
                }
            });
        }
    }
}
