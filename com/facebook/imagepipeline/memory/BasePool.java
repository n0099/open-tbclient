package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes5.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b pCY;
    final com.facebook.common.memory.c pBp;
    final r pCZ;
    final Set<V> pDb;
    private boolean pDc;
    @GuardedBy("this")
    final a pDd;
    @GuardedBy("this")
    final a pDe;
    private final s pDf;
    private final Class<?> prQ = getClass();
    final SparseArray<d<V>> pDa = new SparseArray<>();

    /* loaded from: classes5.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V QK(int i);

    protected abstract int QL(int i);

    protected abstract int QM(int i);

    protected abstract void bv(V v);

    protected abstract int bw(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.pBp = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.pCZ = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.pDf = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.pCZ.pDN) {
            ezs();
        } else {
            a(new SparseIntArray(0));
        }
        this.pDb = com.facebook.common.internal.i.etU();
        this.pDe = new a();
        this.pDd = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.pBp.a(this);
        this.pDf.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V n;
        ezr();
        int QL = QL(i);
        synchronized (this) {
            d<V> QO = QO(QL);
            if (QO != null && (n = QO.get()) != null) {
                com.facebook.common.internal.g.checkState(this.pDb.add(n));
                int bw = bw(n);
                int QM = QM(bw);
                this.pDd.QR(QM);
                this.pDe.QS(QM);
                this.pDf.QZ(QM);
                ewZ();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.prQ, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(bw));
                }
            } else {
                int QM2 = QM(QL);
                if (!QQ(QM2)) {
                    throw new PoolSizeViolationException(this.pCZ.pDI, this.pDd.pDg, this.pDe.pDg, QM2);
                }
                this.pDd.QR(QM2);
                if (QO != null) {
                    QO.ezA();
                }
                n = n(QM2, QL, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.pDb.add(n));
                    ezt();
                    this.pDf.Ra(QM2);
                    ewZ();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.prQ, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(n)), Integer.valueOf(QL));
                    }
                }
            }
        }
        return n;
    }

    private V n(int i, int i2, boolean z) {
        try {
            V QK = QK(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.prQ, "alloc success!!");
                return QK;
            }
            return QK;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.prQ, "alloc fail!!");
            }
            if (!z || pCY == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.g(this.prQ, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (pCY == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.pDd.QS(i);
                    d<V> QO = QO(i2);
                    if (QO != null) {
                        QO.ezB();
                    }
                    com.facebook.common.internal.l.s(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.g(this.prQ, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (pCY == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            pCY.onFailed();
            return n(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bw = bw(v);
        int QM = QM(bw);
        synchronized (this) {
            d<V> QN = QN(bw);
            if (!this.pDb.remove(v)) {
                com.facebook.common.c.a.d(this.prQ, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bw));
                bv(v);
                this.pDf.Rb(QM);
            } else if (QN == null || QN.ezy() || ezu() || !bx(v)) {
                if (QN != null) {
                    QN.ezB();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.prQ, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bw));
                }
                bv(v);
                this.pDd.QS(QM);
                this.pDf.Rb(QM);
            } else {
                QN.release(v);
                this.pDe.QR(QM);
                this.pDd.QS(QM);
                this.pDf.Rc(QM);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.prQ, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bw));
                }
            }
            ewZ();
        }
    }

    protected boolean bx(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void ezr() {
        com.facebook.common.internal.g.checkState(!ezu() || this.pDe.pDg == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.pDa.clear();
            SparseIntArray sparseIntArray2 = this.pCZ.pDK;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.pDa.put(keyAt, new d<>(QM(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.pCZ.pDN));
                }
                this.pDc = false;
            } else {
                this.pDc = true;
            }
        }
    }

    private synchronized void ezs() {
        SparseIntArray sparseIntArray = this.pCZ.pDK;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.pDc = false;
        } else {
            this.pDc = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.pDa.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.pDa.put(keyAt, new d<>(QM(keyAt), sparseIntArray.valueAt(i), 0, this.pCZ.pDN));
        }
    }

    synchronized void ezt() {
        if (ezu()) {
            trimToSize(this.pCZ.pDJ);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.pDd.pDg + this.pDe.pDg) - i, this.pDe.pDg);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.prQ, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.pDd.pDg + this.pDe.pDg), Integer.valueOf(min));
            }
            ewZ();
            for (int i2 = 0; i2 < this.pDa.size() && min > 0; i2++) {
                d<V> valueAt = this.pDa.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bv(pop);
                    min -= valueAt.mItemSize;
                    this.pDe.QS(valueAt.mItemSize);
                }
            }
            ewZ();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.prQ, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.pDd.pDg + this.pDe.pDg));
            }
        }
    }

    private synchronized d<V> QN(int i) {
        return this.pDa.get(i);
    }

    synchronized d<V> QO(int i) {
        d<V> dVar;
        dVar = this.pDa.get(i);
        if (dVar == null && this.pDc) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.c(this.prQ, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = QP(i);
            this.pDa.put(i, dVar);
        }
        return dVar;
    }

    d<V> QP(int i) {
        return new d<>(QM(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.pCZ.pDN);
    }

    synchronized boolean ezu() {
        boolean z;
        z = this.pDd.pDg + this.pDe.pDg > this.pCZ.pDJ;
        if (z) {
            this.pDf.ezI();
        }
        return z;
    }

    synchronized boolean QQ(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.pCZ.pDI;
            if (i > i2 - this.pDd.pDg) {
                this.pDf.ezJ();
            } else {
                int i3 = this.pCZ.pDJ;
                if (i > i3 - (this.pDd.pDg + this.pDe.pDg)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.pDd.pDg + this.pDe.pDg)) {
                    this.pDf.ezJ();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void ewZ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.prQ, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.pDd.mCount), Integer.valueOf(this.pDd.pDg), Integer.valueOf(this.pDe.mCount), Integer.valueOf(this.pDe.pDg));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes5.dex */
    public static class a {
        int mCount;
        int pDg;

        a() {
        }

        public void QR(int i) {
            this.mCount++;
            this.pDg += i;
        }

        public void QS(int i) {
            if (this.pDg >= i && this.mCount > 0) {
                this.mCount--;
                this.pDg -= i;
                return;
            }
            com.facebook.common.c.a.h("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.pDg), Integer.valueOf(this.mCount));
        }
    }

    /* loaded from: classes5.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes5.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
