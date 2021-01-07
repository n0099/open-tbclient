package rx.internal.util.a;
/* loaded from: classes15.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.qnw;
        long j = this.producerIndex;
        long jy = jy(j);
        if (b(eArr, jy) != null) {
            return false;
        }
        b(eArr, jy, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long jy = jy(j);
        E[] eArr = this.qnw;
        E b2 = b(eArr, jy);
        if (b2 == null) {
            return null;
        }
        b(eArr, jy, null);
        soConsumerIndex(j + 1);
        return b2;
    }

    @Override // java.util.Queue
    public E peek() {
        return jz(jy(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eLV = eLV();
        while (true) {
            long eLU = eLU();
            long eLV2 = eLV();
            if (eLV == eLV2) {
                return (int) (eLU - eLV2);
            }
            eLV = eLV2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eLU() == eLV();
    }

    private void soProducerIndex(long j) {
        ae.qxX.a(this, qxR, j);
    }

    private void soConsumerIndex(long j) {
        ae.qxX.a(this, qxQ, j);
    }

    private long eLU() {
        return ae.qxX.e(this, qxR);
    }

    private long eLV() {
        return ae.qxX.e(this, qxQ);
    }
}
