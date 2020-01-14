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
    private static b lTr;
    final com.facebook.common.memory.c lRG;
    final r lTs;
    final Set<V> lTu;
    private boolean lTv;
    @GuardedBy("this")
    final a lTw;
    @GuardedBy("this")
    final a lTx;
    private final s lTy;
    private final Class<?> lGr = getClass();
    final SparseArray<d<V>> lTt = new SparseArray<>();

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
        lTr = bVar;
    }

    public BasePool(com.facebook.common.memory.c cVar, r rVar, s sVar) {
        this.lRG = (com.facebook.common.memory.c) com.facebook.common.internal.g.checkNotNull(cVar);
        this.lTs = (r) com.facebook.common.internal.g.checkNotNull(rVar);
        this.lTy = (s) com.facebook.common.internal.g.checkNotNull(sVar);
        if (this.lTs.lUg) {
            dpv();
        } else {
            a(new SparseIntArray(0));
        }
        this.lTu = com.facebook.common.internal.i.djt();
        this.lTx = new a();
        this.lTw = new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
        this.lRG.a(this);
        this.lTy.a(this);
    }

    @Override // com.facebook.common.memory.e
    public V get(int i) {
        V o;
        dpu();
        int Il = Il(i);
        synchronized (this) {
            d<V> Io = Io(Il);
            if (Io != null && (o = Io.get()) != null) {
                com.facebook.common.internal.g.checkState(this.lTu.add(o));
                int bo = bo(o);
                int Im = Im(bo);
                this.lTw.Ir(Im);
                this.lTx.Is(Im);
                this.lTy.Iy(Im);
                dmV();
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGr, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(bo));
                }
            } else {
                int Im2 = Im(Il);
                if (!Iq(Im2)) {
                    throw new PoolSizeViolationException(this.lTs.lUb, this.lTw.lTz, this.lTx.lTz, Im2);
                }
                this.lTw.Ir(Im2);
                if (Io != null) {
                    Io.dpG();
                }
                o = o(Im2, Il, true);
                synchronized (this) {
                    com.facebook.common.internal.g.checkState(this.lTu.add(o));
                    dpy();
                    this.lTy.Iz(Im2);
                    dmV();
                    if (com.facebook.common.c.a.isLoggable(2)) {
                        com.facebook.common.c.a.a(this.lGr, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(o)), Integer.valueOf(Il));
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
                com.facebook.common.c.a.f(this.lGr, "alloc success!!");
                return Ik;
            }
            return Ik;
        } catch (Throwable th) {
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lGr, "alloc fail!!");
            }
            if (!z || lTr == null) {
                if (com.facebook.common.c.a.isLoggable(3)) {
                    com.facebook.common.c.a.f(this.lGr, "retryOnce won't work." + (z ? "retry = true" : "retry = false") + (lTr == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
                }
                synchronized (this) {
                    this.lTw.Is(i);
                    d<V> Io = Io(i2);
                    if (Io != null) {
                        Io.dpH();
                    }
                    com.facebook.common.internal.l.t(th);
                    return null;
                }
            }
            if (com.facebook.common.c.a.isLoggable(3)) {
                com.facebook.common.c.a.f(this.lGr, "retryOnce will work." + (z ? "retry = true" : "retry = false") + (lTr == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null"));
            }
            lTr.onFailed();
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
            if (!this.lTu.remove(v)) {
                com.facebook.common.c.a.d(this.lGr, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                bn(v);
                this.lTy.IA(Im);
            } else if (In == null || In.dpE() || dpz() || !bp(v)) {
                if (In != null) {
                    In.dpH();
                }
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGr, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
                bn(v);
                this.lTw.Is(Im);
                this.lTy.IA(Im);
            } else {
                In.release(v);
                this.lTx.Ir(Im);
                this.lTw.Is(Im);
                this.lTy.IB(Im);
                if (com.facebook.common.c.a.isLoggable(2)) {
                    com.facebook.common.c.a.a(this.lGr, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bo));
                }
            }
            dmV();
        }
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        dpx();
    }

    protected void dpt() {
    }

    protected boolean bp(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        return true;
    }

    private synchronized void dpu() {
        com.facebook.common.internal.g.checkState(!dpz() || this.lTx.lTz == 0);
    }

    private synchronized void a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(sparseIntArray);
            this.lTt.clear();
            SparseIntArray sparseIntArray2 = this.lTs.lUd;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.lTt.put(keyAt, new d<>(Im(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.lTs.lUg));
                }
                this.lTv = false;
            } else {
                this.lTv = true;
            }
        }
    }

    private synchronized void dpv() {
        SparseIntArray sparseIntArray = this.lTs.lUd;
        if (sparseIntArray != null) {
            b(sparseIntArray);
            this.lTv = false;
        } else {
            this.lTv = true;
        }
    }

    private void b(SparseIntArray sparseIntArray) {
        this.lTt.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.lTt.put(keyAt, new d<>(Im(keyAt), sparseIntArray.valueAt(i), 0, this.lTs.lUg));
        }
    }

    private List<d<V>> dpw() {
        ArrayList arrayList = new ArrayList(this.lTt.size());
        int size = this.lTt.size();
        for (int i = 0; i < size; i++) {
            d<V> valueAt = this.lTt.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.isW;
            int dmI = valueAt.dmI();
            if (valueAt.dpF() > 0) {
                arrayList.add(valueAt);
            }
            this.lTt.setValueAt(i, new d<>(Im(i2), i3, dmI, this.lTs.lUg));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.BasePool<V>] */
    void dpx() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.lTs.lUg) {
                arrayList = dpw();
            } else {
                arrayList = new ArrayList(this.lTt.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.lTt.size(); i++) {
                    d<V> valueAt = this.lTt.valueAt(i);
                    if (valueAt.dpF() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.lTt.keyAt(i), valueAt.dmI());
                }
                a(sparseIntArray);
            }
            this.lTx.reset();
            dmV();
        }
        dpt();
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

    synchronized void dpy() {
        if (dpz()) {
            trimToSize(this.lTs.lUc);
        }
    }

    synchronized void trimToSize(int i) {
        int min = Math.min((this.lTw.lTz + this.lTx.lTz) - i, this.lTx.lTz);
        if (min > 0) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGr, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.lTw.lTz + this.lTx.lTz), Integer.valueOf(min));
            }
            dmV();
            for (int i2 = 0; i2 < this.lTt.size() && min > 0; i2++) {
                d<V> valueAt = this.lTt.valueAt(i2);
                while (min > 0) {
                    V pop = valueAt.pop();
                    if (pop == null) {
                        break;
                    }
                    bn(pop);
                    min -= valueAt.mItemSize;
                    this.lTx.Is(valueAt.mItemSize);
                }
            }
            dmV();
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGr, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.lTw.lTz + this.lTx.lTz));
            }
        }
    }

    private synchronized d<V> In(int i) {
        return this.lTt.get(i);
    }

    synchronized d<V> Io(int i) {
        d<V> dVar;
        dVar = this.lTt.get(i);
        if (dVar == null && this.lTv) {
            if (com.facebook.common.c.a.isLoggable(2)) {
                com.facebook.common.c.a.a(this.lGr, "creating new bucket %s", Integer.valueOf(i));
            }
            dVar = Ip(i);
            this.lTt.put(i, dVar);
        }
        return dVar;
    }

    d<V> Ip(int i) {
        return new d<>(Im(i), Integer.MAX_VALUE, 0, this.lTs.lUg);
    }

    synchronized boolean dpz() {
        boolean z;
        z = this.lTw.lTz + this.lTx.lTz > this.lTs.lUc;
        if (z) {
            this.lTy.dpO();
        }
        return z;
    }

    synchronized boolean Iq(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.lTs.lUb;
            if (i > i2 - this.lTw.lTz) {
                this.lTy.dpP();
            } else {
                int i3 = this.lTs.lUc;
                if (i > i3 - (this.lTw.lTz + this.lTx.lTz)) {
                    trimToSize(i3 - i);
                }
                if (i > i2 - (this.lTw.lTz + this.lTx.lTz)) {
                    this.lTy.dpP();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void dmV() {
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(this.lGr, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.lTw.mCount), Integer.valueOf(this.lTw.lTz), Integer.valueOf(this.lTx.mCount), Integer.valueOf(this.lTx.lTz));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    /* loaded from: classes10.dex */
    public static class a {
        int lTz;
        int mCount;

        a() {
        }

        public void Ir(int i) {
            this.mCount++;
            this.lTz += i;
        }

        public void Is(int i) {
            if (this.lTz >= i && this.mCount > 0) {
                this.mCount--;
                this.lTz -= i;
                return;
            }
            com.facebook.common.c.a.j("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.lTz), Integer.valueOf(this.mCount));
        }

        public void reset() {
            this.mCount = 0;
            this.lTz = 0;
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
