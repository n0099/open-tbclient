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
        E[] eArr = this.nBM;
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
        E[] eArr = this.nBM;
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
        long dJu = dJu();
        while (true) {
            long dJt = dJt();
            long dJu2 = dJu();
            if (dJu == dJu2) {
                return (int) (dJt - dJu2);
            }
            dJu = dJu2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJt() == dJu();
    }

    private void soProducerIndex(long j) {
        ae.nSR.a(this, nSL, j);
    }

    private void soConsumerIndex(long j) {
        ae.nSR.a(this, nSK, j);
    }

    private long dJt() {
        return ae.nSR.d(this, nSL);
    }

    private long dJu() {
        return ae.nSR.d(this, nSK);
    }
}
