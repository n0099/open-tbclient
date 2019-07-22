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
        E[] eArr = this.krz;
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
        E[] eArr = this.krz;
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
        long cQb = cQb();
        while (true) {
            long cQc = cQc();
            long cQb2 = cQb();
            if (cQb == cQb2) {
                return (int) (cQc - cQb2);
            }
            cQb = cQb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cQc() == cQb();
    }

    private void eX(long j) {
        ae.kAU.putOrderedLong(this, kAO, j);
    }

    private void eY(long j) {
        ae.kAU.putOrderedLong(this, kAN, j);
    }

    private long cQc() {
        return ae.kAU.getLongVolatile(this, kAO);
    }

    private long cQb() {
        return ae.kAU.getLongVolatile(this, kAN);
    }
}
