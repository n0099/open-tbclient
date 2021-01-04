package rx.internal.util.a;
/* loaded from: classes15.dex */
public final class q<E> extends v<E> {
    public q(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] eArr = this.qlO;
        long j = this.producerIndex;
        long jv = jv(j);
        if (b(eArr, jv) != null) {
            return false;
        }
        b(eArr, jv, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long jv = jv(j);
        E[] eArr = this.qlO;
        E b2 = b(eArr, jv);
        if (b2 == null) {
            return null;
        }
        b(eArr, jv, null);
        soConsumerIndex(j + 1);
        return b2;
    }

    @Override // java.util.Queue
    public E peek() {
        return jw(jv(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eLr = eLr();
        while (true) {
            long eLq = eLq();
            long eLr2 = eLr();
            if (eLr == eLr2) {
                return (int) (eLq - eLr2);
            }
            eLr = eLr2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eLq() == eLr();
    }

    private void soProducerIndex(long j) {
        ae.qwp.a(this, qwj, j);
    }

    private void soConsumerIndex(long j) {
        ae.qwp.a(this, qwi, j);
    }

    private long eLq() {
        return ae.qwp.e(this, qwj);
    }

    private long eLr() {
        return ae.qwp.e(this, qwi);
    }
}
