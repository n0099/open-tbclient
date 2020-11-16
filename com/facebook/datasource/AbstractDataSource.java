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
    private T djD = null;
    @GuardedBy("this")
    private Throwable oNJ = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean QD = false;
    @GuardedBy("this")
    private DataSourceStatus oNI = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> oNK = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.QD;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.oNI != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean ekz() {
        return this.djD != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.djD;
    }

    public synchronized boolean ekA() {
        return this.oNI == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable ekB() {
        return this.oNJ;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean aoH() {
        boolean z = true;
        synchronized (this) {
            if (this.QD) {
                z = false;
            } else {
                this.QD = true;
                T t = this.djD;
                this.djD = null;
                if (t != null) {
                    bf(t);
                }
                if (!isFinished()) {
                    ekC();
                }
                synchronized (this) {
                    this.oNK.clear();
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
            if (!this.QD) {
                if (this.oNI == DataSourceStatus.IN_PROGRESS) {
                    this.oNK.add(Pair.create(dVar, executor));
                }
                boolean z = ekz() || isFinished() || ekD();
                if (z) {
                    a(dVar, executor, ekA(), ekD());
                }
            }
        }
    }

    private void ekC() {
        boolean ekA = ekA();
        boolean ekD = ekD();
        Iterator<Pair<d<T>, Executor>> it = this.oNK.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, ekA, ekD);
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

    private synchronized boolean ekD() {
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
            ekC();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Throwable th) {
        boolean y = y(th);
        if (y) {
            ekC();
        }
        return y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bp(float f) {
        boolean bq = bq(f);
        if (bq) {
            ekE();
        }
        return bq;
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
                        if (this.QD || this.oNI != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                bf(t);
                            }
                        } else {
                            if (z) {
                                this.oNI = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.djD != t) {
                                T t3 = this.djD;
                                try {
                                    this.djD = t;
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

    private synchronized boolean y(Throwable th) {
        boolean z;
        if (this.QD || this.oNI != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.oNI = DataSourceStatus.FAILURE;
            this.oNJ = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean bq(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.QD && this.oNI == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void ekE() {
        Iterator<Pair<d<T>, Executor>> it = this.oNK.iterator();
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
