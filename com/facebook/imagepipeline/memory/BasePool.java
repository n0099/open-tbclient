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
/* loaded from: classes4.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b ncS;
    final com.facebook.common.memory.c nbh;
    final r ncT;
    final Set<V> ncV;
    private boolean ncW;
    @GuardedBy("this")
    final a ncX;
    @GuardedBy("this")
    final a ncY;
    private final s ncZ;
    private final Class<?> mPx = getClass();
    final SparseArray<d<V>> ncU = new SparseArray<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Jn(int i);

    protected abstract int Jo(int i);

    protected abstract int Jp(int i);

    protected abstract void bl(V v);

    protected abstract int bm(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.nbh = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.ncT = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.ncZ = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.ncT.ndH) {
            dIB();
        } else {
            a(new SparseIntArray(0));
        }
        this.ncV = com.facebook.common.internal.i.dCx();
        this.ncY = new a();
        this.ncX = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.nbh.a(this);
        this.ncZ.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V n;
        dIA();
        int Jo = Jo(i);
        synchronized (this) {
            d<V> Jr = Jr(Jo);
            if (Jr != null && (n = Jr.get()) != null) {
                com.facebook.common.internal.g.checkState(this.ncV.add(n));
                int bm = bm(n);
                int Jp = Jp(bm);
                this.ncX.Ju(Jp);
                this.ncY.Jv(Jp);
                this.ncZ.JB(Jp);
                dGd();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mPx, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(bm));
                }
            } else {
                int Jp2 = Jp(Jo);
                if (!Jt(Jp2)) {
                    throw new PoolSizeViolationException(this.ncT.ndC, this.ncX.nda, this.ncY.nda, Jp2);
                }
                this.ncX.Ju(Jp2);
                if (Jr != null) {
                    Jr.dIL();
                }
                n = n(Jp2, Jo, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.ncV.add(n));
                    dIE();
                    this.ncZ.JC(Jp2);
                    dGd();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.mPx, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(Jo));
                    }
                }
            }
        }
        return n;
    }

    private V n(int i, int i2, boolean z) {
        try {
            V Jn = Jn(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mPx, "alloc success!!");
                return Jn;
            }
            return Jn;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mPx, "alloc fail!!");
            }
            if (!z || ncS == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.mPx, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (ncS == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.ncX.Jv(i);
                    d<V> Jr = Jr(i2);
                    if (Jr != null) {
                        Jr.dIM();
                    }
                    com.facebook.common.internal.l.v(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mPx, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (ncS == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            ncS.onFailed();
            return n(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bm = bm(v);
        int Jp = Jp(bm);
        synchronized (this) {
            d<V> Jq = Jq(bm);
            if (!this.ncV.remove(v)) {
                com.facebook.common.c.a.d(this.mPx, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                bl(v);
                this.ncZ.JD(Jp);
            } else if (Jq == null || Jq.dIJ() || dIF() || !bn(v)) {
                if (Jq != null) {
                    Jq.dIM();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mPx, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
                bl(v);
                this.ncX.Jv(Jp);
                this.ncZ.JD(Jp);
            } else {
                Jq.release(v);
                this.ncY.Ju(Jp);
                this.ncX.Jv(Jp);
                this.ncZ.JE(Jp);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mPx, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
            }
            dGd();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dID();
    }

    protected void dIz() {
    }

    protected boolean bn(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dIA() {
        com.facebook.common.internal.g.checkState(!dIF() || this.ncY.nda == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.ncU.clear();
            SparseIntArray sparseIntArray2 = this.ncT.ndE;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.ncU.put(keyAt, new d<>(Jp(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.ncT.ndH));
                }
                this.ncW = false;
            } else {
                this.ncW = true;
            }
        }
    }

    private synchronized void dIB() {
        SparseIntArray sparseIntArray = this.ncT.ndE;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.ncW = false;
        } else {
            this.ncW = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.ncU.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.ncU.put(keyAt, new d<>(Jp(keyAt), sparseIntArray.valueAt(i), 0, this.ncT.ndH));
        }
    }

    private List<d<V>> dIC() {
        ArrayList arrayList = new ArrayList(this.ncU.size());
        int size = this.ncU.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.ncU.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.jYN;
            int dFO = valueAt.dFO();
            if (valueAt.dIK() > 0) {
                arrayList.add(valueAt);
            }
            this.ncU.setValueAt(i, new d<>(Jp(i2), i3, dFO, this.ncT.ndH));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dID() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.ncT.ndH) {
                arrayList = dIC();
            } else {
                arrayList = new ArrayList(this.ncU.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.ncU.size(); i++) {
                    d<V> valueAt = this.ncU.valueAt(i);
                    if (valueAt.dIK() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.ncU.keyAt(i), valueAt.dFO());
                }
                a(sparseIntArray);
            }
            this.ncY.reset();
            dGd();
        }
        dIz();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bl(pop);
            }
        }
    }

    synchronized void dIE() {
        if (dIF()) {
            trimToSize(this.ncT.ndD);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.ncX.nda + this.ncY.nda) - i, this.ncY.nda);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mPx, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.ncX.nda + this.ncY.nda), Integer.valueOf(min));
            }
            dGd();
            for (int i2 = 0; i2 < this.ncU.size() && min > 0; i2++) {
                d<V> valueAt = this.ncU.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bl(pop);
                    min -= valueAt.mItemSize;
                    this.ncY.Jv(valueAt.mItemSize);
                }
            }
            dGd();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mPx, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.ncX.nda + this.ncY.nda));
            }
        }
    }

    private synchronized d<V> Jq(int i) {
        return this.ncU.get(i);
    }

    synchronized d<V> Jr(int i) {
        d<V> dVar;
        dVar = this.ncU.get(i);
        if (dVar == null && this.ncW) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mPx, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Js(i);
            this.ncU.put(i, dVar);
        }
        return dVar;
    }

    d<V> Js(int i) {
        return new d<>(Jp(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.ncT.ndH);
    }

    synchronized boolean dIF() {
        boolean z;
        z = this.ncX.nda + this.ncY.nda > this.ncT.ndD;
        if (z) {
            this.ncZ.dIT();
        }
        return z;
    }

    synchronized boolean Jt(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.ncT.ndC;
            if (i > i2 - this.ncX.nda) {
                this.ncZ.dIU();
            } else {
                int i3 = this.ncT.ndD;
                if (i > i3 - (this.ncX.nda + this.ncY.nda)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.ncX.nda + this.ncY.nda)) {
                    this.ncZ.dIU();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dGd() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.mPx, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.ncX.mCount), Integer.valueOf(this.ncX.nda), Integer.valueOf(this.ncY.mCount), Integer.valueOf(this.ncY.nda));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes4.dex */
    public static class a {
        int mCount;
        int nda;

        a() {
        }

        public void Ju(int i) {
            this.mCount++;
            this.nda += i;
        }

        public void Jv(int i) {
            if (this.nda >= i && this.mCount > 0) {
                this.mCount--;
                this.nda -= i;
                return;
            }
            com.facebook.common.c.a.l("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.nda), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.nda = 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
