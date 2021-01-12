package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes3.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b pAe;
    final r pAf;
    final Set<V> pAh;
    private boolean pAi;
    @GuardedBy("this")
    final a pAj;
    @GuardedBy("this")
    final a pAk;
    private final s pAl;
    final com.facebook.common.memory.c pyv;
    private final Class<?> pnm = getClass();
    final SparseArray<d<V>> pAg = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Pu(int i);

    protected abstract int Pv(int i);

    protected abstract int Pw(int i);

    protected abstract void bw(V v);

    protected abstract int bx(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.pyv = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pAf = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pAl = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pAf.pAT) {
            ewe();
        } else {
            a(new SparseIntArray(0));
        }
        this.pAh = com.facebook.common.internal.i.eqg();
        this.pAk = new a();
        this.pAj = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.pyv.a(this);
        this.pAl.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V n;
        ewd();
        int Pv = Pv(i);
        synchronized (this) {
            d<V> Py = Py(Pv);
            if (Py != null && (n = Py.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pAh.add(n));
                int bx = bx(n);
                int Pw = Pw(bx);
                this.pAj.PB(Pw);
                this.pAk.PC(Pw);
                this.pAl.PI(Pw);
                etJ();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pnm, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(bx));
                }
            } else {
                int Pw2 = Pw(Pv);
                if (!PA(Pw2)) {
                    throw new PoolSizeViolationException(this.pAf.pAO, this.pAj.pAm, this.pAk.pAm, Pw2);
                }
                this.pAj.PB(Pw2);
                if (Py != null) {
                    Py.ewm();
                }
                n = n(Pw2, Pv, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pAh.add(n));
                    ewf();
                    this.pAl.PJ(Pw2);
                    etJ();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.pnm, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(Pv));
                    }
                }
            }
        }
        return n;
    }

    private V n(int i, int i2, boolean z) {
        try {
            V Pu = Pu(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pnm, "alloc success!!");
                return Pu;
            }
            return Pu;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pnm, "alloc fail!!");
            }
            if (!z || pAe == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.g(this.pnm, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pAe == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pAj.PC(i);
                    d<V> Py = Py(i2);
                    if (Py != null) {
                        Py.ewn();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pnm, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pAe == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pAe.onFailed();
            return n(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bx = bx(v);
        int Pw = Pw(bx);
        synchronized (this) {
            d<V> Px = Px(bx);
            if (!this.pAh.remove(v)) {
                com.facebook.common.c.a.d(this.pnm, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.pAl.PK(Pw);
            } else if (Px == null || Px.ewk() || ewg() || !by(v)) {
                if (Px != null) {
                    Px.ewn();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pnm, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.pAj.PC(Pw);
                this.pAl.PK(Pw);
            } else {
                Px.release(v);
                this.pAk.PB(Pw);
                this.pAj.PC(Pw);
                this.pAl.PL(Pw);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pnm, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            etJ();
        }
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void ewd() {
        com.facebook.common.internal.g.checkState(!ewg() || this.pAk.pAm == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pAg.clear();
            SparseIntArray sparseIntArray2 = this.pAf.pAQ;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pAg.put(keyAt, new d<>(Pw(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pAf.pAT));
                }
                this.pAi = false;
            } else {
                this.pAi = true;
            }
        }
    }

    private synchronized void ewe() {
        SparseIntArray sparseIntArray = this.pAf.pAQ;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pAi = false;
        } else {
            this.pAi = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pAg.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pAg.put(keyAt, new d<>(Pw(keyAt), sparseIntArray.valueAt(i), 0, this.pAf.pAT));
        }
    }

    synchronized void ewf() {
        if (ewg()) {
            trimToSize(this.pAf.pAP);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pAj.pAm + this.pAk.pAm) - i, this.pAk.pAm);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pnm, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pAj.pAm + this.pAk.pAm), Integer.valueOf(min));
            }
            etJ();
            for (int i2 = 0; i2 < this.pAg.size() && min > 0; i2++) {
                d<V> valueAt = this.pAg.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.pAk.PC(valueAt.mItemSize);
                }
            }
            etJ();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pnm, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pAj.pAm + this.pAk.pAm));
            }
        }
    }

    private synchronized d<V> Px(int i) {
        return this.pAg.get(i);
    }

    synchronized d<V> Py(int i) {
        d<V> dVar;
        dVar = this.pAg.get(i);
        if (dVar == null && this.pAi) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.c(this.pnm, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Pz(i);
            this.pAg.put(i, dVar);
        }
        return dVar;
    }

    d<V> Pz(int i) {
        return new d<>(Pw(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.pAf.pAT);
    }

    synchronized boolean ewg() {
        boolean z;
        z = this.pAj.pAm + this.pAk.pAm > this.pAf.pAP;
        if (z) {
            this.pAl.ewu();
        }
        return z;
    }

    synchronized boolean PA(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pAf.pAO;
            if (i > i2 - this.pAj.pAm) {
                this.pAl.ewv();
            } else {
                int i3 = this.pAf.pAP;
                if (i > i3 - (this.pAj.pAm + this.pAk.pAm)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pAj.pAm + this.pAk.pAm)) {
                    this.pAl.ewv();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void etJ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.pnm, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pAj.mCount), Integer.valueOf(this.pAj.pAm), Integer.valueOf(this.pAk.mCount), Integer.valueOf(this.pAk.pAm));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes3.dex */
    public static class a {
        int mCount;
        int pAm;

        a() {
        }

        public void PB(int i) {
            this.mCount++;
            this.pAm += i;
        }

        public void PC(int i) {
            if (this.pAm >= i && this.mCount > 0) {
                this.mCount--;
                this.pAm -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pAm), Integer.valueOf(this.mCount));
        }
    }

    /* loaded from: classes3.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes3.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
