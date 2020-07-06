package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T crp = null;
    @GuardedBy("this")
    private Throwable mJJ = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Pi = false;
    @GuardedBy("this")
    private DataSourceStatus mJI = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> mJK = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Pi;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.mJI != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dzJ() {
        return this.crp != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.crp;
    }

    public synchronized boolean dzK() {
        return this.mJI == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dzL() {
        return this.mJJ;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean aam() {
        boolean z = true;
        synchronized (this) {
            if (this.Pi) {
                z = false;
            } else {
                this.Pi = true;
                T t = this.crp;
                this.crp = null;
                if (t != null) {
                    aT(t);
                }
                if (!isFinished()) {
                    dzM();
                }
                synchronized (this) {
                    this.mJK.clear();
                }
            }
        }
        return z;
    }

    protected void aT(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.Pi) {
                if (this.mJI == DataSourceStatus.IN_PROGRESS) {
                    this.mJK.add(Pair.create(dVar, executor));
                }
                boolean z = dzJ() || isFinished() || dzN();
                if (z) {
                    a(dVar, executor, dzK(), dzN());
                }
            }
        }
    }

    private void dzM() {
        boolean dzK = dzK();
        boolean dzN = dzN();
        Iterator<Pair<d<T>, Executor>> it = this.mJK.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dzK, dzN);
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

    private synchronized boolean dzN() {
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
            dzM();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(Throwable th) {
        boolean A = A(th);
        if (A) {
            dzM();
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aE(float f) {
        boolean aF = aF(f);
        if (aF) {
            dzO();
        }
        return aF;
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
                        if (this.Pi || this.mJI != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aT(t);
                            }
                        } else {
                            if (z) {
                                this.mJI = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.crp != t) {
                                T t3 = this.crp;
                                try {
                                    this.crp = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aT(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aT(t2);
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

    private synchronized boolean A(Throwable th) {
        boolean z;
        if (this.Pi || this.mJI != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.mJI = DataSourceStatus.FAILURE;
            this.mJJ = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aF(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Pi && this.mJI == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dzO() {
        Iterator<Pair<d<T>, Executor>> it = this.mJK.iterator();
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
