package rx.internal.util.a;
/* loaded from: classes14.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.pTH;
        long j = this.producerIndex;
        long iy = iy(j);
        if (b(eArr, iy) != null) {
            return false;
        }
        b(eArr, iy, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long iy = iy(j);
        E[] eArr = this.pTH;
        E b = b(eArr, iy);
        if (b == null) {
            return null;
        }
        b(eArr, iy, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return iz(iy(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eAR = eAR();
        while (true) {
            long eAQ = eAQ();
            long eAR2 = eAR();
            if (eAR == eAR2) {
                return (int) (eAQ - eAR2);
            }
            eAR = eAR2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eAQ() == eAR();
    }

    private void soProducerIndex(long j) {
        ae.qkM.a(this, qkG, j);
    }

    private void soConsumerIndex(long j) {
        ae.qkM.a(this, qkF, j);
    }

    private long eAQ() {
        return ae.qkM.e(this, qkG);
    }

    private long eAR() {
        return ae.qkM.e(this, qkF);
    }
}
