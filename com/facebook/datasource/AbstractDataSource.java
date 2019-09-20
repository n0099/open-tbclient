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
    private T aHI = null;
    @GuardedBy("this")
    private Throwable kdV = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean FD = false;
    @GuardedBy("this")
    private DataSourceStatus kdU = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> kdW = new ConcurrentLinkedQueue<>();

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
        return this.kdU != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean cGo() {
        return this.aHI != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.aHI;
    }

    public synchronized boolean cGp() {
        return this.kdU == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable cGq() {
        return this.kdV;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean AM() {
        boolean z = true;
        synchronized (this) {
            if (this.FD) {
                z = false;
            } else {
                this.FD = true;
                T t = this.aHI;
                this.aHI = null;
                if (t != null) {
                    aG(t);
                }
                if (!isFinished()) {
                    cGr();
                }
                synchronized (this) {
                    this.kdW.clear();
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
                if (this.kdU == DataSourceStatus.IN_PROGRESS) {
                    this.kdW.add(Pair.create(dVar, executor));
                }
                boolean z = cGo() || isFinished() || cGs();
                if (z) {
                    a(dVar, executor, cGp(), cGs());
                }
            }
        }
    }

    private void cGr() {
        boolean cGp = cGp();
        boolean cGs = cGs();
        Iterator<Pair<d<T>, Executor>> it = this.kdW.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, cGp, cGs);
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

    private synchronized boolean cGs() {
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
            cGr();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            cGr();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aY(float f) {
        boolean aZ = aZ(f);
        if (aZ) {
            cGt();
        }
        return aZ;
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
                        if (this.FD || this.kdU != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aG(t);
                            }
                        } else {
                            if (z) {
                                this.kdU = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.aHI != t) {
                                T t3 = this.aHI;
                                try {
                                    this.aHI = t;
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
        if (this.FD || this.kdU != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.kdU = DataSourceStatus.FAILURE;
            this.kdV = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aZ(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.FD && this.kdU == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void cGt() {
        Iterator<Pair<d<T>, Executor>> it = this.kdW.iterator();
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
