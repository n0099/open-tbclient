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
        E[] eArr = this.ntA;
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
        E[] eArr = this.ntA;
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
        long dLb = dLb();
        while (true) {
            long dLa = dLa();
            long dLb2 = dLb();
            if (dLb == dLb2) {
                return (int) (dLa - dLb2);
            }
            dLb = dLb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dLa() == dLb();
    }

    private void soProducerIndex(long j) {
        ae.nKM.a(this, nKG, j);
    }

    private void soConsumerIndex(long j) {
        ae.nKM.a(this, nKF, j);
    }

    private long dLa() {
        return ae.nKM.e(this, nKG);
    }

    private long dLb() {
        return ae.nKM.e(this, nKF);
    }
}
