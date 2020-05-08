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
    private static b mdG;
    final com.facebook.common.memory.c mbX;
    final r mdH;
    final Set<V> mdJ;
    private boolean mdK;
    @GuardedBy("this")
    final a mdL;
    @GuardedBy("this")
    final a mdM;
    private final s mdN;
    private final Class<?> lQq = getClass();
    final SparseArray<d<V>> mdI = new SparseArray<>();

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V GX(int i);

    protected abstract int GY(int i);

    protected abstract int GZ(int i);

    protected abstract void bg(V v);

    protected abstract int bh(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.mbX = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.mdH = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.mdN = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.mdH.mev) {
            dtc();
        } else {
            a(new SparseIntArray(0));
        }
        this.mdJ = com.facebook.common.internal.i.dmW();
        this.mdM = new a();
        this.mdL = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.mbX.a(this);
        this.mdN.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dtb();
        int GY = GY(i);
        synchronized (this) {
            d<V> Hb = Hb(GY);
            if (Hb != null && (o = Hb.get()) != null) {
                com.facebook.common.internal.g.checkState(this.mdJ.add(o));
                int bh = bh(o);
                int GZ = GZ(bh);
                this.mdL.He(GZ);
                this.mdM.Hf(GZ);
                this.mdN.Hl(GZ);
                dqE();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lQq, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bh));
                }
            } else {
                int GZ2 = GZ(GY);
                if (!Hd(GZ2)) {
                    throw new PoolSizeViolationException(this.mdH.meq, this.mdL.mdO, this.mdM.mdO, GZ2);
                }
                this.mdL.He(GZ2);
                if (Hb != null) {
                    Hb.dtn();
                }
                o = o(GZ2, GY, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.mdJ.add(o));
                    dtf();
                    this.mdN.Hm(GZ2);
                    dqE();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lQq, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(GY));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V GX = GX(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lQq, "alloc success!!");
                return GX;
            }
            return GX;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lQq, "alloc fail!!");
            }
            if (!z || mdG == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lQq, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (mdG == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.mdL.Hf(i);
                    d<V> Hb = Hb(i2);
                    if (Hb != null) {
                        Hb.dto();
                    }
                    com.facebook.common.internal.l.x(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lQq, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (mdG == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            mdG.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bh = bh(v);
        int GZ = GZ(bh);
        synchronized (this) {
            d<V> Ha = Ha(bh);
            if (!this.mdJ.remove(v)) {
                com.facebook.common.c.a.d(this.lQq, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bh));
                bg(v);
                this.mdN.Hn(GZ);
            } else if (Ha == null || Ha.dtl() || dtg() || !bi(v)) {
                if (Ha != null) {
                    Ha.dto();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lQq, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bh));
                }
                bg(v);
                this.mdL.Hf(GZ);
                this.mdN.Hn(GZ);
            } else {
                Ha.release(v);
                this.mdM.He(GZ);
                this.mdL.Hf(GZ);
                this.mdN.Ho(GZ);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lQq, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bh));
                }
            }
            dqE();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dte();
    }

    protected void dta() {
    }

    protected boolean bi(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dtb() {
        com.facebook.common.internal.g.checkState(!dtg() || this.mdM.mdO == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.mdI.clear();
            SparseIntArray sparseIntArray2 = this.mdH.mes;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.mdI.put(keyAt, new d<>(GZ(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mdH.mev));
                }
                this.mdK = false;
            } else {
                this.mdK = true;
            }
        }
    }

    private synchronized void dtc() {
        SparseIntArray sparseIntArray = this.mdH.mes;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.mdK = false;
        } else {
            this.mdK = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.mdI.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mdI.put(keyAt, new d<>(GZ(keyAt), sparseIntArray.valueAt(i), 0, this.mdH.mev));
        }
    }

    private List<d<V>> dtd() {
        ArrayList arrayList = new ArrayList(this.mdI.size());
        int size = this.mdI.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.mdI.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.jgO;
            int dqp = valueAt.dqp();
            if (valueAt.dtm() > 0) {
                arrayList.add(valueAt);
            }
            this.mdI.setValueAt(i, new d<>(GZ(i2), i3, dqp, this.mdH.mev));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dte() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.mdH.mev) {
                arrayList = dtd();
            } else {
                arrayList = new ArrayList(this.mdI.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.mdI.size(); i++) {
                    d<V> valueAt = this.mdI.valueAt(i);
                    if (valueAt.dtm() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.mdI.keyAt(i), valueAt.dqp());
                }
                a(sparseIntArray);
            }
            this.mdM.reset();
            dqE();
        }
        dta();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bg(pop);
            }
        }
    }

    synchronized void dtf() {
        if (dtg()) {
            trimToSize(this.mdH.mer);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.mdL.mdO + this.mdM.mdO) - i, this.mdM.mdO);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lQq, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mdL.mdO + this.mdM.mdO), Integer.valueOf(min));
            }
            dqE();
            for (int i2 = 0; i2 < this.mdI.size() && min > 0; i2++) {
                d<V> valueAt = this.mdI.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bg(pop);
                    min -= valueAt.mItemSize;
                    this.mdM.Hf(valueAt.mItemSize);
                }
            }
            dqE();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lQq, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mdL.mdO + this.mdM.mdO));
            }
        }
    }

    private synchronized d<V> Ha(int i) {
        return this.mdI.get(i);
    }

    synchronized d<V> Hb(int i) {
        d<V> dVar;
        dVar = this.mdI.get(i);
        if (dVar == null && this.mdK) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lQq, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Hc(i);
            this.mdI.put(i, dVar);
        }
        return dVar;
    }

    d<V> Hc(int i) {
        return new d<>(GZ(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.mdH.mev);
    }

    synchronized boolean dtg() {
        boolean z;
        z = this.mdL.mdO + this.mdM.mdO > this.mdH.mer;
        if (z) {
            this.mdN.dtv();
        }
        return z;
    }

    synchronized boolean Hd(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.mdH.meq;
            if (i > i2 - this.mdL.mdO) {
                this.mdN.dtw();
            } else {
                int i3 = this.mdH.mer;
                if (i > i3 - (this.mdL.mdO + this.mdM.mdO)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.mdL.mdO + this.mdM.mdO)) {
                    this.mdN.dtw();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dqE() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lQq, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mdL.mCount), Integer.valueOf(this.mdL.mdO), Integer.valueOf(this.mdM.mCount), Integer.valueOf(this.mdM.mdO));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int mCount;
        int mdO;

        a() {
        }

        public void He(int i) {
            this.mCount++;
            this.mdO += i;
        }

        public void Hf(int i) {
            if (this.mdO >= i && this.mCount > 0) {
                this.mCount--;
                this.mdO -= i;
                return;
            }
            com.facebook.common.c.a.l("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mdO), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.mdO = 0;
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
