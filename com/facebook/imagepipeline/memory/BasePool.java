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
    private static b pAf;
    final r pAg;
    final Set<V> pAi;
    private boolean pAj;
    @GuardedBy("this")
    final a pAk;
    @GuardedBy("this")
    final a pAl;
    private final s pAm;
    final com.facebook.common.memory.c pyw;
    private final Class<?> pnn = getClass();
    final SparseArray<d<V>> pAh = new SparseArray<>();

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
        this.pyw = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pAg = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pAm = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pAg.pAU) {
            ewe();
        } else {
            a(new SparseIntArray(0));
        }
        this.pAi = com.facebook.common.internal.i.eqg();
        this.pAl = new a();
        this.pAk = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.pyw.a(this);
        this.pAm.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V n;
        ewd();
        int Pv = Pv(i);
        synchronized (this) {
            d<V> Py = Py(Pv);
            if (Py != null && (n = Py.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pAi.add(n));
                int bx = bx(n);
                int Pw = Pw(bx);
                this.pAk.PB(Pw);
                this.pAl.PC(Pw);
                this.pAm.PI(Pw);
                etJ();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pnn, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(bx));
                }
            } else {
                int Pw2 = Pw(Pv);
                if (!PA(Pw2)) {
                    throw new PoolSizeViolationException(this.pAg.pAP, this.pAk.pAn, this.pAl.pAn, Pw2);
                }
                this.pAk.PB(Pw2);
                if (Py != null) {
                    Py.ewm();
                }
                n = n(Pw2, Pv, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pAi.add(n));
                    ewf();
                    this.pAm.PJ(Pw2);
                    etJ();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.pnn, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(Pv));
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
                com.facebook.common.c.a.g(this.pnn, "alloc success!!");
                return Pu;
            }
            return Pu;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pnn, "alloc fail!!");
            }
            if (!z || pAf == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.g(this.pnn, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pAf == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pAk.PC(i);
                    d<V> Py = Py(i2);
                    if (Py != null) {
                        Py.ewn();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.pnn, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pAf == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pAf.onFailed();
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
            if (!this.pAi.remove(v)) {
                com.facebook.common.c.a.d(this.pnn, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.pAm.PK(Pw);
            } else if (Px == null || Px.ewk() || ewg() || !by(v)) {
                if (Px != null) {
                    Px.ewn();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pnn, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.pAk.PC(Pw);
                this.pAm.PK(Pw);
            } else {
                Px.release(v);
                this.pAl.PB(Pw);
                this.pAk.PC(Pw);
                this.pAm.PL(Pw);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.pnn, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
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
        com.facebook.common.internal.g.checkState(!ewg() || this.pAl.pAn == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pAh.clear();
            SparseIntArray sparseIntArray2 = this.pAg.pAR;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pAh.put(keyAt, new d<>(Pw(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pAg.pAU));
                }
                this.pAj = false;
            } else {
                this.pAj = true;
            }
        }
    }

    private synchronized void ewe() {
        SparseIntArray sparseIntArray = this.pAg.pAR;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pAj = false;
        } else {
            this.pAj = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pAh.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pAh.put(keyAt, new d<>(Pw(keyAt), sparseIntArray.valueAt(i), 0, this.pAg.pAU));
        }
    }

    synchronized void ewf() {
        if (ewg()) {
            trimToSize(this.pAg.pAQ);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pAk.pAn + this.pAl.pAn) - i, this.pAl.pAn);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pnn, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pAk.pAn + this.pAl.pAn), Integer.valueOf(min));
            }
            etJ();
            for (int i2 = 0; i2 < this.pAh.size() && min > 0; i2++) {
                d<V> valueAt = this.pAh.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.pAl.PC(valueAt.mItemSize);
                }
            }
            etJ();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.pnn, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pAk.pAn + this.pAl.pAn));
            }
        }
    }

    private synchronized d<V> Px(int i) {
        return this.pAh.get(i);
    }

    synchronized d<V> Py(int i) {
        d<V> dVar;
        dVar = this.pAh.get(i);
        if (dVar == null && this.pAj) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.c(this.pnn, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Pz(i);
            this.pAh.put(i, dVar);
        }
        return dVar;
    }

    d<V> Pz(int i) {
        return new d<>(Pw(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.pAg.pAU);
    }

    synchronized boolean ewg() {
        boolean z;
        z = this.pAk.pAn + this.pAl.pAn > this.pAg.pAQ;
        if (z) {
            this.pAm.ewu();
        }
        return z;
    }

    synchronized boolean PA(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pAg.pAP;
            if (i > i2 - this.pAk.pAn) {
                this.pAm.ewv();
            } else {
                int i3 = this.pAg.pAQ;
                if (i > i3 - (this.pAk.pAn + this.pAl.pAn)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pAk.pAn + this.pAl.pAn)) {
                    this.pAm.ewv();
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
            com.facebook.common.c.a.a(this.pnn, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pAk.mCount), Integer.valueOf(this.pAk.pAn), Integer.valueOf(this.pAl.mCount), Integer.valueOf(this.pAl.pAn));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes3.dex */
    public static class a {
        int mCount;
        int pAn;

        a() {
        }

        public void PB(int i) {
            this.mCount++;
            this.pAn += i;
        }

        public void PC(int i) {
            if (this.pAn >= i && this.mCount > 0) {
                this.mCount--;
                this.pAn -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pAn), Integer.valueOf(this.mCount));
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
