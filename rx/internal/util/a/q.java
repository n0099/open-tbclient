package rx.internal.util.a;
/* loaded from: classes4.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.qub;
        long j = this.producerIndex;
        long jA = jA(j);
        if (b(eArr, jA) != null) {
            return false;
        }
        b(eArr, jA, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long jA = jA(j);
        E[] eArr = this.qub;
        E b = b(eArr, jA);
        if (b == null) {
            return null;
        }
        b(eArr, jA, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return jB(jA(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eKl = eKl();
        while (true) {
            long eKk = eKk();
            long eKl2 = eKl();
            if (eKl == eKl2) {
                return (int) (eKk - eKl2);
            }
            eKl = eKl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eKk() == eKl();
    }

    private void soProducerIndex(long j) {
        ae.qEB.a(this, qEv, j);
    }

    private void soConsumerIndex(long j) {
        ae.qEB.a(this, qEu, j);
    }

    private long eKk() {
        return ae.qEB.e(this, qEv);
    }

    private long eKl() {
        return ae.qEB.e(this, qEu);
    }
}
