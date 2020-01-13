package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes10.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.e<V> {
    private static b lTm;
    final com.facebook.common.memory.c lRB;
    final r lTn;
    final Set<V> lTp;
    private boolean lTq;
    @GuardedBy("this")
    final a lTr;
    @GuardedBy("this")
    final a lTs;
    private final s lTt;
    private final Class<?> lGm = getClass();
    final SparseArray<d<V>> lTo = new SparseArray<>();

    /* loaded from: classes10.dex */
    public interface b {
        void onFailed();
    }

    protected abstract V Ik(int i);

    protected abstract int Il(int i);

    protected abstract int Im(int i);

    protected abstract void bn(V v);

    protected abstract int bo(V v);

    public static void a(b bVar) {
        lTm = bVar;
    }

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.lRB = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.lTn = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.lTt = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.lTn.lUb) {
            dpt();
        } else {
            a(new SparseIntArray(0));
        }
        this.lTp = com.facebook.common.internal.i.djr();
        this.lTs = new a();
        this.lTr = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.lRB.a(this);
        this.lTt.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dps();
        int Il = Il(i);
        synchronized (this) {
            d<V> Io = Io(Il);
            if (Io != null && (o = Io.get()) != null) {
                com.facebook.common.internal.g.checkState(this.lTp.add(o));
                int bo = bo(o);
                int Im = Im(bo);
                this.lTr.Ir(Im);
                this.lTs.Is(Im);
                this.lTt.Iy(Im);
                dmT();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGm, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bo));
                }
            } else {
                int Im2 = Im(Il);
                if (!Iq(Im2)) {
                    throw new PoolSizeViolationException(this.lTn.lTW, this.lTr.lTu, this.lTs.lTu, Im2);
                }
                this.lTr.Ir(Im2);
                if (Io != null) {
                    Io.dpE();
                }
                o = o(Im2, Il, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.lTp.add(o));
                    dpw();
                    this.lTt.Iz(Im2);
                    dmT();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lGm, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(Il));
                    }
                }
            }
        }
        return o;
    }

    private V o(int i, int i2, boolean z) {
        try {
            V Ik = Ik(i2);
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lGm, "alloc success!!");
                return Ik;
            }
            return Ik;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lGm, "alloc fail!!");
            }
            if (!z || lTm == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lGm, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (lTm == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.lTr.Is(i);
                    d<V> Io = Io(i2);
                    if (Io != null) {
                        Io.dpF();
                    }
                    com.facebook.common.internal.l.t(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lGm, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (lTm == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            lTm.onFailed();
            return o(i, i2, false);
        }
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        int bo = bo(v);
        int Im = Im(bo);
        synchronized (this) {
            d<V> In = In(bo);
            if (!this.lTp.remove(v)) {
                com.facebook.common.c.a.d(this.lGm, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                bn(v);
                this.lTt.IA(Im);
            } else if (In == null || In.dpC() || dpx() || !bp(v)) {
                if (In != null) {
                    In.dpF();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGm, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
                bn(v);
                this.lTr.Is(Im);
                this.lTt.IA(Im);
            } else {
                In.release(v);
                this.lTs.Ir(Im);
                this.lTr.Is(Im);
                this.lTt.IB(Im);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGm, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
            }
            dmT();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dpv();
    }

    protected void dpr() {
    }

    protected boolean bp(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dps() {
        com.facebook.common.internal.g.checkState(!dpx() || this.lTs.lTu == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.lTo.clear();
            SparseIntArray sparseIntArray2 = this.lTn.lTY;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.lTo.put(keyAt, new d<>(Im(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.lTn.lUb));
                }
                this.lTq = false;
            } else {
                this.lTq = true;
            }
        }
    }

    private synchronized void dpt() {
        SparseIntArray sparseIntArray = this.lTn.lTY;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.lTq = false;
        } else {
            this.lTq = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.lTo.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.lTo.put(keyAt, new d<>(Im(keyAt), sparseIntArray.valueAt(i), 0, this.lTn.lUb));
        }
    }

    private List<d<V>> dpu() {
        ArrayList arrayList = new ArrayList(this.lTo.size());
        int size = this.lTo.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.lTo.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.isW;
            int dmG = valueAt.dmG();
            if (valueAt.dpD() > 0) {
                arrayList.add(valueAt);
            }
            this.lTo.setValueAt(i, new d<>(Im(i2), i3, dmG, this.lTn.lUb));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dpv() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.lTn.lUb) {
                arrayList = dpu();
            } else {
                arrayList = new ArrayList(this.lTo.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.lTo.size(); i++) {
                    d<V> valueAt = this.lTo.valueAt(i);
                    if (valueAt.dpD() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.lTo.keyAt(i), valueAt.dmG());
                }
                a(sparseIntArray);
            }
            this.lTs.reset();
            dmT();
        }
        dpr();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d dVar = (d) arrayList.get(i2);
            while (true) {
                Object pop = dVar.pop();
                if (pop == null) {
                    break;
                }
                bn(pop);
            }
        }
    }

    synchronized void dpw() {
        if (dpx()) {
            trimToSize(this.lTn.lTX);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.lTr.lTu + this.lTs.lTu) - i, this.lTs.lTu);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGm, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.lTr.lTu + this.lTs.lTu), Integer.valueOf(min));
            }
            dmT();
            for (int i2 = 0; i2 < this.lTo.size() && min > 0; i2++) {
                d<V> valueAt = this.lTo.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bn(pop);
                    min -= valueAt.mItemSize;
                    this.lTs.Is(valueAt.mItemSize);
                }
            }
            dmT();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGm, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.lTr.lTu + this.lTs.lTu));
            }
        }
    }

    private synchronized d<V> In(int i) {
        return this.lTo.get(i);
    }

    synchronized d<V> Io(int i) {
        d<V> dVar;
        dVar = this.lTo.get(i);
        if (dVar == null && this.lTq) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGm, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Ip(i);
            this.lTo.put(i, dVar);
        }
        return dVar;
    }

    d<V> Ip(int i) {
        return new d<>(Im(i), Integer.MAX_VALUE, 0, this.lTn.lUb);
    }

    synchronized boolean dpx() {
        boolean z;
        z = this.lTr.lTu + this.lTs.lTu > this.lTn.lTX;
        if (z) {
            this.lTt.dpM();
        }
        return z;
    }

    synchronized boolean Iq(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.lTn.lTW;
            if (i > i2 - this.lTr.lTu) {
                this.lTt.dpN();
            } else {
                int i3 = this.lTn.lTX;
                if (i > i3 - (this.lTr.lTu + this.lTs.lTu)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.lTr.lTu + this.lTs.lTu)) {
                    this.lTt.dpN();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dmT() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lGm, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.lTr.mCount), Integer.valueOf(this.lTr.lTu), Integer.valueOf(this.lTs.mCount), Integer.valueOf(this.lTs.lTu));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes10.dex */
    public static class a {
        int lTu;
        int mCount;

        a() {
        }

        public void Ir(int i) {
            this.mCount++;
            this.lTu += i;
        }

        public void Is(int i) {
            if (this.lTu >= i && this.mCount > 0) {
                this.mCount--;
                this.lTu -= i;
                return;
            }
            com.facebook.common.c.a.j("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.lTu), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.lTu = 0;
        }
    }

    /* loaded from: classes10.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes10.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes10.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes10.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
