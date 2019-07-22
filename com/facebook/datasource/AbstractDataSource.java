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
    private T aHk = null;
    @GuardedBy("this")
    private Throwable kas = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean FD = false;
    @GuardedBy("this")
    private DataSourceStatus kar = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> kat = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.FD;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.kar != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean cFf() {
        return this.aHk != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.aHk;
    }

    public synchronized boolean cFg() {
        return this.kar == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable cFh() {
        return this.kas;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean AI() {
        boolean z = true;
        synchronized (this) {
            if (this.FD) {
                z = false;
            } else {
                this.FD = true;
                T t = this.aHk;
                this.aHk = null;
                if (t != null) {
                    aG(t);
                }
                if (!isFinished()) {
                    cFi();
                }
                synchronized (this) {
                    this.kat.clear();
                }
            }
        }
        return z;
    }

    protected void aG(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.FD) {
                if (this.kar == DataSourceStatus.IN_PROGRESS) {
                    this.kat.add(Pair.create(dVar, executor));
                }
                boolean z = cFf() || isFinished() || cFj();
                if (z) {
                    a(dVar, executor, cFg(), cFj());
                }
            }
        }
    }

    private void cFi() {
        boolean cFg = cFg();
        boolean cFj = cFj();
        Iterator<Pair<d<T>, Executor>> it = this.kat.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, cFg, cFj);
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

    private synchronized boolean cFj() {
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
            cFi();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            cFi();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aX(float f) {
        boolean aY = aY(f);
        if (aY) {
            cFk();
        }
        return aY;
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
                        if (this.FD || this.kar != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aG(t);
                            }
                        } else {
                            if (z) {
                                this.kar = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.aHk != t) {
                                T t3 = this.aHk;
                                try {
                                    this.aHk = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aG(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aG(t2);
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
        if (this.FD || this.kar != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.kar = DataSourceStatus.FAILURE;
            this.kas = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aY(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.FD && this.kar == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void cFk() {
        Iterator<Pair<d<T>, Executor>> it = this.kat.iterator();
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
