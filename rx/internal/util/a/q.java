package rx.internal.util.a;
/* loaded from: classes6.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.nDM;
        long j = this.producerIndex;
        long hu = hu(j);
        if (b(eArr, hu) != null) {
            return false;
        }
        b(eArr, hu, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long hu = hu(j);
        E[] eArr = this.nDM;
        E b = b(eArr, hu);
        if (b == null) {
            return null;
        }
        b(eArr, hu, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return hv(hu(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dJX = dJX();
        while (true) {
            long dJW = dJW();
            long dJX2 = dJX();
            if (dJX == dJX2) {
                return (int) (dJW - dJX2);
            }
            dJX = dJX2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dJW() == dJX();
    }

    private void soProducerIndex(long j) {
        ae.nUR.a(this, nUL, j);
    }

    private void soConsumerIndex(long j) {
        ae.nUR.a(this, nUK, j);
    }

    private long dJW() {
        return ae.nUR.d(this, nUL);
    }

    private long dJX() {
        return ae.nUR.d(this, nUK);
    }
}
