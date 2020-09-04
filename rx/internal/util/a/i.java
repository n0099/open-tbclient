package rx.internal.util.a;
/* loaded from: classes5.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.osr;
        long j = this.oJs;
        long efs = efs();
        long hd = hd(efs);
        if (b(eArr, hd) != null) {
            if (efs - eft() > j) {
                return false;
            }
            do {
            } while (b(eArr, hd) != null);
            a(eArr, hd, e);
            hf(1 + efs);
            return true;
        }
        a(eArr, hd, e);
        hf(1 + efs);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eft;
        long ekO = ekO();
        do {
            eft = eft();
            if (eft >= ekO) {
                long efs = efs();
                if (eft >= efs) {
                    return null;
                }
                hg(efs);
            }
        } while (!Y(eft, 1 + eft));
        long hd = hd(eft);
        E[] eArr = this.osr;
        E a = a(eArr, hd);
        b(eArr, hd, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E he;
        long ekO = ekO();
        do {
            long eft = eft();
            if (eft >= ekO) {
                long efs = efs();
                if (eft >= efs) {
                    return null;
                }
                hg(efs);
            }
            he = he(hd(eft));
        } while (he == null);
        return he;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eft = eft();
        while (true) {
            long efs = efs();
            long eft2 = eft();
            if (eft == eft2) {
                return (int) (efs - eft2);
            }
            eft = eft2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eft() == efs();
    }
}
