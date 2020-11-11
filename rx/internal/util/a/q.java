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
        E[] eArr = this.pSe;
        long j = this.producerIndex;
        long iv = iv(j);
        if (b(eArr, iv) != null) {
            return false;
        }
        b(eArr, iv, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long iv = iv(j);
        E[] eArr = this.pSe;
        E b = b(eArr, iv);
        if (b == null) {
            return null;
        }
        b(eArr, iv, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return iw(iv(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eAQ = eAQ();
        while (true) {
            long eAP = eAP();
            long eAQ2 = eAQ();
            if (eAQ == eAQ2) {
                return (int) (eAP - eAQ2);
            }
            eAQ = eAQ2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eAP() == eAQ();
    }

    private void soProducerIndex(long j) {
        ae.qjj.a(this, qjd, j);
    }

    private void soConsumerIndex(long j) {
        ae.qjj.a(this, qjc, j);
    }

    private long eAP() {
        return ae.qjj.e(this, qjd);
    }

    private long eAQ() {
        return ae.qjj.e(this, qjc);
    }
}
