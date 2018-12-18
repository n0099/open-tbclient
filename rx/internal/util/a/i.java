package rx.internal.util.a;
/* loaded from: classes2.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.ixX;
        long j = this.iMB;
        long ceB = ceB();
        long dQ = dQ(ceB);
        if (b(eArr, dQ) != null) {
            if (ceB - ceA() > j) {
                return false;
            }
            do {
            } while (b(eArr, dQ) != null);
            a(eArr, dQ, e);
            dS(1 + ceB);
            return true;
        }
        a(eArr, dQ, e);
        dS(1 + ceB);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long ceA;
        long ceE = ceE();
        do {
            ceA = ceA();
            if (ceA >= ceE) {
                long ceB = ceB();
                if (ceA >= ceB) {
                    return null;
                }
                dT(ceB);
            }
        } while (!u(ceA, 1 + ceA));
        long dQ = dQ(ceA);
        E[] eArr = this.ixX;
        E a = a(eArr, dQ);
        b(eArr, dQ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E dR;
        long ceE = ceE();
        do {
            long ceA = ceA();
            if (ceA >= ceE) {
                long ceB = ceB();
                if (ceA >= ceB) {
                    return null;
                }
                dT(ceB);
            }
            dR = dR(dQ(ceA));
        } while (dR == null);
        return dR;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ceA = ceA();
        while (true) {
            long ceB = ceB();
            long ceA2 = ceA();
            if (ceA == ceA2) {
                return (int) (ceB - ceA2);
            }
            ceA = ceA2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ceA() == ceB();
    }
}
