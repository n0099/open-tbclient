package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T dqM = null;
    @GuardedBy("this")
    private Throwable ppE = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Rx = false;
    @GuardedBy("this")
    private DataSourceStatus ppD = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> ppF = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Rx;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.ppD != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean eqE() {
        return this.dqM != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.dqM;
    }

    public synchronized boolean eqF() {
        return this.ppD == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable eqG() {
        return this.ppE;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean apn() {
        boolean z = true;
        synchronized (this) {
            if (this.Rx) {
                z = false;
            } else {
                this.Rx = true;
                T t = this.dqM;
                this.dqM = null;
                if (t != null) {
                    bf(t);
                }
                if (!isFinished()) {
                    eqH();
                }
                synchronized (this) {
                    this.ppF.clear();
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
            if (!this.Rx) {
                if (this.ppD == DataSourceStatus.IN_PROGRESS) {
                    this.ppF.add(Pair.create(dVar, executor));
                }
                boolean z = eqE() || isFinished() || eqI();
                if (z) {
                    a(dVar, executor, eqF(), eqI());
                }
            }
        }
    }

    private void eqH() {
        boolean eqF = eqF();
        boolean eqI = eqI();
        Iterator<Pair<d<T>, Executor>> it = this.ppF.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, eqF, eqI);
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

    private synchronized boolean eqI() {
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
            eqH();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(Throwable th) {
        boolean x = x(th);
        if (x) {
            eqH();
        }
        return x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bC(float f) {
        boolean bD = bD(f);
        if (bD) {
            eqJ();
        }
        return bD;
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
                        if (this.Rx || this.ppD != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                bf(t);
                            }
                        } else {
                            if (z) {
                                this.ppD = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.dqM != t) {
                                T t3 = this.dqM;
                                try {
                                    this.dqM = t;
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

    private synchronized boolean x(Throwable th) {
        boolean z;
        if (this.Rx || this.ppD != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.ppD = DataSourceStatus.FAILURE;
            this.ppE = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean bD(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Rx && this.ppD == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void eqJ() {
        Iterator<Pair<d<T>, Executor>> it = this.ppF.iterator();
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
