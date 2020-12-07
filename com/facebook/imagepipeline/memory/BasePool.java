package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.support.v7.widget.ActivityChooserView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes15.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b pnt;
    final com.facebook.common.memory.c plK;
    private final s pnA;
    final r pnu;
    final Set<V> pnw;
    private boolean pnx;
    @GuardedBy("this")
    final a pny;
    @GuardedBy("this")
    final a pnz;
    private final Class<?> paD = getClass();
    final SparseArray<d<V>> pnv = new SparseArray<>();

    /* loaded from: classes15.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V QN(int i);

    protected abstract int QO(int i);

    protected abstract int QP(int i);

    protected abstract void bw(V v);

    protected abstract int bx(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.plK = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pnu = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pnA = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pnu.poj) {
            evK();
        } else {
            a(new SparseIntArray(0));
        }
        this.pnw = com.facebook.common.internal.i.epQ();
        this.pnz = new a();
        this.pny = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.plK.a(this);
        this.pnA.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        evJ();
        int QO = QO(i);
        synchronized (this) {
            d<V> QR = QR(QO);
            if (QR != null && (m = QR.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pnw.add(m));
                int bx = bx(m);
                int QP = QP(bx);
                this.pny.QU(QP);
                this.pnz.QV(QP);
                this.pnA.Rb(QP);
                etp();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.paD, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bx));
                }
            } else {
                int QP2 = QP(QO);
                if (!QT(QP2)) {
                    throw new PoolSizeViolationException(this.pnu.pod, this.pny.pnB, this.pnz.pnB, QP2);
                }
                this.pny.QU(QP2);
                if (QR != null) {
                    QR.evS();
                }
                m = m(QP2, QO, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pnw.add(m));
                    evL();
                    this.pnA.Rc(QP2);
                    etp();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.paD, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(QO));
                    }
                }
            }
        }
        return m;
    }

    private V m(int i, int i2, boolean z) {
        try {
            V QN = QN(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.paD, "alloc success!!");
                return QN;
            }
            return QN;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.paD, "alloc fail!!");
            }
            if (!z || pnt == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.paD, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pnt == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pny.QV(i);
                    d<V> QR = QR(i2);
                    if (QR != null) {
                        QR.evT();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.paD, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pnt == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pnt.onFailed();
            return m(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bx = bx(v);
        int QP = QP(bx);
        synchronized (this) {
            d<V> QQ = QQ(bx);
            if (!this.pnw.remove(v)) {
                com.facebook.common.c.a.d(this.paD, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.pnA.Rd(QP);
            } else if (QQ == null || QQ.evQ() || evM() || !by(v)) {
                if (QQ != null) {
                    QQ.evT();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.paD, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.pny.QV(QP);
                this.pnA.Rd(QP);
            } else {
                QQ.release(v);
                this.pnz.QU(QP);
                this.pny.QV(QP);
                this.pnA.Re(QP);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.paD, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            etp();
        }
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void evJ() {
        com.facebook.common.internal.g.checkState(!evM() || this.pnz.pnB == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pnv.clear();
            SparseIntArray sparseIntArray2 = this.pnu.pof;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pnv.put(keyAt, new d<>(QP(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pnu.poj));
                }
                this.pnx = false;
            } else {
                this.pnx = true;
            }
        }
    }

    private synchronized void evK() {
        SparseIntArray sparseIntArray = this.pnu.pof;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pnx = false;
        } else {
            this.pnx = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pnv.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pnv.put(keyAt, new d<>(QP(keyAt), sparseIntArray.valueAt(i), 0, this.pnu.poj));
        }
    }

    synchronized void evL() {
        if (evM()) {
            trimToSize(this.pnu.poe);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pny.pnB + this.pnz.pnB) - i, this.pnz.pnB);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.paD, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pny.pnB + this.pnz.pnB), Integer.valueOf(min));
            }
            etp();
            for (int i2 = 0; i2 < this.pnv.size() && min > 0; i2++) {
                d<V> valueAt = this.pnv.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.pnz.QV(valueAt.mItemSize);
                }
            }
            etp();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.paD, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pny.pnB + this.pnz.pnB));
            }
        }
    }

    private synchronized d<V> QQ(int i) {
        return this.pnv.get(i);
    }

    synchronized d<V> QR(int i) {
        d<V> dVar;
        dVar = this.pnv.get(i);
        if (dVar == null && this.pnx) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.paD, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = QS(i);
            this.pnv.put(i, dVar);
        }
        return dVar;
    }

    d<V> QS(int i) {
        return new d<>(QP(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.pnu.poj);
    }

    synchronized boolean evM() {
        boolean z;
        z = this.pny.pnB + this.pnz.pnB > this.pnu.poe;
        if (z) {
            this.pnA.ewa();
        }
        return z;
    }

    synchronized boolean QT(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pnu.pod;
            if (i > i2 - this.pny.pnB) {
                this.pnA.ewb();
            } else {
                int i3 = this.pnu.poe;
                if (i > i3 - (this.pny.pnB + this.pnz.pnB)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pny.pnB + this.pnz.pnB)) {
                    this.pnA.ewb();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void etp() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.paD, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pny.mCount), Integer.valueOf(this.pny.pnB), Integer.valueOf(this.pnz.mCount), Integer.valueOf(this.pnz.pnB));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes15.dex */
    public static class a {
        int mCount;
        int pnB;

        a() {
        }

        public void QU(int i) {
            this.mCount++;
            this.pnB += i;
        }

        public void QV(int i) {
            if (this.pnB >= i && this.mCount > 0) {
                this.mCount--;
                this.pnB -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pnB), Integer.valueOf(this.mCount));
        }
    }

    /* loaded from: classes15.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes15.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes15.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes15.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
