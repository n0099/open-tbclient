package rx.internal.util.a;
/* loaded from: classes5.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.orZ;
        long j = this.producerIndex;
        long hb = hb(j);
        if (b(eArr, hb) != null) {
            return false;
        }
        b(eArr, hb, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long hb = hb(j);
        E[] eArr = this.orZ;
        E b = b(eArr, hb);
        if (b == null) {
            return null;
        }
        b(eArr, hb, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return hc(hb(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long efk = efk();
        while (true) {
            long efj = efj();
            long efk2 = efk();
            if (efk == efk2) {
                return (int) (efj - efk2);
            }
            efk = efk2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return efj() == efk();
    }

    private void soProducerIndex(long j) {
        ae.oJi.a(this, oJc, j);
    }

    private void soConsumerIndex(long j) {
        ae.oJi.a(this, oJb, j);
    }

    private long efj() {
        return ae.oJi.e(this, oJc);
    }

    private long efk() {
        return ae.oJi.e(this, oJb);
    }
}
