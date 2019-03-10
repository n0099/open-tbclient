package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.support.v7.widget.ActivityChooserView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes2.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    final com.facebook.common.memory.c jHD;
    final r jJd;
    final Set<V> jJf;
    private boolean jJg;
    @GuardedBy("this")
    final a jJh;
    @GuardedBy("this")
    final a jJi;
    private final s jJj;
    private final Class<?> jyO = getClass();
    final SparseArray<d<V>> jJe = new SparseArray<>();

    protected abstract V Ct(int i);

    protected abstract int Cu(int i);

    protected abstract int Cv(int i);

    protected abstract void aY(V v);

    protected abstract int aZ(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jHD = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.jJd = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.jJj = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.jJf = com.facebook.common.internal.h.ctI();
        this.jJi = new a();
        this.jJh = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jHD.a(this);
        this.jJj.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cyU();
        int Cu = Cu(i);
        synchronized (this) {
            d<V> Cw = Cw(Cu);
            if (Cw != null && (v = Cw.get()) != null) {
                com.facebook.common.internal.g.checkState(this.jJf.add(v));
                int aZ = aZ(v);
                int Cv = Cv(aZ);
                this.jJh.Cz(Cv);
                this.jJi.CA(Cv);
                this.jJj.CH(Cv);
                cwL();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyO, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                }
            } else {
                int Cv2 = Cv(Cu);
                if (!Cy(Cv2)) {
                    throw new PoolSizeViolationException(this.jJd.jJK, this.jJh.jJk, this.jJi.jJk, Cv2);
                }
                this.jJh.Cz(Cv2);
                if (Cw != null) {
                    Cw.czc();
                }
                v = null;
                try {
                    v = Ct(Cu);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.jJh.CA(Cv2);
                        d<V> Cw2 = Cw(Cu);
                        if (Cw2 != null) {
                            Cw2.czd();
                        }
                        com.facebook.common.internal.k.r(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.jJf.add(v));
                    cyV();
                    this.jJj.CI(Cv2);
                    cwL();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jyO, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Cu));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aZ = aZ(v);
        int Cv = Cv(aZ);
        synchronized (this) {
            d<V> Cw = Cw(aZ);
            if (!this.jJf.remove(v)) {
                com.facebook.common.c.a.e(this.jyO, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                aY(v);
                this.jJj.CJ(Cv);
            } else if (Cw == null || Cw.cza() || cyW() || !ba(v)) {
                if (Cw != null) {
                    Cw.czd();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyO, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                }
                aY(v);
                this.jJh.CA(Cv);
                this.jJj.CJ(Cv);
            } else {
                Cw.release(v);
                this.jJi.Cz(Cv);
                this.jJh.CA(Cv);
                this.jJj.CK(Cv);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyO, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                }
            }
            cwL();
        }
    }

    protected boolean ba(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cyU() {
        com.facebook.common.internal.g.checkState(!cyW() || this.jJi.jJk == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.jJe.clear();
            SparseIntArray sparseIntArray2 = this.jJd.jJM;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.jJe.put(keyAt, new d<>(Cv(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.jJg = false;
            } else {
                this.jJg = true;
            }
        }
    }

    synchronized void cyV() {
        if (cyW()) {
            trimToSize(this.jJd.jJL);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.jJh.jJk + this.jJi.jJk) - i, this.jJi.jJk);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyO, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.jJh.jJk + this.jJi.jJk), Integer.valueOf(min));
            }
            cwL();
            for (int i2 = 0; i2 < this.jJe.size() && min > 0; i2++) {
                d<V> valueAt = this.jJe.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aY(pop);
                    min -= valueAt.mItemSize;
                    this.jJi.CA(valueAt.mItemSize);
                }
            }
            cwL();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyO, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.jJh.jJk + this.jJi.jJk));
            }
        }
    }

    synchronized d<V> Cw(int i) {
        d<V> dVar;
        dVar = this.jJe.get(i);
        if (dVar == null && this.jJg) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyO, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Cx(i);
            this.jJe.put(i, dVar);
        }
        return dVar;
    }

    d<V> Cx(int i) {
        return new d<>(Cv(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cyW() {
        boolean z;
        z = this.jJh.jJk + this.jJi.jJk > this.jJd.jJL;
        if (z) {
            this.jJj.czk();
        }
        return z;
    }

    synchronized boolean Cy(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.jJd.jJK;
            if (i > i2 - this.jJh.jJk) {
                this.jJj.czl();
            } else {
                int i3 = this.jJd.jJL;
                if (i > i3 - (this.jJh.jJk + this.jJi.jJk)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.jJh.jJk + this.jJi.jJk)) {
                    this.jJj.czl();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cwL() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jyO, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.jJh.mCount), Integer.valueOf(this.jJh.jJk), Integer.valueOf(this.jJi.mCount), Integer.valueOf(this.jJi.jJk));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int jJk;
        int mCount;

        a() {
        }

        public void Cz(int i) {
            this.mCount++;
            this.jJk += i;
        }

        public void CA(int i) {
            if (this.jJk >= i && this.mCount > 0) {
                this.mCount--;
                this.jJk -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.jJk), Integer.valueOf(this.mCount));
        }
    }

    /* loaded from: classes2.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes2.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
