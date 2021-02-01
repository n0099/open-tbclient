package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes5.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b pKn;
    final com.facebook.common.memory.c pIE;
    final r pKo;
    final Set<V> pKq;
    private boolean pKr;
    @GuardedBy("this")
    final a pKs;
    @GuardedBy("this")
    final a pKt;
    private final s pKu;
    private final Class<?> pxC = getClass();
    final SparseArray<d<V>> pKp = new SparseArray<>();

    /* loaded from: classes5.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V PP(int i);

    protected abstract int PQ(int i);

    protected abstract int PR(int i);

    protected abstract void bw(V v);

    protected abstract int bx(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.pIE = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pKo = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pKu = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pKo.pLc) {
            eyw();
        } else {
            a(new SparseIntArray(0));
        }
        this.pKq = com.facebook.common.internal.i.esz();
        this.pKt = new a();
        this.pKs = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.pIE.a(this);
        this.pKu.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        eyv();
        int PQ = PQ(i);
        synchronized (this) {
            d<V> PT = PT(PQ);
            if (PT != null && (o = PT.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pKq.add(o));
                int bx = bx(o);
                int PR = PR(bx);
                this.pKs.PW(PR);
                this.pKt.PX(PR);
                this.pKu.Qd(PR);
                ewb();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pxC, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bx));
                }
            } else {
                int PR2 = PR(PQ);
                if (!PV(PR2)) {
                    throw new PoolSizeViolationException(this.pKo.pKX, this.pKs.pKv, this.pKt.pKv, PR2);
                }
                this.pKs.PW(PR2);
                if (PT != null) {
                    PT.eyE();
                }
                o = o(PR2, PQ, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pKq.add(o));
                    eyx();
                    this.pKu.Qe(PR2);
                    ewb();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.pxC, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(PQ));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V PP = PP(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pxC, "alloc success!!");
                return PP;
            }
            return PP;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pxC, "alloc fail!!");
            }
            if (!z || pKn == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.g(this.pxC, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pKn == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pKs.PX(i);
                    d<V> PT = PT(i2);
                    if (PT != null) {
                        PT.eyF();
                    }
                    com.facebook.common.internal.l.r(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pxC, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pKn == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pKn.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bx = bx(v);
        int PR = PR(bx);
        synchronized (this) {
            d<V> PS = PS(bx);
            if (!this.pKq.remove(v)) {
                com.facebook.common.c.a.d(this.pxC, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.pKu.Qf(PR);
            } else if (PS == null || PS.eyC() || eyy() || !by(v)) {
                if (PS != null) {
                    PS.eyF();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pxC, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.pKs.PX(PR);
                this.pKu.Qf(PR);
            } else {
                PS.release(v);
                this.pKt.PW(PR);
                this.pKs.PX(PR);
                this.pKu.Qg(PR);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pxC, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            ewb();
        }
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void eyv() {
        com.facebook.common.internal.g.checkState(!eyy() || this.pKt.pKv == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pKp.clear();
            SparseIntArray sparseIntArray2 = this.pKo.pKZ;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pKp.put(keyAt, new d<>(PR(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pKo.pLc));
                }
                this.pKr = false;
            } else {
                this.pKr = true;
            }
        }
    }

    private synchronized void eyw() {
        SparseIntArray sparseIntArray = this.pKo.pKZ;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pKr = false;
        } else {
            this.pKr = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pKp.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pKp.put(keyAt, new d<>(PR(keyAt), sparseIntArray.valueAt(i), 0, this.pKo.pLc));
        }
    }

    synchronized void eyx() {
        if (eyy()) {
            trimToSize(this.pKo.pKY);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pKs.pKv + this.pKt.pKv) - i, this.pKt.pKv);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pxC, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pKs.pKv + this.pKt.pKv), Integer.valueOf(min));
            }
            ewb();
            for (int i2 = 0; i2 < this.pKp.size() && min > 0; i2++) {
                d<V> valueAt = this.pKp.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.pKt.PX(valueAt.mItemSize);
                }
            }
            ewb();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pxC, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pKs.pKv + this.pKt.pKv));
            }
        }
    }

    private synchronized d<V> PS(int i) {
        return this.pKp.get(i);
    }

    synchronized d<V> PT(int i) {
        d<V> dVar;
        dVar = this.pKp.get(i);
        if (dVar == null && this.pKr) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.c(this.pxC, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = PU(i);
            this.pKp.put(i, dVar);
        }
        return dVar;
    }

    d<V> PU(int i) {
        return new d<>(PR(i), Integer.MAX_VALUE, 0, this.pKo.pLc);
    }

    synchronized boolean eyy() {
        boolean z;
        z = this.pKs.pKv + this.pKt.pKv > this.pKo.pKY;
        if (z) {
            this.pKu.eyM();
        }
        return z;
    }

    synchronized boolean PV(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pKo.pKX;
            if (i > i2 - this.pKs.pKv) {
                this.pKu.eyN();
            } else {
                int i3 = this.pKo.pKY;
                if (i > i3 - (this.pKs.pKv + this.pKt.pKv)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pKs.pKv + this.pKt.pKv)) {
                    this.pKu.eyN();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void ewb() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.pxC, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pKs.mCount), Integer.valueOf(this.pKs.pKv), Integer.valueOf(this.pKt.mCount), Integer.valueOf(this.pKt.pKv));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes5.dex */
    public static class a {
        int mCount;
        int pKv;

        a() {
        }

        public void PW(int i) {
            this.mCount++;
            this.pKv += i;
        }

        public void PX(int i) {
            if (this.pKv >= i && this.mCount > 0) {
                this.mCount--;
                this.pKv -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pKv), Integer.valueOf(this.mCount));
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
