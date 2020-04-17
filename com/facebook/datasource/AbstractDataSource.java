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
    private T cbR = null;
    @GuardedBy("this")
    private Throwable lSA = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean Ot = false;
    @GuardedBy("this")
    private DataSourceStatus lSz = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> lSB = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.Ot;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.lSz != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dny() {
        return this.cbR != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cbR;
    }

    public synchronized boolean dnz() {
        return this.lSz == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dnA() {
        return this.lSA;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean Wv() {
        boolean z = true;
        synchronized (this) {
            if (this.Ot) {
                z = false;
            } else {
                this.Ot = true;
                T t = this.cbR;
                this.cbR = null;
                if (t != null) {
                    aN(t);
                }
                if (!isFinished()) {
                    dnB();
                }
                synchronized (this) {
                    this.lSB.clear();
                }
            }
        }
        return z;
    }

    protected void aN(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.Ot) {
                if (this.lSz == DataSourceStatus.IN_PROGRESS) {
                    this.lSB.add(Pair.create(dVar, executor));
                }
                boolean z = dny() || isFinished() || dnC();
                if (z) {
                    a(dVar, executor, dnz(), dnC());
                }
            }
        }
    }

    private void dnB() {
        boolean dnz = dnz();
        boolean dnC = dnC();
        Iterator<Pair<d<T>, Executor>> it = this.lSB.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dnz, dnC);
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

    private synchronized boolean dnC() {
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
            dnB();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(Throwable th) {
        boolean A = A(th);
        if (A) {
            dnB();
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean az(float f) {
        boolean aA = aA(f);
        if (aA) {
            dnD();
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
                        if (this.Ot || this.lSz != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aN(t);
                            }
                        } else {
                            if (z) {
                                this.lSz = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cbR != t) {
                                T t3 = this.cbR;
                                try {
                                    this.cbR = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aN(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aN(t2);
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
        if (this.Ot || this.lSz != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.lSz = DataSourceStatus.FAILURE;
            this.lSA = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aA(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.Ot && this.lSz == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dnD() {
        Iterator<Pair<d<T>, Executor>> it = this.lSB.iterator();
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
