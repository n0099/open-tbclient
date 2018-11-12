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
    final com.facebook.common.memory.c iga;
    private boolean ihA;
    @GuardedBy("this")
    final a ihB;
    @GuardedBy("this")
    final a ihC;
    private final s ihD;
    final r ihx;
    final Set<V> ihz;
    private final Class<?> hXm = getClass();
    final SparseArray<d<V>> ihy = new SparseArray<>();

    protected abstract void aH(V v);

    protected abstract int aI(V v);

    protected abstract V xU(int i);

    protected abstract int xV(int i);

    protected abstract int xW(int i);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.iga = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.ihx = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.ihD = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.ihz = com.facebook.common.internal.h.bQW();
        this.ihC = new a();
        this.ihB = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.iga.a(this);
        this.ihD.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        bWb();
        int xV = xV(i);
        synchronized (this) {
            d<V> xX = xX(xV);
            if (xX != null && (v = xX.get()) != null) {
                com.facebook.common.internal.g.checkState(this.ihz.add(v));
                int aI = aI(v);
                int xW = xW(aI);
                this.ihB.ya(xW);
                this.ihC.yb(xW);
                this.ihD.yi(xW);
                bTW();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hXm, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aI));
                }
            } else {
                int xW2 = xW(xV);
                if (!xZ(xW2)) {
                    throw new PoolSizeViolationException(this.ihx.iif, this.ihB.ihE, this.ihC.ihE, xW2);
                }
                this.ihB.ya(xW2);
                if (xX != null) {
                    xX.bWj();
                }
                v = null;
                try {
                    v = xU(xV);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.ihB.yb(xW2);
                        d<V> xX2 = xX(xV);
                        if (xX2 != null) {
                            xX2.bWk();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.ihz.add(v));
                    bWc();
                    this.ihD.yj(xW2);
                    bTW();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.hXm, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(xV));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aI = aI(v);
        int xW = xW(aI);
        synchronized (this) {
            d<V> xX = xX(aI);
            if (!this.ihz.remove(v)) {
                com.facebook.common.c.a.e(this.hXm, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aI));
                aH(v);
                this.ihD.yk(xW);
            } else if (xX == null || xX.bWh() || bWd() || !aJ(v)) {
                if (xX != null) {
                    xX.bWk();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hXm, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aI));
                }
                aH(v);
                this.ihB.yb(xW);
                this.ihD.yk(xW);
            } else {
                xX.release(v);
                this.ihC.ya(xW);
                this.ihB.yb(xW);
                this.ihD.yl(xW);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hXm, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aI));
                }
            }
            bTW();
        }
    }

    protected boolean aJ(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void bWb() {
        com.facebook.common.internal.g.checkState(!bWd() || this.ihC.ihE == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.ihy.clear();
            SparseIntArray sparseIntArray2 = this.ihx.iih;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.ihy.put(keyAt, new d<>(xW(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.ihA = false;
            } else {
                this.ihA = true;
            }
        }
    }

    synchronized void bWc() {
        if (bWd()) {
            trimToSize(this.ihx.iig);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.ihB.ihE + this.ihC.ihE) - i, this.ihC.ihE);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hXm, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.ihB.ihE + this.ihC.ihE), Integer.valueOf(min));
            }
            bTW();
            for (int i2 = 0; i2 < this.ihy.size() && min > 0; i2++) {
                d<V> valueAt = this.ihy.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aH(pop);
                    min -= valueAt.mItemSize;
                    this.ihC.yb(valueAt.mItemSize);
                }
            }
            bTW();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hXm, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.ihB.ihE + this.ihC.ihE));
            }
        }
    }

    synchronized d<V> xX(int i) {
        d<V> dVar;
        dVar = this.ihy.get(i);
        if (dVar == null && this.ihA) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hXm, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = xY(i);
            this.ihy.put(i, dVar);
        }
        return dVar;
    }

    d<V> xY(int i) {
        return new d<>(xW(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean bWd() {
        boolean z;
        z = this.ihB.ihE + this.ihC.ihE > this.ihx.iig;
        if (z) {
            this.ihD.bWr();
        }
        return z;
    }

    synchronized boolean xZ(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.ihx.iif;
            if (i > i2 - this.ihB.ihE) {
                this.ihD.bWs();
            } else {
                int i3 = this.ihx.iig;
                if (i > i3 - (this.ihB.ihE + this.ihC.ihE)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.ihB.ihE + this.ihC.ihE)) {
                    this.ihD.bWs();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void bTW() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.hXm, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.ihB.mCount), Integer.valueOf(this.ihB.ihE), Integer.valueOf(this.ihC.mCount), Integer.valueOf(this.ihC.ihE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int ihE;
        int mCount;

        a() {
        }

        public void ya(int i) {
            this.mCount++;
            this.ihE += i;
        }

        public void yb(int i) {
            if (this.ihE >= i && this.mCount > 0) {
                this.mCount--;
                this.ihE -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.ihE), Integer.valueOf(this.mCount));
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
