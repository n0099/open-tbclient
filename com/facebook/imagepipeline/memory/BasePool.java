package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
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
    private static b lUl;
    final com.facebook.common.memory.c lSA;
    final r lUm;
    final Set<V> lUo;
    private boolean lUp;
    @GuardedBy("this")
    final a lUq;
    @GuardedBy("this")
    final a lUr;
    private final s lUs;
    private final Class<?> lHl = getClass();
    final SparseArray<d<V>> lUn = new SparseArray<>();

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Ip(int i);

    protected abstract int Iq(int i);

    protected abstract int Ir(int i);

    protected abstract void bp(V v);

    protected abstract int bq(V v);

    public static void a(b bVar) {
        lUl = bVar;
    }

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.lSA = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.lUm = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.lUs = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.lUm.lVa) {
            dqK();
        } else {
            a(new SparseIntArray(0));
        }
        this.lUo = com.facebook.common.internal.i.dkJ();
        this.lUr = new a();
        this.lUq = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.lSA.a(this);
        this.lUs.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dqJ();
        int Iq = Iq(i);
        synchronized (this) {
            d<V> It = It(Iq);
            if (It != null && (o = It.get()) != null) {
                com.facebook.common.internal.g.checkState(this.lUo.add(o));
                int bq = bq(o);
                int Ir = Ir(bq);
                this.lUq.Iw(Ir);
                this.lUr.Ix(Ir);
                this.lUs.ID(Ir);
                dol();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lHl, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bq));
                }
            } else {
                int Ir2 = Ir(Iq);
                if (!Iv(Ir2)) {
                    throw new PoolSizeViolationException(this.lUm.lUV, this.lUq.lUt, this.lUr.lUt, Ir2);
                }
                this.lUq.Iw(Ir2);
                if (It != null) {
                    It.dqV();
                }
                o = o(Ir2, Iq, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.lUo.add(o));
                    dqN();
                    this.lUs.IE(Ir2);
                    dol();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lHl, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(Iq));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V Ip = Ip(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lHl, "alloc success!!");
                return Ip;
            }
            return Ip;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lHl, "alloc fail!!");
            }
            if (!z || lUl == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lHl, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (lUl == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.lUq.Ix(i);
                    d<V> It = It(i2);
                    if (It != null) {
                        It.dqW();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lHl, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (lUl == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            lUl.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bq = bq(v);
        int Ir = Ir(bq);
        synchronized (this) {
            d<V> Is = Is(bq);
            if (!this.lUo.remove(v)) {
                com.facebook.common.c.a.d(this.lHl, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                bp(v);
                this.lUs.IF(Ir);
            } else if (Is == null || Is.dqT() || dqO() || !br(v)) {
                if (Is != null) {
                    Is.dqW();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lHl, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
                bp(v);
                this.lUq.Ix(Ir);
                this.lUs.IF(Ir);
            } else {
                Is.release(v);
                this.lUr.Iw(Ir);
                this.lUq.Ix(Ir);
                this.lUs.IG(Ir);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lHl, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
            }
            dol();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dqM();
    }

    protected void dqI() {
    }

    protected boolean br(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dqJ() {
        com.facebook.common.internal.g.checkState(!dqO() || this.lUr.lUt == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.lUn.clear();
            SparseIntArray sparseIntArray2 = this.lUm.lUX;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.lUn.put(keyAt, new d<>(Ir(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.lUm.lVa));
                }
                this.lUp = false;
            } else {
                this.lUp = true;
            }
        }
    }

    private synchronized void dqK() {
        SparseIntArray sparseIntArray = this.lUm.lUX;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.lUp = false;
        } else {
            this.lUp = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.lUn.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.lUn.put(keyAt, new d<>(Ir(keyAt), sparseIntArray.valueAt(i), 0, this.lUm.lVa));
        }
    }

    private List<d<V>> dqL() {
        ArrayList arrayList = new ArrayList(this.lUn.size());
        int size = this.lUn.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.lUn.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.ivf;
            int dnY = valueAt.dnY();
            if (valueAt.dqU() > 0) {
                arrayList.add(valueAt);
            }
            this.lUn.setValueAt(i, new d<>(Ir(i2), i3, dnY, this.lUm.lVa));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dqM() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.lUm.lVa) {
                arrayList = dqL();
            } else {
                arrayList = new ArrayList(this.lUn.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.lUn.size(); i++) {
                    d<V> valueAt = this.lUn.valueAt(i);
                    if (valueAt.dqU() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.lUn.keyAt(i), valueAt.dnY());
                }
                a(sparseIntArray);
            }
            this.lUr.reset();
            dol();
        }
        dqI();
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

    synchronized void dqN() {
        if (dqO()) {
            trimToSize(this.lUm.lUW);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.lUq.lUt + this.lUr.lUt) - i, this.lUr.lUt);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lHl, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.lUq.lUt + this.lUr.lUt), Integer.valueOf(min));
            }
            dol();
            for (int i2 = 0; i2 < this.lUn.size() && min > 0; i2++) {
                d<V> valueAt = this.lUn.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bp(pop);
                    min -= valueAt.mItemSize;
                    this.lUr.Ix(valueAt.mItemSize);
                }
            }
            dol();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lHl, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.lUq.lUt + this.lUr.lUt));
            }
        }
    }

    private synchronized d<V> Is(int i) {
        return this.lUn.get(i);
    }

    synchronized d<V> It(int i) {
        d<V> dVar;
        dVar = this.lUn.get(i);
        if (dVar == null && this.lUp) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lHl, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Iu(i);
            this.lUn.put(i, dVar);
        }
        return dVar;
    }

    d<V> Iu(int i) {
        return new d<>(Ir(i), Integer.MAX_VALUE, 0, this.lUm.lVa);
    }

    synchronized boolean dqO() {
        boolean z;
        z = this.lUq.lUt + this.lUr.lUt > this.lUm.lUW;
        if (z) {
            this.lUs.drd();
        }
        return z;
    }

    synchronized boolean Iv(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.lUm.lUV;
            if (i > i2 - this.lUq.lUt) {
                this.lUs.dre();
            } else {
                int i3 = this.lUm.lUW;
                if (i > i3 - (this.lUq.lUt + this.lUr.lUt)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.lUq.lUt + this.lUr.lUt)) {
                    this.lUs.dre();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dol() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lHl, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.lUq.mCount), Integer.valueOf(this.lUq.lUt), Integer.valueOf(this.lUr.mCount), Integer.valueOf(this.lUr.lUt));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int lUt;
        int mCount;

        a() {
        }

        public void Iw(int i) {
            this.mCount++;
            this.lUt += i;
        }

        public void Ix(int i) {
            if (this.lUt >= i && this.mCount > 0) {
                this.mCount--;
                this.lUt -= i;
                return;
            }
            com.facebook.common.c.a.j("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.lUt), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.lUt = 0;
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
