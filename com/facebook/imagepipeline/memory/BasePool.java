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
    final com.facebook.common.memory.c jZH;
    final r kbh;
    final Set<V> kbj;
    private boolean kbk;
    @GuardedBy("this")
    final a kbl;
    @GuardedBy("this")
    final a kbm;
    private final s kbn;
    private final Class<?> jQV = getClass();
    final SparseArray<d<V>> kbi = new SparseArray<>();

    protected abstract V Dn(int i);

    protected abstract int Do(int i);

    protected abstract int Dp(int i);

    protected abstract void aW(V v);

    protected abstract int aX(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jZH = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.kbh = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.kbn = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.kbj = com.facebook.common.internal.h.cBC();
        this.kbm = new a();
        this.kbl = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jZH.a(this);
        this.kbn.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cGN();
        int Do = Do(i);
        synchronized (this) {
            d<V> Dq = Dq(Do);
            if (Dq != null && (v = Dq.get()) != null) {
                com.facebook.common.internal.g.checkState(this.kbj.add(v));
                int aX = aX(v);
                int Dp = Dp(aX);
                this.kbl.Dt(Dp);
                this.kbm.Du(Dp);
                this.kbn.DB(Dp);
                cEE();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQV, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            } else {
                int Dp2 = Dp(Do);
                if (!Ds(Dp2)) {
                    throw new PoolSizeViolationException(this.kbh.kbO, this.kbl.kbo, this.kbm.kbo, Dp2);
                }
                this.kbl.Dt(Dp2);
                if (Dq != null) {
                    Dq.cGV();
                }
                v = null;
                try {
                    v = Dn(Do);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.kbl.Du(Dp2);
                        d<V> Dq2 = Dq(Do);
                        if (Dq2 != null) {
                            Dq2.cGW();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.kbj.add(v));
                    cGO();
                    this.kbn.DC(Dp2);
                    cEE();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jQV, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Do));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aX = aX(v);
        int Dp = Dp(aX);
        synchronized (this) {
            d<V> Dq = Dq(aX);
            if (!this.kbj.remove(v)) {
                com.facebook.common.c.a.e(this.jQV, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                aW(v);
                this.kbn.DD(Dp);
            } else if (Dq == null || Dq.cGT() || cGP() || !aY(v)) {
                if (Dq != null) {
                    Dq.cGW();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQV, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
                aW(v);
                this.kbl.Du(Dp);
                this.kbn.DD(Dp);
            } else {
                Dq.release(v);
                this.kbm.Dt(Dp);
                this.kbl.Du(Dp);
                this.kbn.DE(Dp);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQV, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            }
            cEE();
        }
    }

    protected boolean aY(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cGN() {
        com.facebook.common.internal.g.checkState(!cGP() || this.kbm.kbo == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.kbi.clear();
            SparseIntArray sparseIntArray2 = this.kbh.kbQ;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.kbi.put(keyAt, new d<>(Dp(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.kbk = false;
            } else {
                this.kbk = true;
            }
        }
    }

    synchronized void cGO() {
        if (cGP()) {
            trimToSize(this.kbh.kbP);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.kbl.kbo + this.kbm.kbo) - i, this.kbm.kbo);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQV, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.kbl.kbo + this.kbm.kbo), Integer.valueOf(min));
            }
            cEE();
            for (int i2 = 0; i2 < this.kbi.size() && min > 0; i2++) {
                d<V> valueAt = this.kbi.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aW(pop);
                    min -= valueAt.mItemSize;
                    this.kbm.Du(valueAt.mItemSize);
                }
            }
            cEE();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQV, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.kbl.kbo + this.kbm.kbo));
            }
        }
    }

    synchronized d<V> Dq(int i) {
        d<V> dVar;
        dVar = this.kbi.get(i);
        if (dVar == null && this.kbk) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQV, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Dr(i);
            this.kbi.put(i, dVar);
        }
        return dVar;
    }

    d<V> Dr(int i) {
        return new d<>(Dp(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cGP() {
        boolean z;
        z = this.kbl.kbo + this.kbm.kbo > this.kbh.kbP;
        if (z) {
            this.kbn.cHd();
        }
        return z;
    }

    synchronized boolean Ds(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.kbh.kbO;
            if (i > i2 - this.kbl.kbo) {
                this.kbn.cHe();
            } else {
                int i3 = this.kbh.kbP;
                if (i > i3 - (this.kbl.kbo + this.kbm.kbo)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.kbl.kbo + this.kbm.kbo)) {
                    this.kbn.cHe();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cEE() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jQV, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.kbl.mCount), Integer.valueOf(this.kbl.kbo), Integer.valueOf(this.kbm.mCount), Integer.valueOf(this.kbm.kbo));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int kbo;
        int mCount;

        a() {
        }

        public void Dt(int i) {
            this.mCount++;
            this.kbo += i;
        }

        public void Du(int i) {
            if (this.kbo >= i && this.mCount > 0) {
                this.mCount--;
                this.kbo -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.kbo), Integer.valueOf(this.mCount));
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
