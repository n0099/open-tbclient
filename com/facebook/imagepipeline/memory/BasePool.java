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
    final com.facebook.common.memory.c iep;
    final r ifM;
    final Set<V> ifO;
    private boolean ifP;
    @GuardedBy("this")
    final a ifQ;
    @GuardedBy("this")
    final a ifR;
    private final s ifS;
    private final Class<?> hVB = getClass();
    final SparseArray<d<V>> ifN = new SparseArray<>();

    protected abstract void aI(V v);

    protected abstract int aJ(V v);

    protected abstract V xB(int i);

    protected abstract int xC(int i);

    protected abstract int xD(int i);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.iep = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.ifM = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.ifS = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.ifO = com.facebook.common.internal.h.bRB();
        this.ifR = new a();
        this.ifQ = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.iep.a(this);
        this.ifS.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        bWG();
        int xC = xC(i);
        synchronized (this) {
            d<V> xE = xE(xC);
            if (xE != null && (v = xE.get()) != null) {
                com.facebook.common.internal.g.checkState(this.ifO.add(v));
                int aJ = aJ(v);
                int xD = xD(aJ);
                this.ifQ.xH(xD);
                this.ifR.xI(xD);
                this.ifS.xP(xD);
                bUB();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hVB, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            } else {
                int xD2 = xD(xC);
                if (!xG(xD2)) {
                    throw new PoolSizeViolationException(this.ifM.igu, this.ifQ.ifT, this.ifR.ifT, xD2);
                }
                this.ifQ.xH(xD2);
                if (xE != null) {
                    xE.bWO();
                }
                v = null;
                try {
                    v = xB(xC);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.ifQ.xI(xD2);
                        d<V> xE2 = xE(xC);
                        if (xE2 != null) {
                            xE2.bWP();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.ifO.add(v));
                    bWH();
                    this.ifS.xQ(xD2);
                    bUB();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.hVB, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(xC));
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
            if (!this.ifO.remove(v)) {
                com.facebook.common.c.a.e(this.hVB, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                aI(v);
                this.ifS.xR(xD);
            } else if (xE == null || xE.bWM() || bWI() || !aK(v)) {
                if (xE != null) {
                    xE.bWP();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hVB, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
                aI(v);
                this.ifQ.xI(xD);
                this.ifS.xR(xD);
            } else {
                xE.release(v);
                this.ifR.xH(xD);
                this.ifQ.xI(xD);
                this.ifS.xS(xD);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.hVB, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
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
        com.facebook.common.internal.g.checkState(!bWI() || this.ifR.ifT == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.ifN.clear();
            SparseIntArray sparseIntArray2 = this.ifM.igw;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.ifN.put(keyAt, new d<>(xD(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.ifP = false;
            } else {
                this.ifP = true;
            }
        }
    }

    synchronized void bWH() {
        if (bWI()) {
            trimToSize(this.ifM.igv);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.ifQ.ifT + this.ifR.ifT) - i, this.ifR.ifT);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hVB, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.ifQ.ifT + this.ifR.ifT), Integer.valueOf(min));
            }
            bUB();
            for (int i2 = 0; i2 < this.ifN.size() && min > 0; i2++) {
                d<V> valueAt = this.ifN.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aI(pop);
                    min -= valueAt.mItemSize;
                    this.ifR.xI(valueAt.mItemSize);
                }
            }
            bUB();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hVB, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.ifQ.ifT + this.ifR.ifT));
            }
        }
    }

    synchronized d<V> xE(int i) {
        d<V> dVar;
        dVar = this.ifN.get(i);
        if (dVar == null && this.ifP) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.hVB, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = xF(i);
            this.ifN.put(i, dVar);
        }
        return dVar;
    }

    d<V> xF(int i) {
        return new d<>(xD(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean bWI() {
        boolean z;
        z = this.ifQ.ifT + this.ifR.ifT > this.ifM.igv;
        if (z) {
            this.ifS.bWW();
        }
        return z;
    }

    synchronized boolean xG(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.ifM.igu;
            if (i > i2 - this.ifQ.ifT) {
                this.ifS.bWX();
            } else {
                int i3 = this.ifM.igv;
                if (i > i3 - (this.ifQ.ifT + this.ifR.ifT)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.ifQ.ifT + this.ifR.ifT)) {
                    this.ifS.bWX();
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
            com.facebook.common.c.a.a(this.hVB, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.ifQ.mCount), Integer.valueOf(this.ifQ.ifT), Integer.valueOf(this.ifR.mCount), Integer.valueOf(this.ifR.ifT));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int ifT;
        int mCount;

        a() {
        }

        public void xH(int i) {
            this.mCount++;
            this.ifT += i;
        }

        public void xI(int i) {
            if (this.ifT >= i && this.mCount > 0) {
                this.mCount--;
                this.ifT -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.ifT), Integer.valueOf(this.mCount));
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
