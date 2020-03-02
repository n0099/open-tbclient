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
    private static b lUa;
    final com.facebook.common.memory.c lSp;
    final r lUb;
    final Set<V> lUd;
    private boolean lUe;
    @GuardedBy("this")
    final a lUf;
    @GuardedBy("this")
    final a lUg;
    private final s lUh;
    private final Class<?> lHa = getClass();
    final SparseArray<d<V>> lUc = new SparseArray<>();

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
        lUa = bVar;
    }

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.lSp = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.lUb = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.lUh = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.lUb.lUP) {
            dqJ();
        } else {
            a(new SparseIntArray(0));
        }
        this.lUd = com.facebook.common.internal.i.dkI();
        this.lUg = new a();
        this.lUf = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.lSp.a(this);
        this.lUh.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dqI();
        int Iq = Iq(i);
        synchronized (this) {
            d<V> It = It(Iq);
            if (It != null && (o = It.get()) != null) {
                com.facebook.common.internal.g.checkState(this.lUd.add(o));
                int bq = bq(o);
                int Ir = Ir(bq);
                this.lUf.Iw(Ir);
                this.lUg.Ix(Ir);
                this.lUh.ID(Ir);
                dok();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lHa, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bq));
                }
            } else {
                int Ir2 = Ir(Iq);
                if (!Iv(Ir2)) {
                    throw new PoolSizeViolationException(this.lUb.lUK, this.lUf.lUi, this.lUg.lUi, Ir2);
                }
                this.lUf.Iw(Ir2);
                if (It != null) {
                    It.dqU();
                }
                o = o(Ir2, Iq, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.lUd.add(o));
                    dqM();
                    this.lUh.IE(Ir2);
                    dok();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lHa, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(Iq));
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
                com.facebook.common.c.a.f(this.lHa, "alloc success!!");
                return Ip;
            }
            return Ip;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lHa, "alloc fail!!");
            }
            if (!z || lUa == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lHa, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (lUa == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.lUf.Ix(i);
                    d<V> It = It(i2);
                    if (It != null) {
                        It.dqV();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lHa, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (lUa == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            lUa.onFailed();
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
            if (!this.lUd.remove(v)) {
                com.facebook.common.c.a.d(this.lHa, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                bp(v);
                this.lUh.IF(Ir);
            } else if (Is == null || Is.dqS() || dqN() || !br(v)) {
                if (Is != null) {
                    Is.dqV();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lHa, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
                bp(v);
                this.lUf.Ix(Ir);
                this.lUh.IF(Ir);
            } else {
                Is.release(v);
                this.lUg.Iw(Ir);
                this.lUf.Ix(Ir);
                this.lUh.IG(Ir);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lHa, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
            }
            dok();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dqL();
    }

    protected void dqH() {
    }

    protected boolean br(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dqI() {
        com.facebook.common.internal.g.checkState(!dqN() || this.lUg.lUi == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.lUc.clear();
            SparseIntArray sparseIntArray2 = this.lUb.lUM;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.lUc.put(keyAt, new d<>(Ir(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.lUb.lUP));
                }
                this.lUe = false;
            } else {
                this.lUe = true;
            }
        }
    }

    private synchronized void dqJ() {
        SparseIntArray sparseIntArray = this.lUb.lUM;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.lUe = false;
        } else {
            this.lUe = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.lUc.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.lUc.put(keyAt, new d<>(Ir(keyAt), sparseIntArray.valueAt(i), 0, this.lUb.lUP));
        }
    }

    private List<d<V>> dqK() {
        ArrayList arrayList = new ArrayList(this.lUc.size());
        int size = this.lUc.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.lUc.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.iuT;
            int dnX = valueAt.dnX();
            if (valueAt.dqT() > 0) {
                arrayList.add(valueAt);
            }
            this.lUc.setValueAt(i, new d<>(Ir(i2), i3, dnX, this.lUb.lUP));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dqL() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.lUb.lUP) {
                arrayList = dqK();
            } else {
                arrayList = new ArrayList(this.lUc.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.lUc.size(); i++) {
                    d<V> valueAt = this.lUc.valueAt(i);
                    if (valueAt.dqT() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.lUc.keyAt(i), valueAt.dnX());
                }
                a(sparseIntArray);
            }
            this.lUg.reset();
            dok();
        }
        dqH();
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

    synchronized void dqM() {
        if (dqN()) {
            trimToSize(this.lUb.lUL);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.lUf.lUi + this.lUg.lUi) - i, this.lUg.lUi);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lHa, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.lUf.lUi + this.lUg.lUi), Integer.valueOf(min));
            }
            dok();
            for (int i2 = 0; i2 < this.lUc.size() && min > 0; i2++) {
                d<V> valueAt = this.lUc.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bp(pop);
                    min -= valueAt.mItemSize;
                    this.lUg.Ix(valueAt.mItemSize);
                }
            }
            dok();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lHa, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.lUf.lUi + this.lUg.lUi));
            }
        }
    }

    private synchronized d<V> Is(int i) {
        return this.lUc.get(i);
    }

    synchronized d<V> It(int i) {
        d<V> dVar;
        dVar = this.lUc.get(i);
        if (dVar == null && this.lUe) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lHa, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Iu(i);
            this.lUc.put(i, dVar);
        }
        return dVar;
    }

    d<V> Iu(int i) {
        return new d<>(Ir(i), Integer.MAX_VALUE, 0, this.lUb.lUP);
    }

    synchronized boolean dqN() {
        boolean z;
        z = this.lUf.lUi + this.lUg.lUi > this.lUb.lUL;
        if (z) {
            this.lUh.drc();
        }
        return z;
    }

    synchronized boolean Iv(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.lUb.lUK;
            if (i > i2 - this.lUf.lUi) {
                this.lUh.drd();
            } else {
                int i3 = this.lUb.lUL;
                if (i > i3 - (this.lUf.lUi + this.lUg.lUi)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.lUf.lUi + this.lUg.lUi)) {
                    this.lUh.drd();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dok() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lHa, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.lUf.mCount), Integer.valueOf(this.lUf.lUi), Integer.valueOf(this.lUg.mCount), Integer.valueOf(this.lUg.lUi));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int lUi;
        int mCount;

        a() {
        }

        public void Iw(int i) {
            this.mCount++;
            this.lUi += i;
        }

        public void Ix(int i) {
            if (this.lUi >= i && this.mCount > 0) {
                this.mCount--;
                this.lUi -= i;
                return;
            }
            com.facebook.common.c.a.j("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.lUi), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.lUi = 0;
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
