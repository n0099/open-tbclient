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
        E[] eArr = this.nPq;
        long j = this.producerIndex;
        long gB = gB(j);
        if (b(eArr, gB) != null) {
            return false;
        }
        b(eArr, gB, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long gB = gB(j);
        E[] eArr = this.nPq;
        E b = b(eArr, gB);
        if (b == null) {
            return null;
        }
        b(eArr, gB, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return gC(gB(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dPL = dPL();
        while (true) {
            long dPK = dPK();
            long dPL2 = dPL();
            if (dPL == dPL2) {
                return (int) (dPK - dPL2);
            }
            dPL = dPL2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dPK() == dPL();
    }

    private void soProducerIndex(long j) {
        ae.ogD.a(this, ogx, j);
    }

    private void soConsumerIndex(long j) {
        ae.ogD.a(this, ogw, j);
    }

    private long dPK() {
        return ae.ogD.e(this, ogx);
    }

    private long dPL() {
        return ae.ogD.e(this, ogw);
    }
}
