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
    final com.facebook.common.memory.c jHv;
    final r jIV;
    final Set<V> jIX;
    private boolean jIY;
    @GuardedBy("this")
    final a jIZ;
    @GuardedBy("this")
    final a jJa;
    private final s jJb;
    private final Class<?> jyG = getClass();
    final SparseArray<d<V>> jIW = new SparseArray<>();

    protected abstract V Ct(int i);

    protected abstract int Cu(int i);

    protected abstract int Cv(int i);

    protected abstract void aY(V v);

    protected abstract int aZ(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jHv = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.jIV = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.jJb = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.jIX = com.facebook.common.internal.h.ctL();
        this.jJa = new a();
        this.jIZ = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jHv.a(this);
        this.jJb.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cyX();
        int Cu = Cu(i);
        synchronized (this) {
            d<V> Cw = Cw(Cu);
            if (Cw != null && (v = Cw.get()) != null) {
                com.facebook.common.internal.g.checkState(this.jIX.add(v));
                int aZ = aZ(v);
                int Cv = Cv(aZ);
                this.jIZ.Cz(Cv);
                this.jJa.CA(Cv);
                this.jJb.CH(Cv);
                cwO();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                }
            } else {
                int Cv2 = Cv(Cu);
                if (!Cy(Cv2)) {
                    throw new PoolSizeViolationException(this.jIV.jJC, this.jIZ.jJc, this.jJa.jJc, Cv2);
                }
                this.jIZ.Cz(Cv2);
                if (Cw != null) {
                    Cw.czf();
                }
                v = null;
                try {
                    v = Ct(Cu);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.jIZ.CA(Cv2);
                        d<V> Cw2 = Cw(Cu);
                        if (Cw2 != null) {
                            Cw2.czg();
                        }
                        com.facebook.common.internal.k.r(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.jIX.add(v));
                    cyY();
                    this.jJb.CI(Cv2);
                    cwO();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jyG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Cu));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aZ = aZ(v);
        int Cv = Cv(aZ);
        synchronized (this) {
            d<V> Cw = Cw(aZ);
            if (!this.jIX.remove(v)) {
                com.facebook.common.c.a.e(this.jyG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                aY(v);
                this.jJb.CJ(Cv);
            } else if (Cw == null || Cw.czd() || cyZ() || !ba(v)) {
                if (Cw != null) {
                    Cw.czg();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                }
                aY(v);
                this.jIZ.CA(Cv);
                this.jJb.CJ(Cv);
            } else {
                Cw.release(v);
                this.jJa.Cz(Cv);
                this.jIZ.CA(Cv);
                this.jJb.CK(Cv);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aZ));
                }
            }
            cwO();
        }
    }

    protected boolean ba(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cyX() {
        com.facebook.common.internal.g.checkState(!cyZ() || this.jJa.jJc == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.jIW.clear();
            SparseIntArray sparseIntArray2 = this.jIV.jJE;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.jIW.put(keyAt, new d<>(Cv(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.jIY = false;
            } else {
                this.jIY = true;
            }
        }
    }

    synchronized void cyY() {
        if (cyZ()) {
            trimToSize(this.jIV.jJD);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.jIZ.jJc + this.jJa.jJc) - i, this.jJa.jJc);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.jIZ.jJc + this.jJa.jJc), Integer.valueOf(min));
            }
            cwO();
            for (int i2 = 0; i2 < this.jIW.size() && min > 0; i2++) {
                d<V> valueAt = this.jIW.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aY(pop);
                    min -= valueAt.mItemSize;
                    this.jJa.CA(valueAt.mItemSize);
                }
            }
            cwO();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.jIZ.jJc + this.jJa.jJc));
            }
        }
    }

    synchronized d<V> Cw(int i) {
        d<V> dVar;
        dVar = this.jIW.get(i);
        if (dVar == null && this.jIY) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyG, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Cx(i);
            this.jIW.put(i, dVar);
        }
        return dVar;
    }

    d<V> Cx(int i) {
        return new d<>(Cv(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cyZ() {
        boolean z;
        z = this.jIZ.jJc + this.jJa.jJc > this.jIV.jJD;
        if (z) {
            this.jJb.czn();
        }
        return z;
    }

    synchronized boolean Cy(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.jIV.jJC;
            if (i > i2 - this.jIZ.jJc) {
                this.jJb.czo();
            } else {
                int i3 = this.jIV.jJD;
                if (i > i3 - (this.jIZ.jJc + this.jJa.jJc)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.jIZ.jJc + this.jJa.jJc)) {
                    this.jJb.czo();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cwO() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jyG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.jIZ.mCount), Integer.valueOf(this.jIZ.jJc), Integer.valueOf(this.jJa.mCount), Integer.valueOf(this.jJa.jJc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int jJc;
        int mCount;

        a() {
        }

        public void Cz(int i) {
            this.mCount++;
            this.jJc += i;
        }

        public void CA(int i) {
            if (this.jJc >= i && this.mCount > 0) {
                this.mCount--;
                this.jJc -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.jJc), Integer.valueOf(this.mCount));
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
