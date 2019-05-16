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
        E[] eArr = this.kjW;
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
        E[] eArr = this.kjW;
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
        long cMk = cMk();
        while (true) {
            long cMl = cMl();
            long cMk2 = cMk();
            if (cMk == cMk2) {
                return (int) (cMl - cMk2);
            }
            cMk = cMk2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMl() == cMk();
    }

    private void eO(long j) {
        ae.ktr.putOrderedLong(this, ktl, j);
    }

    private void eP(long j) {
        ae.ktr.putOrderedLong(this, ktk, j);
    }

    private long cMl() {
        return ae.ktr.getLongVolatile(this, ktl);
    }

    private long cMk() {
        return ae.ktr.getLongVolatile(this, ktk);
    }
}
