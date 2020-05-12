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
    private T cbX = null;
    @GuardedBy("this")
    private Throwable lSE = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Ox = false;
    @GuardedBy("this")
    private DataSourceStatus lSD = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> lSF = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Ox;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.lSD != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dnw() {
        return this.cbX != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cbX;
    }

    public synchronized boolean dnx() {
        return this.lSD == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dny() {
        return this.lSE;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean Wu() {
        boolean z = true;
        synchronized (this) {
            if (this.Ox) {
                z = false;
            } else {
                this.Ox = true;
                T t = this.cbX;
                this.cbX = null;
                if (t != null) {
                    aO(t);
                }
                if (!isFinished()) {
                    dnz();
                }
                synchronized (this) {
                    this.lSF.clear();
                }
            }
        }
        return z;
    }

    protected void aO(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.Ox) {
                if (this.lSD == DataSourceStatus.IN_PROGRESS) {
                    this.lSF.add(Pair.create(dVar, executor));
                }
                boolean z = dnw() || isFinished() || dnA();
                if (z) {
                    a(dVar, executor, dnx(), dnA());
                }
            }
        }
    }

    private void dnz() {
        boolean dnx = dnx();
        boolean dnA = dnA();
        Iterator<Pair<d<T>, Executor>> it = this.lSF.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dnx, dnA);
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

    private synchronized boolean dnA() {
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
            dnz();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(Throwable th) {
        boolean A = A(th);
        if (A) {
            dnz();
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean az(float f) {
        boolean aA = aA(f);
        if (aA) {
            dnB();
        }
        return aA;
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
                        if (this.Ox || this.lSD != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aO(t);
                            }
                        } else {
                            if (z) {
                                this.lSD = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cbX != t) {
                                T t3 = this.cbX;
                                try {
                                    this.cbX = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aO(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aO(t2);
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
        if (this.Ox || this.lSD != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.lSD = DataSourceStatus.FAILURE;
            this.lSE = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aA(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Ox && this.lSD == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dnB() {
        Iterator<Pair<d<T>, Executor>> it = this.lSF.iterator();
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
