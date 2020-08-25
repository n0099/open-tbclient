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
    private T cIH = null;
    @GuardedBy("this")
    private Throwable nlI = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean PQ = false;
    @GuardedBy("this")
    private DataSourceStatus nlH = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> nlJ = new ConcurrentLinkedQueue<>();

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
        return this.nlH != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dOW() {
        return this.cIH != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cIH;
    }

    public synchronized boolean dOX() {
        return this.nlH == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dOY() {
        return this.nlI;
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
                T t = this.cIH;
                this.cIH = null;
                if (t != null) {
                    aV(t);
                }
                if (!isFinished()) {
                    dOZ();
                }
                synchronized (this) {
                    this.nlJ.clear();
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
                if (this.nlH == DataSourceStatus.IN_PROGRESS) {
                    this.nlJ.add(Pair.create(dVar, executor));
                }
                boolean z = dOW() || isFinished() || dPa();
                if (z) {
                    a(dVar, executor, dOX(), dPa());
                }
            }
        }
    }

    private void dOZ() {
        boolean dOX = dOX();
        boolean dPa = dPa();
        Iterator<Pair<d<T>, Executor>> it = this.nlJ.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dOX, dPa);
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

    private synchronized boolean dPa() {
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
            dOZ();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Throwable th) {
        boolean y = y(th);
        if (y) {
            dOZ();
        }
        return y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aJ(float f) {
        boolean aK = aK(f);
        if (aK) {
            dPb();
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
                        if (this.PQ || this.nlH != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aV(t);
                            }
                        } else {
                            if (z) {
                                this.nlH = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cIH != t) {
                                T t3 = this.cIH;
                                try {
                                    this.cIH = t;
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
        if (this.PQ || this.nlH != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.nlH = DataSourceStatus.FAILURE;
            this.nlI = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aK(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.PQ && this.nlH == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dPb() {
        Iterator<Pair<d<T>, Executor>> it = this.nlJ.iterator();
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
