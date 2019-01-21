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
    private T iln = null;
    @GuardedBy("this")
    private Throwable ilo = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean HL = false;
    @GuardedBy("this")
    private DataSourceStatus ilm = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> ilp = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.HL;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.ilm != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean bVd() {
        return this.iln != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.iln;
    }

    public synchronized boolean bVe() {
        return this.ilm == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable bVf() {
        return this.ilo;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean bVg() {
        boolean z = true;
        synchronized (this) {
            if (this.HL) {
                z = false;
            } else {
                this.HL = true;
                T t = this.iln;
                this.iln = null;
                if (t != null) {
                    as(t);
                }
                if (!isFinished()) {
                    bVh();
                }
                synchronized (this) {
                    this.ilp.clear();
                }
            }
        }
        return z;
    }

    protected void as(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.HL) {
                if (this.ilm == DataSourceStatus.IN_PROGRESS) {
                    this.ilp.add(Pair.create(dVar, executor));
                }
                boolean z = bVd() || isFinished() || bVi();
                if (z) {
                    a(dVar, executor, bVe(), bVi());
                }
            }
        }
    }

    private void bVh() {
        boolean bVe = bVe();
        boolean bVi = bVi();
        Iterator<Pair<d<T>, Executor>> it = this.ilp.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, bVe, bVi);
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

    private synchronized boolean bVi() {
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
            bVh();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            bVh();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aF(float f) {
        boolean aG = aG(f);
        if (aG) {
            bVj();
        }
        return aG;
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
                        if (this.HL || this.ilm != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                as(t);
                            }
                        } else {
                            if (z) {
                                this.ilm = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.iln != t) {
                                T t3 = this.iln;
                                try {
                                    this.iln = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            as(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                as(t2);
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
        if (this.HL || this.ilm != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.ilm = DataSourceStatus.FAILURE;
            this.ilo = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aG(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.HL && this.ilm == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void bVj() {
        Iterator<Pair<d<T>, Executor>> it = this.ilp.iterator();
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
