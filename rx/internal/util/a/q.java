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
        E[] eArr = this.osr;
        long j = this.producerIndex;
        long hd = hd(j);
        if (b(eArr, hd) != null) {
            return false;
        }
        b(eArr, hd, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long hd = hd(j);
        E[] eArr = this.osr;
        E b = b(eArr, hd);
        if (b == null) {
            return null;
        }
        b(eArr, hd, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return he(hd(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eft = eft();
        while (true) {
            long efs = efs();
            long eft2 = eft();
            if (eft == eft2) {
                return (int) (efs - eft2);
            }
            eft = eft2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return efs() == eft();
    }

    private void soProducerIndex(long j) {
        ae.oJA.a(this, oJu, j);
    }

    private void soConsumerIndex(long j) {
        ae.oJA.a(this, oJt, j);
    }

    private long efs() {
        return ae.oJA.e(this, oJu);
    }

    private long eft() {
        return ae.oJA.e(this, oJt);
    }
}
