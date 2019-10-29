package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes2.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    final com.facebook.common.memory.c kiD;
    final r kkd;
    final Set<V> kkf;
    private boolean kkg;
    @GuardedBy("this")
    final a kkh;
    @GuardedBy("this")
    final a kki;
    private final s kkj;
    private final Class<?> jZN = getClass();
    final SparseArray<d<V>> kke = new SparseArray<>();

    protected abstract V Cw(int i);

    protected abstract int Cx(int i);

    protected abstract int Cy(int i);

    protected abstract void aR(V v);

    protected abstract int aS(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.kiD = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.kkd = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.kkj = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.kkf = com.facebook.common.internal.h.cCK();
        this.kki = new a();
        this.kkh = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.kiD.a(this);
        this.kkj.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cHX();
        int Cx = Cx(i);
        synchronized (this) {
            d<V> Cz = Cz(Cx);
            if (Cz != null && (v = Cz.get()) != null) {
                com.facebook.common.internal.g.checkState(this.kkf.add(v));
                int aS = aS(v);
                int Cy = Cy(aS);
                this.kkh.CC(Cy);
                this.kki.CD(Cy);
                this.kkj.CK(Cy);
                cFN();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jZN, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                }
            } else {
                int Cy2 = Cy(Cx);
                if (!CB(Cy2)) {
                    throw new PoolSizeViolationException(this.kkd.kkK, this.kkh.kkk, this.kki.kkk, Cy2);
                }
                this.kkh.CC(Cy2);
                if (Cz != null) {
                    Cz.cIf();
                }
                v = null;
                try {
                    v = Cw(Cx);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.kkh.CD(Cy2);
                        d<V> Cz2 = Cz(Cx);
                        if (Cz2 != null) {
                            Cz2.cIg();
                        }
                        com.facebook.common.internal.k.p(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.kkf.add(v));
                    cHY();
                    this.kkj.CL(Cy2);
                    cFN();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jZN, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Cx));
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
        int Cy = Cy(aS);
        synchronized (this) {
            d<V> Cz = Cz(aS);
            if (!this.kkf.remove(v)) {
                com.facebook.common.c.a.d(this.jZN, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                aR(v);
                this.kkj.CM(Cy);
            } else if (Cz == null || Cz.cId() || cHZ() || !aT(v)) {
                if (Cz != null) {
                    Cz.cIg();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jZN, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                }
                aR(v);
                this.kkh.CD(Cy);
                this.kkj.CM(Cy);
            } else {
                Cz.release(v);
                this.kki.CC(Cy);
                this.kkh.CD(Cy);
                this.kkj.CN(Cy);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jZN, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aS));
                }
            }
            cFN();
        }
    }

    protected boolean aT(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cHX() {
        com.facebook.common.internal.g.checkState(!cHZ() || this.kki.kkk == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.kke.clear();
            SparseIntArray sparseIntArray2 = this.kkd.kkM;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.kke.put(keyAt, new d<>(Cy(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.kkg = false;
            } else {
                this.kkg = true;
            }
        }
    }

    synchronized void cHY() {
        if (cHZ()) {
            trimToSize(this.kkd.kkL);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.kkh.kkk + this.kki.kkk) - i, this.kki.kkk);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jZN, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.kkh.kkk + this.kki.kkk), Integer.valueOf(min));
            }
            cFN();
            for (int i2 = 0; i2 < this.kke.size() && min > 0; i2++) {
                d<V> valueAt = this.kke.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aR(pop);
                    min -= valueAt.mItemSize;
                    this.kki.CD(valueAt.mItemSize);
                }
            }
            cFN();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jZN, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.kkh.kkk + this.kki.kkk));
            }
        }
    }

    synchronized d<V> Cz(int i) {
        d<V> dVar;
        dVar = this.kke.get(i);
        if (dVar == null && this.kkg) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jZN, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = CA(i);
            this.kke.put(i, dVar);
        }
        return dVar;
    }

    d<V> CA(int i) {
        return new d<>(Cy(i), Integer.MAX_VALUE, 0);
    }

    synchronized boolean cHZ() {
        boolean z;
        z = this.kkh.kkk + this.kki.kkk > this.kkd.kkL;
        if (z) {
            this.kkj.cIn();
        }
        return z;
    }

    synchronized boolean CB(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.kkd.kkK;
            if (i > i2 - this.kkh.kkk) {
                this.kkj.cIo();
            } else {
                int i3 = this.kkd.kkL;
                if (i > i3 - (this.kkh.kkk + this.kki.kkk)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.kkh.kkk + this.kki.kkk)) {
                    this.kkj.cIo();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cFN() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jZN, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.kkh.mCount), Integer.valueOf(this.kkh.kkk), Integer.valueOf(this.kki.mCount), Integer.valueOf(this.kki.kkk));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int kkk;
        int mCount;

        a() {
        }

        public void CC(int i) {
            this.mCount++;
            this.kkk += i;
        }

        public void CD(int i) {
            if (this.kkk >= i && this.mCount > 0) {
                this.mCount--;
                this.kkk -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.kkk), Integer.valueOf(this.mCount));
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
