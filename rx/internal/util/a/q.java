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
        E[] eArr = this.ipc;
        long j = this.producerIndex;
        long dO = dO(j);
        if (b(eArr, dO) != null) {
            return false;
        }
        b(eArr, dO, e);
        dM(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long dO = dO(j);
        E[] eArr = this.ipc;
        E b = b(eArr, dO);
        if (b == null) {
            return null;
        }
        b(eArr, dO, null);
        dN(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return dP(dO(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cdb = cdb();
        while (true) {
            long cdc = cdc();
            long cdb2 = cdb();
            if (cdb == cdb2) {
                return (int) (cdc - cdb2);
            }
            cdb = cdb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cdc() == cdb();
    }

    private void dM(long j) {
        ae.iDR.putOrderedLong(this, iDL, j);
    }

    private void dN(long j) {
        ae.iDR.putOrderedLong(this, iDK, j);
    }

    private long cdc() {
        return ae.iDR.getLongVolatile(this, iDL);
    }

    private long cdb() {
        return ae.iDR.getLongVolatile(this, iDK);
    }
}
