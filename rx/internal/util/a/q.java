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
        E[] eArr = this.mXo;
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
        E[] eArr = this.mXo;
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
        long dCS = dCS();
        while (true) {
            long dCR = dCR();
            long dCS2 = dCS();
            if (dCS == dCS2) {
                return (int) (dCR - dCS2);
            }
            dCS = dCS2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dCR() == dCS();
    }

    private void soProducerIndex(long j) {
        ae.noE.a(this, noy, j);
    }

    private void soConsumerIndex(long j) {
        ae.noE.a(this, nox, j);
    }

    private long dCR() {
        return ae.noE.e(this, noy);
    }

    private long dCS() {
        return ae.noE.e(this, nox);
    }
}
