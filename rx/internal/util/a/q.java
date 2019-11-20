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
        E[] eArr = this.kuP;
        long j = this.producerIndex;
        long ew = ew(j);
        if (b(eArr, ew) != null) {
            return false;
        }
        b(eArr, ew, e);
        eu(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long ew = ew(j);
        E[] eArr = this.kuP;
        E b = b(eArr, ew);
        if (b == null) {
            return null;
        }
        b(eArr, ew, null);
        ev(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return ex(ew(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cPl = cPl();
        while (true) {
            long cPm = cPm();
            long cPl2 = cPl();
            if (cPl == cPl2) {
                return (int) (cPm - cPl2);
            }
            cPl = cPl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cPm() == cPl();
    }

    private void eu(long j) {
        ae.kEi.putOrderedLong(this, kEc, j);
    }

    private void ev(long j) {
        ae.kEi.putOrderedLong(this, kEb, j);
    }

    private long cPm() {
        return ae.kEi.getLongVolatile(this, kEc);
    }

    private long cPl() {
        return ae.kEi.getLongVolatile(this, kEb);
    }
}
