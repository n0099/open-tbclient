package rx.internal.util.atomic;

import com.baidu.tieba.q9c;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    public static final long serialVersionUID = 6210984603741293445L;
    public final int capacitySkip;
    public final AtomicLong consumerIndex;
    public final int mask;
    public final AtomicLong producerIndex;

    public SpscExactAtomicArrayQueue(int i) {
        super(q9c.b(i));
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t != null) {
            long j = this.producerIndex.get();
            int i = this.mask;
            if (get(((int) (this.capacitySkip + j)) & i) != null) {
                return false;
            }
            this.producerIndex.lazySet(j + 1);
            lazySet(i & ((int) j), t);
            return true;
        }
        throw null;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (this.producerIndex == this.consumerIndex) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T peek() {
        return get(this.mask & ((int) this.consumerIndex.get()));
    }

    @Override // java.util.Queue
    public T poll() {
        long j = this.consumerIndex.get();
        int i = ((int) j) & this.mask;
        T t = get(i);
        if (t == null) {
            return null;
        }
        this.consumerIndex.lazySet(j + 1);
        lazySet(i, null);
        return t;
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long j = this.consumerIndex.get();
        while (true) {
            long j2 = this.producerIndex.get();
            long j3 = this.consumerIndex.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
}
