package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes17.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T cKL = null;
    @GuardedBy("this")
    private Throwable nwa = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Qk = false;
    @GuardedBy("this")
    private DataSourceStatus nvZ = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> nwb = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Qk;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.nvZ != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dTd() {
        return this.cKL != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cKL;
    }

    public synchronized boolean dTe() {
        return this.nvZ == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dTf() {
        return this.nwa;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean aik() {
        boolean z = true;
        synchronized (this) {
            if (this.Qk) {
                z = false;
            } else {
                this.Qk = true;
                T t = this.cKL;
                this.cKL = null;
                if (t != null) {
                    aX(t);
                }
                if (!isFinished()) {
                    dTg();
                }
                synchronized (this) {
                    this.nwb.clear();
                }
            }
        }
        return z;
    }

    protected void aX(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.Qk) {
                if (this.nvZ == DataSourceStatus.IN_PROGRESS) {
                    this.nwb.add(Pair.create(dVar, executor));
                }
                boolean z = dTd() || isFinished() || dTh();
                if (z) {
                    a(dVar, executor, dTe(), dTh());
                }
            }
        }
    }

    private void dTg() {
        boolean dTe = dTe();
        boolean dTh = dTh();
        Iterator<Pair<d<T>, Executor>> it = this.nwb.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dTe, dTh);
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

    private synchronized boolean dTh() {
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
            dTg();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Throwable th) {
        boolean y = y(th);
        if (y) {
            dTg();
        }
        return y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aJ(float f) {
        boolean aK = aK(f);
        if (aK) {
            dTi();
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
                        if (this.Qk || this.nvZ != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aX(t);
                            }
                        } else {
                            if (z) {
                                this.nvZ = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cKL != t) {
                                T t3 = this.cKL;
                                try {
                                    this.cKL = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aX(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aX(t2);
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
        if (this.Qk || this.nvZ != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.nvZ = DataSourceStatus.FAILURE;
            this.nwa = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aK(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Qk && this.nvZ == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dTi() {
        Iterator<Pair<d<T>, Executor>> it = this.nwb.iterator();
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
