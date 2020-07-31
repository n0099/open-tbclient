package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T cAy = null;
    @GuardedBy("this")
    private Throwable mRM = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Pi = false;
    @GuardedBy("this")
    private DataSourceStatus mRL = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> mRN = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
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
        return this.mRL != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dCV() {
        return this.cAy != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cAy;
    }

    public synchronized boolean dCW() {
        return this.mRL == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dCX() {
        return this.mRM;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean abo() {
        boolean z = true;
        synchronized (this) {
            if (this.Pi) {
                z = false;
            } else {
                this.Pi = true;
                T t = this.cAy;
                this.cAy = null;
                if (t != null) {
                    aT(t);
                }
                if (!isFinished()) {
                    dCY();
                }
                synchronized (this) {
                    this.mRN.clear();
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
                if (this.mRL == DataSourceStatus.IN_PROGRESS) {
                    this.mRN.add(Pair.create(dVar, executor));
                }
                boolean z = dCV() || isFinished() || dCZ();
                if (z) {
                    a(dVar, executor, dCW(), dCZ());
                }
            }
        }
    }

    private void dCY() {
        boolean dCW = dCW();
        boolean dCZ = dCZ();
        Iterator<Pair<d<T>, Executor>> it = this.mRN.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dCW, dCZ);
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

    private synchronized boolean dCZ() {
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
            dCY();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y(Throwable th) {
        boolean z = z(th);
        if (z) {
            dCY();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aD(float f) {
        boolean aE = aE(f);
        if (aE) {
            dDa();
        }
        return aE;
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
                        if (this.Pi || this.mRL != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aT(t);
                            }
                        } else {
                            if (z) {
                                this.mRL = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cAy != t) {
                                T t3 = this.cAy;
                                try {
                                    this.cAy = t;
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

    private synchronized boolean z(Throwable th) {
        boolean z;
        if (this.Pi || this.mRL != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.mRL = DataSourceStatus.FAILURE;
            this.mRM = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aE(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Pi && this.mRL == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dDa() {
        Iterator<Pair<d<T>, Executor>> it = this.mRN.iterator();
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
