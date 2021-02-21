package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T dsY = null;
    @GuardedBy("this")
    private Throwable pAo = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Rv = false;
    @GuardedBy("this")
    private DataSourceStatus pAn = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> pAp = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Rv;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.pAn != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean etf() {
        return this.dsY != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.dsY;
    }

    public synchronized boolean etg() {
        return this.pAn == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable eth() {
        return this.pAo;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean apL() {
        boolean z = true;
        synchronized (this) {
            if (this.Rv) {
                z = false;
            } else {
                this.Rv = true;
                T t = this.dsY;
                this.dsY = null;
                if (t != null) {
                    bf(t);
                }
                if (!isFinished()) {
                    eti();
                }
                synchronized (this) {
                    this.pAp.clear();
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
            if (!this.Rv) {
                if (this.pAn == DataSourceStatus.IN_PROGRESS) {
                    this.pAp.add(Pair.create(dVar, executor));
                }
                boolean z = etf() || isFinished() || etj();
                if (z) {
                    a(dVar, executor, etg(), etj());
                }
            }
        }
    }

    private void eti() {
        boolean etg = etg();
        boolean etj = etj();
        Iterator<Pair<d<T>, Executor>> it = this.pAp.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, etg, etj);
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

    private synchronized boolean etj() {
        boolean z;
        if (isClosed()) {
            z = isFinished() ? false : true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(@Nullable T t, boolean z) {
        boolean d = d(t, z);
        if (d) {
            eti();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            eti();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bF(float f) {
        boolean bG = bG(f);
        if (bG) {
            etk();
        }
        return bG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [282=4] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(@Nullable T t, boolean z) {
        boolean z2;
        T t2;
        try {
            try {
                synchronized (this) {
                    try {
                        if (this.Rv || this.pAn != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                bf(t);
                            }
                        } else {
                            if (z) {
                                this.pAn = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.dsY != t) {
                                T t3 = this.dsY;
                                try {
                                    this.dsY = t;
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

    private synchronized boolean u(Throwable th) {
        boolean z;
        if (this.Rv || this.pAn != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.pAn = DataSourceStatus.FAILURE;
            this.pAo = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean bG(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Rv && this.pAn == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void etk() {
        Iterator<Pair<d<T>, Executor>> it = this.pAp.iterator();
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
