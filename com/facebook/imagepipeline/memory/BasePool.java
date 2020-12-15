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
    private static b pnv;
    final com.facebook.common.memory.c plM;
    @GuardedBy("this")
    final a pnA;
    @GuardedBy("this")
    final a pnB;
    private final s pnC;
    final r pnw;
    final Set<V> pny;
    private boolean pnz;
    private final Class<?> paF = getClass();
    final SparseArray<d<V>> pnx = new SparseArray<>();

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
        this.plM = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pnw = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pnC = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pnw.pol) {
            evL();
        } else {
            a(new SparseIntArray(0));
        }
        this.pny = com.facebook.common.internal.i.epR();
        this.pnB = new a();
        this.pnA = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.plM.a(this);
        this.pnC.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        evK();
        int QO = QO(i);
        synchronized (this) {
            d<V> QR = QR(QO);
            if (QR != null && (m = QR.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pny.add(m));
                int bx = bx(m);
                int QP = QP(bx);
                this.pnA.QU(QP);
                this.pnB.QV(QP);
                this.pnC.Rb(QP);
                etq();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.paF, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bx));
                }
            } else {
                int QP2 = QP(QO);
                if (!QT(QP2)) {
                    throw new PoolSizeViolationException(this.pnw.pof, this.pnA.pnD, this.pnB.pnD, QP2);
                }
                this.pnA.QU(QP2);
                if (QR != null) {
                    QR.evT();
                }
                m = m(QP2, QO, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pny.add(m));
                    evM();
                    this.pnC.Rc(QP2);
                    etq();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.paF, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(QO));
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
                com.facebook.common.c.a.f(this.paF, "alloc success!!");
                return QN;
            }
            return QN;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.paF, "alloc fail!!");
            }
            if (!z || pnv == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.paF, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pnv == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pnA.QV(i);
                    d<V> QR = QR(i2);
                    if (QR != null) {
                        QR.evU();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.paF, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pnv == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pnv.onFailed();
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
            if (!this.pny.remove(v)) {
                com.facebook.common.c.a.d(this.paF, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.pnC.Rd(QP);
            } else if (QQ == null || QQ.evR() || evN() || !by(v)) {
                if (QQ != null) {
                    QQ.evU();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.paF, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.pnA.QV(QP);
                this.pnC.Rd(QP);
            } else {
                QQ.release(v);
                this.pnB.QU(QP);
                this.pnA.QV(QP);
                this.pnC.Re(QP);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.paF, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            etq();
        }
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void evK() {
        com.facebook.common.internal.g.checkState(!evN() || this.pnB.pnD == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pnx.clear();
            SparseIntArray sparseIntArray2 = this.pnw.poh;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pnx.put(keyAt, new d<>(QP(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pnw.pol));
                }
                this.pnz = false;
            } else {
                this.pnz = true;
            }
        }
    }

    private synchronized void evL() {
        SparseIntArray sparseIntArray = this.pnw.poh;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pnz = false;
        } else {
            this.pnz = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pnx.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pnx.put(keyAt, new d<>(QP(keyAt), sparseIntArray.valueAt(i), 0, this.pnw.pol));
        }
    }

    synchronized void evM() {
        if (evN()) {
            trimToSize(this.pnw.pog);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pnA.pnD + this.pnB.pnD) - i, this.pnB.pnD);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.paF, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pnA.pnD + this.pnB.pnD), Integer.valueOf(min));
            }
            etq();
            for (int i2 = 0; i2 < this.pnx.size() && min > 0; i2++) {
                d<V> valueAt = this.pnx.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.pnB.QV(valueAt.mItemSize);
                }
            }
            etq();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.paF, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pnA.pnD + this.pnB.pnD));
            }
        }
    }

    private synchronized d<V> QQ(int i) {
        return this.pnx.get(i);
    }

    synchronized d<V> QR(int i) {
        d<V> dVar;
        dVar = this.pnx.get(i);
        if (dVar == null && this.pnz) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.paF, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = QS(i);
            this.pnx.put(i, dVar);
        }
        return dVar;
    }

    d<V> QS(int i) {
        return new d<>(QP(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.pnw.pol);
    }

    synchronized boolean evN() {
        boolean z;
        z = this.pnA.pnD + this.pnB.pnD > this.pnw.pog;
        if (z) {
            this.pnC.ewb();
        }
        return z;
    }

    synchronized boolean QT(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pnw.pof;
            if (i > i2 - this.pnA.pnD) {
                this.pnC.ewc();
            } else {
                int i3 = this.pnw.pog;
                if (i > i3 - (this.pnA.pnD + this.pnB.pnD)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pnA.pnD + this.pnB.pnD)) {
                    this.pnC.ewc();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void etq() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.paF, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pnA.mCount), Integer.valueOf(this.pnA.pnD), Integer.valueOf(this.pnB.mCount), Integer.valueOf(this.pnB.pnD));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes15.dex */
    public static class a {
        int mCount;
        int pnD;

        a() {
        }

        public void QU(int i) {
            this.mCount++;
            this.pnD += i;
        }

        public void QV(int i) {
            if (this.pnD >= i && this.mCount > 0) {
                this.mCount--;
                this.pnD -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pnD), Integer.valueOf(this.mCount));
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
