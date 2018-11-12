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
    private T hZI = null;
    @GuardedBy("this")
    private Throwable hZJ = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean HL = false;
    @GuardedBy("this")
    private DataSourceStatus hZH = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> hZK = new ConcurrentLinkedQueue<>();

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
        return this.hZH != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean bRz() {
        return this.hZI != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.hZI;
    }

    public synchronized boolean bRA() {
        return this.hZH == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable bRB() {
        return this.hZJ;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean bRC() {
        boolean z = true;
        synchronized (this) {
            if (this.HL) {
                z = false;
            } else {
                this.HL = true;
                T t = this.hZI;
                this.hZI = null;
                if (t != null) {
                    ar(t);
                }
                if (!isFinished()) {
                    bRD();
                }
                synchronized (this) {
                    this.hZK.clear();
                }
            }
        }
        return z;
    }

    protected void ar(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.HL) {
                if (this.hZH == DataSourceStatus.IN_PROGRESS) {
                    this.hZK.add(Pair.create(dVar, executor));
                }
                boolean z = bRz() || isFinished() || bRE();
                if (z) {
                    a(dVar, executor, bRA(), bRE());
                }
            }
        }
    }

    private void bRD() {
        boolean bRA = bRA();
        boolean bRE = bRE();
        Iterator<Pair<d<T>, Executor>> it = this.hZK.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, bRA, bRE);
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

    private synchronized boolean bRE() {
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
            bRD();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(Throwable th) {
        boolean u = u(th);
        if (u) {
            bRD();
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aF(float f) {
        boolean aG = aG(f);
        if (aG) {
            bRF();
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
                        if (this.HL || this.hZH != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                ar(t);
                            }
                        } else {
                            if (z) {
                                this.hZH = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.hZI != t) {
                                T t3 = this.hZI;
                                try {
                                    this.hZI = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            ar(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                ar(t2);
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
        if (this.HL || this.hZH != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.hZH = DataSourceStatus.FAILURE;
            this.hZJ = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean aG(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.HL && this.hZH == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void bRF() {
        Iterator<Pair<d<T>, Executor>> it = this.hZK.iterator();
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
