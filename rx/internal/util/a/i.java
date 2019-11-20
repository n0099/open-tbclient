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
        E[] eArr = this.kuP;
        long j = this.kEa;
        long cPm = cPm();
        long ew = ew(cPm);
        if (b(eArr, ew) != null) {
            if (cPm - cPl() > j) {
                return false;
            }
            do {
            } while (b(eArr, ew) != null);
            a(eArr, ew, e);
            ey(1 + cPm);
            return true;
        }
        a(eArr, ew, e);
        ey(1 + cPm);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cPl;
        long cPp = cPp();
        do {
            cPl = cPl();
            if (cPl >= cPp) {
                long cPm = cPm();
                if (cPl >= cPm) {
                    return null;
                }
                ez(cPm);
            }
        } while (!G(cPl, 1 + cPl));
        long ew = ew(cPl);
        E[] eArr = this.kuP;
        E a = a(eArr, ew);
        b(eArr, ew, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E ex;
        long cPp = cPp();
        do {
            long cPl = cPl();
            if (cPl >= cPp) {
                long cPm = cPm();
                if (cPl >= cPm) {
                    return null;
                }
                ez(cPm);
            }
            ex = ex(ew(cPl));
        } while (ex == null);
        return ex;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cPl = cPl();
        while (true) {
            long cPm = cPm();
            long cPl2 = cPl();
            if (cPl == cPl2) {
                return (int) (cPm - cPl2);
            }
            cPl = cPl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cPl() == cPm();
    }
}
