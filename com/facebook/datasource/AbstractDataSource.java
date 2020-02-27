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
    private T bDg = null;
    @GuardedBy("this")
    private Throwable lJm = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean vA = false;
    @GuardedBy("this")
    private DataSourceStatus lJl = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> lJn = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.vA;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.lJl != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean dld() {
        return this.bDg != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.bDg;
    }

    public synchronized boolean dle() {
        return this.lJl == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable dlf() {
        return this.lJm;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean OB() {
        boolean z = true;
        synchronized (this) {
            if (this.vA) {
                z = false;
            } else {
                this.vA = true;
                T t = this.bDg;
                this.bDg = null;
                if (t != null) {
                    aX(t);
                }
                if (!isFinished()) {
                    dlg();
                }
                synchronized (this) {
                    this.lJn.clear();
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
            if (!this.vA) {
                if (this.lJl == DataSourceStatus.IN_PROGRESS) {
                    this.lJn.add(Pair.create(dVar, executor));
                }
                boolean z = dld() || isFinished() || dlh();
                if (z) {
                    a(dVar, executor, dle(), dlh());
                }
            }
        }
    }

    private void dlg() {
        boolean dle = dle();
        boolean dlh = dlh();
        Iterator<Pair<d<T>, Executor>> it = this.lJn.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, dle, dlh);
        }
    }

    private void a(final d<T> dVar, Executor executor, final boolean z, final boolean z2) {
        executor.execute(new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    dVar.onFailure(AbstractDataSource.this);
                } else if (z2) {
                    dVar.onCancellation(AbstractDataSource.this);
                } else {
                    dVar.onNewResult(AbstractDataSource.this);
                }
            }
        });
    }

    private synchronized boolean dlh() {
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
            dlg();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(Throwable th) {
        boolean v = v(th);
        if (v) {
            dlg();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bj(float f) {
        boolean bk = bk(f);
        if (bk) {
            dli();
        }
        return bk;
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
                        if (this.vA || this.lJl != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aX(t);
                            }
                        } else {
                            if (z) {
                                this.lJl = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.bDg != t) {
                                T t3 = this.bDg;
                                try {
                                    this.bDg = t;
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

    private synchronized boolean v(Throwable th) {
        boolean z;
        if (this.vA || this.lJl != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.lJl = DataSourceStatus.FAILURE;
            this.lJm = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean bk(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.vA && this.lJl == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void dli() {
        Iterator<Pair<d<T>, Executor>> it = this.lJn.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            final d dVar = (d) next.first;
            ((Executor) next.second).execute(new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.2
                @Override // java.lang.Runnable
                public void run() {
                    dVar.onProgressUpdate(AbstractDataSource.this);
                }
            });
        }
    }
}
