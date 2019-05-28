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
    final com.facebook.common.memory.c jZE;
    final r kbe;
    final Set<V> kbg;
    private boolean kbh;
    @GuardedBy("this")
    final a kbi;
    @GuardedBy("this")
    final a kbj;
    private final s kbk;
    private final Class<?> jQS = getClass();
    final SparseArray<d<V>> kbf = new SparseArray<>();

    protected abstract V Dn(int i);

    protected abstract int Do(int i);

    protected abstract int Dp(int i);

    protected abstract void aW(V v);

    protected abstract int aX(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jZE = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.kbe = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.kbk = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.kbg = com.facebook.common.internal.h.cBD();
        this.kbj = new a();
        this.kbi = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jZE.a(this);
        this.kbk.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cGO();
        int Do = Do(i);
        synchronized (this) {
            d<V> Dq = Dq(Do);
            if (Dq != null && (v = Dq.get()) != null) {
                com.facebook.common.internal.g.checkState(this.kbg.add(v));
                int aX = aX(v);
                int Dp = Dp(aX);
                this.kbi.Dt(Dp);
                this.kbj.Du(Dp);
                this.kbk.DB(Dp);
                cEF();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQS, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            } else {
                int Dp2 = Dp(Do);
                if (!Ds(Dp2)) {
                    throw new PoolSizeViolationException(this.kbe.kbL, this.kbi.kbl, this.kbj.kbl, Dp2);
                }
                this.kbi.Dt(Dp2);
                if (Dq != null) {
                    Dq.cGW();
                }
                v = null;
                try {
                    v = Dn(Do);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.kbi.Du(Dp2);
                        d<V> Dq2 = Dq(Do);
                        if (Dq2 != null) {
                            Dq2.cGX();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.kbg.add(v));
                    cGP();
                    this.kbk.DC(Dp2);
                    cEF();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jQS, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Do));
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
            if (!this.kbg.remove(v)) {
                com.facebook.common.c.a.e(this.jQS, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                aW(v);
                this.kbk.DD(Dp);
            } else if (Dq == null || Dq.cGU() || cGQ() || !aY(v)) {
                if (Dq != null) {
                    Dq.cGX();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQS, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
                aW(v);
                this.kbi.Du(Dp);
                this.kbk.DD(Dp);
            } else {
                Dq.release(v);
                this.kbj.Dt(Dp);
                this.kbi.Du(Dp);
                this.kbk.DE(Dp);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQS, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            }
            cEF();
        }
    }

    protected boolean aY(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cGO() {
        com.facebook.common.internal.g.checkState(!cGQ() || this.kbj.kbl == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.kbf.clear();
            SparseIntArray sparseIntArray2 = this.kbe.kbN;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.kbf.put(keyAt, new d<>(Dp(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.kbh = false;
            } else {
                this.kbh = true;
            }
        }
    }

    synchronized void cGP() {
        if (cGQ()) {
            trimToSize(this.kbe.kbM);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.kbi.kbl + this.kbj.kbl) - i, this.kbj.kbl);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQS, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.kbi.kbl + this.kbj.kbl), Integer.valueOf(min));
            }
            cEF();
            for (int i2 = 0; i2 < this.kbf.size() && min > 0; i2++) {
                d<V> valueAt = this.kbf.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aW(pop);
                    min -= valueAt.mItemSize;
                    this.kbj.Du(valueAt.mItemSize);
                }
            }
            cEF();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQS, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.kbi.kbl + this.kbj.kbl));
            }
        }
    }

    synchronized d<V> Dq(int i) {
        d<V> dVar;
        dVar = this.kbf.get(i);
        if (dVar == null && this.kbh) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQS, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Dr(i);
            this.kbf.put(i, dVar);
        }
        return dVar;
    }

    d<V> Dr(int i) {
        return new d<>(Dp(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cGQ() {
        boolean z;
        z = this.kbi.kbl + this.kbj.kbl > this.kbe.kbM;
        if (z) {
            this.kbk.cHe();
        }
        return z;
    }

    synchronized boolean Ds(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.kbe.kbL;
            if (i > i2 - this.kbi.kbl) {
                this.kbk.cHf();
            } else {
                int i3 = this.kbe.kbM;
                if (i > i3 - (this.kbi.kbl + this.kbj.kbl)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.kbi.kbl + this.kbj.kbl)) {
                    this.kbk.cHf();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cEF() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jQS, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.kbi.mCount), Integer.valueOf(this.kbi.kbl), Integer.valueOf(this.kbj.mCount), Integer.valueOf(this.kbj.kbl));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int kbl;
        int mCount;

        a() {
        }

        public void Dt(int i) {
            this.mCount++;
            this.kbl += i;
        }

        public void Du(int i) {
            if (this.kbl >= i && this.mCount > 0) {
                this.mCount--;
                this.kbl -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.kbl), Integer.valueOf(this.mCount));
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
