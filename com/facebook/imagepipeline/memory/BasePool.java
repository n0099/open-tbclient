package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes5.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b pKN;
    final com.facebook.common.memory.c pJe;
    final r pKO;
    final Set<V> pKQ;
    private boolean pKR;
    @GuardedBy("this")
    final a pKS;
    @GuardedBy("this")
    final a pKT;
    private final s pKU;
    private final Class<?> pyc = getClass();
    final SparseArray<d<V>> pKP = new SparseArray<>();

    /* loaded from: classes5.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V PQ(int i);

    protected abstract int PR(int i);

    protected abstract int PS(int i);

    protected abstract void bw(V v);

    protected abstract int bx(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.pJe = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pKO = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pKU = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pKO.pLC) {
            eyE();
        } else {
            a(new SparseIntArray(0));
        }
        this.pKQ = com.facebook.common.internal.i.esH();
        this.pKT = new a();
        this.pKS = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.pJe.a(this);
        this.pKU.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        eyD();
        int PR = PR(i);
        synchronized (this) {
            d<V> PU = PU(PR);
            if (PU != null && (o = PU.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pKQ.add(o));
                int bx = bx(o);
                int PS = PS(bx);
                this.pKS.PX(PS);
                this.pKT.PY(PS);
                this.pKU.Qe(PS);
                ewj();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pyc, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bx));
                }
            } else {
                int PS2 = PS(PR);
                if (!PW(PS2)) {
                    throw new PoolSizeViolationException(this.pKO.pLx, this.pKS.pKV, this.pKT.pKV, PS2);
                }
                this.pKS.PX(PS2);
                if (PU != null) {
                    PU.eyM();
                }
                o = o(PS2, PR, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pKQ.add(o));
                    eyF();
                    this.pKU.Qf(PS2);
                    ewj();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.pyc, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(PR));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V PQ = PQ(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pyc, "alloc success!!");
                return PQ;
            }
            return PQ;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pyc, "alloc fail!!");
            }
            if (!z || pKN == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.g(this.pyc, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pKN == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pKS.PY(i);
                    d<V> PU = PU(i2);
                    if (PU != null) {
                        PU.eyN();
                    }
                    com.facebook.common.internal.l.r(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pyc, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pKN == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pKN.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bx = bx(v);
        int PS = PS(bx);
        synchronized (this) {
            d<V> PT = PT(bx);
            if (!this.pKQ.remove(v)) {
                com.facebook.common.c.a.d(this.pyc, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.pKU.Qg(PS);
            } else if (PT == null || PT.eyK() || eyG() || !by(v)) {
                if (PT != null) {
                    PT.eyN();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pyc, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.pKS.PY(PS);
                this.pKU.Qg(PS);
            } else {
                PT.release(v);
                this.pKT.PX(PS);
                this.pKS.PY(PS);
                this.pKU.Qh(PS);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pyc, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            ewj();
        }
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void eyD() {
        com.facebook.common.internal.g.checkState(!eyG() || this.pKT.pKV == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pKP.clear();
            SparseIntArray sparseIntArray2 = this.pKO.pLz;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pKP.put(keyAt, new d<>(PS(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pKO.pLC));
                }
                this.pKR = false;
            } else {
                this.pKR = true;
            }
        }
    }

    private synchronized void eyE() {
        SparseIntArray sparseIntArray = this.pKO.pLz;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pKR = false;
        } else {
            this.pKR = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pKP.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pKP.put(keyAt, new d<>(PS(keyAt), sparseIntArray.valueAt(i), 0, this.pKO.pLC));
        }
    }

    synchronized void eyF() {
        if (eyG()) {
            trimToSize(this.pKO.pLy);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pKS.pKV + this.pKT.pKV) - i, this.pKT.pKV);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pyc, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pKS.pKV + this.pKT.pKV), Integer.valueOf(min));
            }
            ewj();
            for (int i2 = 0; i2 < this.pKP.size() && min > 0; i2++) {
                d<V> valueAt = this.pKP.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.pKT.PY(valueAt.mItemSize);
                }
            }
            ewj();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pyc, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pKS.pKV + this.pKT.pKV));
            }
        }
    }

    private synchronized d<V> PT(int i) {
        return this.pKP.get(i);
    }

    synchronized d<V> PU(int i) {
        d<V> dVar;
        dVar = this.pKP.get(i);
        if (dVar == null && this.pKR) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.c(this.pyc, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = PV(i);
            this.pKP.put(i, dVar);
        }
        return dVar;
    }

    d<V> PV(int i) {
        return new d<>(PS(i), Integer.MAX_VALUE, 0, this.pKO.pLC);
    }

    synchronized boolean eyG() {
        boolean z;
        z = this.pKS.pKV + this.pKT.pKV > this.pKO.pLy;
        if (z) {
            this.pKU.eyU();
        }
        return z;
    }

    synchronized boolean PW(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pKO.pLx;
            if (i > i2 - this.pKS.pKV) {
                this.pKU.eyV();
            } else {
                int i3 = this.pKO.pLy;
                if (i > i3 - (this.pKS.pKV + this.pKT.pKV)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pKS.pKV + this.pKT.pKV)) {
                    this.pKU.eyV();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void ewj() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.pyc, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pKS.mCount), Integer.valueOf(this.pKS.pKV), Integer.valueOf(this.pKT.mCount), Integer.valueOf(this.pKT.pKV));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes5.dex */
    public static class a {
        int mCount;
        int pKV;

        a() {
        }

        public void PX(int i) {
            this.mCount++;
            this.pKV += i;
        }

        public void PY(int i) {
            if (this.pKV >= i && this.mCount > 0) {
                this.mCount--;
                this.pKV -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pKV), Integer.valueOf(this.mCount));
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
