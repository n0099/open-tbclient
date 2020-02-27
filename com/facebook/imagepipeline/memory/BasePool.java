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
    private static b lTY;
    final com.facebook.common.memory.c lSn;
    final r lTZ;
    final Set<V> lUb;
    private boolean lUc;
    @GuardedBy("this")
    final a lUd;
    @GuardedBy("this")
    final a lUe;
    private final s lUf;
    private final Class<?> lGY = getClass();
    final SparseArray<d<V>> lUa = new SparseArray<>();

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
        lTY = bVar;
    }

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.lSn = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.lTZ = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.lUf = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.lTZ.lUN) {
            dqH();
        } else {
            a(new SparseIntArray(0));
        }
        this.lUb = com.facebook.common.internal.i.dkG();
        this.lUe = new a();
        this.lUd = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.lSn.a(this);
        this.lUf.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dqG();
        int Iq = Iq(i);
        synchronized (this) {
            d<V> It = It(Iq);
            if (It != null && (o = It.get()) != null) {
                com.facebook.common.internal.g.checkState(this.lUb.add(o));
                int bq = bq(o);
                int Ir = Ir(bq);
                this.lUd.Iw(Ir);
                this.lUe.Ix(Ir);
                this.lUf.ID(Ir);
                doi();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGY, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bq));
                }
            } else {
                int Ir2 = Ir(Iq);
                if (!Iv(Ir2)) {
                    throw new PoolSizeViolationException(this.lTZ.lUI, this.lUd.lUg, this.lUe.lUg, Ir2);
                }
                this.lUd.Iw(Ir2);
                if (It != null) {
                    It.dqS();
                }
                o = o(Ir2, Iq, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.lUb.add(o));
                    dqK();
                    this.lUf.IE(Ir2);
                    doi();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lGY, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(Iq));
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
                com.facebook.common.c.a.f(this.lGY, "alloc success!!");
                return Ip;
            }
            return Ip;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lGY, "alloc fail!!");
            }
            if (!z || lTY == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lGY, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (lTY == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.lUd.Ix(i);
                    d<V> It = It(i2);
                    if (It != null) {
                        It.dqT();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lGY, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (lTY == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            lTY.onFailed();
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
            if (!this.lUb.remove(v)) {
                com.facebook.common.c.a.d(this.lGY, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                bp(v);
                this.lUf.IF(Ir);
            } else if (Is == null || Is.dqQ() || dqL() || !br(v)) {
                if (Is != null) {
                    Is.dqT();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGY, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
                bp(v);
                this.lUd.Ix(Ir);
                this.lUf.IF(Ir);
            } else {
                Is.release(v);
                this.lUe.Iw(Ir);
                this.lUd.Ix(Ir);
                this.lUf.IG(Ir);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGY, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
            }
            doi();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dqJ();
    }

    protected void dqF() {
    }

    protected boolean br(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dqG() {
        com.facebook.common.internal.g.checkState(!dqL() || this.lUe.lUg == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.lUa.clear();
            SparseIntArray sparseIntArray2 = this.lTZ.lUK;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.lUa.put(keyAt, new d<>(Ir(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.lTZ.lUN));
                }
                this.lUc = false;
            } else {
                this.lUc = true;
            }
        }
    }

    private synchronized void dqH() {
        SparseIntArray sparseIntArray = this.lTZ.lUK;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.lUc = false;
        } else {
            this.lUc = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.lUa.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.lUa.put(keyAt, new d<>(Ir(keyAt), sparseIntArray.valueAt(i), 0, this.lTZ.lUN));
        }
    }

    private List<d<V>> dqI() {
        ArrayList arrayList = new ArrayList(this.lUa.size());
        int size = this.lUa.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.lUa.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.iuR;
            int dnV = valueAt.dnV();
            if (valueAt.dqR() > 0) {
                arrayList.add(valueAt);
            }
            this.lUa.setValueAt(i, new d<>(Ir(i2), i3, dnV, this.lTZ.lUN));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dqJ() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.lTZ.lUN) {
                arrayList = dqI();
            } else {
                arrayList = new ArrayList(this.lUa.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.lUa.size(); i++) {
                    d<V> valueAt = this.lUa.valueAt(i);
                    if (valueAt.dqR() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.lUa.keyAt(i), valueAt.dnV());
                }
                a(sparseIntArray);
            }
            this.lUe.reset();
            doi();
        }
        dqF();
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

    synchronized void dqK() {
        if (dqL()) {
            trimToSize(this.lTZ.lUJ);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.lUd.lUg + this.lUe.lUg) - i, this.lUe.lUg);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGY, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.lUd.lUg + this.lUe.lUg), Integer.valueOf(min));
            }
            doi();
            for (int i2 = 0; i2 < this.lUa.size() && min > 0; i2++) {
                d<V> valueAt = this.lUa.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bp(pop);
                    min -= valueAt.mItemSize;
                    this.lUe.Ix(valueAt.mItemSize);
                }
            }
            doi();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGY, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.lUd.lUg + this.lUe.lUg));
            }
        }
    }

    private synchronized d<V> Is(int i) {
        return this.lUa.get(i);
    }

    synchronized d<V> It(int i) {
        d<V> dVar;
        dVar = this.lUa.get(i);
        if (dVar == null && this.lUc) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGY, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Iu(i);
            this.lUa.put(i, dVar);
        }
        return dVar;
    }

    d<V> Iu(int i) {
        return new d<>(Ir(i), Integer.MAX_VALUE, 0, this.lTZ.lUN);
    }

    synchronized boolean dqL() {
        boolean z;
        z = this.lUd.lUg + this.lUe.lUg > this.lTZ.lUJ;
        if (z) {
            this.lUf.dra();
        }
        return z;
    }

    synchronized boolean Iv(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.lTZ.lUI;
            if (i > i2 - this.lUd.lUg) {
                this.lUf.drb();
            } else {
                int i3 = this.lTZ.lUJ;
                if (i > i3 - (this.lUd.lUg + this.lUe.lUg)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.lUd.lUg + this.lUe.lUg)) {
                    this.lUf.drb();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void doi() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lGY, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.lUd.mCount), Integer.valueOf(this.lUd.lUg), Integer.valueOf(this.lUe.mCount), Integer.valueOf(this.lUe.lUg));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int lUg;
        int mCount;

        a() {
        }

        public void Iw(int i) {
            this.mCount++;
            this.lUg += i;
        }

        public void Ix(int i) {
            if (this.lUg >= i && this.mCount > 0) {
                this.mCount--;
                this.lUg -= i;
                return;
            }
            com.facebook.common.c.a.j("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.lUg), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.lUg = 0;
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
