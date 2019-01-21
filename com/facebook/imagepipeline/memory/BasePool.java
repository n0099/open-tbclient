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
    final com.facebook.common.memory.c irE;
    final r itb;
    final Set<V> itd;
    private boolean ite;
    @GuardedBy("this")
    final a itf;
    @GuardedBy("this")
    final a itg;
    private final s ith;
    private final Class<?> iiR = getClass();
    final SparseArray<d<V>> itc = new SparseArray<>();

    protected abstract void aI(V v);

    protected abstract int aJ(V v);

    protected abstract V yG(int i);

    protected abstract int yH(int i);

    protected abstract int yI(int i);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.irE = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.itb = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.ith = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.itd = com.facebook.common.internal.h.bUA();
        this.itg = new a();
        this.itf = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.irE.a(this);
        this.ith.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        bZF();
        int yH = yH(i);
        synchronized (this) {
            d<V> yJ = yJ(yH);
            if (yJ != null && (v = yJ.get()) != null) {
                com.facebook.common.internal.g.checkState(this.itd.add(v));
                int aJ = aJ(v);
                int yI = yI(aJ);
                this.itf.yM(yI);
                this.itg.yN(yI);
                this.ith.yU(yI);
                bXA();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iiR, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            } else {
                int yI2 = yI(yH);
                if (!yL(yI2)) {
                    throw new PoolSizeViolationException(this.itb.itJ, this.itf.iti, this.itg.iti, yI2);
                }
                this.itf.yM(yI2);
                if (yJ != null) {
                    yJ.bZN();
                }
                v = null;
                try {
                    v = yG(yH);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.itf.yN(yI2);
                        d<V> yJ2 = yJ(yH);
                        if (yJ2 != null) {
                            yJ2.bZO();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.itd.add(v));
                    bZG();
                    this.ith.yV(yI2);
                    bXA();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.iiR, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(yH));
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
            if (!this.itd.remove(v)) {
                com.facebook.common.c.a.e(this.iiR, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                aI(v);
                this.ith.yW(yI);
            } else if (yJ == null || yJ.bZL() || bZH() || !aK(v)) {
                if (yJ != null) {
                    yJ.bZO();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iiR, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
                aI(v);
                this.itf.yN(yI);
                this.ith.yW(yI);
            } else {
                yJ.release(v);
                this.itg.yM(yI);
                this.itf.yN(yI);
                this.ith.yX(yI);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iiR, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
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
        com.facebook.common.internal.g.checkState(!bZH() || this.itg.iti == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.itc.clear();
            SparseIntArray sparseIntArray2 = this.itb.itL;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.itc.put(keyAt, new d<>(yI(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.ite = false;
            } else {
                this.ite = true;
            }
        }
    }

    synchronized void bZG() {
        if (bZH()) {
            trimToSize(this.itb.itK);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.itf.iti + this.itg.iti) - i, this.itg.iti);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iiR, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.itf.iti + this.itg.iti), Integer.valueOf(min));
            }
            bXA();
            for (int i2 = 0; i2 < this.itc.size() && min > 0; i2++) {
                d<V> valueAt = this.itc.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aI(pop);
                    min -= valueAt.mItemSize;
                    this.itg.yN(valueAt.mItemSize);
                }
            }
            bXA();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iiR, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.itf.iti + this.itg.iti));
            }
        }
    }

    synchronized d<V> yJ(int i) {
        d<V> dVar;
        dVar = this.itc.get(i);
        if (dVar == null && this.ite) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iiR, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = yK(i);
            this.itc.put(i, dVar);
        }
        return dVar;
    }

    d<V> yK(int i) {
        return new d<>(yI(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean bZH() {
        boolean z;
        z = this.itf.iti + this.itg.iti > this.itb.itK;
        if (z) {
            this.ith.bZV();
        }
        return z;
    }

    synchronized boolean yL(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.itb.itJ;
            if (i > i2 - this.itf.iti) {
                this.ith.bZW();
            } else {
                int i3 = this.itb.itK;
                if (i > i3 - (this.itf.iti + this.itg.iti)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.itf.iti + this.itg.iti)) {
                    this.ith.bZW();
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
            com.facebook.common.c.a.a(this.iiR, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.itf.mCount), Integer.valueOf(this.itf.iti), Integer.valueOf(this.itg.mCount), Integer.valueOf(this.itg.iti));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int iti;
        int mCount;

        a() {
        }

        public void yM(int i) {
            this.mCount++;
            this.iti += i;
        }

        public void yN(int i) {
            if (this.iti >= i && this.mCount > 0) {
                this.mCount--;
                this.iti -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.iti), Integer.valueOf(this.mCount));
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
