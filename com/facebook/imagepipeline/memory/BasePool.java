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
    private static b mdC;
    final com.facebook.common.memory.c mbT;
    final r mdD;
    final Set<V> mdF;
    private boolean mdG;
    @GuardedBy("this")
    final a mdH;
    @GuardedBy("this")
    final a mdI;
    private final s mdJ;
    private final Class<?> lQm = getClass();
    final SparseArray<d<V>> mdE = new SparseArray<>();

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V GX(int i);

    protected abstract int GY(int i);

    protected abstract int GZ(int i);

    protected abstract void bf(V v);

    protected abstract int bg(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.mbT = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.mdD = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.mdJ = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.mdD.mer) {
            dtf();
        } else {
            a(new SparseIntArray(0));
        }
        this.mdF = com.facebook.common.internal.i.dmZ();
        this.mdI = new a();
        this.mdH = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.mbT.a(this);
        this.mdJ.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dte();
        int GY = GY(i);
        synchronized (this) {
            d<V> Hb = Hb(GY);
            if (Hb != null && (o = Hb.get()) != null) {
                com.facebook.common.internal.g.checkState(this.mdF.add(o));
                int bg = bg(o);
                int GZ = GZ(bg);
                this.mdH.He(GZ);
                this.mdI.Hf(GZ);
                this.mdJ.Hl(GZ);
                dqH();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lQm, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bg));
                }
            } else {
                int GZ2 = GZ(GY);
                if (!Hd(GZ2)) {
                    throw new PoolSizeViolationException(this.mdD.mem, this.mdH.mdK, this.mdI.mdK, GZ2);
                }
                this.mdH.He(GZ2);
                if (Hb != null) {
                    Hb.dtq();
                }
                o = o(GZ2, GY, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.mdF.add(o));
                    dti();
                    this.mdJ.Hm(GZ2);
                    dqH();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lQm, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(GY));
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
                com.facebook.common.c.a.f(this.lQm, "alloc success!!");
                return GX;
            }
            return GX;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lQm, "alloc fail!!");
            }
            if (!z || mdC == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lQm, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (mdC == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.mdH.Hf(i);
                    d<V> Hb = Hb(i2);
                    if (Hb != null) {
                        Hb.dtr();
                    }
                    com.facebook.common.internal.l.x(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lQm, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (mdC == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            mdC.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bg = bg(v);
        int GZ = GZ(bg);
        synchronized (this) {
            d<V> Ha = Ha(bg);
            if (!this.mdF.remove(v)) {
                com.facebook.common.c.a.d(this.lQm, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bg));
                bf(v);
                this.mdJ.Hn(GZ);
            } else if (Ha == null || Ha.dto() || dtj() || !bh(v)) {
                if (Ha != null) {
                    Ha.dtr();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lQm, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bg));
                }
                bf(v);
                this.mdH.Hf(GZ);
                this.mdJ.Hn(GZ);
            } else {
                Ha.release(v);
                this.mdI.He(GZ);
                this.mdH.Hf(GZ);
                this.mdJ.Ho(GZ);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lQm, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bg));
                }
            }
            dqH();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dth();
    }

    protected void dtd() {
    }

    protected boolean bh(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dte() {
        com.facebook.common.internal.g.checkState(!dtj() || this.mdI.mdK == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.mdE.clear();
            SparseIntArray sparseIntArray2 = this.mdD.meo;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.mdE.put(keyAt, new d<>(GZ(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mdD.mer));
                }
                this.mdG = false;
            } else {
                this.mdG = true;
            }
        }
    }

    private synchronized void dtf() {
        SparseIntArray sparseIntArray = this.mdD.meo;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.mdG = false;
        } else {
            this.mdG = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.mdE.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mdE.put(keyAt, new d<>(GZ(keyAt), sparseIntArray.valueAt(i), 0, this.mdD.mer));
        }
    }

    private List<d<V>> dtg() {
        ArrayList arrayList = new ArrayList(this.mdE.size());
        int size = this.mdE.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.mdE.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.jgK;
            int dqs = valueAt.dqs();
            if (valueAt.dtp() > 0) {
                arrayList.add(valueAt);
            }
            this.mdE.setValueAt(i, new d<>(GZ(i2), i3, dqs, this.mdD.mer));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dth() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.mdD.mer) {
                arrayList = dtg();
            } else {
                arrayList = new ArrayList(this.mdE.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.mdE.size(); i++) {
                    d<V> valueAt = this.mdE.valueAt(i);
                    if (valueAt.dtp() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.mdE.keyAt(i), valueAt.dqs());
                }
                a(sparseIntArray);
            }
            this.mdI.reset();
            dqH();
        }
        dtd();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bf(pop);
            }
        }
    }

    synchronized void dti() {
        if (dtj()) {
            trimToSize(this.mdD.men);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.mdH.mdK + this.mdI.mdK) - i, this.mdI.mdK);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lQm, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mdH.mdK + this.mdI.mdK), Integer.valueOf(min));
            }
            dqH();
            for (int i2 = 0; i2 < this.mdE.size() && min > 0; i2++) {
                d<V> valueAt = this.mdE.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bf(pop);
                    min -= valueAt.mItemSize;
                    this.mdI.Hf(valueAt.mItemSize);
                }
            }
            dqH();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lQm, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mdH.mdK + this.mdI.mdK));
            }
        }
    }

    private synchronized d<V> Ha(int i) {
        return this.mdE.get(i);
    }

    synchronized d<V> Hb(int i) {
        d<V> dVar;
        dVar = this.mdE.get(i);
        if (dVar == null && this.mdG) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lQm, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Hc(i);
            this.mdE.put(i, dVar);
        }
        return dVar;
    }

    d<V> Hc(int i) {
        return new d<>(GZ(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.mdD.mer);
    }

    synchronized boolean dtj() {
        boolean z;
        z = this.mdH.mdK + this.mdI.mdK > this.mdD.men;
        if (z) {
            this.mdJ.dty();
        }
        return z;
    }

    synchronized boolean Hd(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.mdD.mem;
            if (i > i2 - this.mdH.mdK) {
                this.mdJ.dtz();
            } else {
                int i3 = this.mdD.men;
                if (i > i3 - (this.mdH.mdK + this.mdI.mdK)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.mdH.mdK + this.mdI.mdK)) {
                    this.mdJ.dtz();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dqH() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lQm, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mdH.mCount), Integer.valueOf(this.mdH.mdK), Integer.valueOf(this.mdI.mCount), Integer.valueOf(this.mdI.mdK));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int mCount;
        int mdK;

        a() {
        }

        public void He(int i) {
            this.mCount++;
            this.mdK += i;
        }

        public void Hf(int i) {
            if (this.mdK >= i && this.mCount > 0) {
                this.mCount--;
                this.mdK -= i;
                return;
            }
            com.facebook.common.c.a.l("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mdK), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.mdK = 0;
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
