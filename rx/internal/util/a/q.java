package rx.internal.util.a;
/* loaded from: classes16.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.oRn;
        long j = this.producerIndex;
        long hJ = hJ(j);
        if (b(eArr, hJ) != null) {
            return false;
        }
        b(eArr, hJ, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long hJ = hJ(j);
        E[] eArr = this.oRn;
        E b = b(eArr, hJ);
        if (b == null) {
            return null;
        }
        b(eArr, hJ, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return hK(hJ(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long enb = enb();
        while (true) {
            long ena = ena();
            long enb2 = enb();
            if (enb == enb2) {
                return (int) (ena - enb2);
            }
            enb = enb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ena() == enb();
    }

    private void soProducerIndex(long j) {
        ae.piy.a(this, pis, j);
    }

    private void soConsumerIndex(long j) {
        ae.piy.a(this, pir, j);
    }

    private long ena() {
        return ae.piy.e(this, pis);
    }

    private long enb() {
        return ae.piy.e(this, pir);
    }
}
