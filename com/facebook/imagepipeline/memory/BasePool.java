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
    private static b mUO;
    final com.facebook.common.memory.c mTa;
    final r mUP;
    final Set<V> mUR;
    private boolean mUS;
    @GuardedBy("this")
    final a mUT;
    @GuardedBy("this")
    final a mUU;
    private final s mUV;
    private final Class<?> mHo = getClass();
    final SparseArray<d<V>> mUQ = new SparseArray<>();

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V IS(int i);

    protected abstract int IT(int i);

    protected abstract int IU(int i);

    protected abstract void bl(V v);

    protected abstract int bm(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.mTa = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.mUP = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.mUV = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.mUP.mVD) {
            dFl();
        } else {
            a(new SparseIntArray(0));
        }
        this.mUR = com.facebook.common.internal.i.dzh();
        this.mUU = new a();
        this.mUT = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.mTa.a(this);
        this.mUV.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dFk();
        int IT = IT(i);
        synchronized (this) {
            d<V> IW = IW(IT);
            if (IW != null && (o = IW.get()) != null) {
                com.facebook.common.internal.g.checkState(this.mUR.add(o));
                int bm = bm(o);
                int IU = IU(bm);
                this.mUT.IZ(IU);
                this.mUU.Ja(IU);
                this.mUV.Jg(IU);
                dCN();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mHo, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bm));
                }
            } else {
                int IU2 = IU(IT);
                if (!IY(IU2)) {
                    throw new PoolSizeViolationException(this.mUP.mVy, this.mUT.mUW, this.mUU.mUW, IU2);
                }
                this.mUT.IZ(IU2);
                if (IW != null) {
                    IW.dFv();
                }
                o = o(IU2, IT, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.mUR.add(o));
                    dFo();
                    this.mUV.Jh(IU2);
                    dCN();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.mHo, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(IT));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V IS = IS(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mHo, "alloc success!!");
                return IS;
            }
            return IS;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mHo, "alloc fail!!");
            }
            if (!z || mUO == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.mHo, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (mUO == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.mUT.Ja(i);
                    d<V> IW = IW(i2);
                    if (IW != null) {
                        IW.dFw();
                    }
                    com.facebook.common.internal.l.x(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mHo, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (mUO == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            mUO.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bm = bm(v);
        int IU = IU(bm);
        synchronized (this) {
            d<V> IV = IV(bm);
            if (!this.mUR.remove(v)) {
                com.facebook.common.c.a.d(this.mHo, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                bl(v);
                this.mUV.Ji(IU);
            } else if (IV == null || IV.dFt() || dFp() || !bn(v)) {
                if (IV != null) {
                    IV.dFw();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mHo, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
                bl(v);
                this.mUT.Ja(IU);
                this.mUV.Ji(IU);
            } else {
                IV.release(v);
                this.mUU.IZ(IU);
                this.mUT.Ja(IU);
                this.mUV.Jj(IU);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mHo, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
            }
            dCN();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dFn();
    }

    protected void dFj() {
    }

    protected boolean bn(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dFk() {
        com.facebook.common.internal.g.checkState(!dFp() || this.mUU.mUW == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.mUQ.clear();
            SparseIntArray sparseIntArray2 = this.mUP.mVA;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.mUQ.put(keyAt, new d<>(IU(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mUP.mVD));
                }
                this.mUS = false;
            } else {
                this.mUS = true;
            }
        }
    }

    private synchronized void dFl() {
        SparseIntArray sparseIntArray = this.mUP.mVA;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.mUS = false;
        } else {
            this.mUS = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.mUQ.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mUQ.put(keyAt, new d<>(IU(keyAt), sparseIntArray.valueAt(i), 0, this.mUP.mVD));
        }
    }

    private List<d<V>> dFm() {
        ArrayList arrayList = new ArrayList(this.mUQ.size());
        int size = this.mUQ.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.mUQ.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.jQp;
            int dCy = valueAt.dCy();
            if (valueAt.dFu() > 0) {
                arrayList.add(valueAt);
            }
            this.mUQ.setValueAt(i, new d<>(IU(i2), i3, dCy, this.mUP.mVD));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dFn() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.mUP.mVD) {
                arrayList = dFm();
            } else {
                arrayList = new ArrayList(this.mUQ.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.mUQ.size(); i++) {
                    d<V> valueAt = this.mUQ.valueAt(i);
                    if (valueAt.dFu() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.mUQ.keyAt(i), valueAt.dCy());
                }
                a(sparseIntArray);
            }
            this.mUU.reset();
            dCN();
        }
        dFj();
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

    synchronized void dFo() {
        if (dFp()) {
            trimToSize(this.mUP.mVz);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.mUT.mUW + this.mUU.mUW) - i, this.mUU.mUW);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mHo, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mUT.mUW + this.mUU.mUW), Integer.valueOf(min));
            }
            dCN();
            for (int i2 = 0; i2 < this.mUQ.size() && min > 0; i2++) {
                d<V> valueAt = this.mUQ.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bl(pop);
                    min -= valueAt.mItemSize;
                    this.mUU.Ja(valueAt.mItemSize);
                }
            }
            dCN();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mHo, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mUT.mUW + this.mUU.mUW));
            }
        }
    }

    private synchronized d<V> IV(int i) {
        return this.mUQ.get(i);
    }

    synchronized d<V> IW(int i) {
        d<V> dVar;
        dVar = this.mUQ.get(i);
        if (dVar == null && this.mUS) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mHo, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = IX(i);
            this.mUQ.put(i, dVar);
        }
        return dVar;
    }

    d<V> IX(int i) {
        return new d<>(IU(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.mUP.mVD);
    }

    synchronized boolean dFp() {
        boolean z;
        z = this.mUT.mUW + this.mUU.mUW > this.mUP.mVz;
        if (z) {
            this.mUV.dFD();
        }
        return z;
    }

    synchronized boolean IY(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.mUP.mVy;
            if (i > i2 - this.mUT.mUW) {
                this.mUV.dFE();
            } else {
                int i3 = this.mUP.mVz;
                if (i > i3 - (this.mUT.mUW + this.mUU.mUW)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.mUT.mUW + this.mUU.mUW)) {
                    this.mUV.dFE();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dCN() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.mHo, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUT.mCount), Integer.valueOf(this.mUT.mUW), Integer.valueOf(this.mUU.mCount), Integer.valueOf(this.mUU.mUW));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int mCount;
        int mUW;

        a() {
        }

        public void IZ(int i) {
            this.mCount++;
            this.mUW += i;
        }

        public void Ja(int i) {
            if (this.mUW >= i && this.mCount > 0) {
                this.mCount--;
                this.mUW -= i;
                return;
            }
            com.facebook.common.c.a.l("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mUW), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.mUW = 0;
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
