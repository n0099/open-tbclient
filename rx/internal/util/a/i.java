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
        E[] eArr = this.pKj;
        long j = this.pUF;
        long eDh = eDh();
        long iL = iL(eDh);
        if (b(eArr, iL) != null) {
            if (eDh - eDi() > j) {
                return false;
            }
            do {
            } while (b(eArr, iL) != null);
            a(eArr, iL, e);
            iN(1 + eDh);
            return true;
        }
        a(eArr, iL, e);
        iN(1 + eDh);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eDi;
        long eGm = eGm();
        do {
            eDi = eDi();
            if (eDi >= eGm) {
                long eDh = eDh();
                if (eDi >= eDh) {
                    return null;
                }
                iO(eDh);
            }
        } while (!S(eDi, 1 + eDi));
        long iL = iL(eDi);
        E[] eArr = this.pKj;
        E a2 = a(eArr, iL);
        b(eArr, iL, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E iM;
        long eGm = eGm();
        do {
            long eDi = eDi();
            if (eDi >= eGm) {
                long eDh = eDh();
                if (eDi >= eDh) {
                    return null;
                }
                iO(eDh);
            }
            iM = iM(iL(eDi));
        } while (iM == null);
        return iM;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eDi = eDi();
        while (true) {
            long eDh = eDh();
            long eDi2 = eDi();
            if (eDi == eDi2) {
                return (int) (eDh - eDi2);
            }
            eDi = eDi2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eDi() == eDh();
    }
}
