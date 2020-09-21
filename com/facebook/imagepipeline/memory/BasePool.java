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
/* loaded from: classes25.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b nGZ;
    final com.facebook.common.memory.c nFo;
    final r nHa;
    final Set<V> nHc;
    private boolean nHd;
    @GuardedBy("this")
    final a nHe;
    @GuardedBy("this")
    final a nHf;
    private final s nHg;
    private final Class<?> ntL = getClass();
    final SparseArray<d<V>> nHb = new SparseArray<>();

    /* loaded from: classes25.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Mw(int i);

    protected abstract int Mx(int i);

    protected abstract int My(int i);

    protected abstract void bp(V v);

    protected abstract int bq(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.nFo = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.nHa = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.nHg = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.nHa.nHO) {
            dYI();
        } else {
            a(new SparseIntArray(0));
        }
        this.nHc = com.facebook.common.internal.i.dSF();
        this.nHf = new a();
        this.nHe = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.nFo.a(this);
        this.nHg.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        dYH();
        int Mx = Mx(i);
        synchronized (this) {
            d<V> MA = MA(Mx);
            if (MA != null && (m = MA.get()) != null) {
                com.facebook.common.internal.g.checkState(this.nHc.add(m));
                int bq = bq(m);
                int My = My(bq);
                this.nHe.MD(My);
                this.nHf.ME(My);
                this.nHg.MK(My);
                dWk();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.ntL, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bq));
                }
            } else {
                int My2 = My(Mx);
                if (!MC(My2)) {
                    throw new PoolSizeViolationException(this.nHa.nHJ, this.nHe.nHh, this.nHf.nHh, My2);
                }
                this.nHe.MD(My2);
                if (MA != null) {
                    MA.dYS();
                }
                m = m(My2, Mx, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.nHc.add(m));
                    dYL();
                    this.nHg.ML(My2);
                    dWk();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.ntL, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(Mx));
                    }
                }
            }
        }
        return m;
    }

    private V m(int i, int i2, boolean z) {
        try {
            V Mw = Mw(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.ntL, "alloc success!!");
                return Mw;
            }
            return Mw;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.ntL, "alloc fail!!");
            }
            if (!z || nGZ == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.ntL, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (nGZ == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.nHe.ME(i);
                    d<V> MA = MA(i2);
                    if (MA != null) {
                        MA.dYT();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.ntL, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (nGZ == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            nGZ.onFailed();
            return m(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bq = bq(v);
        int My = My(bq);
        synchronized (this) {
            d<V> Mz = Mz(bq);
            if (!this.nHc.remove(v)) {
                com.facebook.common.c.a.d(this.ntL, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                bp(v);
                this.nHg.MM(My);
            } else if (Mz == null || Mz.dYQ() || dYM() || !br(v)) {
                if (Mz != null) {
                    Mz.dYT();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.ntL, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
                bp(v);
                this.nHe.ME(My);
                this.nHg.MM(My);
            } else {
                Mz.release(v);
                this.nHf.MD(My);
                this.nHe.ME(My);
                this.nHg.MN(My);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.ntL, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
            }
            dWk();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dYK();
    }

    protected void dYG() {
    }

    protected boolean br(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dYH() {
        com.facebook.common.internal.g.checkState(!dYM() || this.nHf.nHh == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.nHb.clear();
            SparseIntArray sparseIntArray2 = this.nHa.nHL;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.nHb.put(keyAt, new d<>(My(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.nHa.nHO));
                }
                this.nHd = false;
            } else {
                this.nHd = true;
            }
        }
    }

    private synchronized void dYI() {
        SparseIntArray sparseIntArray = this.nHa.nHL;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.nHd = false;
        } else {
            this.nHd = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.nHb.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.nHb.put(keyAt, new d<>(My(keyAt), sparseIntArray.valueAt(i), 0, this.nHa.nHO));
        }
    }

    private List<d<V>> dYJ() {
        ArrayList arrayList = new ArrayList(this.nHb.size());
        int size = this.nHb.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.nHb.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.kwR;
            int dVV = valueAt.dVV();
            if (valueAt.dYR() > 0) {
                arrayList.add(valueAt);
            }
            this.nHb.setValueAt(i, new d<>(My(i2), i3, dVV, this.nHa.nHO));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dYK() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.nHa.nHO) {
                arrayList = dYJ();
            } else {
                arrayList = new ArrayList(this.nHb.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.nHb.size(); i++) {
                    d<V> valueAt = this.nHb.valueAt(i);
                    if (valueAt.dYR() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.nHb.keyAt(i), valueAt.dVV());
                }
                a(sparseIntArray);
            }
            this.nHf.reset();
            dWk();
        }
        dYG();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bp(pop);
            }
        }
    }

    synchronized void dYL() {
        if (dYM()) {
            trimToSize(this.nHa.nHK);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.nHe.nHh + this.nHf.nHh) - i, this.nHf.nHh);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.ntL, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.nHe.nHh + this.nHf.nHh), Integer.valueOf(min));
            }
            dWk();
            for (int i2 = 0; i2 < this.nHb.size() && min > 0; i2++) {
                d<V> valueAt = this.nHb.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bp(pop);
                    min -= valueAt.mItemSize;
                    this.nHf.ME(valueAt.mItemSize);
                }
            }
            dWk();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.ntL, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.nHe.nHh + this.nHf.nHh));
            }
        }
    }

    private synchronized d<V> Mz(int i) {
        return this.nHb.get(i);
    }

    synchronized d<V> MA(int i) {
        d<V> dVar;
        dVar = this.nHb.get(i);
        if (dVar == null && this.nHd) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.ntL, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = MB(i);
            this.nHb.put(i, dVar);
        }
        return dVar;
    }

    d<V> MB(int i) {
        return new d<>(My(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.nHa.nHO);
    }

    synchronized boolean dYM() {
        boolean z;
        z = this.nHe.nHh + this.nHf.nHh > this.nHa.nHK;
        if (z) {
            this.nHg.dZa();
        }
        return z;
    }

    synchronized boolean MC(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.nHa.nHJ;
            if (i > i2 - this.nHe.nHh) {
                this.nHg.dZb();
            } else {
                int i3 = this.nHa.nHK;
                if (i > i3 - (this.nHe.nHh + this.nHf.nHh)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.nHe.nHh + this.nHf.nHh)) {
                    this.nHg.dZb();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dWk() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.ntL, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.nHe.mCount), Integer.valueOf(this.nHe.nHh), Integer.valueOf(this.nHf.mCount), Integer.valueOf(this.nHf.nHh));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes25.dex */
    public static class a {
        int mCount;
        int nHh;

        a() {
        }

        public void MD(int i) {
            this.mCount++;
            this.nHh += i;
        }

        public void ME(int i) {
            if (this.nHh >= i && this.mCount > 0) {
                this.mCount--;
                this.nHh -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.nHh), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.nHh = 0;
        }
    }

    /* loaded from: classes25.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes25.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes25.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes25.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
