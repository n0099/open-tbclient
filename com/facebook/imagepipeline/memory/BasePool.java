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
/* loaded from: classes15.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b oYE;
    final com.facebook.common.memory.c oWV;
    final r oYF;
    final Set<V> oYH;
    private boolean oYI;
    @GuardedBy("this")
    final a oYJ;
    @GuardedBy("this")
    final a oYK;
    private final s oYL;
    private final Class<?> oLv = getClass();
    final SparseArray<d<V>> oYG = new SparseArray<>();

    /* loaded from: classes15.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V PR(int i);

    protected abstract int PS(int i);

    protected abstract int PT(int i);

    protected abstract void bx(V v);

    protected abstract int by(V v);

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.oWV = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.oYF = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.oYL = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.oYF.oZt) {
            eqg();
        } else {
            a(new SparseIntArray(0));
        }
        this.oYH = com.facebook.common.internal.i.ekb();
        this.oYK = new a();
        this.oYJ = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.oWV.a(this);
        this.oYL.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V m;
        eqf();
        int PS = PS(i);
        synchronized (this) {
            d<V> PV = PV(PS);
            if (PV != null && (m = PV.get()) != null) {
                com.facebook.common.internal.g.checkState(this.oYH.add(m));
                int by = by(m);
                int PT = PT(by);
                this.oYJ.PY(PT);
                this.oYK.PZ(PT);
                this.oYL.Qf(PT);
                enH();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oLv, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(by));
                }
            } else {
                int PT2 = PT(PS);
                if (!PX(PT2)) {
                    throw new PoolSizeViolationException(this.oYF.oZo, this.oYJ.oYM, this.oYK.oYM, PT2);
                }
                this.oYJ.PY(PT2);
                if (PV != null) {
                    PV.eqq();
                }
                m = m(PT2, PS, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.oYH.add(m));
                    eqj();
                    this.oYL.Qg(PT2);
                    enH();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.oLv, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(m)), Integer.valueOf(PS));
                    }
                }
            }
        }
        return m;
    }

    private V m(int i, int i2, boolean z) {
        try {
            V PR = PR(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oLv, "alloc success!!");
                return PR;
            }
            return PR;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oLv, "alloc fail!!");
            }
            if (!z || oYE == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.oLv, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (oYE == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.oYJ.PZ(i);
                    d<V> PV = PV(i2);
                    if (PV != null) {
                        PV.eqr();
                    }
                    com.facebook.common.internal.l.u(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.oLv, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (oYE == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            oYE.onFailed();
            return m(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int by = by(v);
        int PT = PT(by);
        synchronized (this) {
            d<V> PU = PU(by);
            if (!this.oYH.remove(v)) {
                com.facebook.common.c.a.d(this.oLv, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(by));
                bx(v);
                this.oYL.Qh(PT);
            } else if (PU == null || PU.eqo() || eqk() || !bz(v)) {
                if (PU != null) {
                    PU.eqr();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oLv, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(by));
                }
                bx(v);
                this.oYJ.PZ(PT);
                this.oYL.Qh(PT);
            } else {
                PU.release(v);
                this.oYK.PY(PT);
                this.oYJ.PZ(PT);
                this.oYL.Qi(PT);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.oLv, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(by));
                }
            }
            enH();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        eqi();
    }

    protected void eqe() {
    }

    protected boolean bz(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void eqf() {
        com.facebook.common.internal.g.checkState(!eqk() || this.oYK.oYM == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.oYG.clear();
            SparseIntArray sparseIntArray2 = this.oYF.oZq;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.oYG.put(keyAt, new d<>(PT(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.oYF.oZt));
                }
                this.oYI = false;
            } else {
                this.oYI = true;
            }
        }
    }

    private synchronized void eqg() {
        SparseIntArray sparseIntArray = this.oYF.oZq;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.oYI = false;
        } else {
            this.oYI = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.oYG.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.oYG.put(keyAt, new d<>(PT(keyAt), sparseIntArray.valueAt(i), 0, this.oYF.oZt));
        }
    }

    private List<d<V>> eqh() {
        ArrayList arrayList = new ArrayList(this.oYG.size());
        int size = this.oYG.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.oYG.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.leP;
            int ens = valueAt.ens();
            if (valueAt.eqp() > 0) {
                arrayList.add(valueAt);
            }
            this.oYG.setValueAt(i, new d<>(PT(i2), i3, ens, this.oYF.oZt));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void eqi() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.oYF.oZt) {
                arrayList = eqh();
            } else {
                arrayList = new ArrayList(this.oYG.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.oYG.size(); i++) {
                    d<V> valueAt = this.oYG.valueAt(i);
                    if (valueAt.eqp() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.oYG.keyAt(i), valueAt.ens());
                }
                a(sparseIntArray);
            }
            this.oYK.reset();
            enH();
        }
        eqe();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bx(pop);
            }
        }
    }

    synchronized void eqj() {
        if (eqk()) {
            trimToSize(this.oYF.oZp);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.oYJ.oYM + this.oYK.oYM) - i, this.oYK.oYM);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oLv, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.oYJ.oYM + this.oYK.oYM), Integer.valueOf(min));
            }
            enH();
            for (int i2 = 0; i2 < this.oYG.size() && min > 0; i2++) {
                d<V> valueAt = this.oYG.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bx(pop);
                    min -= valueAt.mItemSize;
                    this.oYK.PZ(valueAt.mItemSize);
                }
            }
            enH();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oLv, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.oYJ.oYM + this.oYK.oYM));
            }
        }
    }

    private synchronized d<V> PU(int i) {
        return this.oYG.get(i);
    }

    synchronized d<V> PV(int i) {
        d<V> dVar;
        dVar = this.oYG.get(i);
        if (dVar == null && this.oYI) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.oLv, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = PW(i);
            this.oYG.put(i, dVar);
        }
        return dVar;
    }

    d<V> PW(int i) {
        return new d<>(PT(i), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, this.oYF.oZt);
    }

    synchronized boolean eqk() {
        boolean z;
        z = this.oYJ.oYM + this.oYK.oYM > this.oYF.oZp;
        if (z) {
            this.oYL.eqy();
        }
        return z;
    }

    synchronized boolean PX(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.oYF.oZo;
            if (i > i2 - this.oYJ.oYM) {
                this.oYL.eqz();
            } else {
                int i3 = this.oYF.oZp;
                if (i > i3 - (this.oYJ.oYM + this.oYK.oYM)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.oYJ.oYM + this.oYK.oYM)) {
                    this.oYL.eqz();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void enH() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.oLv, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.oYJ.mCount), Integer.valueOf(this.oYJ.oYM), Integer.valueOf(this.oYK.mCount), Integer.valueOf(this.oYK.oYM));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes15.dex */
    public static class a {
        int mCount;
        int oYM;

        a() {
        }

        public void PY(int i) {
            this.mCount++;
            this.oYM += i;
        }

        public void PZ(int i) {
            if (this.oYM >= i && this.mCount > 0) {
                this.mCount--;
                this.oYM -= i;
                return;
            }
            com.facebook.common.c.a.k("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.oYM), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.oYM = 0;
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
