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
        E[] eArr = this.iCo;
        long j = this.producerIndex;
        long dV = dV(j);
        if (b(eArr, dV) != null) {
            return false;
        }
        b(eArr, dV, e);
        dT(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long dV = dV(j);
        E[] eArr = this.iCo;
        E b = b(eArr, dV);
        if (b == null) {
            return null;
        }
        b(eArr, dV, null);
        dU(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return dW(dV(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cfZ = cfZ();
        while (true) {
            long cga = cga();
            long cfZ2 = cfZ();
            if (cfZ == cfZ2) {
                return (int) (cga - cfZ2);
            }
            cfZ = cfZ2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cga() == cfZ();
    }

    private void dT(long j) {
        ae.iRa.putOrderedLong(this, iQU, j);
    }

    private void dU(long j) {
        ae.iRa.putOrderedLong(this, iQT, j);
    }

    private long cga() {
        return ae.iRa.getLongVolatile(this, iQU);
    }

    private long cfZ() {
        return ae.iRa.getLongVolatile(this, iQT);
    }
}
