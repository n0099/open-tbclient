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
    private static b pEF;
    final com.facebook.common.memory.c pCW;
    final r pEG;
    final Set<V> pEI;
    private boolean pEJ;
    @GuardedBy("this")
    final a pEK;
    @GuardedBy("this")
    final a pEL;
    private final s pEM;
    private final Class<?> prR = getClass();
    final SparseArray<d<V>> pEH = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Rb(int i);

    protected abstract int Rc(int i);

    protected abstract int Rd(int i);

    protected abstract void bw(V v);

    protected abstract int bx(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.pCW = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pEG = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pEM = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pEG.pFu) {
            ezW();
        } else {
            a(new SparseIntArray(0));
        }
        this.pEI = com.facebook.common.internal.i.eua();
        this.pEL = new a();
        this.pEK = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.pCW.a(this);
        this.pEM.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V n;
        ezV();
        int Rc = Rc(i);
        synchronized (this) {
            d<V> Rf = Rf(Rc);
            if (Rf != null && (n = Rf.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pEI.add(n));
                int bx = bx(n);
                int Rd = Rd(bx);
                this.pEK.Ri(Rd);
                this.pEL.Rj(Rd);
                this.pEM.Rp(Rd);
                exB();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.prR, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(bx));
                }
            } else {
                int Rd2 = Rd(Rc);
                if (!Rh(Rd2)) {
                    throw new PoolSizeViolationException(this.pEG.pFp, this.pEK.pEN, this.pEL.pEN, Rd2);
                }
                this.pEK.Ri(Rd2);
                if (Rf != null) {
                    Rf.eAe();
                }
                n = n(Rd2, Rc, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pEI.add(n));
                    ezX();
                    this.pEM.Rq(Rd2);
                    exB();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.prR, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(Rc));
                    }
                }
            }
        }
        return n;
    }

    private V n(int i, int i2, boolean z) {
        try {
            V Rb = Rb(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.prR, "alloc success!!");
                return Rb;
            }
            return Rb;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.prR, "alloc fail!!");
            }
            if (!z || pEF == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.g(this.prR, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pEF == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pEK.Rj(i);
                    d<V> Rf = Rf(i2);
                    if (Rf != null) {
                        Rf.eAf();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.prR, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pEF == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pEF.onFailed();
            return n(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bx = bx(v);
        int Rd = Rd(bx);
        synchronized (this) {
            d<V> Re = Re(bx);
            if (!this.pEI.remove(v)) {
                com.facebook.common.c.a.d(this.prR, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.pEM.Rr(Rd);
            } else if (Re == null || Re.eAc() || ezY() || !by(v)) {
                if (Re != null) {
                    Re.eAf();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.prR, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.pEK.Rj(Rd);
                this.pEM.Rr(Rd);
            } else {
                Re.release(v);
                this.pEL.Ri(Rd);
                this.pEK.Rj(Rd);
                this.pEM.Rs(Rd);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.prR, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            exB();
        }
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void ezV() {
        com.facebook.common.internal.g.checkState(!ezY() || this.pEL.pEN == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pEH.clear();
            SparseIntArray sparseIntArray2 = this.pEG.pFr;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pEH.put(keyAt, new d<>(Rd(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pEG.pFu));
                }
                this.pEJ = false;
            } else {
                this.pEJ = true;
            }
        }
    }

    private synchronized void ezW() {
        SparseIntArray sparseIntArray = this.pEG.pFr;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pEJ = false;
        } else {
            this.pEJ = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pEH.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pEH.put(keyAt, new d<>(Rd(keyAt), sparseIntArray.valueAt(i), 0, this.pEG.pFu));
        }
    }

    synchronized void ezX() {
        if (ezY()) {
            trimToSize(this.pEG.pFq);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pEK.pEN + this.pEL.pEN) - i, this.pEL.pEN);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.prR, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pEK.pEN + this.pEL.pEN), Integer.valueOf(min));
            }
            exB();
            for (int i2 = 0; i2 < this.pEH.size() && min > 0; i2++) {
                d<V> valueAt = this.pEH.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.pEL.Rj(valueAt.mItemSize);
                }
            }
            exB();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.prR, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pEK.pEN + this.pEL.pEN));
            }
        }
    }

    private synchronized d<V> Re(int i) {
        return this.pEH.get(i);
    }

    synchronized d<V> Rf(int i) {
        d<V> dVar;
        dVar = this.pEH.get(i);
        if (dVar == null && this.pEJ) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.c(this.prR, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Rg(i);
            this.pEH.put(i, dVar);
        }
        return dVar;
    }

    d<V> Rg(int i) {
        return new d<>(Rd(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.pEG.pFu);
    }

    synchronized boolean ezY() {
        boolean z;
        z = this.pEK.pEN + this.pEL.pEN > this.pEG.pFq;
        if (z) {
            this.pEM.eAm();
        }
        return z;
    }

    synchronized boolean Rh(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pEG.pFp;
            if (i > i2 - this.pEK.pEN) {
                this.pEM.eAn();
            } else {
                int i3 = this.pEG.pFq;
                if (i > i3 - (this.pEK.pEN + this.pEL.pEN)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pEK.pEN + this.pEL.pEN)) {
                    this.pEM.eAn();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void exB() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.prR, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pEK.mCount), Integer.valueOf(this.pEK.pEN), Integer.valueOf(this.pEL.mCount), Integer.valueOf(this.pEL.pEN));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes3.dex */
    public static class a {
        int mCount;
        int pEN;

        a() {
        }

        public void Ri(int i) {
            this.mCount++;
            this.pEN += i;
        }

        public void Rj(int i) {
            if (this.pEN >= i && this.mCount > 0) {
                this.mCount--;
                this.pEN -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pEN), Integer.valueOf(this.mCount));
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
