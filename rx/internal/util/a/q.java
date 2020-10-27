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
        E[] eArr = this.pIK;
        long j = this.producerIndex;
        long hZ = hZ(j);
        if (b(eArr, hZ) != null) {
            return false;
        }
        b(eArr, hZ, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long hZ = hZ(j);
        E[] eArr = this.pIK;
        E b = b(eArr, hZ);
        if (b == null) {
            return null;
        }
        b(eArr, hZ, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return ia(hZ(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long exb = exb();
        while (true) {
            long exa = exa();
            long exb2 = exb();
            if (exb == exb2) {
                return (int) (exa - exb2);
            }
            exb = exb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return exa() == exb();
    }

    private void soProducerIndex(long j) {
        ae.pZO.a(this, pZI, j);
    }

    private void soConsumerIndex(long j) {
        ae.pZO.a(this, pZH, j);
    }

    private long exa() {
        return ae.pZO.e(this, pZI);
    }

    private long exb() {
        return ae.pZO.e(this, pZH);
    }
}
