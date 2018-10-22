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
    final com.facebook.common.memory.c ieq;
    final r ifN;
    final Set<V> ifP;
    private boolean ifQ;
    @GuardedBy("this")
    final a ifR;
    @GuardedBy("this")
    final a ifS;
    private final s ifT;
    private final Class<?> hVC = getClass();
    final SparseArray<d<V>> ifO = new SparseArray<>();

    protected abstract void aI(V v);

    protected abstract int aJ(V v);

    protected abstract V xB(int i);

    protected abstract int xC(int i);

    protected abstract int xD(int i);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.ieq = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.ifN = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.ifT = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.ifP = com.facebook.common.internal.h.bRB();
        this.ifS = new a();
        this.ifR = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.ieq.a(this);
        this.ifT.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        bWG();
        int xC = xC(i);
        synchronized (this) {
            d<V> xE = xE(xC);
            if (xE != null && (v = xE.get()) != null) {
                com.facebook.common.internal.g.checkState(this.ifP.add(v));
                int aJ = aJ(v);
                int xD = xD(aJ);
                this.ifR.xH(xD);
                this.ifS.xI(xD);
                this.ifT.xP(xD);
                bUB();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hVC, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            } else {
                int xD2 = xD(xC);
                if (!xG(xD2)) {
                    throw new PoolSizeViolationException(this.ifN.igv, this.ifR.ifU, this.ifS.ifU, xD2);
                }
                this.ifR.xH(xD2);
                if (xE != null) {
                    xE.bWO();
                }
                v = null;
                try {
                    v = xB(xC);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.ifR.xI(xD2);
                        d<V> xE2 = xE(xC);
                        if (xE2 != null) {
                            xE2.bWP();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.ifP.add(v));
                    bWH();
                    this.ifT.xQ(xD2);
                    bUB();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.hVC, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(xC));
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
        int xD = xD(aJ);
        synchronized (this) {
            d<V> xE = xE(aJ);
            if (!this.ifP.remove(v)) {
                com.facebook.common.c.a.e(this.hVC, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                aI(v);
                this.ifT.xR(xD);
            } else if (xE == null || xE.bWM() || bWI() || !aK(v)) {
                if (xE != null) {
                    xE.bWP();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hVC, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
                aI(v);
                this.ifR.xI(xD);
                this.ifT.xR(xD);
            } else {
                xE.release(v);
                this.ifS.xH(xD);
                this.ifR.xI(xD);
                this.ifT.xS(xD);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hVC, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            }
            bUB();
        }
    }

    protected boolean aK(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void bWG() {
        com.facebook.common.internal.g.checkState(!bWI() || this.ifS.ifU == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.ifO.clear();
            SparseIntArray sparseIntArray2 = this.ifN.igx;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.ifO.put(keyAt, new d<>(xD(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.ifQ = false;
            } else {
                this.ifQ = true;
            }
        }
    }

    synchronized void bWH() {
        if (bWI()) {
            trimToSize(this.ifN.igw);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.ifR.ifU + this.ifS.ifU) - i, this.ifS.ifU);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hVC, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.ifR.ifU + this.ifS.ifU), Integer.valueOf(min));
            }
            bUB();
            for (int i2 = 0; i2 < this.ifO.size() && min > 0; i2++) {
                d<V> valueAt = this.ifO.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aI(pop);
                    min -= valueAt.mItemSize;
                    this.ifS.xI(valueAt.mItemSize);
                }
            }
            bUB();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hVC, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.ifR.ifU + this.ifS.ifU));
            }
        }
    }

    synchronized d<V> xE(int i) {
        d<V> dVar;
        dVar = this.ifO.get(i);
        if (dVar == null && this.ifQ) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hVC, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = xF(i);
            this.ifO.put(i, dVar);
        }
        return dVar;
    }

    d<V> xF(int i) {
        return new d<>(xD(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean bWI() {
        boolean z;
        z = this.ifR.ifU + this.ifS.ifU > this.ifN.igw;
        if (z) {
            this.ifT.bWW();
        }
        return z;
    }

    synchronized boolean xG(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.ifN.igv;
            if (i > i2 - this.ifR.ifU) {
                this.ifT.bWX();
            } else {
                int i3 = this.ifN.igw;
                if (i > i3 - (this.ifR.ifU + this.ifS.ifU)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.ifR.ifU + this.ifS.ifU)) {
                    this.ifT.bWX();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void bUB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.hVC, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.ifR.mCount), Integer.valueOf(this.ifR.ifU), Integer.valueOf(this.ifS.mCount), Integer.valueOf(this.ifS.ifU));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int ifU;
        int mCount;

        a() {
        }

        public void xH(int i) {
            this.mCount++;
            this.ifU += i;
        }

        public void xI(int i) {
            if (this.ifU >= i && this.mCount > 0) {
                this.mCount--;
                this.ifU -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.ifU), Integer.valueOf(this.mCount));
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
