package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes2.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    final com.facebook.common.memory.c kkr;
    final r klR;
    final Set<V> klT;
    private boolean klU;
    @GuardedBy("this")
    final a klV;
    @GuardedBy("this")
    final a klW;
    private final s klX;
    private final Class<?> kbD = getClass();
    final SparseArray<d<V>> klS = new SparseArray<>();

    protected abstract V Ea(int i);

    protected abstract int Eb(int i);

    protected abstract int Ec(int i);

    protected abstract void aW(V v);

    protected abstract int aX(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.kkr = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.klR = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.klX = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.klT = com.facebook.common.internal.h.cFM();
        this.klW = new a();
        this.klV = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.kkr.a(this);
        this.klX.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cLa();
        int Eb = Eb(i);
        synchronized (this) {
            d<V> Ed = Ed(Eb);
            if (Ed != null && (v = Ed.get()) != null) {
                com.facebook.common.internal.g.checkState(this.klT.add(v));
                int aX = aX(v);
                int Ec = Ec(aX);
                this.klV.Eg(Ec);
                this.klW.Eh(Ec);
                this.klX.Eo(Ec);
                cIQ();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.kbD, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            } else {
                int Ec2 = Ec(Eb);
                if (!Ef(Ec2)) {
                    throw new PoolSizeViolationException(this.klR.kmy, this.klV.klY, this.klW.klY, Ec2);
                }
                this.klV.Eg(Ec2);
                if (Ed != null) {
                    Ed.cLi();
                }
                v = null;
                try {
                    v = Ea(Eb);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.klV.Eh(Ec2);
                        d<V> Ed2 = Ed(Eb);
                        if (Ed2 != null) {
                            Ed2.cLj();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.klT.add(v));
                    cLb();
                    this.klX.Ep(Ec2);
                    cIQ();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.kbD, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Eb));
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
        int Ec = Ec(aX);
        synchronized (this) {
            d<V> Ed = Ed(aX);
            if (!this.klT.remove(v)) {
                com.facebook.common.c.a.e(this.kbD, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                aW(v);
                this.klX.Eq(Ec);
            } else if (Ed == null || Ed.cLg() || cLc() || !aY(v)) {
                if (Ed != null) {
                    Ed.cLj();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.kbD, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
                aW(v);
                this.klV.Eh(Ec);
                this.klX.Eq(Ec);
            } else {
                Ed.release(v);
                this.klW.Eg(Ec);
                this.klV.Eh(Ec);
                this.klX.Er(Ec);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.kbD, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            }
            cIQ();
        }
    }

    protected boolean aY(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cLa() {
        com.facebook.common.internal.g.checkState(!cLc() || this.klW.klY == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.klS.clear();
            SparseIntArray sparseIntArray2 = this.klR.kmA;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.klS.put(keyAt, new d<>(Ec(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.klU = false;
            } else {
                this.klU = true;
            }
        }
    }

    synchronized void cLb() {
        if (cLc()) {
            trimToSize(this.klR.kmz);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.klV.klY + this.klW.klY) - i, this.klW.klY);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.kbD, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.klV.klY + this.klW.klY), Integer.valueOf(min));
            }
            cIQ();
            for (int i2 = 0; i2 < this.klS.size() && min > 0; i2++) {
                d<V> valueAt = this.klS.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aW(pop);
                    min -= valueAt.mItemSize;
                    this.klW.Eh(valueAt.mItemSize);
                }
            }
            cIQ();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.kbD, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.klV.klY + this.klW.klY));
            }
        }
    }

    synchronized d<V> Ed(int i) {
        d<V> dVar;
        dVar = this.klS.get(i);
        if (dVar == null && this.klU) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.kbD, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Ee(i);
            this.klS.put(i, dVar);
        }
        return dVar;
    }

    d<V> Ee(int i) {
        return new d<>(Ec(i), Integer.MAX_VALUE, 0);
    }

    synchronized boolean cLc() {
        boolean z;
        z = this.klV.klY + this.klW.klY > this.klR.kmz;
        if (z) {
            this.klX.cLq();
        }
        return z;
    }

    synchronized boolean Ef(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.klR.kmy;
            if (i > i2 - this.klV.klY) {
                this.klX.cLr();
            } else {
                int i3 = this.klR.kmz;
                if (i > i3 - (this.klV.klY + this.klW.klY)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.klV.klY + this.klW.klY)) {
                    this.klX.cLr();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cIQ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.kbD, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.klV.mCount), Integer.valueOf(this.klV.klY), Integer.valueOf(this.klW.mCount), Integer.valueOf(this.klW.klY));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int klY;
        int mCount;

        a() {
        }

        public void Eg(int i) {
            this.mCount++;
            this.klY += i;
        }

        public void Eh(int i) {
            if (this.klY >= i && this.mCount > 0) {
                this.mCount--;
                this.klY -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.klY), Integer.valueOf(this.mCount));
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
