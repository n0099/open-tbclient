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
    private T cWO = null;
    @GuardedBy("this")
    private Throwable nLt = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean QB = false;
    @GuardedBy("this")
    private DataSourceStatus nLs = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> nLu = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.QB;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.nLs != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dWO() {
        return this.cWO != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cWO;
    }

    public synchronized boolean dWP() {
        return this.nLs == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dWQ() {
        return this.nLt;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean akV() {
        boolean z = true;
        synchronized (this) {
            if (this.QB) {
                z = false;
            } else {
                this.QB = true;
                T t = this.cWO;
                this.cWO = null;
                if (t != null) {
                    ba(t);
                }
                if (!isFinished()) {
                    dWR();
                }
                synchronized (this) {
                    this.nLu.clear();
                }
            }
        }
        return z;
    }

    protected void ba(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.QB) {
                if (this.nLs == DataSourceStatus.IN_PROGRESS) {
                    this.nLu.add(Pair.create(dVar, executor));
                }
                boolean z = dWO() || isFinished() || dWS();
                if (z) {
                    a(dVar, executor, dWP(), dWS());
                }
            }
        }
    }

    private void dWR() {
        boolean dWP = dWP();
        boolean dWS = dWS();
        Iterator<Pair<d<T>, Executor>> it = this.nLu.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dWP, dWS);
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

    private synchronized boolean dWS() {
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
            dWR();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Throwable th) {
        boolean y = y(th);
        if (y) {
            dWR();
        }
        return y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aP(float f) {
        boolean aQ = aQ(f);
        if (aQ) {
            dWT();
        }
        return aQ;
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
                        if (this.QB || this.nLs != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                ba(t);
                            }
                        } else {
                            if (z) {
                                this.nLs = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cWO != t) {
                                T t3 = this.cWO;
                                try {
                                    this.cWO = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            ba(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                ba(t2);
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
        if (this.QB || this.nLs != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.nLs = DataSourceStatus.FAILURE;
            this.nLt = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aQ(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.QB && this.nLs == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dWT() {
        Iterator<Pair<d<T>, Executor>> it = this.nLu.iterator();
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
