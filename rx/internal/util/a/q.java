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
        E[] eArr = this.iBh;
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
        E[] eArr = this.iBh;
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
        long cfr = cfr();
        while (true) {
            long cfs = cfs();
            long cfr2 = cfr();
            if (cfr == cfr2) {
                return (int) (cfs - cfr2);
            }
            cfr = cfr2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cfs() == cfr();
    }

    private void dT(long j) {
        ae.iPT.putOrderedLong(this, iPN, j);
    }

    private void dU(long j) {
        ae.iPT.putOrderedLong(this, iPM, j);
    }

    private long cfs() {
        return ae.iPT.getLongVolatile(this, iPN);
    }

    private long cfr() {
        return ae.iPT.getLongVolatile(this, iPM);
    }
}
