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
        long dCT = dCT();
        while (true) {
            long dCS = dCS();
            long dCT2 = dCT();
            if (dCT == dCT2) {
                return (int) (dCS - dCT2);
            }
            dCT = dCT2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dCS() == dCT();
    }

    private void soProducerIndex(long j) {
        ae.noE.a(this, noy, j);
    }

    private void soConsumerIndex(long j) {
        ae.noE.a(this, nox, j);
    }

    private long dCS() {
        return ae.noE.e(this, noy);
    }

    private long dCT() {
        return ae.noE.e(this, nox);
    }
}
