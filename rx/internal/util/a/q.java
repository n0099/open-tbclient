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
        long ceB = ceB();
        while (true) {
            long ceC = ceC();
            long ceB2 = ceB();
            if (ceB == ceB2) {
                return (int) (ceC - ceB2);
            }
            ceB = ceB2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ceC() == ceB();
    }

    private void dO(long j) {
        ae.iMJ.putOrderedLong(this, iMD, j);
    }

    private void dP(long j) {
        ae.iMJ.putOrderedLong(this, iMC, j);
    }

    private long ceC() {
        return ae.iMJ.getLongVolatile(this, iMD);
    }

    private long ceB() {
        return ae.iMJ.getLongVolatile(this, iMC);
    }
}
