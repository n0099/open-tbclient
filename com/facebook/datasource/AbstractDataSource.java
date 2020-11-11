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
    private T dlk = null;
    @GuardedBy("this")
    private Throwable oMf = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean QC = false;
    @GuardedBy("this")
    private DataSourceStatus oMe = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> oMg = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.QC;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.oMe != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean ekB() {
        return this.dlk != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.dlk;
    }

    public synchronized boolean ekC() {
        return this.oMe == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable ekD() {
        return this.oMf;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean apq() {
        boolean z = true;
        synchronized (this) {
            if (this.QC) {
                z = false;
            } else {
                this.QC = true;
                T t = this.dlk;
                this.dlk = null;
                if (t != null) {
                    be(t);
                }
                if (!isFinished()) {
                    ekE();
                }
                synchronized (this) {
                    this.oMg.clear();
                }
            }
        }
        return z;
    }

    protected void be(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.QC) {
                if (this.oMe == DataSourceStatus.IN_PROGRESS) {
                    this.oMg.add(Pair.create(dVar, executor));
                }
                boolean z = ekB() || isFinished() || ekF();
                if (z) {
                    a(dVar, executor, ekC(), ekF());
                }
            }
        }
    }

    private void ekE() {
        boolean ekC = ekC();
        boolean ekF = ekF();
        Iterator<Pair<d<T>, Executor>> it = this.oMg.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, ekC, ekF);
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

    private synchronized boolean ekF() {
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
            ekE();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Throwable th) {
        boolean y = y(th);
        if (y) {
            ekE();
        }
        return y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bi(float f) {
        boolean bj = bj(f);
        if (bj) {
            ekG();
        }
        return bj;
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
                        if (this.QC || this.oMe != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                be(t);
                            }
                        } else {
                            if (z) {
                                this.oMe = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.dlk != t) {
                                T t3 = this.dlk;
                                try {
                                    this.dlk = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            be(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                be(t2);
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
        if (this.QC || this.oMe != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.oMe = DataSourceStatus.FAILURE;
            this.oMf = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean bj(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.QC && this.oMe == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void ekG() {
        Iterator<Pair<d<T>, Executor>> it = this.oMg.iterator();
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
