package rx.internal.util.a;
/* loaded from: classes12.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.pKl;
        long j = this.pUH;
        long eDi = eDi();
        long iL = iL(eDi);
        if (b(eArr, iL) != null) {
            if (eDi - eDj() > j) {
                return false;
            }
            do {
            } while (b(eArr, iL) != null);
            a(eArr, iL, e);
            iN(1 + eDi);
            return true;
        }
        a(eArr, iL, e);
        iN(1 + eDi);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eDj;
        long eGn = eGn();
        do {
            eDj = eDj();
            if (eDj >= eGn) {
                long eDi = eDi();
                if (eDj >= eDi) {
                    return null;
                }
                iO(eDi);
            }
        } while (!S(eDj, 1 + eDj));
        long iL = iL(eDj);
        E[] eArr = this.pKl;
        E a2 = a(eArr, iL);
        b(eArr, iL, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E iM;
        long eGn = eGn();
        do {
            long eDj = eDj();
            if (eDj >= eGn) {
                long eDi = eDi();
                if (eDj >= eDi) {
                    return null;
                }
                iO(eDi);
            }
            iM = iM(iL(eDj));
        } while (iM == null);
        return iM;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eDj = eDj();
        while (true) {
            long eDi = eDi();
            long eDj2 = eDj();
            if (eDj == eDj2) {
                return (int) (eDi - eDj2);
            }
            eDj = eDj2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eDj() == eDi();
    }
}
