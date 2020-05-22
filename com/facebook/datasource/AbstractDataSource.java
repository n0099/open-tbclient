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
    private T cmB = null;
    @GuardedBy("this")
    private Throwable mmw = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean OE = false;
    @GuardedBy("this")
    private DataSourceStatus mmv = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> mmx = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.OE;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.mmv != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean duO() {
        return this.cmB != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.cmB;
    }

    public synchronized boolean duP() {
        return this.mmv == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable duQ() {
        return this.mmw;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean Zg() {
        boolean z = true;
        synchronized (this) {
            if (this.OE) {
                z = false;
            } else {
                this.OE = true;
                T t = this.cmB;
                this.cmB = null;
                if (t != null) {
                    aS(t);
                }
                if (!isFinished()) {
                    duR();
                }
                synchronized (this) {
                    this.mmx.clear();
                }
            }
        }
        return z;
    }

    protected void aS(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.OE) {
                if (this.mmv == DataSourceStatus.IN_PROGRESS) {
                    this.mmx.add(Pair.create(dVar, executor));
                }
                boolean z = duO() || isFinished() || duS();
                if (z) {
                    a(dVar, executor, duP(), duS());
                }
            }
        }
    }

    private void duR() {
        boolean duP = duP();
        boolean duS = duS();
        Iterator<Pair<d<T>, Executor>> it = this.mmx.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, duP, duS);
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

    private synchronized boolean duS() {
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
            duR();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(Throwable th) {
        boolean A = A(th);
        if (A) {
            duR();
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ay(float f) {
        boolean az = az(f);
        if (az) {
            duT();
        }
        return az;
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
                        if (this.OE || this.mmv != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aS(t);
                            }
                        } else {
                            if (z) {
                                this.mmv = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.cmB != t) {
                                T t3 = this.cmB;
                                try {
                                    this.cmB = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aS(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aS(t2);
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

    private synchronized boolean A(Throwable th) {
        boolean z;
        if (this.OE || this.mmv != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.mmv = DataSourceStatus.FAILURE;
            this.mmw = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean az(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.OE && this.mmv == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void duT() {
        Iterator<Pair<d<T>, Executor>> it = this.mmx.iterator();
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
