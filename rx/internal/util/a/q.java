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
        E[] eArr = this.nYb;
        long j = this.producerIndex;
        long gO = gO(j);
        if (b(eArr, gO) != null) {
            return false;
        }
        b(eArr, gO, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long gO = gO(j);
        E[] eArr = this.nYb;
        E b = b(eArr, gO);
        if (b == null) {
            return null;
        }
        b(eArr, gO, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return gP(gO(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dTi = dTi();
        while (true) {
            long dTh = dTh();
            long dTi2 = dTi();
            if (dTi == dTi2) {
                return (int) (dTh - dTi2);
            }
            dTi = dTi2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dTh() == dTi();
    }

    private void soProducerIndex(long j) {
        ae.opn.a(this, oph, j);
    }

    private void soConsumerIndex(long j) {
        ae.opn.a(this, opg, j);
    }

    private long dTh() {
        return ae.opn.e(this, oph);
    }

    private long dTi() {
        return ae.opn.e(this, opg);
    }
}
