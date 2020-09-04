package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T cIL = null;
    @GuardedBy("this")
    private Throwable nma = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean PQ = false;
    @GuardedBy("this")
    private DataSourceStatus nlZ = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> nmb = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.PQ;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.nlZ != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dPf() {
        return this.cIL != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cIL;
    }

    public synchronized boolean dPg() {
        return this.nlZ == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dPh() {
        return this.nma;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean ahA() {
        boolean z = true;
        synchronized (this) {
            if (this.PQ) {
                z = false;
            } else {
                this.PQ = true;
                T t = this.cIL;
                this.cIL = null;
                if (t != null) {
                    aV(t);
                }
                if (!isFinished()) {
                    dPi();
                }
                synchronized (this) {
                    this.nmb.clear();
                }
            }
        }
        return z;
    }

    protected void aV(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.PQ) {
                if (this.nlZ == DataSourceStatus.IN_PROGRESS) {
                    this.nmb.add(Pair.create(dVar, executor));
                }
                boolean z = dPf() || isFinished() || dPj();
                if (z) {
                    a(dVar, executor, dPg(), dPj());
                }
            }
        }
    }

    private void dPi() {
        boolean dPg = dPg();
        boolean dPj = dPj();
        Iterator<Pair<d<T>, Executor>> it = this.nmb.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dPg, dPj);
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

    private synchronized boolean dPj() {
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
            dPi();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Throwable th) {
        boolean y = y(th);
        if (y) {
            dPi();
        }
        return y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aJ(float f) {
        boolean aK = aK(f);
        if (aK) {
            dPk();
        }
        return aK;
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
                        if (this.PQ || this.nlZ != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aV(t);
                            }
                        } else {
                            if (z) {
                                this.nlZ = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cIL != t) {
                                T t3 = this.cIL;
                                try {
                                    this.cIL = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aV(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aV(t2);
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
        if (this.PQ || this.nlZ != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.nlZ = DataSourceStatus.FAILURE;
            this.nma = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aK(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.PQ && this.nlZ == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dPk() {
        Iterator<Pair<d<T>, Executor>> it = this.nmb.iterator();
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
