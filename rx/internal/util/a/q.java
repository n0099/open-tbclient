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
        E[] eArr = this.nXZ;
        long j = this.producerIndex;
        long gO = gO(j);
        if (b(eArr, gO) != null) {
            return false;
        }
        b(eArr, gO, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long gO = gO(j);
        E[] eArr = this.nXZ;
        E b = b(eArr, gO);
        if (b == null) {
            return null;
        }
        b(eArr, gO, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return gP(gO(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dTh = dTh();
        while (true) {
            long dTg = dTg();
            long dTh2 = dTh();
            if (dTh == dTh2) {
                return (int) (dTg - dTh2);
            }
            dTh = dTh2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dTg() == dTh();
    }

    private void soProducerIndex(long j) {
        ae.opl.a(this, opf, j);
    }

    private void soConsumerIndex(long j) {
        ae.opl.a(this, ope, j);
    }

    private long dTg() {
        return ae.opl.e(this, opf);
    }

    private long dTh() {
        return ae.opl.e(this, ope);
    }
}
