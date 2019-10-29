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
        E[] eArr = this.kvG;
        long j = this.producerIndex;
        long ex = ex(j);
        if (b(eArr, ex) != null) {
            return false;
        }
        b(eArr, ex, e);
        ev(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long ex = ex(j);
        E[] eArr = this.kvG;
        E b = b(eArr, ex);
        if (b == null) {
            return null;
        }
        b(eArr, ex, null);
        ew(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return ey(ex(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cPn = cPn();
        while (true) {
            long cPo = cPo();
            long cPn2 = cPn();
            if (cPn == cPn2) {
                return (int) (cPo - cPn2);
            }
            cPn = cPn2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cPo() == cPn();
    }

    private void ev(long j) {
        ae.kEZ.putOrderedLong(this, kET, j);
    }

    private void ew(long j) {
        ae.kEZ.putOrderedLong(this, kES, j);
    }

    private long cPo() {
        return ae.kEZ.getLongVolatile(this, kET);
    }

    private long cPn() {
        return ae.kEZ.getLongVolatile(this, kES);
    }
}
