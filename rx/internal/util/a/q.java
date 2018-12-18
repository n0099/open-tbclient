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
        E[] eArr = this.ixX;
        long j = this.producerIndex;
        long dQ = dQ(j);
        if (b(eArr, dQ) != null) {
            return false;
        }
        b(eArr, dQ, e);
        dO(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long dQ = dQ(j);
        E[] eArr = this.ixX;
        E b = b(eArr, dQ);
        if (b == null) {
            return null;
        }
        b(eArr, dQ, null);
        dP(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return dR(dQ(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ceA = ceA();
        while (true) {
            long ceB = ceB();
            long ceA2 = ceA();
            if (ceA == ceA2) {
                return (int) (ceB - ceA2);
            }
            ceA = ceA2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ceB() == ceA();
    }

    private void dO(long j) {
        ae.iMJ.putOrderedLong(this, iMD, j);
    }

    private void dP(long j) {
        ae.iMJ.putOrderedLong(this, iMC, j);
    }

    private long ceB() {
        return ae.iMJ.getLongVolatile(this, iMD);
    }

    private long ceA() {
        return ae.iMJ.getLongVolatile(this, iMC);
    }
}
