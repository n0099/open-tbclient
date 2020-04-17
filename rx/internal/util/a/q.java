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
        E[] eArr = this.mXl;
        long j = this.producerIndex;
        long gv = gv(j);
        if (b(eArr, gv) != null) {
            return false;
        }
        b(eArr, gv, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long gv = gv(j);
        E[] eArr = this.mXl;
        E b = b(eArr, gv);
        if (b == null) {
            return null;
        }
        b(eArr, gv, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return gw(gv(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dCW = dCW();
        while (true) {
            long dCV = dCV();
            long dCW2 = dCW();
            if (dCW == dCW2) {
                return (int) (dCV - dCW2);
            }
            dCW = dCW2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dCV() == dCW();
    }

    private void soProducerIndex(long j) {
        ae.noB.a(this, nou, j);
    }

    private void soConsumerIndex(long j) {
        ae.noB.a(this, nos, j);
    }

    private long dCV() {
        return ae.noB.e(this, nou);
    }

    private long dCW() {
        return ae.noB.e(this, nos);
    }
}
