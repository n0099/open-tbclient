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
    final com.facebook.common.memory.c jZD;
    final r kbd;
    final Set<V> kbf;
    private boolean kbg;
    @GuardedBy("this")
    final a kbh;
    @GuardedBy("this")
    final a kbi;
    private final s kbj;
    private final Class<?> jQR = getClass();
    final SparseArray<d<V>> kbe = new SparseArray<>();

    protected abstract V Dn(int i);

    protected abstract int Do(int i);

    protected abstract int Dp(int i);

    protected abstract void aW(V v);

    protected abstract int aX(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jZD = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.kbd = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.kbj = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.kbf = com.facebook.common.internal.h.cBB();
        this.kbi = new a();
        this.kbh = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jZD.a(this);
        this.kbj.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cGM();
        int Do = Do(i);
        synchronized (this) {
            d<V> Dq = Dq(Do);
            if (Dq != null && (v = Dq.get()) != null) {
                com.facebook.common.internal.g.checkState(this.kbf.add(v));
                int aX = aX(v);
                int Dp = Dp(aX);
                this.kbh.Dt(Dp);
                this.kbi.Du(Dp);
                this.kbj.DB(Dp);
                cED();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQR, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            } else {
                int Dp2 = Dp(Do);
                if (!Ds(Dp2)) {
                    throw new PoolSizeViolationException(this.kbd.kbK, this.kbh.kbk, this.kbi.kbk, Dp2);
                }
                this.kbh.Dt(Dp2);
                if (Dq != null) {
                    Dq.cGU();
                }
                v = null;
                try {
                    v = Dn(Do);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.kbh.Du(Dp2);
                        d<V> Dq2 = Dq(Do);
                        if (Dq2 != null) {
                            Dq2.cGV();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.kbf.add(v));
                    cGN();
                    this.kbj.DC(Dp2);
                    cED();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jQR, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Do));
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
            if (!this.kbf.remove(v)) {
                com.facebook.common.c.a.e(this.jQR, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                aW(v);
                this.kbj.DD(Dp);
            } else if (Dq == null || Dq.cGS() || cGO() || !aY(v)) {
                if (Dq != null) {
                    Dq.cGV();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQR, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
                aW(v);
                this.kbh.Du(Dp);
                this.kbj.DD(Dp);
            } else {
                Dq.release(v);
                this.kbi.Dt(Dp);
                this.kbh.Du(Dp);
                this.kbj.DE(Dp);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jQR, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            }
            cED();
        }
    }

    protected boolean aY(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cGM() {
        com.facebook.common.internal.g.checkState(!cGO() || this.kbi.kbk == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.kbe.clear();
            SparseIntArray sparseIntArray2 = this.kbd.kbM;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.kbe.put(keyAt, new d<>(Dp(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.kbg = false;
            } else {
                this.kbg = true;
            }
        }
    }

    synchronized void cGN() {
        if (cGO()) {
            trimToSize(this.kbd.kbL);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.kbh.kbk + this.kbi.kbk) - i, this.kbi.kbk);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQR, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.kbh.kbk + this.kbi.kbk), Integer.valueOf(min));
            }
            cED();
            for (int i2 = 0; i2 < this.kbe.size() && min > 0; i2++) {
                d<V> valueAt = this.kbe.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aW(pop);
                    min -= valueAt.mItemSize;
                    this.kbi.Du(valueAt.mItemSize);
                }
            }
            cED();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQR, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.kbh.kbk + this.kbi.kbk));
            }
        }
    }

    synchronized d<V> Dq(int i) {
        d<V> dVar;
        dVar = this.kbe.get(i);
        if (dVar == null && this.kbg) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jQR, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Dr(i);
            this.kbe.put(i, dVar);
        }
        return dVar;
    }

    d<V> Dr(int i) {
        return new d<>(Dp(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cGO() {
        boolean z;
        z = this.kbh.kbk + this.kbi.kbk > this.kbd.kbL;
        if (z) {
            this.kbj.cHc();
        }
        return z;
    }

    synchronized boolean Ds(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.kbd.kbK;
            if (i > i2 - this.kbh.kbk) {
                this.kbj.cHd();
            } else {
                int i3 = this.kbd.kbL;
                if (i > i3 - (this.kbh.kbk + this.kbi.kbk)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.kbh.kbk + this.kbi.kbk)) {
                    this.kbj.cHd();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cED() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jQR, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.kbh.mCount), Integer.valueOf(this.kbh.kbk), Integer.valueOf(this.kbi.mCount), Integer.valueOf(this.kbi.kbk));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int kbk;
        int mCount;

        a() {
        }

        public void Dt(int i) {
            this.mCount++;
            this.kbk += i;
        }

        public void Du(int i) {
            if (this.kbk >= i && this.mCount > 0) {
                this.mCount--;
                this.kbk -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.kbk), Integer.valueOf(this.mCount));
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
