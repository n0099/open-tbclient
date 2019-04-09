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
    final com.facebook.common.memory.c jGQ;
    final r jIq;
    final Set<V> jIs;
    private boolean jIt;
    @GuardedBy("this")
    final a jIu;
    @GuardedBy("this")
    final a jIv;
    private final s jIw;
    private final Class<?> jyb = getClass();
    final SparseArray<d<V>> jIr = new SparseArray<>();

    protected abstract V Cj(int i);

    protected abstract int Ck(int i);

    protected abstract int Cl(int i);

    protected abstract void aU(V v);

    protected abstract int aV(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jGQ = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.jIq = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.jIw = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.jIs = com.facebook.common.internal.h.ctE();
        this.jIv = new a();
        this.jIu = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jGQ.a(this);
        this.jIw.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cyQ();
        int Ck = Ck(i);
        synchronized (this) {
            d<V> Cm = Cm(Ck);
            if (Cm != null && (v = Cm.get()) != null) {
                com.facebook.common.internal.g.checkState(this.jIs.add(v));
                int aV = aV(v);
                int Cl = Cl(aV);
                this.jIu.Cp(Cl);
                this.jIv.Cq(Cl);
                this.jIw.Cx(Cl);
                cwH();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyb, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
                }
            } else {
                int Cl2 = Cl(Ck);
                if (!Co(Cl2)) {
                    throw new PoolSizeViolationException(this.jIq.jIX, this.jIu.jIx, this.jIv.jIx, Cl2);
                }
                this.jIu.Cp(Cl2);
                if (Cm != null) {
                    Cm.cyY();
                }
                v = null;
                try {
                    v = Cj(Ck);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.jIu.Cq(Cl2);
                        d<V> Cm2 = Cm(Ck);
                        if (Cm2 != null) {
                            Cm2.cyZ();
                        }
                        com.facebook.common.internal.k.r(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.jIs.add(v));
                    cyR();
                    this.jIw.Cy(Cl2);
                    cwH();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jyb, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Ck));
                    }
                }
            }
        }
        return v;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int aV = aV(v);
        int Cl = Cl(aV);
        synchronized (this) {
            d<V> Cm = Cm(aV);
            if (!this.jIs.remove(v)) {
                com.facebook.common.c.a.e(this.jyb, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
                aU(v);
                this.jIw.Cz(Cl);
            } else if (Cm == null || Cm.cyW() || cyS() || !aW(v)) {
                if (Cm != null) {
                    Cm.cyZ();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyb, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
                }
                aU(v);
                this.jIu.Cq(Cl);
                this.jIw.Cz(Cl);
            } else {
                Cm.release(v);
                this.jIv.Cp(Cl);
                this.jIu.Cq(Cl);
                this.jIw.CA(Cl);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jyb, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
                }
            }
            cwH();
        }
    }

    protected boolean aW(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void cyQ() {
        com.facebook.common.internal.g.checkState(!cyS() || this.jIv.jIx == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.jIr.clear();
            SparseIntArray sparseIntArray2 = this.jIq.jIZ;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.jIr.put(keyAt, new d<>(Cl(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.jIt = false;
            } else {
                this.jIt = true;
            }
        }
    }

    synchronized void cyR() {
        if (cyS()) {
            trimToSize(this.jIq.jIY);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.jIu.jIx + this.jIv.jIx) - i, this.jIv.jIx);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyb, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.jIu.jIx + this.jIv.jIx), Integer.valueOf(min));
            }
            cwH();
            for (int i2 = 0; i2 < this.jIr.size() && min > 0; i2++) {
                d<V> valueAt = this.jIr.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aU(pop);
                    min -= valueAt.mItemSize;
                    this.jIv.Cq(valueAt.mItemSize);
                }
            }
            cwH();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyb, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.jIu.jIx + this.jIv.jIx));
            }
        }
    }

    synchronized d<V> Cm(int i) {
        d<V> dVar;
        dVar = this.jIr.get(i);
        if (dVar == null && this.jIt) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jyb, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Cn(i);
            this.jIr.put(i, dVar);
        }
        return dVar;
    }

    d<V> Cn(int i) {
        return new d<>(Cl(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cyS() {
        boolean z;
        z = this.jIu.jIx + this.jIv.jIx > this.jIq.jIY;
        if (z) {
            this.jIw.czg();
        }
        return z;
    }

    synchronized boolean Co(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.jIq.jIX;
            if (i > i2 - this.jIu.jIx) {
                this.jIw.czh();
            } else {
                int i3 = this.jIq.jIY;
                if (i > i3 - (this.jIu.jIx + this.jIv.jIx)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.jIu.jIx + this.jIv.jIx)) {
                    this.jIw.czh();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void cwH() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.jyb, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.jIu.mCount), Integer.valueOf(this.jIu.jIx), Integer.valueOf(this.jIv.mCount), Integer.valueOf(this.jIv.jIx));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int jIx;
        int mCount;

        a() {
        }

        public void Cp(int i) {
            this.mCount++;
            this.jIx += i;
        }

        public void Cq(int i) {
            if (this.jIx >= i && this.mCount > 0) {
                this.mCount--;
                this.jIx -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.jIx), Integer.valueOf(this.mCount));
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
