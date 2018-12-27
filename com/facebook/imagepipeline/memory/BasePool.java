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
    final com.facebook.common.memory.c iqw;
    final r irT;
    final Set<V> irV;
    private boolean irW;
    @GuardedBy("this")
    final a irX;
    @GuardedBy("this")
    final a irY;
    private final s irZ;
    private final Class<?> ihJ = getClass();
    final SparseArray<d<V>> irU = new SparseArray<>();

    protected abstract void aI(V v);

    protected abstract int aJ(V v);

    protected abstract V yE(int i);

    protected abstract int yF(int i);

    protected abstract int yG(int i);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.iqw = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.irT = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.irZ = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.irV = com.facebook.common.internal.h.bTS();
        this.irY = new a();
        this.irX = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.iqw.a(this);
        this.irZ.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        bYX();
        int yF = yF(i);
        synchronized (this) {
            d<V> yH = yH(yF);
            if (yH != null && (v = yH.get()) != null) {
                com.facebook.common.internal.g.checkState(this.irV.add(v));
                int aJ = aJ(v);
                int yG = yG(aJ);
                this.irX.yK(yG);
                this.irY.yL(yG);
                this.irZ.yS(yG);
                bWS();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.ihJ, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            } else {
                int yG2 = yG(yF);
                if (!yJ(yG2)) {
                    throw new PoolSizeViolationException(this.irT.isB, this.irX.isa, this.irY.isa, yG2);
                }
                this.irX.yK(yG2);
                if (yH != null) {
                    yH.bZf();
                }
                v = null;
                try {
                    v = yE(yF);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.irX.yL(yG2);
                        d<V> yH2 = yH(yF);
                        if (yH2 != null) {
                            yH2.bZg();
                        }
                        com.facebook.common.internal.k.q(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.irV.add(v));
                    bYY();
                    this.irZ.yT(yG2);
                    bWS();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.ihJ, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(yF));
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
        int yG = yG(aJ);
        synchronized (this) {
            d<V> yH = yH(aJ);
            if (!this.irV.remove(v)) {
                com.facebook.common.c.a.e(this.ihJ, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                aI(v);
                this.irZ.yU(yG);
            } else if (yH == null || yH.bZd() || bYZ() || !aK(v)) {
                if (yH != null) {
                    yH.bZg();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.ihJ, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
                aI(v);
                this.irX.yL(yG);
                this.irZ.yU(yG);
            } else {
                yH.release(v);
                this.irY.yK(yG);
                this.irX.yL(yG);
                this.irZ.yV(yG);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.ihJ, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aJ));
                }
            }
            bWS();
        }
    }

    protected boolean aK(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void bYX() {
        com.facebook.common.internal.g.checkState(!bYZ() || this.irY.isa == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.irU.clear();
            SparseIntArray sparseIntArray2 = this.irT.isD;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.irU.put(keyAt, new d<>(yG(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.irW = false;
            } else {
                this.irW = true;
            }
        }
    }

    synchronized void bYY() {
        if (bYZ()) {
            trimToSize(this.irT.isC);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.irX.isa + this.irY.isa) - i, this.irY.isa);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.ihJ, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.irX.isa + this.irY.isa), Integer.valueOf(min));
            }
            bWS();
            for (int i2 = 0; i2 < this.irU.size() && min > 0; i2++) {
                d<V> valueAt = this.irU.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aI(pop);
                    min -= valueAt.mItemSize;
                    this.irY.yL(valueAt.mItemSize);
                }
            }
            bWS();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.ihJ, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.irX.isa + this.irY.isa));
            }
        }
    }

    synchronized d<V> yH(int i) {
        d<V> dVar;
        dVar = this.irU.get(i);
        if (dVar == null && this.irW) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.ihJ, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = yI(i);
            this.irU.put(i, dVar);
        }
        return dVar;
    }

    d<V> yI(int i) {
        return new d<>(yG(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean bYZ() {
        boolean z;
        z = this.irX.isa + this.irY.isa > this.irT.isC;
        if (z) {
            this.irZ.bZn();
        }
        return z;
    }

    synchronized boolean yJ(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.irT.isB;
            if (i > i2 - this.irX.isa) {
                this.irZ.bZo();
            } else {
                int i3 = this.irT.isC;
                if (i > i3 - (this.irX.isa + this.irY.isa)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.irX.isa + this.irY.isa)) {
                    this.irZ.bZo();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void bWS() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.ihJ, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.irX.mCount), Integer.valueOf(this.irX.isa), Integer.valueOf(this.irY.mCount), Integer.valueOf(this.irY.isa));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int isa;
        int mCount;

        a() {
        }

        public void yK(int i) {
            this.mCount++;
            this.isa += i;
        }

        public void yL(int i) {
            if (this.isa >= i && this.mCount > 0) {
                this.mCount--;
                this.isa -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.isa), Integer.valueOf(this.mCount));
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
