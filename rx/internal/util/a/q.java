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
        E[] eArr = this.jRD;
        long j = this.producerIndex;
        long er = er(j);
        if (b(eArr, er) != null) {
            return false;
        }
        b(eArr, er, e);
        ep(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long er = er(j);
        E[] eArr = this.jRD;
        E b = b(eArr, er);
        if (b == null) {
            return null;
        }
        b(eArr, er, null);
        eq(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return es(er(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEE = cEE();
        while (true) {
            long cEF = cEF();
            long cEE2 = cEE();
            if (cEE == cEE2) {
                return (int) (cEF - cEE2);
            }
            cEE = cEE2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEF() == cEE();
    }

    private void ep(long j) {
        ae.kbb.putOrderedLong(this, kaV, j);
    }

    private void eq(long j) {
        ae.kbb.putOrderedLong(this, kaU, j);
    }

    private long cEF() {
        return ae.kbb.getLongVolatile(this, kaV);
    }

    private long cEE() {
        return ae.kbb.getLongVolatile(this, kaU);
    }
}
