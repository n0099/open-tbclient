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
        E[] eArr = this.oRn;
        long j = this.piq;
        long ena = ena();
        long hJ = hJ(ena);
        if (b(eArr, hJ) != null) {
            if (ena - enb() > j) {
                return false;
            }
            do {
            } while (b(eArr, hJ) != null);
            a(eArr, hJ, e);
            hL(1 + ena);
            return true;
        }
        a(eArr, hJ, e);
        hL(1 + ena);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long enb;
        long esx = esx();
        do {
            enb = enb();
            if (enb >= esx) {
                long ena = ena();
                if (enb >= ena) {
                    return null;
                }
                hM(ena);
            }
        } while (!V(enb, 1 + enb));
        long hJ = hJ(enb);
        E[] eArr = this.oRn;
        E a2 = a(eArr, hJ);
        b(eArr, hJ, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E hK;
        long esx = esx();
        do {
            long enb = enb();
            if (enb >= esx) {
                long ena = ena();
                if (enb >= ena) {
                    return null;
                }
                hM(ena);
            }
            hK = hK(hJ(enb));
        } while (hK == null);
        return hK;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long enb = enb();
        while (true) {
            long ena = ena();
            long enb2 = enb();
            if (enb == enb2) {
                return (int) (ena - enb2);
            }
            enb = enb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return enb() == ena();
    }
}
