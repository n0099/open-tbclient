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
        E[] eArr = this.kka;
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
        E[] eArr = this.kka;
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
        long cMl = cMl();
        while (true) {
            long cMm = cMm();
            long cMl2 = cMl();
            if (cMl == cMl2) {
                return (int) (cMm - cMl2);
            }
            cMl = cMl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMm() == cMl();
    }

    private void eO(long j) {
        ae.ktv.putOrderedLong(this, ktp, j);
    }

    private void eP(long j) {
        ae.ktv.putOrderedLong(this, kto, j);
    }

    private long cMm() {
        return ae.ktv.getLongVolatile(this, ktp);
    }

    private long cMl() {
        return ae.ktv.getLongVolatile(this, kto);
    }
}
