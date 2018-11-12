package rx.internal.util.a;
/* loaded from: classes2.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.iqN;
        long j = this.producerIndex;
        long dJ = dJ(j);
        if (b(eArr, dJ) != null) {
            return false;
        }
        b(eArr, dJ, e);
        dH(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long dJ = dJ(j);
        E[] eArr = this.iqN;
        E b = b(eArr, dJ);
        if (b == null) {
            return null;
        }
        b(eArr, dJ, null);
        dI(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return dK(dJ(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ccy = ccy();
        while (true) {
            long ccz = ccz();
            long ccy2 = ccy();
            if (ccy == ccy2) {
                return (int) (ccz - ccy2);
            }
            ccy = ccy2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ccz() == ccy();
    }

    private void dH(long j) {
        ae.iFC.putOrderedLong(this, iFw, j);
    }

    private void dI(long j) {
        ae.iFC.putOrderedLong(this, iFv, j);
    }

    private long ccz() {
        return ae.iFC.getLongVolatile(this, iFw);
    }

    private long ccy() {
        return ae.iFC.getLongVolatile(this, iFv);
    }
}
