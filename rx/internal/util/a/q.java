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
        E[] eArr = this.qiU;
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
        E[] eArr = this.qiU;
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
        long eIf = eIf();
        while (true) {
            long eIe = eIe();
            long eIf2 = eIf();
            if (eIf == eIf2) {
                return (int) (eIe - eIf2);
            }
            eIf = eIf2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eIe() == eIf();
    }

    private void soProducerIndex(long j) {
        ae.qtv.a(this, qtp, j);
    }

    private void soConsumerIndex(long j) {
        ae.qtv.a(this, qto, j);
    }

    private long eIe() {
        return ae.qtv.e(this, qtp);
    }

    private long eIf() {
        return ae.qtv.e(this, qto);
    }
}
