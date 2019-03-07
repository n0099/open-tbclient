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
        E[] eArr = this.jSa;
        long j = this.producerIndex;
        long es = es(j);
        if (b(eArr, es) != null) {
            return false;
        }
        b(eArr, es, e);
        eq(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex;
        long es = es(j);
        E[] eArr = this.jSa;
        E b = b(eArr, es);
        if (b == null) {
            return null;
        }
        b(eArr, es, null);
        er(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return et(es(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEC = cEC();
        while (true) {
            long cED = cED();
            long cEC2 = cEC();
            if (cEC == cEC2) {
                return (int) (cED - cEC2);
            }
            cEC = cEC2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cED() == cEC();
    }

    private void eq(long j) {
        ae.kby.putOrderedLong(this, kbs, j);
    }

    private void er(long j) {
        ae.kby.putOrderedLong(this, kbr, j);
    }

    private long cED() {
        return ae.kby.getLongVolatile(this, kbs);
    }

    private long cEC() {
        return ae.kby.getLongVolatile(this, kbr);
    }
}
