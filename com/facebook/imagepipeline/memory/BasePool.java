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
    final com.facebook.common.memory.c khT;
    private final s kjA;
    final r kju;
    final Set<V> kjw;
    private boolean kjx;
    @GuardedBy("this")
    final a kjy;
    @GuardedBy("this")
    final a kjz;
    private final Class<?> jZg = getClass();
    final SparseArray<d<V>> kjv = new SparseArray<>();

    protected abstract V DW(int i);

    protected abstract int DX(int i);

    protected abstract int DY(int i);

    protected abstract void aW(V v);

    protected abstract int aX(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.khT = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.kju = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.kjA = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.kjw = com.facebook.common.internal.h.cEY();
        this.kjz = new a();
        this.kjy = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.khT.a(this);
        this.kjA.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cKm();
        int DX = DX(i);
        synchronized (this) {
            d<V> DZ = DZ(DX);
            if (DZ != null && (v = DZ.get()) != null) {
                com.facebook.common.internal.g.checkState(this.kjw.add(v));
                int aX = aX(v);
                int DY = DY(aX);
                this.kjy.Ec(DY);
                this.kjz.Ed(DY);
                this.kjA.Ek(DY);
                cIc();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jZg, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            } else {
                int DY2 = DY(DX);
                if (!Eb(DY2)) {
                    throw new PoolSizeViolationException(this.kju.kkb, this.kjy.kjB, this.kjz.kjB, DY2);
                }
                this.kjy.Ec(DY2);
                if (DZ != null) {
                    DZ.cKu();
                }
                v = null;
                try {
                    v = DW(DX);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.kjy.Ed(DY2);
                        d<V> DZ2 = DZ(DX);
                        if (DZ2 != null) {
                            DZ2.cKv();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.kjw.add(v));
                    cKn();
                    this.kjA.El(DY2);
                    cIc();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jZg, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(DX));
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
        int DY = DY(aX);
        synchronized (this) {
            d<V> DZ = DZ(aX);
            if (!this.kjw.remove(v)) {
                com.facebook.common.c.a.e(this.jZg, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                aW(v);
                this.kjA.Em(DY);
            } else if (DZ == null || DZ.cKs() || cKo() || !aY(v)) {
                if (DZ != null) {
                    DZ.cKv();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jZg, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
                aW(v);
                this.kjy.Ed(DY);
                this.kjA.Em(DY);
            } else {
                DZ.release(v);
                this.kjz.Ec(DY);
                this.kjy.Ed(DY);
                this.kjA.En(DY);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jZg, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            }
            cIc();
        }
    }

    protected boolean aY(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cKm() {
        com.facebook.common.internal.g.checkState(!cKo() || this.kjz.kjB == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.kjv.clear();
            SparseIntArray sparseIntArray2 = this.kju.kkd;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.kjv.put(keyAt, new d<>(DY(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.kjx = false;
            } else {
                this.kjx = true;
            }
        }
    }

    synchronized void cKn() {
        if (cKo()) {
            trimToSize(this.kju.kkc);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.kjy.kjB + this.kjz.kjB) - i, this.kjz.kjB);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jZg, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.kjy.kjB + this.kjz.kjB), Integer.valueOf(min));
            }
            cIc();
            for (int i2 = 0; i2 < this.kjv.size() && min > 0; i2++) {
                d<V> valueAt = this.kjv.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aW(pop);
                    min -= valueAt.mItemSize;
                    this.kjz.Ed(valueAt.mItemSize);
                }
            }
            cIc();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jZg, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.kjy.kjB + this.kjz.kjB));
            }
        }
    }

    synchronized d<V> DZ(int i) {
        d<V> dVar;
        dVar = this.kjv.get(i);
        if (dVar == null && this.kjx) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jZg, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Ea(i);
            this.kjv.put(i, dVar);
        }
        return dVar;
    }

    d<V> Ea(int i) {
        return new d<>(DY(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cKo() {
        boolean z;
        z = this.kjy.kjB + this.kjz.kjB > this.kju.kkc;
        if (z) {
            this.kjA.cKC();
        }
        return z;
    }

    synchronized boolean Eb(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.kju.kkb;
            if (i > i2 - this.kjy.kjB) {
                this.kjA.cKD();
            } else {
                int i3 = this.kju.kkc;
                if (i > i3 - (this.kjy.kjB + this.kjz.kjB)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.kjy.kjB + this.kjz.kjB)) {
                    this.kjA.cKD();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cIc() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jZg, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.kjy.mCount), Integer.valueOf(this.kjy.kjB), Integer.valueOf(this.kjz.mCount), Integer.valueOf(this.kjz.kjB));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int kjB;
        int mCount;

        a() {
        }

        public void Ec(int i) {
            this.mCount++;
            this.kjB += i;
        }

        public void Ed(int i) {
            if (this.kjB >= i && this.mCount > 0) {
                this.mCount--;
                this.kjB -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.kjB), Integer.valueOf(this.mCount));
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
