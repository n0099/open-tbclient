package rx.internal.util.a;
/* loaded from: classes6.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.nBZ;
        long j = this.producerIndex;
        long ht = ht(j);
        if (b(eArr, ht) != null) {
            return false;
        }
        b(eArr, ht, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long ht = ht(j);
        E[] eArr = this.nBZ;
        E b = b(eArr, ht);
        if (b == null) {
            return null;
        }
        b(eArr, ht, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return hu(ht(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dJx = dJx();
        while (true) {
            long dJw = dJw();
            long dJx2 = dJx();
            if (dJx == dJx2) {
                return (int) (dJw - dJx2);
            }
            dJx = dJx2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJw() == dJx();
    }

    private void soProducerIndex(long j) {
        ae.nTe.a(this, nSY, j);
    }

    private void soConsumerIndex(long j) {
        ae.nTe.a(this, nSX, j);
    }

    private long dJw() {
        return ae.nTe.d(this, nSY);
    }

    private long dJx() {
        return ae.nTe.d(this, nSX);
    }
}
