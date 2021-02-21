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
        E[] eArr = this.qtz;
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
        E[] eArr = this.qtz;
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
        long eKD = eKD();
        while (true) {
            long eKC = eKC();
            long eKD2 = eKD();
            if (eKD == eKD2) {
                return (int) (eKC - eKD2);
            }
            eKD = eKD2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eKC() == eKD();
    }

    private void soProducerIndex(long j) {
        ae.qDZ.a(this, qDT, j);
    }

    private void soConsumerIndex(long j) {
        ae.qDZ.a(this, qDS, j);
    }

    private long eKC() {
        return ae.qDZ.e(this, qDT);
    }

    private long eKD() {
        return ae.qDZ.e(this, qDS);
    }
}
