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
    final com.facebook.common.memory.c irD;
    final r ita;
    final Set<V> itc;
    private boolean itd;
    @GuardedBy("this")
    final a ite;
    @GuardedBy("this")
    final a itf;
    private final s itg;
    private final Class<?> iiQ = getClass();
    final SparseArray<d<V>> itb = new SparseArray<>();

    protected abstract void aI(V v);

    protected abstract int aJ(V v);

    protected abstract V yG(int i);

    protected abstract int yH(int i);

    protected abstract int yI(int i);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.irD = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.ita = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.itg = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.itc = com.facebook.common.internal.h.bUA();
        this.itf = new a();
        this.ite = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.irD.a(this);
        this.itg.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        bZF();
        int yH = yH(i);
        synchronized (this) {
            d<V> yJ = yJ(yH);
            if (yJ != null && (v = yJ.get()) != null) {
                com.facebook.common.internal.g.checkState(this.itc.add(v));
                int aJ = aJ(v);
                int yI = yI(aJ);
                this.ite.yM(yI);
                this.itf.yN(yI);
                this.itg.yU(yI);
                bXA();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iiQ, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            } else {
                int yI2 = yI(yH);
                if (!yL(yI2)) {
                    throw new PoolSizeViolationException(this.ita.itI, this.ite.ith, this.itf.ith, yI2);
                }
                this.ite.yM(yI2);
                if (yJ != null) {
                    yJ.bZN();
                }
                v = null;
                try {
                    v = yG(yH);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.ite.yN(yI2);
                        d<V> yJ2 = yJ(yH);
                        if (yJ2 != null) {
                            yJ2.bZO();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.itc.add(v));
                    bZG();
                    this.itg.yV(yI2);
                    bXA();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.iiQ, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(yH));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aJ = aJ(v);
        int yI = yI(aJ);
        synchronized (this) {
            d<V> yJ = yJ(aJ);
            if (!this.itc.remove(v)) {
                com.facebook.common.c.a.e(this.iiQ, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                aI(v);
                this.itg.yW(yI);
            } else if (yJ == null || yJ.bZL() || bZH() || !aK(v)) {
                if (yJ != null) {
                    yJ.bZO();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iiQ, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
                aI(v);
                this.ite.yN(yI);
                this.itg.yW(yI);
            } else {
                yJ.release(v);
                this.itf.yM(yI);
                this.ite.yN(yI);
                this.itg.yX(yI);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iiQ, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            }
            bXA();
        }
    }

    protected boolean aK(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void bZF() {
        com.facebook.common.internal.g.checkState(!bZH() || this.itf.ith == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.itb.clear();
            SparseIntArray sparseIntArray2 = this.ita.itK;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.itb.put(keyAt, new d<>(yI(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.itd = false;
            } else {
                this.itd = true;
            }
        }
    }

    synchronized void bZG() {
        if (bZH()) {
            trimToSize(this.ita.itJ);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.ite.ith + this.itf.ith) - i, this.itf.ith);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iiQ, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.ite.ith + this.itf.ith), Integer.valueOf(min));
            }
            bXA();
            for (int i2 = 0; i2 < this.itb.size() && min > 0; i2++) {
                d<V> valueAt = this.itb.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aI(pop);
                    min -= valueAt.mItemSize;
                    this.itf.yN(valueAt.mItemSize);
                }
            }
            bXA();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iiQ, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.ite.ith + this.itf.ith));
            }
        }
    }

    synchronized d<V> yJ(int i) {
        d<V> dVar;
        dVar = this.itb.get(i);
        if (dVar == null && this.itd) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iiQ, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = yK(i);
            this.itb.put(i, dVar);
        }
        return dVar;
    }

    d<V> yK(int i) {
        return new d<>(yI(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean bZH() {
        boolean z;
        z = this.ite.ith + this.itf.ith > this.ita.itJ;
        if (z) {
            this.itg.bZV();
        }
        return z;
    }

    synchronized boolean yL(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.ita.itI;
            if (i > i2 - this.ite.ith) {
                this.itg.bZW();
            } else {
                int i3 = this.ita.itJ;
                if (i > i3 - (this.ite.ith + this.itf.ith)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.ite.ith + this.itf.ith)) {
                    this.itg.bZW();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void bXA() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.iiQ, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.ite.mCount), Integer.valueOf(this.ite.ith), Integer.valueOf(this.itf.mCount), Integer.valueOf(this.itf.ith));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int ith;
        int mCount;

        a() {
        }

        public void yM(int i) {
            this.mCount++;
            this.ith += i;
        }

        public void yN(int i) {
            if (this.ith >= i && this.mCount > 0) {
                this.mCount--;
                this.ith -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.ith), Integer.valueOf(this.mCount));
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
