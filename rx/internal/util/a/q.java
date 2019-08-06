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
        E[] eArr = this.ksF;
        long j = this.producerIndex;
        long eZ = eZ(j);
        if (b(eArr, eZ) != null) {
            return false;
        }
        b(eArr, eZ, e);
        eX(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long eZ = eZ(j);
        E[] eArr = this.ksF;
        E b = b(eArr, eZ);
        if (b == null) {
            return null;
        }
        b(eArr, eZ, null);
        eY(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return fa(eZ(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cQw = cQw();
        while (true) {
            long cQx = cQx();
            long cQw2 = cQw();
            if (cQw == cQw2) {
                return (int) (cQx - cQw2);
            }
            cQw = cQw2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cQx() == cQw();
    }

    private void eX(long j) {
        ae.kCa.putOrderedLong(this, kBU, j);
    }

    private void eY(long j) {
        ae.kCa.putOrderedLong(this, kBT, j);
    }

    private long cQx() {
        return ae.kCa.getLongVolatile(this, kBU);
    }

    private long cQw() {
        return ae.kCa.getLongVolatile(this, kBT);
    }
}
