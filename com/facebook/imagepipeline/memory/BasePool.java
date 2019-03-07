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
    final com.facebook.common.memory.c jHk;
    final r jIK;
    final Set<V> jIM;
    private boolean jIN;
    @GuardedBy("this")
    final a jIO;
    @GuardedBy("this")
    final a jIP;
    private final s jIQ;
    private final Class<?> jyv = getClass();
    final SparseArray<d<V>> jIL = new SparseArray<>();

    protected abstract V Cs(int i);

    protected abstract int Ct(int i);

    protected abstract int Cu(int i);

    protected abstract void aX(V v);

    protected abstract int aY(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jHk = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.jIK = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.jIQ = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.jIM = com.facebook.common.internal.h.cty();
        this.jIP = new a();
        this.jIO = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jHk.a(this);
        this.jIQ.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cyK();
        int Ct = Ct(i);
        synchronized (this) {
            d<V> Cv = Cv(Ct);
            if (Cv != null && (v = Cv.get()) != null) {
                com.facebook.common.internal.g.checkState(this.jIM.add(v));
                int aY = aY(v);
                int Cu = Cu(aY);
                this.jIO.Cy(Cu);
                this.jIP.Cz(Cu);
                this.jIQ.CG(Cu);
                cwB();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyv, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aY));
                }
            } else {
                int Cu2 = Cu(Ct);
                if (!Cx(Cu2)) {
                    throw new PoolSizeViolationException(this.jIK.jJr, this.jIO.jIR, this.jIP.jIR, Cu2);
                }
                this.jIO.Cy(Cu2);
                if (Cv != null) {
                    Cv.cyS();
                }
                v = null;
                try {
                    v = Cs(Ct);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.jIO.Cz(Cu2);
                        d<V> Cv2 = Cv(Ct);
                        if (Cv2 != null) {
                            Cv2.cyT();
                        }
                        com.facebook.common.internal.k.r(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.jIM.add(v));
                    cyL();
                    this.jIQ.CH(Cu2);
                    cwB();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jyv, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Ct));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aY = aY(v);
        int Cu = Cu(aY);
        synchronized (this) {
            d<V> Cv = Cv(aY);
            if (!this.jIM.remove(v)) {
                com.facebook.common.c.a.e(this.jyv, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aY));
                aX(v);
                this.jIQ.CI(Cu);
            } else if (Cv == null || Cv.cyQ() || cyM() || !aZ(v)) {
                if (Cv != null) {
                    Cv.cyT();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyv, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aY));
                }
                aX(v);
                this.jIO.Cz(Cu);
                this.jIQ.CI(Cu);
            } else {
                Cv.release(v);
                this.jIP.Cy(Cu);
                this.jIO.Cz(Cu);
                this.jIQ.CJ(Cu);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyv, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aY));
                }
            }
            cwB();
        }
    }

    protected boolean aZ(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cyK() {
        com.facebook.common.internal.g.checkState(!cyM() || this.jIP.jIR == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.jIL.clear();
            SparseIntArray sparseIntArray2 = this.jIK.jJt;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.jIL.put(keyAt, new d<>(Cu(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.jIN = false;
            } else {
                this.jIN = true;
            }
        }
    }

    synchronized void cyL() {
        if (cyM()) {
            trimToSize(this.jIK.jJs);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.jIO.jIR + this.jIP.jIR) - i, this.jIP.jIR);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyv, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.jIO.jIR + this.jIP.jIR), Integer.valueOf(min));
            }
            cwB();
            for (int i2 = 0; i2 < this.jIL.size() && min > 0; i2++) {
                d<V> valueAt = this.jIL.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aX(pop);
                    min -= valueAt.mItemSize;
                    this.jIP.Cz(valueAt.mItemSize);
                }
            }
            cwB();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyv, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.jIO.jIR + this.jIP.jIR));
            }
        }
    }

    synchronized d<V> Cv(int i) {
        d<V> dVar;
        dVar = this.jIL.get(i);
        if (dVar == null && this.jIN) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyv, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Cw(i);
            this.jIL.put(i, dVar);
        }
        return dVar;
    }

    d<V> Cw(int i) {
        return new d<>(Cu(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cyM() {
        boolean z;
        z = this.jIO.jIR + this.jIP.jIR > this.jIK.jJs;
        if (z) {
            this.jIQ.cza();
        }
        return z;
    }

    synchronized boolean Cx(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.jIK.jJr;
            if (i > i2 - this.jIO.jIR) {
                this.jIQ.czb();
            } else {
                int i3 = this.jIK.jJs;
                if (i > i3 - (this.jIO.jIR + this.jIP.jIR)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.jIO.jIR + this.jIP.jIR)) {
                    this.jIQ.czb();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cwB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jyv, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.jIO.mCount), Integer.valueOf(this.jIO.jIR), Integer.valueOf(this.jIP.mCount), Integer.valueOf(this.jIP.jIR));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int jIR;
        int mCount;

        a() {
        }

        public void Cy(int i) {
            this.mCount++;
            this.jIR += i;
        }

        public void Cz(int i) {
            if (this.jIR >= i && this.mCount > 0) {
                this.mCount--;
                this.jIR -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.jIR), Integer.valueOf(this.mCount));
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
