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
    private T baE = null;
    @GuardedBy("this")
    private Throwable kbn = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean sm = false;
    @GuardedBy("this")
    private DataSourceStatus kbm = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> kbo = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.sm;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.kbm != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean cDk() {
        return this.baE != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.baE;
    }

    public synchronized boolean cDl() {
        return this.kbm == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable cDm() {
        return this.kbn;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean FI() {
        boolean z = true;
        synchronized (this) {
            if (this.sm) {
                z = false;
            } else {
                this.sm = true;
                T t = this.baE;
                this.baE = null;
                if (t != null) {
                    aB((AbstractDataSource<T>) t);
                }
                if (!isFinished()) {
                    cDn();
                }
                synchronized (this) {
                    this.kbo.clear();
                }
            }
        }
        return z;
    }

    protected void aB(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.sm) {
                if (this.kbm == DataSourceStatus.IN_PROGRESS) {
                    this.kbo.add(Pair.create(dVar, executor));
                }
                boolean z = cDk() || isFinished() || cDo();
                if (z) {
                    a(dVar, executor, cDl(), cDo());
                }
            }
        }
    }

    private void cDn() {
        boolean cDl = cDl();
        boolean cDo = cDo();
        Iterator<Pair<d<T>, Executor>> it = this.kbo.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, cDl, cDo);
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

    private synchronized boolean cDo() {
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
            cDn();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            cDn();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aB(float f) {
        boolean aC = aC(f);
        if (aC) {
            cDp();
        }
        return aC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [287=4] */
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
                        if (this.sm || this.kbm != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aB((AbstractDataSource<T>) t);
                            }
                        } else {
                            if (z) {
                                this.kbm = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.baE != t) {
                                T t3 = this.baE;
                                try {
                                    this.baE = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aB((AbstractDataSource<T>) t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aB((AbstractDataSource<T>) t2);
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

    private synchronized boolean u(Throwable th) {
        boolean z;
        if (this.sm || this.kbm != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.kbm = DataSourceStatus.FAILURE;
            this.kbn = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aC(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.sm && this.kbm == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void cDp() {
        Iterator<Pair<d<T>, Executor>> it = this.kbo.iterator();
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
