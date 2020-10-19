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
/* loaded from: classes18.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b nWq;
    final com.facebook.common.memory.c nUH;
    final r nWr;
    final Set<V> nWt;
    private boolean nWu;
    @GuardedBy("this")
    final a nWv;
    @GuardedBy("this")
    final a nWw;
    private final s nWx;
    private final Class<?> nJf = getClass();
    final SparseArray<d<V>> nWs = new SparseArray<>();

    /* loaded from: classes18.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Nc(int i);

    protected abstract int Nd(int i);

    protected abstract int Ne(int i);

    protected abstract void bs(V v);

    protected abstract int bt(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.nUH = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.nWr = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.nWx = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.nWr.nXf) {
            ect();
        } else {
            a(new SparseIntArray(0));
        }
        this.nWt = com.facebook.common.internal.i.dWq();
        this.nWw = new a();
        this.nWv = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.nUH.a(this);
        this.nWx.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        ecs();
        int Nd = Nd(i);
        synchronized (this) {
            d<V> Ng = Ng(Nd);
            if (Ng != null && (m = Ng.get()) != null) {
                com.facebook.common.internal.g.checkState(this.nWt.add(m));
                int bt = bt(m);
                int Ne = Ne(bt);
                this.nWv.Nj(Ne);
                this.nWw.Nk(Ne);
                this.nWx.Nq(Ne);
                dZV();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.nJf, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bt));
                }
            } else {
                int Ne2 = Ne(Nd);
                if (!Ni(Ne2)) {
                    throw new PoolSizeViolationException(this.nWr.nXa, this.nWv.nWy, this.nWw.nWy, Ne2);
                }
                this.nWv.Nj(Ne2);
                if (Ng != null) {
                    Ng.ecD();
                }
                m = m(Ne2, Nd, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.nWt.add(m));
                    ecw();
                    this.nWx.Nr(Ne2);
                    dZV();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.nJf, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(Nd));
                    }
                }
            }
        }
        return m;
    }

    private V m(int i, int i2, boolean z) {
        try {
            V Nc = Nc(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.nJf, "alloc success!!");
                return Nc;
            }
            return Nc;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.nJf, "alloc fail!!");
            }
            if (!z || nWq == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.nJf, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (nWq == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.nWv.Nk(i);
                    d<V> Ng = Ng(i2);
                    if (Ng != null) {
                        Ng.ecE();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.nJf, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (nWq == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            nWq.onFailed();
            return m(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bt = bt(v);
        int Ne = Ne(bt);
        synchronized (this) {
            d<V> Nf = Nf(bt);
            if (!this.nWt.remove(v)) {
                com.facebook.common.c.a.d(this.nJf, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bt));
                bs(v);
                this.nWx.Ns(Ne);
            } else if (Nf == null || Nf.ecB() || ecx() || !bu(v)) {
                if (Nf != null) {
                    Nf.ecE();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.nJf, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bt));
                }
                bs(v);
                this.nWv.Nk(Ne);
                this.nWx.Ns(Ne);
            } else {
                Nf.release(v);
                this.nWw.Nj(Ne);
                this.nWv.Nk(Ne);
                this.nWx.Nt(Ne);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.nJf, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bt));
                }
            }
            dZV();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ecv();
    }

    protected void ecr() {
    }

    protected boolean bu(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void ecs() {
        com.facebook.common.internal.g.checkState(!ecx() || this.nWw.nWy == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.nWs.clear();
            SparseIntArray sparseIntArray2 = this.nWr.nXc;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.nWs.put(keyAt, new d<>(Ne(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.nWr.nXf));
                }
                this.nWu = false;
            } else {
                this.nWu = true;
            }
        }
    }

    private synchronized void ect() {
        SparseIntArray sparseIntArray = this.nWr.nXc;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.nWu = false;
        } else {
            this.nWu = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.nWs.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.nWs.put(keyAt, new d<>(Ne(keyAt), sparseIntArray.valueAt(i), 0, this.nWr.nXf));
        }
    }

    private List<d<V>> ecu() {
        ArrayList arrayList = new ArrayList(this.nWs.size());
        int size = this.nWs.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.nWs.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.kMd;
            int dZG = valueAt.dZG();
            if (valueAt.ecC() > 0) {
                arrayList.add(valueAt);
            }
            this.nWs.setValueAt(i, new d<>(Ne(i2), i3, dZG, this.nWr.nXf));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void ecv() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.nWr.nXf) {
                arrayList = ecu();
            } else {
                arrayList = new ArrayList(this.nWs.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.nWs.size(); i++) {
                    d<V> valueAt = this.nWs.valueAt(i);
                    if (valueAt.ecC() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.nWs.keyAt(i), valueAt.dZG());
                }
                a(sparseIntArray);
            }
            this.nWw.reset();
            dZV();
        }
        ecr();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bs(pop);
            }
        }
    }

    synchronized void ecw() {
        if (ecx()) {
            trimToSize(this.nWr.nXb);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.nWv.nWy + this.nWw.nWy) - i, this.nWw.nWy);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.nJf, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.nWv.nWy + this.nWw.nWy), Integer.valueOf(min));
            }
            dZV();
            for (int i2 = 0; i2 < this.nWs.size() && min > 0; i2++) {
                d<V> valueAt = this.nWs.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bs(pop);
                    min -= valueAt.mItemSize;
                    this.nWw.Nk(valueAt.mItemSize);
                }
            }
            dZV();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.nJf, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.nWv.nWy + this.nWw.nWy));
            }
        }
    }

    private synchronized d<V> Nf(int i) {
        return this.nWs.get(i);
    }

    synchronized d<V> Ng(int i) {
        d<V> dVar;
        dVar = this.nWs.get(i);
        if (dVar == null && this.nWu) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.nJf, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Nh(i);
            this.nWs.put(i, dVar);
        }
        return dVar;
    }

    d<V> Nh(int i) {
        return new d<>(Ne(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.nWr.nXf);
    }

    synchronized boolean ecx() {
        boolean z;
        z = this.nWv.nWy + this.nWw.nWy > this.nWr.nXb;
        if (z) {
            this.nWx.ecL();
        }
        return z;
    }

    synchronized boolean Ni(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.nWr.nXa;
            if (i > i2 - this.nWv.nWy) {
                this.nWx.ecM();
            } else {
                int i3 = this.nWr.nXb;
                if (i > i3 - (this.nWv.nWy + this.nWw.nWy)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.nWv.nWy + this.nWw.nWy)) {
                    this.nWx.ecM();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dZV() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.nJf, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.nWv.mCount), Integer.valueOf(this.nWv.nWy), Integer.valueOf(this.nWw.mCount), Integer.valueOf(this.nWw.nWy));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes18.dex */
    public static class a {
        int mCount;
        int nWy;

        a() {
        }

        public void Nj(int i) {
            this.mCount++;
            this.nWy += i;
        }

        public void Nk(int i) {
            if (this.nWy >= i && this.mCount > 0) {
                this.mCount--;
                this.nWy -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.nWy), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.nWy = 0;
        }
    }

    /* loaded from: classes18.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes18.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes18.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes18.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
