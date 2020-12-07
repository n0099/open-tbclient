package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes19.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T dqC = null;
    @GuardedBy("this")
    private Throwable pcR = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Rw = false;
    @GuardedBy("this")
    private DataSourceStatus pcQ = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> pcS = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Rw;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.pcQ != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean eqo() {
        return this.dqC != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.dqC;
    }

    public synchronized boolean eqp() {
        return this.pcQ == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable eqq() {
        return this.pcR;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean arP() {
        boolean z = true;
        synchronized (this) {
            if (this.Rw) {
                z = false;
            } else {
                this.Rw = true;
                T t = this.dqC;
                this.dqC = null;
                if (t != null) {
                    bf(t);
                }
                if (!isFinished()) {
                    eqr();
                }
                synchronized (this) {
                    this.pcS.clear();
                }
            }
        }
        return z;
    }

    protected void bf(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.Rw) {
                if (this.pcQ == DataSourceStatus.IN_PROGRESS) {
                    this.pcS.add(Pair.create(dVar, executor));
                }
                boolean z = eqo() || isFinished() || eqs();
                if (z) {
                    a(dVar, executor, eqp(), eqs());
                }
            }
        }
    }

    private void eqr() {
        boolean eqp = eqp();
        boolean eqs = eqs();
        Iterator<Pair<d<T>, Executor>> it = this.pcS.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, eqp, eqs);
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

    private synchronized boolean eqs() {
        boolean z;
        if (isClosed()) {
            z = isFinished() ? false : true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(@Nullable T t, boolean z) {
        boolean c = c(t, z);
        if (c) {
            eqr();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Throwable th) {
        boolean y = y(th);
        if (y) {
            eqr();
        }
        return y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bq(float f) {
        boolean br = br(f);
        if (br) {
            eqt();
        }
        return br;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [282=4] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(@Nullable T t, boolean z) {
        boolean z2;
        T t2;
        try {
            try {
                synchronized (this) {
                    try {
                        if (this.Rw || this.pcQ != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                bf(t);
                            }
                        } else {
                            if (z) {
                                this.pcQ = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.dqC != t) {
                                T t3 = this.dqC;
                                try {
                                    this.dqC = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            bf(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                bf(t2);
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

    private synchronized boolean y(Throwable th) {
        boolean z;
        if (this.Rw || this.pcQ != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.pcQ = DataSourceStatus.FAILURE;
            this.pcR = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean br(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Rw && this.pcQ == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void eqt() {
        Iterator<Pair<d<T>, Executor>> it = this.pcS.iterator();
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
