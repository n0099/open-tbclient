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
    private static b oNI;
    final com.facebook.common.memory.c oLZ;
    final r oNJ;
    final Set<V> oNL;
    private boolean oNM;
    @GuardedBy("this")
    final a oNN;
    @GuardedBy("this")
    final a oNO;
    private final s oNP;
    private final Class<?> oAy = getClass();
    final SparseArray<d<V>> oNK = new SparseArray<>();

    /* loaded from: classes18.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V OT(int i);

    protected abstract int OU(int i);

    protected abstract int OV(int i);

    protected abstract void bw(V v);

    protected abstract int bx(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.oLZ = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.oNJ = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.oNP = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.oNJ.oOx) {
            emr();
        } else {
            a(new SparseIntArray(0));
        }
        this.oNL = com.facebook.common.internal.i.ego();
        this.oNO = new a();
        this.oNN = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.oLZ.a(this);
        this.oNP.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        emq();
        int OU = OU(i);
        synchronized (this) {
            d<V> OX = OX(OU);
            if (OX != null && (m = OX.get()) != null) {
                com.facebook.common.internal.g.checkState(this.oNL.add(m));
                int bx = bx(m);
                int OV = OV(bx);
                this.oNN.Pa(OV);
                this.oNO.Pb(OV);
                this.oNP.Ph(OV);
                ejT();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oAy, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bx));
                }
            } else {
                int OV2 = OV(OU);
                if (!OZ(OV2)) {
                    throw new PoolSizeViolationException(this.oNJ.oOs, this.oNN.oNQ, this.oNO.oNQ, OV2);
                }
                this.oNN.Pa(OV2);
                if (OX != null) {
                    OX.emB();
                }
                m = m(OV2, OU, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.oNL.add(m));
                    emu();
                    this.oNP.Pi(OV2);
                    ejT();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.oAy, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(OU));
                    }
                }
            }
        }
        return m;
    }

    private V m(int i, int i2, boolean z) {
        try {
            V OT = OT(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oAy, "alloc success!!");
                return OT;
            }
            return OT;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oAy, "alloc fail!!");
            }
            if (!z || oNI == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.oAy, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (oNI == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.oNN.Pb(i);
                    d<V> OX = OX(i2);
                    if (OX != null) {
                        OX.emC();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oAy, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (oNI == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            oNI.onFailed();
            return m(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bx = bx(v);
        int OV = OV(bx);
        synchronized (this) {
            d<V> OW = OW(bx);
            if (!this.oNL.remove(v)) {
                com.facebook.common.c.a.d(this.oAy, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.oNP.Pj(OV);
            } else if (OW == null || OW.emz() || emv() || !by(v)) {
                if (OW != null) {
                    OW.emC();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oAy, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.oNN.Pb(OV);
                this.oNP.Pj(OV);
            } else {
                OW.release(v);
                this.oNO.Pa(OV);
                this.oNN.Pb(OV);
                this.oNP.Pk(OV);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oAy, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            ejT();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        emt();
    }

    protected void emp() {
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void emq() {
        com.facebook.common.internal.g.checkState(!emv() || this.oNO.oNQ == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.oNK.clear();
            SparseIntArray sparseIntArray2 = this.oNJ.oOu;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.oNK.put(keyAt, new d<>(OV(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.oNJ.oOx));
                }
                this.oNM = false;
            } else {
                this.oNM = true;
            }
        }
    }

    private synchronized void emr() {
        SparseIntArray sparseIntArray = this.oNJ.oOu;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.oNM = false;
        } else {
            this.oNM = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.oNK.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.oNK.put(keyAt, new d<>(OV(keyAt), sparseIntArray.valueAt(i), 0, this.oNJ.oOx));
        }
    }

    private List<d<V>> ems() {
        ArrayList arrayList = new ArrayList(this.oNK.size());
        int size = this.oNK.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.oNK.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.kYA;
            int ejE = valueAt.ejE();
            if (valueAt.emA() > 0) {
                arrayList.add(valueAt);
            }
            this.oNK.setValueAt(i, new d<>(OV(i2), i3, ejE, this.oNJ.oOx));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void emt() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.oNJ.oOx) {
                arrayList = ems();
            } else {
                arrayList = new ArrayList(this.oNK.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.oNK.size(); i++) {
                    d<V> valueAt = this.oNK.valueAt(i);
                    if (valueAt.emA() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.oNK.keyAt(i), valueAt.ejE());
                }
                a(sparseIntArray);
            }
            this.oNO.reset();
            ejT();
        }
        emp();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bw(pop);
            }
        }
    }

    synchronized void emu() {
        if (emv()) {
            trimToSize(this.oNJ.oOt);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.oNN.oNQ + this.oNO.oNQ) - i, this.oNO.oNQ);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oAy, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.oNN.oNQ + this.oNO.oNQ), Integer.valueOf(min));
            }
            ejT();
            for (int i2 = 0; i2 < this.oNK.size() && min > 0; i2++) {
                d<V> valueAt = this.oNK.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.oNO.Pb(valueAt.mItemSize);
                }
            }
            ejT();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oAy, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.oNN.oNQ + this.oNO.oNQ));
            }
        }
    }

    private synchronized d<V> OW(int i) {
        return this.oNK.get(i);
    }

    synchronized d<V> OX(int i) {
        d<V> dVar;
        dVar = this.oNK.get(i);
        if (dVar == null && this.oNM) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oAy, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = OY(i);
            this.oNK.put(i, dVar);
        }
        return dVar;
    }

    d<V> OY(int i) {
        return new d<>(OV(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.oNJ.oOx);
    }

    synchronized boolean emv() {
        boolean z;
        z = this.oNN.oNQ + this.oNO.oNQ > this.oNJ.oOt;
        if (z) {
            this.oNP.emJ();
        }
        return z;
    }

    synchronized boolean OZ(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.oNJ.oOs;
            if (i > i2 - this.oNN.oNQ) {
                this.oNP.emK();
            } else {
                int i3 = this.oNJ.oOt;
                if (i > i3 - (this.oNN.oNQ + this.oNO.oNQ)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.oNN.oNQ + this.oNO.oNQ)) {
                    this.oNP.emK();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void ejT() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.oAy, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.oNN.mCount), Integer.valueOf(this.oNN.oNQ), Integer.valueOf(this.oNO.mCount), Integer.valueOf(this.oNO.oNQ));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes18.dex */
    public static class a {
        int mCount;
        int oNQ;

        a() {
        }

        public void Pa(int i) {
            this.mCount++;
            this.oNQ += i;
        }

        public void Pb(int i) {
            if (this.oNQ >= i && this.mCount > 0) {
                this.mCount--;
                this.oNQ -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.oNQ), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.oNQ = 0;
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
