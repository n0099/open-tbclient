package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.TypeCastException;
@kotlin.h
/* loaded from: classes5.dex */
final class ak<T> extends d<T> implements RandomAccess {
    private int btx;
    private final int capacity;
    private final Object[] oBY;
    private int size;

    public ak(int i) {
        this.capacity = i;
        if (!(this.capacity >= 0)) {
            throw new IllegalArgumentException(("ring buffer capacity should not be negative but it is " + this.capacity).toString());
        }
        this.oBY = new Object[this.capacity];
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
        d.oBP.eb(i, size());
        return (T) this.oBY[(this.btx + i) % getCapacity()];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @kotlin.h
    /* loaded from: classes5.dex */
    public static final class a extends b<T> {
        private int count;
        private int index;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.count = ak.this.size();
            this.index = ak.this.btx;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.collections.ak$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.b
        protected void ejT() {
            if (this.count != 0) {
                bM(ak.this.oBY[this.index]);
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
        kotlin.jvm.internal.q.m(tArr, com.baidu.fsg.base.statistics.b.j);
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            kotlin.jvm.internal.q.l((Object) tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = this.btx;
        int i3 = 0;
        while (i3 < size && i2 < this.capacity) {
            tArr[i3] = this.oBY[i2];
            i2++;
            i3++;
        }
        while (i3 < size) {
            tArr[i3] = this.oBY[i];
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
        this.oBY[(this.btx + size()) % getCapacity()] = t;
        this.size = size() + 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.collections.ak<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void OB(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
        if (!(i <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        if (i > 0) {
            int i2 = this.btx;
            int capacity = (i2 + i) % getCapacity();
            if (i2 > capacity) {
                a(this.oBY, null, i2, this.capacity);
                a(this.oBY, null, 0, capacity);
            } else {
                a(this.oBY, null, i2, capacity);
            }
            this.btx = capacity;
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
