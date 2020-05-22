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
        E[] eArr = this.nsq;
        long j = this.producerIndex;
        long gw = gw(j);
        if (b(eArr, gw) != null) {
            return false;
        }
        b(eArr, gw, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long gw = gw(j);
        E[] eArr = this.nsq;
        E b = b(eArr, gw);
        if (b == null) {
            return null;
        }
        b(eArr, gw, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return gx(gw(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dKN = dKN();
        while (true) {
            long dKM = dKM();
            long dKN2 = dKN();
            if (dKN == dKN2) {
                return (int) (dKM - dKN2);
            }
            dKN = dKN2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dKM() == dKN();
    }

    private void soProducerIndex(long j) {
        ae.nJC.a(this, nJw, j);
    }

    private void soConsumerIndex(long j) {
        ae.nJC.a(this, nJv, j);
    }

    private long dKM() {
        return ae.nJC.e(this, nJw);
    }

    private long dKN() {
        return ae.nJC.e(this, nJv);
    }
}
