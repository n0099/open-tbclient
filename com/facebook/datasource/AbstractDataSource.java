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
    private T aEE = null;
    @GuardedBy("this")
    private Throwable jAP = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean HM = false;
    @GuardedBy("this")
    private DataSourceStatus jAO = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> jAQ = new ConcurrentLinkedQueue<>();

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
        return this.jAO != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean cub() {
        return this.aEE != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.aEE;
    }

    public synchronized boolean cuc() {
        return this.jAO == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable cud() {
        return this.jAP;
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
                T t = this.aEE;
                this.aEE = null;
                if (t != null) {
                    aH(t);
                }
                if (!isFinished()) {
                    cue();
                }
                synchronized (this) {
                    this.jAQ.clear();
                }
            }
        }
        return z;
    }

    protected void aH(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.HM) {
                if (this.jAO == DataSourceStatus.IN_PROGRESS) {
                    this.jAQ.add(Pair.create(dVar, executor));
                }
                boolean z = cub() || isFinished() || cuf();
                if (z) {
                    a(dVar, executor, cuc(), cuf());
                }
            }
        }
    }

    private void cue() {
        boolean cuc = cuc();
        boolean cuf = cuf();
        Iterator<Pair<d<T>, Executor>> it = this.jAQ.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, cuc, cuf);
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

    private synchronized boolean cuf() {
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
            cue();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(Throwable th) {
        boolean v = v(th);
        if (v) {
            cue();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aS(float f) {
        boolean aT = aT(f);
        if (aT) {
            cug();
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
                        if (this.HM || this.jAO != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aH(t);
                            }
                        } else {
                            if (z) {
                                this.jAO = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.aEE != t) {
                                T t3 = this.aEE;
                                try {
                                    this.aEE = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aH(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aH(t2);
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
        if (this.HM || this.jAO != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.jAO = DataSourceStatus.FAILURE;
            this.jAP = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aT(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.HM && this.jAO == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void cug() {
        Iterator<Pair<d<T>, Executor>> it = this.jAQ.iterator();
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
