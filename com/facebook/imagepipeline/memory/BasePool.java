package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes9.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b lPA;
    final com.facebook.common.memory.c lNP;
    final r lPB;
    final Set<V> lPD;
    private boolean lPE;
    @GuardedBy("this")
    final a lPF;
    @GuardedBy("this")
    final a lPG;
    private final s lPH;
    private final Class<?> lCO = getClass();
    final SparseArray<d<V>> lPC = new SparseArray<>();

    /* loaded from: classes9.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Ib(int i);

    protected abstract int Ic(int i);

    protected abstract int Id(int i);

    protected abstract void bm(V v);

    protected abstract int bn(V v);

    public static void a(b bVar) {
        lPA = bVar;
    }

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.lNP = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.lPB = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.lPH = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.lPB.lQp) {
            dom();
        } else {
            a(new SparseIntArray(0));
        }
        this.lPD = com.facebook.common.internal.i.diq();
        this.lPG = new a();
        this.lPF = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.lNP.a(this);
        this.lPH.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dol();
        int Ic = Ic(i);
        synchronized (this) {
            d<V> If = If(Ic);
            if (If != null && (o = If.get()) != null) {
                com.facebook.common.internal.g.checkState(this.lPD.add(o));
                int bn = bn(o);
                int Id = Id(bn);
                this.lPF.Ii(Id);
                this.lPG.Ij(Id);
                this.lPH.Ip(Id);
                dlO();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lCO, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bn));
                }
            } else {
                int Id2 = Id(Ic);
                if (!Ih(Id2)) {
                    throw new PoolSizeViolationException(this.lPB.lQk, this.lPF.lPI, this.lPG.lPI, Id2);
                }
                this.lPF.Ii(Id2);
                if (If != null) {
                    If.dov();
                }
                o = o(Id2, Ic, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.lPD.add(o));
                    don();
                    this.lPH.Iq(Id2);
                    dlO();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lCO, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(Ic));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V Ib = Ib(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lCO, "alloc success!!");
                return Ib;
            }
            return Ib;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lCO, "alloc fail!!");
            }
            if (!z || lPA == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lCO, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (lPA == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.lPF.Ij(i);
                    d<V> If = If(i2);
                    if (If != null) {
                        If.dow();
                    }
                    com.facebook.common.internal.l.t(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lCO, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (lPA == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            lPA.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bn = bn(v);
        int Id = Id(bn);
        synchronized (this) {
            d<V> Ie = Ie(bn);
            if (!this.lPD.remove(v)) {
                com.facebook.common.c.a.d(this.lCO, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bn));
                bm(v);
                this.lPH.Ir(Id);
            } else if (Ie == null || Ie.dot() || doo() || !bo(v)) {
                if (Ie != null) {
                    Ie.dow();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lCO, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bn));
                }
                bm(v);
                this.lPF.Ij(Id);
                this.lPH.Ir(Id);
            } else {
                Ie.release(v);
                this.lPG.Ii(Id);
                this.lPF.Ij(Id);
                this.lPH.Is(Id);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lCO, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bn));
                }
            }
            dlO();
        }
    }

    protected boolean bo(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dol() {
        com.facebook.common.internal.g.checkState(!doo() || this.lPG.lPI == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.lPC.clear();
            SparseIntArray sparseIntArray2 = this.lPB.lQm;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.lPC.put(keyAt, new d<>(Id(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.lPB.lQp));
                }
                this.lPE = false;
            } else {
                this.lPE = true;
            }
        }
    }

    private synchronized void dom() {
        SparseIntArray sparseIntArray = this.lPB.lQm;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.lPE = false;
        } else {
            this.lPE = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.lPC.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.lPC.put(keyAt, new d<>(Id(keyAt), sparseIntArray.valueAt(i), 0, this.lPB.lQp));
        }
    }

    synchronized void don() {
        if (doo()) {
            trimToSize(this.lPB.lQl);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.lPF.lPI + this.lPG.lPI) - i, this.lPG.lPI);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lCO, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.lPF.lPI + this.lPG.lPI), Integer.valueOf(min));
            }
            dlO();
            for (int i2 = 0; i2 < this.lPC.size() && min > 0; i2++) {
                d<V> valueAt = this.lPC.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bm(pop);
                    min -= valueAt.mItemSize;
                    this.lPG.Ij(valueAt.mItemSize);
                }
            }
            dlO();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lCO, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.lPF.lPI + this.lPG.lPI));
            }
        }
    }

    private synchronized d<V> Ie(int i) {
        return this.lPC.get(i);
    }

    synchronized d<V> If(int i) {
        d<V> dVar;
        dVar = this.lPC.get(i);
        if (dVar == null && this.lPE) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lCO, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Ig(i);
            this.lPC.put(i, dVar);
        }
        return dVar;
    }

    d<V> Ig(int i) {
        return new d<>(Id(i), Integer.MAX_VALUE, 0, this.lPB.lQp);
    }

    synchronized boolean doo() {
        boolean z;
        z = this.lPF.lPI + this.lPG.lPI > this.lPB.lQl;
        if (z) {
            this.lPH.doD();
        }
        return z;
    }

    synchronized boolean Ih(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.lPB.lQk;
            if (i > i2 - this.lPF.lPI) {
                this.lPH.doE();
            } else {
                int i3 = this.lPB.lQl;
                if (i > i3 - (this.lPF.lPI + this.lPG.lPI)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.lPF.lPI + this.lPG.lPI)) {
                    this.lPH.doE();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dlO() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lCO, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.lPF.mCount), Integer.valueOf(this.lPF.lPI), Integer.valueOf(this.lPG.mCount), Integer.valueOf(this.lPG.lPI));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes9.dex */
    public static class a {
        int lPI;
        int mCount;

        a() {
        }

        public void Ii(int i) {
            this.mCount++;
            this.lPI += i;
        }

        public void Ij(int i) {
            if (this.lPI >= i && this.mCount > 0) {
                this.mCount--;
                this.lPI -= i;
                return;
            }
            com.facebook.common.c.a.j("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.lPI), Integer.valueOf(this.mCount));
        }
    }

    /* loaded from: classes9.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes9.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes9.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes9.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
