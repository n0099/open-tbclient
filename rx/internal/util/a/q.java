package rx.internal.util.a;
/* loaded from: classes7.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.oBY;
        long j = this.producerIndex;
        long hr = hr(j);
        if (b(eArr, hr) != null) {
            return false;
        }
        b(eArr, hr, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long hr = hr(j);
        E[] eArr = this.oBY;
        E b = b(eArr, hr);
        if (b == null) {
            return null;
        }
        b(eArr, hr, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return hs(hr(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ejq = ejq();
        while (true) {
            long ejp = ejp();
            long ejq2 = ejq();
            if (ejq == ejq2) {
                return (int) (ejp - ejq2);
            }
            ejq = ejq2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ejp() == ejq();
    }

    private void soProducerIndex(long j) {
        ae.oTf.a(this, oSZ, j);
    }

    private void soConsumerIndex(long j) {
        ae.oTf.a(this, oSY, j);
    }

    private long ejp() {
        return ae.oTf.e(this, oSZ);
    }

    private long ejq() {
        return ae.oTf.e(this, oSY);
    }
}
