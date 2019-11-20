package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes2.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    final com.facebook.common.memory.c khL;
    final r kjm;
    final Set<V> kjo;
    private boolean kjp;
    @GuardedBy("this")
    final a kjq;
    @GuardedBy("this")
    final a kjr;
    private final s kjs;
    private final Class<?> jYW = getClass();
    final SparseArray<d<V>> kjn = new SparseArray<>();

    protected abstract V Cv(int i);

    protected abstract int Cw(int i);

    protected abstract int Cx(int i);

    protected abstract void aR(V v);

    protected abstract int aS(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.khL = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.kjm = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.kjs = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.kjo = com.facebook.common.internal.h.cCI();
        this.kjr = new a();
        this.kjq = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.khL.a(this);
        this.kjs.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cHV();
        int Cw = Cw(i);
        synchronized (this) {
            d<V> Cy = Cy(Cw);
            if (Cy != null && (v = Cy.get()) != null) {
                com.facebook.common.internal.g.checkState(this.kjo.add(v));
                int aS = aS(v);
                int Cx = Cx(aS);
                this.kjq.CB(Cx);
                this.kjr.CC(Cx);
                this.kjs.CJ(Cx);
                cFL();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jYW, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                }
            } else {
                int Cx2 = Cx(Cw);
                if (!CA(Cx2)) {
                    throw new PoolSizeViolationException(this.kjm.kjT, this.kjq.kjt, this.kjr.kjt, Cx2);
                }
                this.kjq.CB(Cx2);
                if (Cy != null) {
                    Cy.cId();
                }
                v = null;
                try {
                    v = Cv(Cw);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.kjq.CC(Cx2);
                        d<V> Cy2 = Cy(Cw);
                        if (Cy2 != null) {
                            Cy2.cIe();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.kjo.add(v));
                    cHW();
                    this.kjs.CK(Cx2);
                    cFL();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jYW, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Cw));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aS = aS(v);
        int Cx = Cx(aS);
        synchronized (this) {
            d<V> Cy = Cy(aS);
            if (!this.kjo.remove(v)) {
                com.facebook.common.c.a.d(this.jYW, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                aR(v);
                this.kjs.CL(Cx);
            } else if (Cy == null || Cy.cIb() || cHX() || !aT(v)) {
                if (Cy != null) {
                    Cy.cIe();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jYW, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                }
                aR(v);
                this.kjq.CC(Cx);
                this.kjs.CL(Cx);
            } else {
                Cy.release(v);
                this.kjr.CB(Cx);
                this.kjq.CC(Cx);
                this.kjs.CM(Cx);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jYW, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                }
            }
            cFL();
        }
    }

    protected boolean aT(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cHV() {
        com.facebook.common.internal.g.checkState(!cHX() || this.kjr.kjt == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.kjn.clear();
            SparseIntArray sparseIntArray2 = this.kjm.kjV;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.kjn.put(keyAt, new d<>(Cx(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.kjp = false;
            } else {
                this.kjp = true;
            }
        }
    }

    synchronized void cHW() {
        if (cHX()) {
            trimToSize(this.kjm.kjU);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.kjq.kjt + this.kjr.kjt) - i, this.kjr.kjt);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jYW, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.kjq.kjt + this.kjr.kjt), Integer.valueOf(min));
            }
            cFL();
            for (int i2 = 0; i2 < this.kjn.size() && min > 0; i2++) {
                d<V> valueAt = this.kjn.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aR(pop);
                    min -= valueAt.mItemSize;
                    this.kjr.CC(valueAt.mItemSize);
                }
            }
            cFL();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jYW, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.kjq.kjt + this.kjr.kjt));
            }
        }
    }

    synchronized d<V> Cy(int i) {
        d<V> dVar;
        dVar = this.kjn.get(i);
        if (dVar == null && this.kjp) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jYW, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Cz(i);
            this.kjn.put(i, dVar);
        }
        return dVar;
    }

    d<V> Cz(int i) {
        return new d<>(Cx(i), Integer.MAX_VALUE, 0);
    }

    synchronized boolean cHX() {
        boolean z;
        z = this.kjq.kjt + this.kjr.kjt > this.kjm.kjU;
        if (z) {
            this.kjs.cIl();
        }
        return z;
    }

    synchronized boolean CA(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.kjm.kjT;
            if (i > i2 - this.kjq.kjt) {
                this.kjs.cIm();
            } else {
                int i3 = this.kjm.kjU;
                if (i > i3 - (this.kjq.kjt + this.kjr.kjt)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.kjq.kjt + this.kjr.kjt)) {
                    this.kjs.cIm();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cFL() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jYW, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.kjq.mCount), Integer.valueOf(this.kjq.kjt), Integer.valueOf(this.kjr.mCount), Integer.valueOf(this.kjr.kjt));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int kjt;
        int mCount;

        a() {
        }

        public void CB(int i) {
            this.mCount++;
            this.kjt += i;
        }

        public void CC(int i) {
            if (this.kjt >= i && this.mCount > 0) {
                this.mCount--;
                this.kjt -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.kjt), Integer.valueOf(this.mCount));
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
