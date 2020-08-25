package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.support.v7.widget.ActivityChooserView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes8.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b nwK;
    final com.facebook.common.memory.c nuZ;
    final r nwL;
    final Set<V> nwN;
    private boolean nwO;
    @GuardedBy("this")
    final a nwP;
    @GuardedBy("this")
    final a nwQ;
    private final s nwR;
    private final Class<?> nju = getClass();
    final SparseArray<d<V>> nwM = new SparseArray<>();

    /* loaded from: classes8.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V LR(int i);

    protected abstract int LS(int i);

    protected abstract int LT(int i);

    protected abstract void bn(V v);

    protected abstract int bo(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.nuZ = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.nwL = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.nwR = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.nwL.nxz) {
            dUB();
        } else {
            a(new SparseIntArray(0));
        }
        this.nwN = com.facebook.common.internal.i.dOy();
        this.nwQ = new a();
        this.nwP = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.nuZ.a(this);
        this.nwR.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        dUA();
        int LS = LS(i);
        synchronized (this) {
            d<V> LV = LV(LS);
            if (LV != null && (m = LV.get()) != null) {
                com.facebook.common.internal.g.checkState(this.nwN.add(m));
                int bo = bo(m);
                int LT = LT(bo);
                this.nwP.LY(LT);
                this.nwQ.LZ(LT);
                this.nwR.Mf(LT);
                dSd();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.nju, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bo));
                }
            } else {
                int LT2 = LT(LS);
                if (!LX(LT2)) {
                    throw new PoolSizeViolationException(this.nwL.nxu, this.nwP.nwS, this.nwQ.nwS, LT2);
                }
                this.nwP.LY(LT2);
                if (LV != null) {
                    LV.dUL();
                }
                m = m(LT2, LS, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.nwN.add(m));
                    dUE();
                    this.nwR.Mg(LT2);
                    dSd();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.nju, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(LS));
                    }
                }
            }
        }
        return m;
    }

    private V m(int i, int i2, boolean z) {
        try {
            V LR = LR(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.nju, "alloc success!!");
                return LR;
            }
            return LR;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.nju, "alloc fail!!");
            }
            if (!z || nwK == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.nju, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (nwK == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.nwP.LZ(i);
                    d<V> LV = LV(i2);
                    if (LV != null) {
                        LV.dUM();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.nju, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (nwK == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            nwK.onFailed();
            return m(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bo = bo(v);
        int LT = LT(bo);
        synchronized (this) {
            d<V> LU = LU(bo);
            if (!this.nwN.remove(v)) {
                com.facebook.common.c.a.d(this.nju, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                bn(v);
                this.nwR.Mh(LT);
            } else if (LU == null || LU.dUJ() || dUF() || !bp(v)) {
                if (LU != null) {
                    LU.dUM();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.nju, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
                bn(v);
                this.nwP.LZ(LT);
                this.nwR.Mh(LT);
            } else {
                LU.release(v);
                this.nwQ.LY(LT);
                this.nwP.LZ(LT);
                this.nwR.Mi(LT);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.nju, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
            }
            dSd();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dUD();
    }

    protected void dUz() {
    }

    protected boolean bp(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dUA() {
        com.facebook.common.internal.g.checkState(!dUF() || this.nwQ.nwS == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.nwM.clear();
            SparseIntArray sparseIntArray2 = this.nwL.nxw;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.nwM.put(keyAt, new d<>(LT(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.nwL.nxz));
                }
                this.nwO = false;
            } else {
                this.nwO = true;
            }
        }
    }

    private synchronized void dUB() {
        SparseIntArray sparseIntArray = this.nwL.nxw;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.nwO = false;
        } else {
            this.nwO = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.nwM.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.nwM.put(keyAt, new d<>(LT(keyAt), sparseIntArray.valueAt(i), 0, this.nwL.nxz));
        }
    }

    private List<d<V>> dUC() {
        ArrayList arrayList = new ArrayList(this.nwM.size());
        int size = this.nwM.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.nwM.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.kol;
            int dRO = valueAt.dRO();
            if (valueAt.dUK() > 0) {
                arrayList.add(valueAt);
            }
            this.nwM.setValueAt(i, new d<>(LT(i2), i3, dRO, this.nwL.nxz));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dUD() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.nwL.nxz) {
                arrayList = dUC();
            } else {
                arrayList = new ArrayList(this.nwM.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.nwM.size(); i++) {
                    d<V> valueAt = this.nwM.valueAt(i);
                    if (valueAt.dUK() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.nwM.keyAt(i), valueAt.dRO());
                }
                a(sparseIntArray);
            }
            this.nwQ.reset();
            dSd();
        }
        dUz();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bn(pop);
            }
        }
    }

    synchronized void dUE() {
        if (dUF()) {
            trimToSize(this.nwL.nxv);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.nwP.nwS + this.nwQ.nwS) - i, this.nwQ.nwS);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.nju, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.nwP.nwS + this.nwQ.nwS), Integer.valueOf(min));
            }
            dSd();
            for (int i2 = 0; i2 < this.nwM.size() && min > 0; i2++) {
                d<V> valueAt = this.nwM.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bn(pop);
                    min -= valueAt.mItemSize;
                    this.nwQ.LZ(valueAt.mItemSize);
                }
            }
            dSd();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.nju, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.nwP.nwS + this.nwQ.nwS));
            }
        }
    }

    private synchronized d<V> LU(int i) {
        return this.nwM.get(i);
    }

    synchronized d<V> LV(int i) {
        d<V> dVar;
        dVar = this.nwM.get(i);
        if (dVar == null && this.nwO) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.nju, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = LW(i);
            this.nwM.put(i, dVar);
        }
        return dVar;
    }

    d<V> LW(int i) {
        return new d<>(LT(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.nwL.nxz);
    }

    synchronized boolean dUF() {
        boolean z;
        z = this.nwP.nwS + this.nwQ.nwS > this.nwL.nxv;
        if (z) {
            this.nwR.dUT();
        }
        return z;
    }

    synchronized boolean LX(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.nwL.nxu;
            if (i > i2 - this.nwP.nwS) {
                this.nwR.dUU();
            } else {
                int i3 = this.nwL.nxv;
                if (i > i3 - (this.nwP.nwS + this.nwQ.nwS)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.nwP.nwS + this.nwQ.nwS)) {
                    this.nwR.dUU();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dSd() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.nju, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.nwP.mCount), Integer.valueOf(this.nwP.nwS), Integer.valueOf(this.nwQ.mCount), Integer.valueOf(this.nwQ.nwS));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes8.dex */
    public static class a {
        int mCount;
        int nwS;

        a() {
        }

        public void LY(int i) {
            this.mCount++;
            this.nwS += i;
        }

        public void LZ(int i) {
            if (this.nwS >= i && this.mCount > 0) {
                this.mCount--;
                this.nwS -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.nwS), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.nwS = 0;
        }
    }

    /* loaded from: classes8.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes8.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes8.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes8.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
