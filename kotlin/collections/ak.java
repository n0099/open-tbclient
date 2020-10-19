package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.TypeCastException;
@kotlin.h
/* loaded from: classes10.dex */
final class ak<T> extends d<T> implements RandomAccess {
    private int bxk;
    private final int capacity;
    private final Object[] oRn;
    private int size;

    public ak(int i) {
        this.capacity = i;
        if (!(this.capacity >= 0)) {
            throw new IllegalArgumentException(("ring buffer capacity should not be negative but it is " + this.capacity).toString());
        }
        this.oRn = new Object[this.capacity];
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // kotlin.collections.a
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.d, java.util.List
    public T get(int i) {
        d.oRe.eb(i, size());
        return (T) this.oRn[(this.bxk + i) % getCapacity()];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a extends b<T> {
        private int count;
        private int index;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.count = ak.this.size();
            this.index = ak.this.bxk;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.collections.ak$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.b
        protected void enF() {
            if (this.count != 0) {
                bP(ak.this.oRn[this.index]);
                this.index = (this.index + 1) % ak.this.getCapacity();
                this.count--;
                return;
            }
            done();
        }
    }

    @Override // kotlin.collections.d, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int i = 0;
        kotlin.jvm.internal.q.n(tArr, com.baidu.fsg.base.statistics.b.j);
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            kotlin.jvm.internal.q.m(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = this.bxk;
        int i3 = 0;
        while (i3 < size && i2 < this.capacity) {
            tArr[i3] = this.oRn[i2];
            i2++;
            i3++;
        }
        while (i3 < size) {
            tArr[i3] = this.oRn[i];
            i3++;
            i++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        if (tArr == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return tArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.collections.ak<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // kotlin.collections.a, java.util.Collection
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.oRn[(this.bxk + size()) % getCapacity()] = t;
        this.size = size() + 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.collections.ak<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Ph(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
        if (!(i <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        if (i > 0) {
            int i2 = this.bxk;
            int capacity = (i2 + i) % getCapacity();
            if (i2 > capacity) {
                a(this.oRn, null, i2, this.capacity);
                a(this.oRn, null, 0, capacity);
            } else {
                a(this.oRn, null, i2, capacity);
            }
            this.bxk = capacity;
            this.size = size() - i;
        }
    }

    private final <T> void a(T[] tArr, T t, int i, int i2) {
        while (i < i2) {
            tArr[i] = t;
            i++;
        }
    }
}
