package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T duA = null;
    @GuardedBy("this")
    private Throwable pCt = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean SU = false;
    @GuardedBy("this")
    private DataSourceStatus pCs = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> pCu = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.SU;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.pCs != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean eto() {
        return this.duA != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.duA;
    }

    public synchronized boolean etp() {
        return this.pCs == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable etq() {
        return this.pCt;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean apO() {
        boolean z = true;
        synchronized (this) {
            if (this.SU) {
                z = false;
            } else {
                this.SU = true;
                T t = this.duA;
                this.duA = null;
                if (t != null) {
                    bh(t);
                }
                if (!isFinished()) {
                    etr();
                }
                synchronized (this) {
                    this.pCu.clear();
                }
            }
        }
        return z;
    }

    protected void bh(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.SU) {
                if (this.pCs == DataSourceStatus.IN_PROGRESS) {
                    this.pCu.add(Pair.create(dVar, executor));
                }
                boolean z = eto() || isFinished() || ets();
                if (z) {
                    a(dVar, executor, etp(), ets());
                }
            }
        }
    }

    private void etr() {
        boolean etp = etp();
        boolean ets = ets();
        Iterator<Pair<d<T>, Executor>> it = this.pCu.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, etp, ets);
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

    private synchronized boolean ets() {
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
            etr();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            etr();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bJ(float f) {
        boolean bK = bK(f);
        if (bK) {
            ett();
        }
        return bK;
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
                        if (this.SU || this.pCs != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                bh(t);
                            }
                        } else {
                            if (z) {
                                this.pCs = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.duA != t) {
                                T t3 = this.duA;
                                try {
                                    this.duA = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            bh(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                bh(t2);
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
        if (this.SU || this.pCs != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.pCs = DataSourceStatus.FAILURE;
            this.pCt = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean bK(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.SU && this.pCs == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void ett() {
        Iterator<Pair<d<T>, Executor>> it = this.pCu.iterator();
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
