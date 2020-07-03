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
        E[] eArr = this.nPn;
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
        E[] eArr = this.nPn;
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
        long dPH = dPH();
        while (true) {
            long dPG = dPG();
            long dPH2 = dPH();
            if (dPH == dPH2) {
                return (int) (dPG - dPH2);
            }
            dPH = dPH2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dPG() == dPH();
    }

    private void soProducerIndex(long j) {
        ae.ogA.a(this, ogu, j);
    }

    private void soConsumerIndex(long j) {
        ae.ogA.a(this, ogt, j);
    }

    private long dPG() {
        return ae.ogA.e(this, ogu);
    }

    private long dPH() {
        return ae.ogA.e(this, ogt);
    }
}
