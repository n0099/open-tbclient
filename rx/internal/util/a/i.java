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
        E[] eArr = this.kvG;
        long j = this.kER;
        long cPo = cPo();
        long ex = ex(cPo);
        if (b(eArr, ex) != null) {
            if (cPo - cPn() > j) {
                return false;
            }
            do {
            } while (b(eArr, ex) != null);
            a(eArr, ex, e);
            ez(1 + cPo);
            return true;
        }
        a(eArr, ex, e);
        ez(1 + cPo);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cPn;
        long cPr = cPr();
        do {
            cPn = cPn();
            if (cPn >= cPr) {
                long cPo = cPo();
                if (cPn >= cPo) {
                    return null;
                }
                eA(cPo);
            }
        } while (!G(cPn, 1 + cPn));
        long ex = ex(cPn);
        E[] eArr = this.kvG;
        E a = a(eArr, ex);
        b(eArr, ex, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E ey;
        long cPr = cPr();
        do {
            long cPn = cPn();
            if (cPn >= cPr) {
                long cPo = cPo();
                if (cPn >= cPo) {
                    return null;
                }
                eA(cPo);
            }
            ey = ey(ex(cPn));
        } while (ey == null);
        return ey;
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
        return cPn() == cPo();
    }
}
