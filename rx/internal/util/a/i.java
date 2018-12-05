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
        long ceC = ceC();
        long dQ = dQ(ceC);
        if (b(eArr, dQ) != null) {
            if (ceC - ceB() > j) {
                return false;
            }
            do {
            } while (b(eArr, dQ) != null);
            a(eArr, dQ, e);
            dS(1 + ceC);
            return true;
        }
        a(eArr, dQ, e);
        dS(1 + ceC);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long ceB;
        long ceF = ceF();
        do {
            ceB = ceB();
            if (ceB >= ceF) {
                long ceC = ceC();
                if (ceB >= ceC) {
                    return null;
                }
                dT(ceC);
            }
        } while (!u(ceB, 1 + ceB));
        long dQ = dQ(ceB);
        E[] eArr = this.ixX;
        E a = a(eArr, dQ);
        b(eArr, dQ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E dR;
        long ceF = ceF();
        do {
            long ceB = ceB();
            if (ceB >= ceF) {
                long ceC = ceC();
                if (ceB >= ceC) {
                    return null;
                }
                dT(ceC);
            }
            dR = dR(dQ(ceB));
        } while (dR == null);
        return dR;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ceB = ceB();
        while (true) {
            long ceC = ceC();
            long ceB2 = ceB();
            if (ceB == ceB2) {
                return (int) (ceC - ceB2);
            }
            ceB = ceB2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ceB() == ceC();
    }
}
