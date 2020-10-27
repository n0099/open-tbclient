package rx.internal.util.a;
/* loaded from: classes16.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.pIK;
        long j = this.pZG;
        long exa = exa();
        long hZ = hZ(exa);
        if (b(eArr, hZ) != null) {
            if (exa - exb() > j) {
                return false;
            }
            do {
            } while (b(eArr, hZ) != null);
            a(eArr, hZ, e);
            ib(1 + exa);
            return true;
        }
        a(eArr, hZ, e);
        ib(1 + exa);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long exb;
        long eCv = eCv();
        do {
            exb = exb();
            if (exb >= eCv) {
                long exa = exa();
                if (exb >= exa) {
                    return null;
                }
                ic(exa);
            }
        } while (!W(exb, 1 + exb));
        long hZ = hZ(exb);
        E[] eArr = this.pIK;
        E a2 = a(eArr, hZ);
        b(eArr, hZ, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E ia;
        long eCv = eCv();
        do {
            long exb = exb();
            if (exb >= eCv) {
                long exa = exa();
                if (exb >= exa) {
                    return null;
                }
                ic(exa);
            }
            ia = ia(hZ(exb));
        } while (ia == null);
        return ia;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long exb = exb();
        while (true) {
            long exa = exa();
            long exb2 = exb();
            if (exb == exb2) {
                return (int) (exa - exb2);
            }
            exb = exb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return exb() == exa();
    }
}
