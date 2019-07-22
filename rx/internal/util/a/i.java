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
        E[] eArr = this.krz;
        long j = this.kAM;
        long cQc = cQc();
        long eZ = eZ(cQc);
        if (b(eArr, eZ) != null) {
            if (cQc - cQb() > j) {
                return false;
            }
            do {
            } while (b(eArr, eZ) != null);
            a(eArr, eZ, e);
            fb(1 + cQc);
            return true;
        }
        a(eArr, eZ, e);
        fb(1 + cQc);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cQb;
        long cQf = cQf();
        do {
            cQb = cQb();
            if (cQb >= cQf) {
                long cQc = cQc();
                if (cQb >= cQc) {
                    return null;
                }
                fc(cQc);
            }
        } while (!A(cQb, 1 + cQb));
        long eZ = eZ(cQb);
        E[] eArr = this.krz;
        E a = a(eArr, eZ);
        b(eArr, eZ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E fa;
        long cQf = cQf();
        do {
            long cQb = cQb();
            if (cQb >= cQf) {
                long cQc = cQc();
                if (cQb >= cQc) {
                    return null;
                }
                fc(cQc);
            }
            fa = fa(eZ(cQb));
        } while (fa == null);
        return fa;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cQb = cQb();
        while (true) {
            long cQc = cQc();
            long cQb2 = cQb();
            if (cQb == cQb2) {
                return (int) (cQc - cQb2);
            }
            cQb = cQb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cQb() == cQc();
    }
}
