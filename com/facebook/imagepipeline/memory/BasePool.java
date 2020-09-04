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
    private static b nxc;
    final com.facebook.common.memory.c nvr;
    final r nxd;
    final Set<V> nxf;
    private boolean nxg;
    @GuardedBy("this")
    final a nxh;
    @GuardedBy("this")
    final a nxi;
    private final s nxj;
    private final Class<?> njM = getClass();
    final SparseArray<d<V>> nxe = new SparseArray<>();

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
        this.nvr = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.nxd = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.nxj = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.nxd.nxR) {
            dUK();
        } else {
            a(new SparseIntArray(0));
        }
        this.nxf = com.facebook.common.internal.i.dOH();
        this.nxi = new a();
        this.nxh = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.nvr.a(this);
        this.nxj.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        dUJ();
        int LS = LS(i);
        synchronized (this) {
            d<V> LV = LV(LS);
            if (LV != null && (m = LV.get()) != null) {
                com.facebook.common.internal.g.checkState(this.nxf.add(m));
                int bo = bo(m);
                int LT = LT(bo);
                this.nxh.LY(LT);
                this.nxi.LZ(LT);
                this.nxj.Mf(LT);
                dSm();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.njM, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bo));
                }
            } else {
                int LT2 = LT(LS);
                if (!LX(LT2)) {
                    throw new PoolSizeViolationException(this.nxd.nxM, this.nxh.nxk, this.nxi.nxk, LT2);
                }
                this.nxh.LY(LT2);
                if (LV != null) {
                    LV.dUU();
                }
                m = m(LT2, LS, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.nxf.add(m));
                    dUN();
                    this.nxj.Mg(LT2);
                    dSm();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.njM, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(LS));
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
                com.facebook.common.c.a.f(this.njM, "alloc success!!");
                return LR;
            }
            return LR;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.njM, "alloc fail!!");
            }
            if (!z || nxc == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.njM, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (nxc == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.nxh.LZ(i);
                    d<V> LV = LV(i2);
                    if (LV != null) {
                        LV.dUV();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.njM, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (nxc == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            nxc.onFailed();
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
            if (!this.nxf.remove(v)) {
                com.facebook.common.c.a.d(this.njM, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                bn(v);
                this.nxj.Mh(LT);
            } else if (LU == null || LU.dUS() || dUO() || !bp(v)) {
                if (LU != null) {
                    LU.dUV();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.njM, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
                bn(v);
                this.nxh.LZ(LT);
                this.nxj.Mh(LT);
            } else {
                LU.release(v);
                this.nxi.LY(LT);
                this.nxh.LZ(LT);
                this.nxj.Mi(LT);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.njM, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
            }
            dSm();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dUM();
    }

    protected void dUI() {
    }

    protected boolean bp(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dUJ() {
        com.facebook.common.internal.g.checkState(!dUO() || this.nxi.nxk == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.nxe.clear();
            SparseIntArray sparseIntArray2 = this.nxd.nxO;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.nxe.put(keyAt, new d<>(LT(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.nxd.nxR));
                }
                this.nxg = false;
            } else {
                this.nxg = true;
            }
        }
    }

    private synchronized void dUK() {
        SparseIntArray sparseIntArray = this.nxd.nxO;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.nxg = false;
        } else {
            this.nxg = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.nxe.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.nxe.put(keyAt, new d<>(LT(keyAt), sparseIntArray.valueAt(i), 0, this.nxd.nxR));
        }
    }

    private List<d<V>> dUL() {
        ArrayList arrayList = new ArrayList(this.nxe.size());
        int size = this.nxe.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.nxe.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.kos;
            int dRX = valueAt.dRX();
            if (valueAt.dUT() > 0) {
                arrayList.add(valueAt);
            }
            this.nxe.setValueAt(i, new d<>(LT(i2), i3, dRX, this.nxd.nxR));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dUM() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.nxd.nxR) {
                arrayList = dUL();
            } else {
                arrayList = new ArrayList(this.nxe.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.nxe.size(); i++) {
                    d<V> valueAt = this.nxe.valueAt(i);
                    if (valueAt.dUT() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.nxe.keyAt(i), valueAt.dRX());
                }
                a(sparseIntArray);
            }
            this.nxi.reset();
            dSm();
        }
        dUI();
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

    synchronized void dUN() {
        if (dUO()) {
            trimToSize(this.nxd.nxN);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.nxh.nxk + this.nxi.nxk) - i, this.nxi.nxk);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.njM, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.nxh.nxk + this.nxi.nxk), Integer.valueOf(min));
            }
            dSm();
            for (int i2 = 0; i2 < this.nxe.size() && min > 0; i2++) {
                d<V> valueAt = this.nxe.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bn(pop);
                    min -= valueAt.mItemSize;
                    this.nxi.LZ(valueAt.mItemSize);
                }
            }
            dSm();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.njM, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.nxh.nxk + this.nxi.nxk));
            }
        }
    }

    private synchronized d<V> LU(int i) {
        return this.nxe.get(i);
    }

    synchronized d<V> LV(int i) {
        d<V> dVar;
        dVar = this.nxe.get(i);
        if (dVar == null && this.nxg) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.njM, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = LW(i);
            this.nxe.put(i, dVar);
        }
        return dVar;
    }

    d<V> LW(int i) {
        return new d<>(LT(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.nxd.nxR);
    }

    synchronized boolean dUO() {
        boolean z;
        z = this.nxh.nxk + this.nxi.nxk > this.nxd.nxN;
        if (z) {
            this.nxj.dVc();
        }
        return z;
    }

    synchronized boolean LX(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.nxd.nxM;
            if (i > i2 - this.nxh.nxk) {
                this.nxj.dVd();
            } else {
                int i3 = this.nxd.nxN;
                if (i > i3 - (this.nxh.nxk + this.nxi.nxk)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.nxh.nxk + this.nxi.nxk)) {
                    this.nxj.dVd();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dSm() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.njM, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.nxh.mCount), Integer.valueOf(this.nxh.nxk), Integer.valueOf(this.nxi.mCount), Integer.valueOf(this.nxi.nxk));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes8.dex */
    public static class a {
        int mCount;
        int nxk;

        a() {
        }

        public void LY(int i) {
            this.mCount++;
            this.nxk += i;
        }

        public void LZ(int i) {
            if (this.nxk >= i && this.mCount > 0) {
                this.mCount--;
                this.nxk -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.nxk), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.nxk = 0;
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
