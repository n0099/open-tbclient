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
        E[] eArr = this.nBO;
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
        E[] eArr = this.nBO;
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
        long dJw = dJw();
        while (true) {
            long dJv = dJv();
            long dJw2 = dJw();
            if (dJw == dJw2) {
                return (int) (dJv - dJw2);
            }
            dJw = dJw2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJv() == dJw();
    }

    private void soProducerIndex(long j) {
        ae.nST.a(this, nSN, j);
    }

    private void soConsumerIndex(long j) {
        ae.nST.a(this, nSM, j);
    }

    private long dJv() {
        return ae.nST.d(this, nSN);
    }

    private long dJw() {
        return ae.nST.d(this, nSM);
    }
}
