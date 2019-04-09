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
        E[] eArr = this.jRE;
        long j = this.kaU;
        long cEF = cEF();
        long er = er(cEF);
        if (b(eArr, er) != null) {
            if (cEF - cEE() > j) {
                return false;
            }
            do {
            } while (b(eArr, er) != null);
            a(eArr, er, e);
            et(1 + cEF);
            return true;
        }
        a(eArr, er, e);
        et(1 + cEF);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cEE;
        long cEI = cEI();
        do {
            cEE = cEE();
            if (cEE >= cEI) {
                long cEF = cEF();
                if (cEE >= cEF) {
                    return null;
                }
                eu(cEF);
            }
        } while (!z(cEE, 1 + cEE));
        long er = er(cEE);
        E[] eArr = this.jRE;
        E a = a(eArr, er);
        b(eArr, er, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E es;
        long cEI = cEI();
        do {
            long cEE = cEE();
            if (cEE >= cEI) {
                long cEF = cEF();
                if (cEE >= cEF) {
                    return null;
                }
                eu(cEF);
            }
            es = es(er(cEE));
        } while (es == null);
        return es;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEE = cEE();
        while (true) {
            long cEF = cEF();
            long cEE2 = cEE();
            if (cEE == cEE2) {
                return (int) (cEF - cEE2);
            }
            cEE = cEE2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEE() == cEF();
    }
}
