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
        E[] eArr = this.kuY;
        long j = this.producerIndex;
        long fc = fc(j);
        if (b(eArr, fc) != null) {
            return false;
        }
        b(eArr, fc, e);
        fa(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long fc = fc(j);
        E[] eArr = this.kuY;
        E b = b(eArr, fc);
        if (b == null) {
            return null;
        }
        b(eArr, fc, null);
        fb(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return fd(fc(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cRi = cRi();
        while (true) {
            long cRj = cRj();
            long cRi2 = cRi();
            if (cRi == cRi2) {
                return (int) (cRj - cRi2);
            }
            cRi = cRi2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cRj() == cRi();
    }

    private void fa(long j) {
        ae.kEs.putOrderedLong(this, kEm, j);
    }

    private void fb(long j) {
        ae.kEs.putOrderedLong(this, kEl, j);
    }

    private long cRj() {
        return ae.kEs.getLongVolatile(this, kEm);
    }

    private long cRi() {
        return ae.kEs.getLongVolatile(this, kEl);
    }
}
