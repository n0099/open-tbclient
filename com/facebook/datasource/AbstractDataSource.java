package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T aEF = null;
    @GuardedBy("this")
    private Throwable jBa = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean HM = false;
    @GuardedBy("this")
    private DataSourceStatus jAZ = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> jBb = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.HM;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.jAZ != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean cuo() {
        return this.aEF != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.aEF;
    }

    public synchronized boolean cup() {
        return this.jAZ == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable cuq() {
        return this.jBa;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean zf() {
        boolean z = true;
        synchronized (this) {
            if (this.HM) {
                z = false;
            } else {
                this.HM = true;
                T t = this.aEF;
                this.aEF = null;
                if (t != null) {
                    aI(t);
                }
                if (!isFinished()) {
                    cur();
                }
                synchronized (this) {
                    this.jBb.clear();
                }
            }
        }
        return z;
    }

    protected void aI(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.HM) {
                if (this.jAZ == DataSourceStatus.IN_PROGRESS) {
                    this.jBb.add(Pair.create(dVar, executor));
                }
                boolean z = cuo() || isFinished() || cus();
                if (z) {
                    a(dVar, executor, cup(), cus());
                }
            }
        }
    }

    private void cur() {
        boolean cup = cup();
        boolean cus = cus();
        Iterator<Pair<d<T>, Executor>> it = this.jBb.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, cup, cus);
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

    private synchronized boolean cus() {
        boolean z;
        if (isClosed()) {
            z = isFinished() ? false : true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(@Nullable T t, boolean z) {
        boolean b = b(t, z);
        if (b) {
            cur();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(Throwable th) {
        boolean v = v(th);
        if (v) {
            cur();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aS(float f) {
        boolean aT = aT(f);
        if (aT) {
            cut();
        }
        return aT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=4] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(@Nullable T t, boolean z) {
        boolean z2;
        T t2;
        try {
            try {
                synchronized (this) {
                    try {
                        if (this.HM || this.jAZ != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aI(t);
                            }
                        } else {
                            if (z) {
                                this.jAZ = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.aEF != t) {
                                T t3 = this.aEF;
                                try {
                                    this.aEF = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aI(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aI(t2);
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
        if (this.HM || this.jAZ != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.jAZ = DataSourceStatus.FAILURE;
            this.jBa = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aT(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.HM && this.jAZ == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void cut() {
        Iterator<Pair<d<T>, Executor>> it = this.jBb.iterator();
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
