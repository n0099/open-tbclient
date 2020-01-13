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
        E[] eArr = this.nBf;
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
        E[] eArr = this.nBf;
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
        long dIl = dIl();
        while (true) {
            long dIk = dIk();
            long dIl2 = dIl();
            if (dIl == dIl2) {
                return (int) (dIk - dIl2);
            }
            dIl = dIl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dIk() == dIl();
    }

    private void soProducerIndex(long j) {
        ae.nRY.a(this, nRS, j);
    }

    private void soConsumerIndex(long j) {
        ae.nRY.a(this, nRR, j);
    }

    private long dIk() {
        return ae.nRY.d(this, nRS);
    }

    private long dIl() {
        return ae.nRY.d(this, nRR);
    }
}
