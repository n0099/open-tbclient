package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.support.v7.widget.ActivityChooserView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes2.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    final com.facebook.common.memory.c inl;
    final r ioJ;
    final Set<V> ioL;
    private boolean ioM;
    @GuardedBy("this")
    final a ioN;
    @GuardedBy("this")
    final a ioO;
    private final s ioP;
    private final Class<?> iez = getClass();
    final SparseArray<d<V>> ioK = new SparseArray<>();

    protected abstract void aI(V v);

    protected abstract int aJ(V v);

    protected abstract V yr(int i);

    protected abstract int ys(int i);

    protected abstract int yt(int i);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.inl = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.ioJ = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.ioP = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.ioL = com.facebook.common.internal.h.bTc();
        this.ioO = new a();
        this.ioN = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.inl.a(this);
        this.ioP.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        bYh();
        int ys = ys(i);
        synchronized (this) {
            d<V> yu = yu(ys);
            if (yu != null && (v = yu.get()) != null) {
                com.facebook.common.internal.g.checkState(this.ioL.add(v));
                int aJ = aJ(v);
                int yt = yt(aJ);
                this.ioN.yx(yt);
                this.ioO.yy(yt);
                this.ioP.yF(yt);
                bWc();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iez, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            } else {
                int yt2 = yt(ys);
                if (!yw(yt2)) {
                    throw new PoolSizeViolationException(this.ioJ.ipr, this.ioN.ioQ, this.ioO.ioQ, yt2);
                }
                this.ioN.yx(yt2);
                if (yu != null) {
                    yu.bYp();
                }
                v = null;
                try {
                    v = yr(ys);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.ioN.yy(yt2);
                        d<V> yu2 = yu(ys);
                        if (yu2 != null) {
                            yu2.bYq();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.ioL.add(v));
                    bYi();
                    this.ioP.yG(yt2);
                    bWc();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.iez, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(ys));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aJ = aJ(v);
        int yt = yt(aJ);
        synchronized (this) {
            d<V> yu = yu(aJ);
            if (!this.ioL.remove(v)) {
                com.facebook.common.c.a.e(this.iez, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                aI(v);
                this.ioP.yH(yt);
            } else if (yu == null || yu.bYn() || bYj() || !aK(v)) {
                if (yu != null) {
                    yu.bYq();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iez, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
                aI(v);
                this.ioN.yy(yt);
                this.ioP.yH(yt);
            } else {
                yu.release(v);
                this.ioO.yx(yt);
                this.ioN.yy(yt);
                this.ioP.yI(yt);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.iez, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            }
            bWc();
        }
    }

    protected boolean aK(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void bYh() {
        com.facebook.common.internal.g.checkState(!bYj() || this.ioO.ioQ == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.ioK.clear();
            SparseIntArray sparseIntArray2 = this.ioJ.ipt;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.ioK.put(keyAt, new d<>(yt(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.ioM = false;
            } else {
                this.ioM = true;
            }
        }
    }

    synchronized void bYi() {
        if (bYj()) {
            trimToSize(this.ioJ.ips);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.ioN.ioQ + this.ioO.ioQ) - i, this.ioO.ioQ);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iez, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.ioN.ioQ + this.ioO.ioQ), Integer.valueOf(min));
            }
            bWc();
            for (int i2 = 0; i2 < this.ioK.size() && min > 0; i2++) {
                d<V> valueAt = this.ioK.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aI(pop);
                    min -= valueAt.mItemSize;
                    this.ioO.yy(valueAt.mItemSize);
                }
            }
            bWc();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iez, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.ioN.ioQ + this.ioO.ioQ));
            }
        }
    }

    synchronized d<V> yu(int i) {
        d<V> dVar;
        dVar = this.ioK.get(i);
        if (dVar == null && this.ioM) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.iez, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = yv(i);
            this.ioK.put(i, dVar);
        }
        return dVar;
    }

    d<V> yv(int i) {
        return new d<>(yt(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean bYj() {
        boolean z;
        z = this.ioN.ioQ + this.ioO.ioQ > this.ioJ.ips;
        if (z) {
            this.ioP.bYx();
        }
        return z;
    }

    synchronized boolean yw(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.ioJ.ipr;
            if (i > i2 - this.ioN.ioQ) {
                this.ioP.bYy();
            } else {
                int i3 = this.ioJ.ips;
                if (i > i3 - (this.ioN.ioQ + this.ioO.ioQ)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.ioN.ioQ + this.ioO.ioQ)) {
                    this.ioP.bYy();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void bWc() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.iez, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.ioN.mCount), Integer.valueOf(this.ioN.ioQ), Integer.valueOf(this.ioO.mCount), Integer.valueOf(this.ioO.ioQ));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int ioQ;
        int mCount;

        a() {
        }

        public void yx(int i) {
            this.mCount++;
            this.ioQ += i;
        }

        public void yy(int i) {
            if (this.ioQ >= i && this.mCount > 0) {
                this.mCount--;
                this.ioQ -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.ioQ), Integer.valueOf(this.mCount));
        }
    }

    /* loaded from: classes2.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes2.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
