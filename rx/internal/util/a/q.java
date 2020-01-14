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
        E[] eArr = this.nBk;
        long j = this.producerIndex;
        long hv = hv(j);
        if (b(eArr, hv) != null) {
            return false;
        }
        b(eArr, hv, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long hv = hv(j);
        E[] eArr = this.nBk;
        E b = b(eArr, hv);
        if (b == null) {
            return null;
        }
        b(eArr, hv, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return hw(hv(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dIn = dIn();
        while (true) {
            long dIm = dIm();
            long dIn2 = dIn();
            if (dIn == dIn2) {
                return (int) (dIm - dIn2);
            }
            dIn = dIn2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dIm() == dIn();
    }

    private void soProducerIndex(long j) {
        ae.nSd.a(this, nRX, j);
    }

    private void soConsumerIndex(long j) {
        ae.nSd.a(this, nRW, j);
    }

    private long dIm() {
        return ae.nSd.d(this, nRX);
    }

    private long dIn() {
        return ae.nSd.d(this, nRW);
    }
}
