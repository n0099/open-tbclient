package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes5.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b pMS;
    final com.facebook.common.memory.c pLj;
    final r pMT;
    final Set<V> pMV;
    private boolean pMW;
    @GuardedBy("this")
    final a pMX;
    @GuardedBy("this")
    final a pMY;
    private final s pMZ;
    private final Class<?> pAh = getClass();
    final SparseArray<d<V>> pMU = new SparseArray<>();

    /* loaded from: classes5.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V PU(int i);

    protected abstract int PV(int i);

    protected abstract int PW(int i);

    protected abstract void by(V v);

    protected abstract int bz(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.pLj = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pMT = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pMZ = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pMT.pNH) {
            eyN();
        } else {
            a(new SparseIntArray(0));
        }
        this.pMV = com.facebook.common.internal.i.esQ();
        this.pMY = new a();
        this.pMX = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.pLj.a(this);
        this.pMZ.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        eyM();
        int PV = PV(i);
        synchronized (this) {
            d<V> PY = PY(PV);
            if (PY != null && (o = PY.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pMV.add(o));
                int bz = bz(o);
                int PW = PW(bz);
                this.pMX.Qb(PW);
                this.pMY.Qc(PW);
                this.pMZ.Qi(PW);
                ews();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pAh, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bz));
                }
            } else {
                int PW2 = PW(PV);
                if (!Qa(PW2)) {
                    throw new PoolSizeViolationException(this.pMT.pNC, this.pMX.pNa, this.pMY.pNa, PW2);
                }
                this.pMX.Qb(PW2);
                if (PY != null) {
                    PY.eyV();
                }
                o = o(PW2, PV, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pMV.add(o));
                    eyO();
                    this.pMZ.Qj(PW2);
                    ews();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.pAh, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(PV));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V PU = PU(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pAh, "alloc success!!");
                return PU;
            }
            return PU;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pAh, "alloc fail!!");
            }
            if (!z || pMS == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.g(this.pAh, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pMS == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pMX.Qc(i);
                    d<V> PY = PY(i2);
                    if (PY != null) {
                        PY.eyW();
                    }
                    com.facebook.common.internal.l.r(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pAh, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pMS == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pMS.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bz = bz(v);
        int PW = PW(bz);
        synchronized (this) {
            d<V> PX = PX(bz);
            if (!this.pMV.remove(v)) {
                com.facebook.common.c.a.d(this.pAh, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bz));
                by(v);
                this.pMZ.Qk(PW);
            } else if (PX == null || PX.eyT() || eyP() || !bA(v)) {
                if (PX != null) {
                    PX.eyW();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pAh, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bz));
                }
                by(v);
                this.pMX.Qc(PW);
                this.pMZ.Qk(PW);
            } else {
                PX.release(v);
                this.pMY.Qb(PW);
                this.pMX.Qc(PW);
                this.pMZ.Ql(PW);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pAh, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bz));
                }
            }
            ews();
        }
    }

    protected boolean bA(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void eyM() {
        com.facebook.common.internal.g.checkState(!eyP() || this.pMY.pNa == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pMU.clear();
            SparseIntArray sparseIntArray2 = this.pMT.pNE;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pMU.put(keyAt, new d<>(PW(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pMT.pNH));
                }
                this.pMW = false;
            } else {
                this.pMW = true;
            }
        }
    }

    private synchronized void eyN() {
        SparseIntArray sparseIntArray = this.pMT.pNE;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pMW = false;
        } else {
            this.pMW = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pMU.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pMU.put(keyAt, new d<>(PW(keyAt), sparseIntArray.valueAt(i), 0, this.pMT.pNH));
        }
    }

    synchronized void eyO() {
        if (eyP()) {
            trimToSize(this.pMT.pND);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pMX.pNa + this.pMY.pNa) - i, this.pMY.pNa);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pAh, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pMX.pNa + this.pMY.pNa), Integer.valueOf(min));
            }
            ews();
            for (int i2 = 0; i2 < this.pMU.size() && min > 0; i2++) {
                d<V> valueAt = this.pMU.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    by(pop);
                    min -= valueAt.mItemSize;
                    this.pMY.Qc(valueAt.mItemSize);
                }
            }
            ews();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pAh, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pMX.pNa + this.pMY.pNa));
            }
        }
    }

    private synchronized d<V> PX(int i) {
        return this.pMU.get(i);
    }

    synchronized d<V> PY(int i) {
        d<V> dVar;
        dVar = this.pMU.get(i);
        if (dVar == null && this.pMW) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pAh, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = PZ(i);
            this.pMU.put(i, dVar);
        }
        return dVar;
    }

    d<V> PZ(int i) {
        return new d<>(PW(i), Integer.MAX_VALUE, 0, this.pMT.pNH);
    }

    synchronized boolean eyP() {
        boolean z;
        z = this.pMX.pNa + this.pMY.pNa > this.pMT.pND;
        if (z) {
            this.pMZ.ezd();
        }
        return z;
    }

    synchronized boolean Qa(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pMT.pNC;
            if (i > i2 - this.pMX.pNa) {
                this.pMZ.eze();
            } else {
                int i3 = this.pMT.pND;
                if (i > i3 - (this.pMX.pNa + this.pMY.pNa)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pMX.pNa + this.pMY.pNa)) {
                    this.pMZ.eze();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void ews() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.pAh, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pMX.mCount), Integer.valueOf(this.pMX.pNa), Integer.valueOf(this.pMY.mCount), Integer.valueOf(this.pMY.pNa));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes5.dex */
    public static class a {
        int mCount;
        int pNa;

        a() {
        }

        public void Qb(int i) {
            this.mCount++;
            this.pNa += i;
        }

        public void Qc(int i) {
            if (this.pNa >= i && this.mCount > 0) {
                this.mCount--;
                this.pNa -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pNa), Integer.valueOf(this.mCount));
        }
    }

    /* loaded from: classes5.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes5.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
