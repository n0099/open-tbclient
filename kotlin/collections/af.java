package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.TypeCastException;
@kotlin.e
/* loaded from: classes6.dex */
final class af<T> extends d<T> implements RandomAccess {
    private int bNG;
    private final int capacity;
    private final Object[] qsZ;
    private int size;

    public af(int i) {
        this.capacity = i;
        if (!(this.capacity >= 0)) {
            throw new IllegalArgumentException(("ring buffer capacity should not be negative but it is " + this.capacity).toString());
        }
        this.qsZ = new Object[this.capacity];
    }

    public final int getCapacity() {
        return this.capacity;
    }

    private void setSize(int i) {
        this.size = i;
    }

    @Override // kotlin.collections.a
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.d, java.util.List
    public T get(int i) {
        d.qsR.ei(i, size());
        return (T) this.qsZ[(this.bNG + i) % getCapacity()];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a extends b<T> {
        private int count;
        private int index;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.count = af.this.size();
            this.index = af.this.bNG;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.collections.af$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.b
        protected void eKS() {
            if (this.count != 0) {
                bR(af.this.qsZ[this.index]);
                this.index = (this.index + 1) % af.this.getCapacity();
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
        kotlin.jvm.internal.p.o(tArr, com.baidu.fsg.base.statistics.b.j);
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            kotlin.jvm.internal.p.n(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        for (int i3 = this.bNG; i2 < size && i3 < this.capacity; i3++) {
            tArr[i2] = this.qsZ[i3];
            i2++;
        }
        while (i2 < size) {
            tArr[i2] = this.qsZ[i];
            i2++;
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.collections.af<T> */
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
        this.qsZ[(this.bNG + size()) % getCapacity()] = t;
        setSize(size() + 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.collections.af<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void St(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
        if (!(i <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        if (i > 0) {
            int i2 = this.bNG;
            int capacity = (i2 + i) % getCapacity();
            if (i2 > capacity) {
                a(this.qsZ, null, i2, this.capacity);
                a(this.qsZ, null, 0, capacity);
            } else {
                a(this.qsZ, null, i2, capacity);
            }
            this.bNG = capacity;
            setSize(size() - i);
        }
    }

    private final <T> void a(T[] tArr, T t, int i, int i2) {
        int i3 = i2 - 1;
        if (i > i3) {
            return;
        }
        while (true) {
            tArr[i] = t;
            if (i == i3) {
                return;
            }
            i++;
        }
    }
}
