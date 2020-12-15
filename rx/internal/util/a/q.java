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
        E[] eArr = this.pKl;
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
        E[] eArr = this.pKl;
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
        long eDj = eDj();
        while (true) {
            long eDi = eDi();
            long eDj2 = eDj();
            if (eDj == eDj2) {
                return (int) (eDi - eDj2);
            }
            eDj = eDj2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eDi() == eDj();
    }

    private void soProducerIndex(long j) {
        ae.pUP.a(this, pUJ, j);
    }

    private void soConsumerIndex(long j) {
        ae.pUP.a(this, pUI, j);
    }

    private long eDi() {
        return ae.pUP.e(this, pUJ);
    }

    private long eDj() {
        return ae.pUP.e(this, pUI);
    }
}
