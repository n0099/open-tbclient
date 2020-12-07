package rx.internal.util.a;
/* loaded from: classes12.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.pKj;
        long j = this.producerIndex;
        long iL = iL(j);
        if (b(eArr, iL) != null) {
            return false;
        }
        b(eArr, iL, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long iL = iL(j);
        E[] eArr = this.pKj;
        E b = b(eArr, iL);
        if (b == null) {
            return null;
        }
        b(eArr, iL, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return iM(iL(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eDi = eDi();
        while (true) {
            long eDh = eDh();
            long eDi2 = eDi();
            if (eDi == eDi2) {
                return (int) (eDh - eDi2);
            }
            eDi = eDi2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eDh() == eDi();
    }

    private void soProducerIndex(long j) {
        ae.pUN.a(this, pUH, j);
    }

    private void soConsumerIndex(long j) {
        ae.pUN.a(this, pUG, j);
    }

    private long eDh() {
        return ae.pUN.e(this, pUH);
    }

    private long eDi() {
        return ae.pUN.e(this, pUG);
    }
}
