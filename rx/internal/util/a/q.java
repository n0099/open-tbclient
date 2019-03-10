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
        E[] eArr = this.jSt;
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
        E[] eArr = this.jSt;
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
        long cEM = cEM();
        while (true) {
            long cEN = cEN();
            long cEM2 = cEM();
            if (cEM == cEM2) {
                return (int) (cEN - cEM2);
            }
            cEM = cEM2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEN() == cEM();
    }

    private void eq(long j) {
        ae.kbR.putOrderedLong(this, kbL, j);
    }

    private void er(long j) {
        ae.kbR.putOrderedLong(this, kbK, j);
    }

    private long cEN() {
        return ae.kbR.getLongVolatile(this, kbL);
    }

    private long cEM() {
        return ae.kbR.getLongVolatile(this, kbK);
    }
}
