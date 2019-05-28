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
        E[] eArr = this.kjX;
        long j = this.producerIndex;
        long eQ = eQ(j);
        if (b(eArr, eQ) != null) {
            return false;
        }
        b(eArr, eQ, e);
        eO(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long eQ = eQ(j);
        E[] eArr = this.kjX;
        E b = b(eArr, eQ);
        if (b == null) {
            return null;
        }
        b(eArr, eQ, null);
        eP(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return eR(eQ(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cMm = cMm();
        while (true) {
            long cMn = cMn();
            long cMm2 = cMm();
            if (cMm == cMm2) {
                return (int) (cMn - cMm2);
            }
            cMm = cMm2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMn() == cMm();
    }

    private void eO(long j) {
        ae.kts.putOrderedLong(this, ktm, j);
    }

    private void eP(long j) {
        ae.kts.putOrderedLong(this, ktl, j);
    }

    private long cMn() {
        return ae.kts.getLongVolatile(this, ktm);
    }

    private long cMm() {
        return ae.kts.getLongVolatile(this, ktl);
    }
}
