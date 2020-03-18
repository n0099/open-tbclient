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
    private static b lVR;
    final com.facebook.common.memory.c lUg;
    final r lVS;
    final Set<V> lVU;
    private boolean lVV;
    @GuardedBy("this")
    final a lVW;
    @GuardedBy("this")
    final a lVX;
    private final s lVY;
    private final Class<?> lIR = getClass();
    final SparseArray<d<V>> lVT = new SparseArray<>();

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Iv(int i);

    protected abstract int Iw(int i);

    protected abstract int Ix(int i);

    protected abstract void bp(V v);

    protected abstract int bq(V v);

    public static void a(b bVar) {
        lVR = bVar;
    }

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.lUg = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.lVS = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.lVY = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.lVS.lWG) {
            drh();
        } else {
            a(new SparseIntArray(0));
        }
        this.lVU = com.facebook.common.internal.i.dlg();
        this.lVX = new a();
        this.lVW = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.lUg.a(this);
        this.lVY.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        drg();
        int Iw = Iw(i);
        synchronized (this) {
            d<V> Iz = Iz(Iw);
            if (Iz != null && (o = Iz.get()) != null) {
                com.facebook.common.internal.g.checkState(this.lVU.add(o));
                int bq = bq(o);
                int Ix = Ix(bq);
                this.lVW.IC(Ix);
                this.lVX.ID(Ix);
                this.lVY.IJ(Ix);
                doI();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lIR, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bq));
                }
            } else {
                int Ix2 = Ix(Iw);
                if (!IB(Ix2)) {
                    throw new PoolSizeViolationException(this.lVS.lWB, this.lVW.lVZ, this.lVX.lVZ, Ix2);
                }
                this.lVW.IC(Ix2);
                if (Iz != null) {
                    Iz.drs();
                }
                o = o(Ix2, Iw, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.lVU.add(o));
                    drk();
                    this.lVY.IK(Ix2);
                    doI();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lIR, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(Iw));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V Iv = Iv(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lIR, "alloc success!!");
                return Iv;
            }
            return Iv;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lIR, "alloc fail!!");
            }
            if (!z || lVR == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lIR, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (lVR == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.lVW.ID(i);
                    d<V> Iz = Iz(i2);
                    if (Iz != null) {
                        Iz.drt();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lIR, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (lVR == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            lVR.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bq = bq(v);
        int Ix = Ix(bq);
        synchronized (this) {
            d<V> Iy = Iy(bq);
            if (!this.lVU.remove(v)) {
                com.facebook.common.c.a.d(this.lIR, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                bp(v);
                this.lVY.IL(Ix);
            } else if (Iy == null || Iy.drq() || drl() || !br(v)) {
                if (Iy != null) {
                    Iy.drt();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lIR, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
                bp(v);
                this.lVW.ID(Ix);
                this.lVY.IL(Ix);
            } else {
                Iy.release(v);
                this.lVX.IC(Ix);
                this.lVW.ID(Ix);
                this.lVY.IM(Ix);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lIR, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bq));
                }
            }
            doI();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        drj();
    }

    protected void drf() {
    }

    protected boolean br(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void drg() {
        com.facebook.common.internal.g.checkState(!drl() || this.lVX.lVZ == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.lVT.clear();
            SparseIntArray sparseIntArray2 = this.lVS.lWD;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.lVT.put(keyAt, new d<>(Ix(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.lVS.lWG));
                }
                this.lVV = false;
            } else {
                this.lVV = true;
            }
        }
    }

    private synchronized void drh() {
        SparseIntArray sparseIntArray = this.lVS.lWD;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.lVV = false;
        } else {
            this.lVV = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.lVT.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.lVT.put(keyAt, new d<>(Ix(keyAt), sparseIntArray.valueAt(i), 0, this.lVS.lWG));
        }
    }

    private List<d<V>> dri() {
        ArrayList arrayList = new ArrayList(this.lVT.size());
        int size = this.lVT.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.lVT.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.iwF;
            int dov = valueAt.dov();
            if (valueAt.drr() > 0) {
                arrayList.add(valueAt);
            }
            this.lVT.setValueAt(i, new d<>(Ix(i2), i3, dov, this.lVS.lWG));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void drj() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.lVS.lWG) {
                arrayList = dri();
            } else {
                arrayList = new ArrayList(this.lVT.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.lVT.size(); i++) {
                    d<V> valueAt = this.lVT.valueAt(i);
                    if (valueAt.drr() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.lVT.keyAt(i), valueAt.dov());
                }
                a(sparseIntArray);
            }
            this.lVX.reset();
            doI();
        }
        drf();
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

    synchronized void drk() {
        if (drl()) {
            trimToSize(this.lVS.lWC);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.lVW.lVZ + this.lVX.lVZ) - i, this.lVX.lVZ);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lIR, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.lVW.lVZ + this.lVX.lVZ), Integer.valueOf(min));
            }
            doI();
            for (int i2 = 0; i2 < this.lVT.size() && min > 0; i2++) {
                d<V> valueAt = this.lVT.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bp(pop);
                    min -= valueAt.mItemSize;
                    this.lVX.ID(valueAt.mItemSize);
                }
            }
            doI();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lIR, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.lVW.lVZ + this.lVX.lVZ));
            }
        }
    }

    private synchronized d<V> Iy(int i) {
        return this.lVT.get(i);
    }

    synchronized d<V> Iz(int i) {
        d<V> dVar;
        dVar = this.lVT.get(i);
        if (dVar == null && this.lVV) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lIR, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = IA(i);
            this.lVT.put(i, dVar);
        }
        return dVar;
    }

    d<V> IA(int i) {
        return new d<>(Ix(i), Integer.MAX_VALUE, 0, this.lVS.lWG);
    }

    synchronized boolean drl() {
        boolean z;
        z = this.lVW.lVZ + this.lVX.lVZ > this.lVS.lWC;
        if (z) {
            this.lVY.drA();
        }
        return z;
    }

    synchronized boolean IB(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.lVS.lWB;
            if (i > i2 - this.lVW.lVZ) {
                this.lVY.drB();
            } else {
                int i3 = this.lVS.lWC;
                if (i > i3 - (this.lVW.lVZ + this.lVX.lVZ)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.lVW.lVZ + this.lVX.lVZ)) {
                    this.lVY.drB();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void doI() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lIR, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.lVW.mCount), Integer.valueOf(this.lVW.lVZ), Integer.valueOf(this.lVX.mCount), Integer.valueOf(this.lVX.lVZ));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int lVZ;
        int mCount;

        a() {
        }

        public void IC(int i) {
            this.mCount++;
            this.lVZ += i;
        }

        public void ID(int i) {
            if (this.lVZ >= i && this.mCount > 0) {
                this.mCount--;
                this.lVZ -= i;
                return;
            }
            com.facebook.common.c.a.j("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.lVZ), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.lVZ = 0;
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
