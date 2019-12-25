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
        E[] eArr = this.mYL;
        long j = this.producerIndex;
        long gX = gX(j);
        if (b(eArr, gX) != null) {
            return false;
        }
        b(eArr, gX, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long gX = gX(j);
        E[] eArr = this.mYL;
        E b = b(eArr, gX);
        if (b == null) {
            return null;
        }
        b(eArr, gX, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return gY(gX(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dEb = dEb();
        while (true) {
            long dEa = dEa();
            long dEb2 = dEb();
            if (dEb == dEb2) {
                return (int) (dEa - dEb2);
            }
            dEb = dEb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dEa() == dEb();
    }

    private void soProducerIndex(long j) {
        ae.njb.a(this, niV, j);
    }

    private void soConsumerIndex(long j) {
        ae.njb.a(this, niU, j);
    }

    private long dEa() {
        return ae.njb.d(this, niV);
    }

    private long dEb() {
        return ae.njb.d(this, niU);
    }
}
