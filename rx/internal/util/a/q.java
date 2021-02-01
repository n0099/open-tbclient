package rx.internal.util.a;
/* loaded from: classes5.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.qsZ;
        long j = this.producerIndex;
        long jB = jB(j);
        if (b(eArr, jB) != null) {
            return false;
        }
        b(eArr, jB, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long jB = jB(j);
        E[] eArr = this.qsZ;
        E b2 = b(eArr, jB);
        if (b2 == null) {
            return null;
        }
        b(eArr, jB, null);
        soConsumerIndex(j + 1);
        return b2;
    }

    @Override // java.util.Queue
    public E peek() {
        return jC(jB(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eKv = eKv();
        while (true) {
            long eKu = eKu();
            long eKv2 = eKv();
            if (eKv == eKv2) {
                return (int) (eKu - eKv2);
            }
            eKv = eKv2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eKu() == eKv();
    }

    private void soProducerIndex(long j) {
        ae.qDz.a(this, qDt, j);
    }

    private void soConsumerIndex(long j) {
        ae.qDz.a(this, qDs, j);
    }

    private long eKu() {
        return ae.qDz.e(this, qDt);
    }

    private long eKv() {
        return ae.qDz.e(this, qDs);
    }
}
