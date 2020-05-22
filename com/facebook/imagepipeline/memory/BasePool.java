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
/* loaded from: classes12.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b mxx;
    final com.facebook.common.memory.c mvO;
    final Set<V> mxA;
    private boolean mxB;
    @GuardedBy("this")
    final a mxC;
    @GuardedBy("this")
    final a mxD;
    private final s mxE;
    final r mxy;
    private final Class<?> mki = getClass();
    final SparseArray<d<V>> mxz = new SparseArray<>();

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V HJ(int i);

    protected abstract int HK(int i);

    protected abstract int HL(int i);

    protected abstract void bk(V v);

    protected abstract int bl(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.mvO = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.mxy = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.mxE = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.mxy.mym) {
            dAv();
        } else {
            a(new SparseIntArray(0));
        }
        this.mxA = com.facebook.common.internal.i.duq();
        this.mxD = new a();
        this.mxC = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.mvO.a(this);
        this.mxE.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dAu();
        int HK = HK(i);
        synchronized (this) {
            d<V> HN = HN(HK);
            if (HN != null && (o = HN.get()) != null) {
                com.facebook.common.internal.g.checkState(this.mxA.add(o));
                int bl = bl(o);
                int HL = HL(bl);
                this.mxC.HQ(HL);
                this.mxD.HR(HL);
                this.mxE.HX(HL);
                dxX();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mki, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bl));
                }
            } else {
                int HL2 = HL(HK);
                if (!HP(HL2)) {
                    throw new PoolSizeViolationException(this.mxy.myh, this.mxC.mxF, this.mxD.mxF, HL2);
                }
                this.mxC.HQ(HL2);
                if (HN != null) {
                    HN.dAF();
                }
                o = o(HL2, HK, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.mxA.add(o));
                    dAy();
                    this.mxE.HY(HL2);
                    dxX();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.mki, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(HK));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V HJ = HJ(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mki, "alloc success!!");
                return HJ;
            }
            return HJ;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mki, "alloc fail!!");
            }
            if (!z || mxx == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.mki, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (mxx == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.mxC.HR(i);
                    d<V> HN = HN(i2);
                    if (HN != null) {
                        HN.dAG();
                    }
                    com.facebook.common.internal.l.x(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mki, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (mxx == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            mxx.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bl = bl(v);
        int HL = HL(bl);
        synchronized (this) {
            d<V> HM = HM(bl);
            if (!this.mxA.remove(v)) {
                com.facebook.common.c.a.d(this.mki, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bl));
                bk(v);
                this.mxE.HZ(HL);
            } else if (HM == null || HM.dAD() || dAz() || !bm(v)) {
                if (HM != null) {
                    HM.dAG();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mki, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bl));
                }
                bk(v);
                this.mxC.HR(HL);
                this.mxE.HZ(HL);
            } else {
                HM.release(v);
                this.mxD.HQ(HL);
                this.mxC.HR(HL);
                this.mxE.Ia(HL);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mki, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bl));
                }
            }
            dxX();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dAx();
    }

    protected void dAt() {
    }

    protected boolean bm(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dAu() {
        com.facebook.common.internal.g.checkState(!dAz() || this.mxD.mxF == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.mxz.clear();
            SparseIntArray sparseIntArray2 = this.mxy.myj;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.mxz.put(keyAt, new d<>(HL(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mxy.mym));
                }
                this.mxB = false;
            } else {
                this.mxB = true;
            }
        }
    }

    private synchronized void dAv() {
        SparseIntArray sparseIntArray = this.mxy.myj;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.mxB = false;
        } else {
            this.mxB = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.mxz.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mxz.put(keyAt, new d<>(HL(keyAt), sparseIntArray.valueAt(i), 0, this.mxy.mym));
        }
    }

    private List<d<V>> dAw() {
        ArrayList arrayList = new ArrayList(this.mxz.size());
        int size = this.mxz.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.mxz.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.jvR;
            int dxI = valueAt.dxI();
            if (valueAt.dAE() > 0) {
                arrayList.add(valueAt);
            }
            this.mxz.setValueAt(i, new d<>(HL(i2), i3, dxI, this.mxy.mym));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dAx() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.mxy.mym) {
                arrayList = dAw();
            } else {
                arrayList = new ArrayList(this.mxz.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.mxz.size(); i++) {
                    d<V> valueAt = this.mxz.valueAt(i);
                    if (valueAt.dAE() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.mxz.keyAt(i), valueAt.dxI());
                }
                a(sparseIntArray);
            }
            this.mxD.reset();
            dxX();
        }
        dAt();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bk(pop);
            }
        }
    }

    synchronized void dAy() {
        if (dAz()) {
            trimToSize(this.mxy.myi);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.mxC.mxF + this.mxD.mxF) - i, this.mxD.mxF);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mki, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mxC.mxF + this.mxD.mxF), Integer.valueOf(min));
            }
            dxX();
            for (int i2 = 0; i2 < this.mxz.size() && min > 0; i2++) {
                d<V> valueAt = this.mxz.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bk(pop);
                    min -= valueAt.mItemSize;
                    this.mxD.HR(valueAt.mItemSize);
                }
            }
            dxX();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mki, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mxC.mxF + this.mxD.mxF));
            }
        }
    }

    private synchronized d<V> HM(int i) {
        return this.mxz.get(i);
    }

    synchronized d<V> HN(int i) {
        d<V> dVar;
        dVar = this.mxz.get(i);
        if (dVar == null && this.mxB) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mki, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = HO(i);
            this.mxz.put(i, dVar);
        }
        return dVar;
    }

    d<V> HO(int i) {
        return new d<>(HL(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.mxy.mym);
    }

    synchronized boolean dAz() {
        boolean z;
        z = this.mxC.mxF + this.mxD.mxF > this.mxy.myi;
        if (z) {
            this.mxE.dAN();
        }
        return z;
    }

    synchronized boolean HP(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.mxy.myh;
            if (i > i2 - this.mxC.mxF) {
                this.mxE.dAO();
            } else {
                int i3 = this.mxy.myi;
                if (i > i3 - (this.mxC.mxF + this.mxD.mxF)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.mxC.mxF + this.mxD.mxF)) {
                    this.mxE.dAO();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dxX() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.mki, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mxC.mCount), Integer.valueOf(this.mxC.mxF), Integer.valueOf(this.mxD.mCount), Integer.valueOf(this.mxD.mxF));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int mCount;
        int mxF;

        a() {
        }

        public void HQ(int i) {
            this.mCount++;
            this.mxF += i;
        }

        public void HR(int i) {
            if (this.mxF >= i && this.mCount > 0) {
                this.mCount--;
                this.mxF -= i;
                return;
            }
            com.facebook.common.c.a.l("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mxF), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.mxF = 0;
        }
    }

    /* loaded from: classes12.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes12.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes12.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes12.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
