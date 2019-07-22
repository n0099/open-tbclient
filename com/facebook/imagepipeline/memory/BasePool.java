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
    final com.facebook.common.memory.c kgN;
    final r kio;
    final Set<V> kiq;
    private boolean kir;
    @GuardedBy("this")
    final a kis;
    @GuardedBy("this")
    final a kit;
    private final s kiu;
    private final Class<?> jYa = getClass();
    final SparseArray<d<V>> kip = new SparseArray<>();

    protected abstract V DU(int i);

    protected abstract int DV(int i);

    protected abstract int DW(int i);

    protected abstract void aW(V v);

    protected abstract int aX(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.kgN = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.kio = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.kiu = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.kiq = com.facebook.common.internal.h.cED();
        this.kit = new a();
        this.kis = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.kgN.a(this);
        this.kiu.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cJR();
        int DV = DV(i);
        synchronized (this) {
            d<V> DX = DX(DV);
            if (DX != null && (v = DX.get()) != null) {
                com.facebook.common.internal.g.checkState(this.kiq.add(v));
                int aX = aX(v);
                int DW = DW(aX);
                this.kis.Ea(DW);
                this.kit.Eb(DW);
                this.kiu.Ei(DW);
                cHH();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jYa, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            } else {
                int DW2 = DW(DV);
                if (!DZ(DW2)) {
                    throw new PoolSizeViolationException(this.kio.kiV, this.kis.kiv, this.kit.kiv, DW2);
                }
                this.kis.Ea(DW2);
                if (DX != null) {
                    DX.cJZ();
                }
                v = null;
                try {
                    v = DU(DV);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.kis.Eb(DW2);
                        d<V> DX2 = DX(DV);
                        if (DX2 != null) {
                            DX2.cKa();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.kiq.add(v));
                    cJS();
                    this.kiu.Ej(DW2);
                    cHH();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jYa, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(DV));
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
        int DW = DW(aX);
        synchronized (this) {
            d<V> DX = DX(aX);
            if (!this.kiq.remove(v)) {
                com.facebook.common.c.a.e(this.jYa, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                aW(v);
                this.kiu.Ek(DW);
            } else if (DX == null || DX.cJX() || cJT() || !aY(v)) {
                if (DX != null) {
                    DX.cKa();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jYa, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
                aW(v);
                this.kis.Eb(DW);
                this.kiu.Ek(DW);
            } else {
                DX.release(v);
                this.kit.Ea(DW);
                this.kis.Eb(DW);
                this.kiu.El(DW);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jYa, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aX));
                }
            }
            cHH();
        }
    }

    protected boolean aY(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cJR() {
        com.facebook.common.internal.g.checkState(!cJT() || this.kit.kiv == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.kip.clear();
            SparseIntArray sparseIntArray2 = this.kio.kiX;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.kip.put(keyAt, new d<>(DW(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.kir = false;
            } else {
                this.kir = true;
            }
        }
    }

    synchronized void cJS() {
        if (cJT()) {
            trimToSize(this.kio.kiW);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.kis.kiv + this.kit.kiv) - i, this.kit.kiv);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jYa, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.kis.kiv + this.kit.kiv), Integer.valueOf(min));
            }
            cHH();
            for (int i2 = 0; i2 < this.kip.size() && min > 0; i2++) {
                d<V> valueAt = this.kip.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aW(pop);
                    min -= valueAt.mItemSize;
                    this.kit.Eb(valueAt.mItemSize);
                }
            }
            cHH();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jYa, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.kis.kiv + this.kit.kiv));
            }
        }
    }

    synchronized d<V> DX(int i) {
        d<V> dVar;
        dVar = this.kip.get(i);
        if (dVar == null && this.kir) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jYa, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = DY(i);
            this.kip.put(i, dVar);
        }
        return dVar;
    }

    d<V> DY(int i) {
        return new d<>(DW(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cJT() {
        boolean z;
        z = this.kis.kiv + this.kit.kiv > this.kio.kiW;
        if (z) {
            this.kiu.cKh();
        }
        return z;
    }

    synchronized boolean DZ(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.kio.kiV;
            if (i > i2 - this.kis.kiv) {
                this.kiu.cKi();
            } else {
                int i3 = this.kio.kiW;
                if (i > i3 - (this.kis.kiv + this.kit.kiv)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.kis.kiv + this.kit.kiv)) {
                    this.kiu.cKi();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cHH() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jYa, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.kis.mCount), Integer.valueOf(this.kis.kiv), Integer.valueOf(this.kit.mCount), Integer.valueOf(this.kit.kiv));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int kiv;
        int mCount;

        a() {
        }

        public void Ea(int i) {
            this.mCount++;
            this.kiv += i;
        }

        public void Eb(int i) {
            if (this.kiv >= i && this.mCount > 0) {
                this.mCount--;
                this.kiv -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.kiv), Integer.valueOf(this.mCount));
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
