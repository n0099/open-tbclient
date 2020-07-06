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
    private static b mUR;
    final com.facebook.common.memory.c mTd;
    final r mUS;
    final Set<V> mUU;
    private boolean mUV;
    @GuardedBy("this")
    final a mUW;
    @GuardedBy("this")
    final a mUX;
    private final s mUY;
    private final Class<?> mHr = getClass();
    final SparseArray<d<V>> mUT = new SparseArray<>();

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
        this.mTd = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.mUS = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.mUY = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.mUS.mVG) {
            dFp();
        } else {
            a(new SparseIntArray(0));
        }
        this.mUU = com.facebook.common.internal.i.dzl();
        this.mUX = new a();
        this.mUW = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.mTd.a(this);
        this.mUY.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dFo();
        int IT = IT(i);
        synchronized (this) {
            d<V> IW = IW(IT);
            if (IW != null && (o = IW.get()) != null) {
                com.facebook.common.internal.g.checkState(this.mUU.add(o));
                int bm = bm(o);
                int IU = IU(bm);
                this.mUW.IZ(IU);
                this.mUX.Ja(IU);
                this.mUY.Jg(IU);
                dCR();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mHr, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bm));
                }
            } else {
                int IU2 = IU(IT);
                if (!IY(IU2)) {
                    throw new PoolSizeViolationException(this.mUS.mVB, this.mUW.mUZ, this.mUX.mUZ, IU2);
                }
                this.mUW.IZ(IU2);
                if (IW != null) {
                    IW.dFz();
                }
                o = o(IU2, IT, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.mUU.add(o));
                    dFs();
                    this.mUY.Jh(IU2);
                    dCR();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.mHr, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(IT));
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
                com.facebook.common.c.a.f(this.mHr, "alloc success!!");
                return IS;
            }
            return IS;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mHr, "alloc fail!!");
            }
            if (!z || mUR == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.mHr, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (mUR == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.mUW.Ja(i);
                    d<V> IW = IW(i2);
                    if (IW != null) {
                        IW.dFA();
                    }
                    com.facebook.common.internal.l.x(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.mHr, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (mUR == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            mUR.onFailed();
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
            if (!this.mUU.remove(v)) {
                com.facebook.common.c.a.d(this.mHr, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                bl(v);
                this.mUY.Ji(IU);
            } else if (IV == null || IV.dFx() || dFt() || !bn(v)) {
                if (IV != null) {
                    IV.dFA();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mHr, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
                bl(v);
                this.mUW.Ja(IU);
                this.mUY.Ji(IU);
            } else {
                IV.release(v);
                this.mUX.IZ(IU);
                this.mUW.Ja(IU);
                this.mUY.Jj(IU);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.mHr, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bm));
                }
            }
            dCR();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dFr();
    }

    protected void dFn() {
    }

    protected boolean bn(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dFo() {
        com.facebook.common.internal.g.checkState(!dFt() || this.mUX.mUZ == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.mUT.clear();
            SparseIntArray sparseIntArray2 = this.mUS.mVD;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.mUT.put(keyAt, new d<>(IU(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mUS.mVG));
                }
                this.mUV = false;
            } else {
                this.mUV = true;
            }
        }
    }

    private synchronized void dFp() {
        SparseIntArray sparseIntArray = this.mUS.mVD;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.mUV = false;
        } else {
            this.mUV = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.mUT.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mUT.put(keyAt, new d<>(IU(keyAt), sparseIntArray.valueAt(i), 0, this.mUS.mVG));
        }
    }

    private List<d<V>> dFq() {
        ArrayList arrayList = new ArrayList(this.mUT.size());
        int size = this.mUT.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.mUT.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.jQp;
            int dCC = valueAt.dCC();
            if (valueAt.dFy() > 0) {
                arrayList.add(valueAt);
            }
            this.mUT.setValueAt(i, new d<>(IU(i2), i3, dCC, this.mUS.mVG));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dFr() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.mUS.mVG) {
                arrayList = dFq();
            } else {
                arrayList = new ArrayList(this.mUT.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.mUT.size(); i++) {
                    d<V> valueAt = this.mUT.valueAt(i);
                    if (valueAt.dFy() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.mUT.keyAt(i), valueAt.dCC());
                }
                a(sparseIntArray);
            }
            this.mUX.reset();
            dCR();
        }
        dFn();
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

    synchronized void dFs() {
        if (dFt()) {
            trimToSize(this.mUS.mVC);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.mUW.mUZ + this.mUX.mUZ) - i, this.mUX.mUZ);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mHr, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mUW.mUZ + this.mUX.mUZ), Integer.valueOf(min));
            }
            dCR();
            for (int i2 = 0; i2 < this.mUT.size() && min > 0; i2++) {
                d<V> valueAt = this.mUT.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bl(pop);
                    min -= valueAt.mItemSize;
                    this.mUX.Ja(valueAt.mItemSize);
                }
            }
            dCR();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mHr, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mUW.mUZ + this.mUX.mUZ));
            }
        }
    }

    private synchronized d<V> IV(int i) {
        return this.mUT.get(i);
    }

    synchronized d<V> IW(int i) {
        d<V> dVar;
        dVar = this.mUT.get(i);
        if (dVar == null && this.mUV) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.mHr, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = IX(i);
            this.mUT.put(i, dVar);
        }
        return dVar;
    }

    d<V> IX(int i) {
        return new d<>(IU(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.mUS.mVG);
    }

    synchronized boolean dFt() {
        boolean z;
        z = this.mUW.mUZ + this.mUX.mUZ > this.mUS.mVC;
        if (z) {
            this.mUY.dFH();
        }
        return z;
    }

    synchronized boolean IY(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.mUS.mVB;
            if (i > i2 - this.mUW.mUZ) {
                this.mUY.dFI();
            } else {
                int i3 = this.mUS.mVC;
                if (i > i3 - (this.mUW.mUZ + this.mUX.mUZ)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.mUW.mUZ + this.mUX.mUZ)) {
                    this.mUY.dFI();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dCR() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.mHr, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUW.mCount), Integer.valueOf(this.mUW.mUZ), Integer.valueOf(this.mUX.mCount), Integer.valueOf(this.mUX.mUZ));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes12.dex */
    public static class a {
        int mCount;
        int mUZ;

        a() {
        }

        public void IZ(int i) {
            this.mCount++;
            this.mUZ += i;
        }

        public void Ja(int i) {
            if (this.mUZ >= i && this.mCount > 0) {
                this.mCount--;
                this.mUZ -= i;
                return;
            }
            com.facebook.common.c.a.l("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mUZ), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.mUZ = 0;
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
