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
    private static b ncU;
    final com.facebook.common.memory.c nbj;
    final r ncV;
    final Set<V> ncX;
    private boolean ncY;
    @GuardedBy("this")
    final a ncZ;
    @GuardedBy("this")
    final a nda;
    private final s ndb;
    private final Class<?> mPz = getClass();
    final SparseArray<d<V>> ncW = new SparseArray<>();

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
        this.nbj = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.ncV = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.ndb = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.ncV.ndJ) {
            dIC();
        } else {
            a(new SparseIntArray(0));
        }
        this.ncX = com.facebook.common.internal.i.dCy();
        this.nda = new a();
        this.ncZ = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.nbj.a(this);
        this.ndb.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V n;
        dIB();
        int Jo = Jo(i);
        synchronized (this) {
            d<V> Jr = Jr(Jo);
            if (Jr != null && (n = Jr.get()) != null) {
                com.facebook.common.internal.g.checkState(this.ncX.add(n));
                int bm = bm(n);
                int Jp = Jp(bm);
                this.ncZ.Ju(Jp);
                this.nda.Jv(Jp);
                this.ndb.JB(Jp);
                dGe();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mPz, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(bm));
                }
            } else {
                int Jp2 = Jp(Jo);
                if (!Jt(Jp2)) {
                    throw new PoolSizeViolationException(this.ncV.ndE, this.ncZ.ndc, this.nda.ndc, Jp2);
                }
                this.ncZ.Ju(Jp2);
                if (Jr != null) {
                    Jr.dIM();
                }
                n = n(Jp2, Jo, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.ncX.add(n));
                    dIF();
                    this.ndb.JC(Jp2);
                    dGe();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.mPz, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(Jo));
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
                com.facebook.common.c.a.f(this.mPz, "alloc success!!");
                return Jn;
            }
            return Jn;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mPz, "alloc fail!!");
            }
            if (!z || ncU == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.mPz, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (ncU == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.ncZ.Jv(i);
                    d<V> Jr = Jr(i2);
                    if (Jr != null) {
                        Jr.dIN();
                    }
                    com.facebook.common.internal.l.v(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mPz, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (ncU == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            ncU.onFailed();
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
            if (!this.ncX.remove(v)) {
                com.facebook.common.c.a.d(this.mPz, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                bl(v);
                this.ndb.JD(Jp);
            } else if (Jq == null || Jq.dIK() || dIG() || !bn(v)) {
                if (Jq != null) {
                    Jq.dIN();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mPz, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
                bl(v);
                this.ncZ.Jv(Jp);
                this.ndb.JD(Jp);
            } else {
                Jq.release(v);
                this.nda.Ju(Jp);
                this.ncZ.Jv(Jp);
                this.ndb.JE(Jp);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mPz, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
            }
            dGe();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dIE();
    }

    protected void dIA() {
    }

    protected boolean bn(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dIB() {
        com.facebook.common.internal.g.checkState(!dIG() || this.nda.ndc == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.ncW.clear();
            SparseIntArray sparseIntArray2 = this.ncV.ndG;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.ncW.put(keyAt, new d<>(Jp(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.ncV.ndJ));
                }
                this.ncY = false;
            } else {
                this.ncY = true;
            }
        }
    }

    private synchronized void dIC() {
        SparseIntArray sparseIntArray = this.ncV.ndG;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.ncY = false;
        } else {
            this.ncY = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.ncW.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.ncW.put(keyAt, new d<>(Jp(keyAt), sparseIntArray.valueAt(i), 0, this.ncV.ndJ));
        }
    }

    private List<d<V>> dID() {
        ArrayList arrayList = new ArrayList(this.ncW.size());
        int size = this.ncW.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.ncW.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.jYP;
            int dFP = valueAt.dFP();
            if (valueAt.dIL() > 0) {
                arrayList.add(valueAt);
            }
            this.ncW.setValueAt(i, new d<>(Jp(i2), i3, dFP, this.ncV.ndJ));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dIE() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.ncV.ndJ) {
                arrayList = dID();
            } else {
                arrayList = new ArrayList(this.ncW.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.ncW.size(); i++) {
                    d<V> valueAt = this.ncW.valueAt(i);
                    if (valueAt.dIL() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.ncW.keyAt(i), valueAt.dFP());
                }
                a(sparseIntArray);
            }
            this.nda.reset();
            dGe();
        }
        dIA();
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

    synchronized void dIF() {
        if (dIG()) {
            trimToSize(this.ncV.ndF);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.ncZ.ndc + this.nda.ndc) - i, this.nda.ndc);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mPz, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.ncZ.ndc + this.nda.ndc), Integer.valueOf(min));
            }
            dGe();
            for (int i2 = 0; i2 < this.ncW.size() && min > 0; i2++) {
                d<V> valueAt = this.ncW.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bl(pop);
                    min -= valueAt.mItemSize;
                    this.nda.Jv(valueAt.mItemSize);
                }
            }
            dGe();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mPz, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.ncZ.ndc + this.nda.ndc));
            }
        }
    }

    private synchronized d<V> Jq(int i) {
        return this.ncW.get(i);
    }

    synchronized d<V> Jr(int i) {
        d<V> dVar;
        dVar = this.ncW.get(i);
        if (dVar == null && this.ncY) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mPz, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Js(i);
            this.ncW.put(i, dVar);
        }
        return dVar;
    }

    d<V> Js(int i) {
        return new d<>(Jp(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.ncV.ndJ);
    }

    synchronized boolean dIG() {
        boolean z;
        z = this.ncZ.ndc + this.nda.ndc > this.ncV.ndF;
        if (z) {
            this.ndb.dIU();
        }
        return z;
    }

    synchronized boolean Jt(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.ncV.ndE;
            if (i > i2 - this.ncZ.ndc) {
                this.ndb.dIV();
            } else {
                int i3 = this.ncV.ndF;
                if (i > i3 - (this.ncZ.ndc + this.nda.ndc)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.ncZ.ndc + this.nda.ndc)) {
                    this.ndb.dIV();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dGe() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.mPz, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.ncZ.mCount), Integer.valueOf(this.ncZ.ndc), Integer.valueOf(this.nda.mCount), Integer.valueOf(this.nda.ndc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes4.dex */
    public static class a {
        int mCount;
        int ndc;

        a() {
        }

        public void Ju(int i) {
            this.mCount++;
            this.ndc += i;
        }

        public void Jv(int i) {
            if (this.ndc >= i && this.mCount > 0) {
                this.mCount--;
                this.ndc -= i;
                return;
            }
            com.facebook.common.c.a.l("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.ndc), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.ndc = 0;
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
