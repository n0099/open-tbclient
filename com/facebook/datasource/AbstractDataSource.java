package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public abstract class AbstractDataSource<T> implements b<T> {
    @GuardedBy("this")
    @Nullable
    private T byZ = null;
    @GuardedBy("this")
    private Throwable lIA = null;
    @GuardedBy("this")
    private float mProgress = 0.0f;
    @GuardedBy("this")
    private boolean vi = false;
    @GuardedBy("this")
    private DataSourceStatus lIz = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> lIB = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public synchronized boolean isClosed() {
        return this.vi;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean isFinished() {
        return this.lIz != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean djO() {
        return this.byZ != null;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.byZ;
    }

    public synchronized boolean djP() {
        return this.lIz == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable djQ() {
        return this.lIA;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.b
    public boolean Mn() {
        boolean z = true;
        synchronized (this) {
            if (this.vi) {
                z = false;
            } else {
                this.vi = true;
                T t = this.byZ;
                this.byZ = null;
                if (t != null) {
                    aV(t);
                }
                if (!isFinished()) {
                    djR();
                }
                synchronized (this) {
                    this.lIB.clear();
                }
            }
        }
        return z;
    }

    protected void aV(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    public void a(d<T> dVar, Executor executor) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkNotNull(executor);
        synchronized (this) {
            if (!this.vi) {
                if (this.lIz == DataSourceStatus.IN_PROGRESS) {
                    this.lIB.add(Pair.create(dVar, executor));
                }
                boolean z = djO() || isFinished() || djS();
                if (z) {
                    a(dVar, executor, djP(), djS());
                }
            }
        }
    }

    private void djR() {
        boolean djP = djP();
        boolean djS = djS();
        Iterator<Pair<d<T>, Executor>> it = this.lIB.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            a((d) next.first, (Executor) next.second, djP, djS);
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

    private synchronized boolean djS() {
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
            djR();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v(Throwable th) {
        boolean x = x(th);
        if (x) {
            djR();
        }
        return x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bk(float f) {
        boolean bl = bl(f);
        if (bl) {
            djT();
        }
        return bl;
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
                        if (this.vi || this.lIz != DataSourceStatus.IN_PROGRESS) {
                            z2 = false;
                            if (t != null) {
                                aV(t);
                            }
                        } else {
                            if (z) {
                                this.lIz = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.byZ != t) {
                                T t3 = this.byZ;
                                try {
                                    this.byZ = t;
                                    t2 = t3;
                                } catch (Throwable th) {
                                    th = th;
                                    t = t3;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (t != null) {
                                            aV(t);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                t2 = null;
                            }
                            z2 = true;
                            if (t2 != null) {
                                aV(t2);
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

    private synchronized boolean x(Throwable th) {
        boolean z;
        if (this.vi || this.lIz != DataSourceStatus.IN_PROGRESS) {
            z = false;
        } else {
            this.lIz = DataSourceStatus.FAILURE;
            this.lIA = th;
            z = true;
        }
        return z;
    }

    private synchronized boolean bl(float f) {
        boolean z = false;
        synchronized (this) {
            if (!this.vi && this.lIz == DataSourceStatus.IN_PROGRESS && f >= this.mProgress) {
                this.mProgress = f;
                z = true;
            }
        }
        return z;
    }

    protected void djT() {
        Iterator<Pair<d<T>, Executor>> it = this.lIB.iterator();
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
