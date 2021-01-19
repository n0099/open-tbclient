package rx.internal.util.a;
/* loaded from: classes14.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.qiV;
        long j = this.qto;
        long eIe = eIe();
        long jy = jy(eIe);
        if (b(eArr, jy) != null) {
            if (eIe - eIf() > j) {
                return false;
            }
            do {
            } while (b(eArr, jy) != null);
            a(eArr, jy, e);
            jA(1 + eIe);
            return true;
        }
        a(eArr, jy, e);
        jA(1 + eIe);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eIf;
        long eLj = eLj();
        do {
            eIf = eIf();
            if (eIf >= eLj) {
                long eIe = eIe();
                if (eIf >= eIe) {
                    return null;
                }
                jB(eIe);
            }
        } while (!Y(eIf, 1 + eIf));
        long jy = jy(eIf);
        E[] eArr = this.qiV;
        E a2 = a(eArr, jy);
        b(eArr, jy, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E jz;
        long eLj = eLj();
        do {
            long eIf = eIf();
            if (eIf >= eLj) {
                long eIe = eIe();
                if (eIf >= eIe) {
                    return null;
                }
                jB(eIe);
            }
            jz = jz(jy(eIf));
        } while (jz == null);
        return jz;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eIf = eIf();
        while (true) {
            long eIe = eIe();
            long eIf2 = eIf();
            if (eIf == eIf2) {
                return (int) (eIe - eIf2);
            }
            eIf = eIf2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eIf() == eIe();
    }
}
