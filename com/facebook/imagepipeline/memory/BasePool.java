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
    final com.facebook.common.memory.c jGP;
    final r jIp;
    final Set<V> jIr;
    private boolean jIs;
    @GuardedBy("this")
    final a jIt;
    @GuardedBy("this")
    final a jIu;
    private final s jIv;
    private final Class<?> jya = getClass();
    final SparseArray<d<V>> jIq = new SparseArray<>();

    protected abstract V Cj(int i);

    protected abstract int Ck(int i);

    protected abstract int Cl(int i);

    protected abstract void aU(V v);

    protected abstract int aV(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.jGP = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.jIp = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.jIv = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        a(new SparseIntArray(0));
        this.jIr = com.facebook.common.internal.h.ctE();
        this.jIu = new a();
        this.jIt = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.jGP.a(this);
        this.jIv.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V v;
        cyQ();
        int Ck = Ck(i);
        synchronized (this) {
            d<V> Cm = Cm(Ck);
            if (Cm != null && (v = Cm.get()) != null) {
                com.facebook.common.internal.g.checkState(this.jIr.add(v));
                int aV = aV(v);
                int Cl = Cl(aV);
                this.jIt.Cp(Cl);
                this.jIu.Cq(Cl);
                this.jIv.Cx(Cl);
                cwH();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jya, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
                }
            } else {
                int Cl2 = Cl(Ck);
                if (!Co(Cl2)) {
                    throw new PoolSizeViolationException(this.jIp.jIW, this.jIt.jIw, this.jIu.jIw, Cl2);
                }
                this.jIt.Cp(Cl2);
                if (Cm != null) {
                    Cm.cyY();
                }
                v = null;
                try {
                    v = Cj(Ck);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.jIt.Cq(Cl2);
                        d<V> Cm2 = Cm(Ck);
                        if (Cm2 != null) {
                            Cm2.cyZ();
                        }
                        com.facebook.common.internal.k.r(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.jIr.add(v));
                    cyR();
                    this.jIv.Cy(Cl2);
                    cwH();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.jya, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(Ck));
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
            if (!this.jIr.remove(v)) {
                com.facebook.common.c.a.e(this.jya, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
                aU(v);
                this.jIv.Cz(Cl);
            } else if (Cm == null || Cm.cyW() || cyS() || !aW(v)) {
                if (Cm != null) {
                    Cm.cyZ();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jya, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
                }
                aU(v);
                this.jIt.Cq(Cl);
                this.jIv.Cz(Cl);
            } else {
                Cm.release(v);
                this.jIu.Cp(Cl);
                this.jIt.Cq(Cl);
                this.jIv.CA(Cl);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.jya, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(aV));
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
        com.facebook.common.internal.g.checkState(!cyS() || this.jIu.jIw == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.jIq.clear();
            SparseIntArray sparseIntArray2 = this.jIp.jIY;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.jIq.put(keyAt, new d<>(Cl(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.jIs = false;
            } else {
                this.jIs = true;
            }
        }
    }

    synchronized void cyR() {
        if (cyS()) {
            trimToSize(this.jIp.jIX);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.jIt.jIw + this.jIu.jIw) - i, this.jIu.jIw);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jya, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.jIt.jIw + this.jIu.jIw), Integer.valueOf(min));
            }
            cwH();
            for (int i2 = 0; i2 < this.jIq.size() && min > 0; i2++) {
                d<V> valueAt = this.jIq.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    aU(pop);
                    min -= valueAt.mItemSize;
                    this.jIu.Cq(valueAt.mItemSize);
                }
            }
            cwH();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jya, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.jIt.jIw + this.jIu.jIw));
            }
        }
    }

    synchronized d<V> Cm(int i) {
        d<V> dVar;
        dVar = this.jIq.get(i);
        if (dVar == null && this.jIs) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.jya, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Cn(i);
            this.jIq.put(i, dVar);
        }
        return dVar;
    }

    d<V> Cn(int i) {
        return new d<>(Cl(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0);
    }

    synchronized boolean cyS() {
        boolean z;
        z = this.jIt.jIw + this.jIu.jIw > this.jIp.jIX;
        if (z) {
            this.jIv.czg();
        }
        return z;
    }

    synchronized boolean Co(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.jIp.jIW;
            if (i > i2 - this.jIt.jIw) {
                this.jIv.czh();
            } else {
                int i3 = this.jIp.jIX;
                if (i > i3 - (this.jIt.jIw + this.jIu.jIw)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.jIt.jIw + this.jIu.jIw)) {
                    this.jIv.czh();
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
            com.facebook.common.c.a.a(this.jya, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.jIt.mCount), Integer.valueOf(this.jIt.jIw), Integer.valueOf(this.jIu.mCount), Integer.valueOf(this.jIu.jIw));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes2.dex */
    public static class a {
        int jIw;
        int mCount;

        a() {
        }

        public void Cp(int i) {
            this.mCount++;
            this.jIw += i;
        }

        public void Cq(int i) {
            if (this.jIw >= i && this.mCount > 0) {
                this.mCount--;
                this.jIw -= i;
                return;
            }
            com.facebook.common.c.a.f("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.jIw), Integer.valueOf(this.mCount));
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
