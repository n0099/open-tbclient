package rx.internal.util.a;
/* loaded from: classes7.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.oBY;
        long j = this.oSX;
        long ejp = ejp();
        long hr = hr(ejp);
        if (b(eArr, hr) != null) {
            if (ejp - ejq() > j) {
                return false;
            }
            do {
            } while (b(eArr, hr) != null);
            a(eArr, hr, e);
            ht(1 + ejp);
            return true;
        }
        a(eArr, hr, e);
        ht(1 + ejp);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long ejq;
        long eoM = eoM();
        do {
            ejq = ejq();
            if (ejq >= eoM) {
                long ejp = ejp();
                if (ejq >= ejp) {
                    return null;
                }
                hu(ejp);
            }
        } while (!V(ejq, 1 + ejq));
        long hr = hr(ejq);
        E[] eArr = this.oBY;
        E a = a(eArr, hr);
        b(eArr, hr, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hs;
        long eoM = eoM();
        do {
            long ejq = ejq();
            if (ejq >= eoM) {
                long ejp = ejp();
                if (ejq >= ejp) {
                    return null;
                }
                hu(ejp);
            }
            hs = hs(hr(ejq));
        } while (hs == null);
        return hs;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ejq = ejq();
        while (true) {
            long ejp = ejp();
            long ejq2 = ejq();
            if (ejq == ejq2) {
                return (int) (ejp - ejq2);
            }
            ejq = ejq2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ejq() == ejp();
    }
}
