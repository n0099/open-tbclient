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
        E[] eArr = this.jSl;
        long j = this.producerIndex;
        long es = es(j);
        if (b(eArr, es) != null) {
            return false;
        }
        b(eArr, es, e);
        eq(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long es = es(j);
        E[] eArr = this.jSl;
        E b = b(eArr, es);
        if (b == null) {
            return null;
        }
        b(eArr, es, null);
        er(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return et(es(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEP = cEP();
        while (true) {
            long cEQ = cEQ();
            long cEP2 = cEP();
            if (cEP == cEP2) {
                return (int) (cEQ - cEP2);
            }
            cEP = cEP2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEQ() == cEP();
    }

    private void eq(long j) {
        ae.kbJ.putOrderedLong(this, kbD, j);
    }

    private void er(long j) {
        ae.kbJ.putOrderedLong(this, kbC, j);
    }

    private long cEQ() {
        return ae.kbJ.getLongVolatile(this, kbD);
    }

    private long cEP() {
        return ae.kbJ.getLongVolatile(this, kbC);
    }
}
