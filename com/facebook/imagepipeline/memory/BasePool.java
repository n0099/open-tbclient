package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.support.v7.widget.ActivityChooserView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes18.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b oXb;
    final com.facebook.common.memory.c oVs;
    final r oXc;
    final Set<V> oXe;
    private boolean oXf;
    @GuardedBy("this")
    final a oXg;
    @GuardedBy("this")
    final a oXh;
    private final s oXi;
    private final Class<?> oJR = getClass();
    final SparseArray<d<V>> oXd = new SparseArray<>();

    /* loaded from: classes18.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Po(int i);

    protected abstract int Pp(int i);

    protected abstract int Pq(int i);

    protected abstract void bw(V v);

    protected abstract int bx(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.oVs = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.oXc = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.oXi = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.oXc.oXQ) {
            eqi();
        } else {
            a(new SparseIntArray(0));
        }
        this.oXe = com.facebook.common.internal.i.ekd();
        this.oXh = new a();
        this.oXg = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.oVs.a(this);
        this.oXi.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        eqh();
        int Pp = Pp(i);
        synchronized (this) {
            d<V> Ps = Ps(Pp);
            if (Ps != null && (m = Ps.get()) != null) {
                com.facebook.common.internal.g.checkState(this.oXe.add(m));
                int bx = bx(m);
                int Pq = Pq(bx);
                this.oXg.Pv(Pq);
                this.oXh.Pw(Pq);
                this.oXi.PC(Pq);
                enJ();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oJR, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(bx));
                }
            } else {
                int Pq2 = Pq(Pp);
                if (!Pu(Pq2)) {
                    throw new PoolSizeViolationException(this.oXc.oXL, this.oXg.oXj, this.oXh.oXj, Pq2);
                }
                this.oXg.Pv(Pq2);
                if (Ps != null) {
                    Ps.eqs();
                }
                m = m(Pq2, Pp, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.oXe.add(m));
                    eql();
                    this.oXi.PD(Pq2);
                    enJ();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.oJR, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(Pp));
                    }
                }
            }
        }
        return m;
    }

    private V m(int i, int i2, boolean z) {
        try {
            V Po = Po(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oJR, "alloc success!!");
                return Po;
            }
            return Po;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oJR, "alloc fail!!");
            }
            if (!z || oXb == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.oJR, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (oXb == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.oXg.Pw(i);
                    d<V> Ps = Ps(i2);
                    if (Ps != null) {
                        Ps.eqt();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oJR, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (oXb == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            oXb.onFailed();
            return m(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bx = bx(v);
        int Pq = Pq(bx);
        synchronized (this) {
            d<V> Pr = Pr(bx);
            if (!this.oXe.remove(v)) {
                com.facebook.common.c.a.d(this.oJR, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                bw(v);
                this.oXi.PE(Pq);
            } else if (Pr == null || Pr.eqq() || eqm() || !by(v)) {
                if (Pr != null) {
                    Pr.eqt();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oJR, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
                bw(v);
                this.oXg.Pw(Pq);
                this.oXi.PE(Pq);
            } else {
                Pr.release(v);
                this.oXh.Pv(Pq);
                this.oXg.Pw(Pq);
                this.oXi.PF(Pq);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oJR, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bx));
                }
            }
            enJ();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        eqk();
    }

    protected void eqg() {
    }

    protected boolean by(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void eqh() {
        com.facebook.common.internal.g.checkState(!eqm() || this.oXh.oXj == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.oXd.clear();
            SparseIntArray sparseIntArray2 = this.oXc.oXN;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.oXd.put(keyAt, new d<>(Pq(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.oXc.oXQ));
                }
                this.oXf = false;
            } else {
                this.oXf = true;
            }
        }
    }

    private synchronized void eqi() {
        SparseIntArray sparseIntArray = this.oXc.oXN;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.oXf = false;
        } else {
            this.oXf = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.oXd.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.oXd.put(keyAt, new d<>(Pq(keyAt), sparseIntArray.valueAt(i), 0, this.oXc.oXQ));
        }
    }

    private List<d<V>> eqj() {
        ArrayList arrayList = new ArrayList(this.oXd.size());
        int size = this.oXd.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.oXd.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.ley;
            int enu = valueAt.enu();
            if (valueAt.eqr() > 0) {
                arrayList.add(valueAt);
            }
            this.oXd.setValueAt(i, new d<>(Pq(i2), i3, enu, this.oXc.oXQ));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void eqk() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.oXc.oXQ) {
                arrayList = eqj();
            } else {
                arrayList = new ArrayList(this.oXd.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.oXd.size(); i++) {
                    d<V> valueAt = this.oXd.valueAt(i);
                    if (valueAt.eqr() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.oXd.keyAt(i), valueAt.enu());
                }
                a(sparseIntArray);
            }
            this.oXh.reset();
            enJ();
        }
        eqg();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bw(pop);
            }
        }
    }

    synchronized void eql() {
        if (eqm()) {
            trimToSize(this.oXc.oXM);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.oXg.oXj + this.oXh.oXj) - i, this.oXh.oXj);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oJR, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.oXg.oXj + this.oXh.oXj), Integer.valueOf(min));
            }
            enJ();
            for (int i2 = 0; i2 < this.oXd.size() && min > 0; i2++) {
                d<V> valueAt = this.oXd.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bw(pop);
                    min -= valueAt.mItemSize;
                    this.oXh.Pw(valueAt.mItemSize);
                }
            }
            enJ();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oJR, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.oXg.oXj + this.oXh.oXj));
            }
        }
    }

    private synchronized d<V> Pr(int i) {
        return this.oXd.get(i);
    }

    synchronized d<V> Ps(int i) {
        d<V> dVar;
        dVar = this.oXd.get(i);
        if (dVar == null && this.oXf) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oJR, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Pt(i);
            this.oXd.put(i, dVar);
        }
        return dVar;
    }

    d<V> Pt(int i) {
        return new d<>(Pq(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.oXc.oXQ);
    }

    synchronized boolean eqm() {
        boolean z;
        z = this.oXg.oXj + this.oXh.oXj > this.oXc.oXM;
        if (z) {
            this.oXi.eqA();
        }
        return z;
    }

    synchronized boolean Pu(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.oXc.oXL;
            if (i > i2 - this.oXg.oXj) {
                this.oXi.eqB();
            } else {
                int i3 = this.oXc.oXM;
                if (i > i3 - (this.oXg.oXj + this.oXh.oXj)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.oXg.oXj + this.oXh.oXj)) {
                    this.oXi.eqB();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void enJ() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.oJR, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.oXg.mCount), Integer.valueOf(this.oXg.oXj), Integer.valueOf(this.oXh.mCount), Integer.valueOf(this.oXh.oXj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes18.dex */
    public static class a {
        int mCount;
        int oXj;

        a() {
        }

        public void Pv(int i) {
            this.mCount++;
            this.oXj += i;
        }

        public void Pw(int i) {
            if (this.oXj >= i && this.mCount > 0) {
                this.mCount--;
                this.oXj -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.oXj), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.oXj = 0;
        }
    }

    /* loaded from: classes18.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes18.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes18.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes18.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
