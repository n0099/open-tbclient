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
        E[] eArr = this.kuY;
        long j = this.kEk;
        long cRj = cRj();
        long fc = fc(cRj);
        if (b(eArr, fc) != null) {
            if (cRj - cRi() > j) {
                return false;
            }
            do {
            } while (b(eArr, fc) != null);
            a(eArr, fc, e);
            fe(1 + cRj);
            return true;
        }
        a(eArr, fc, e);
        fe(1 + cRj);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cRi;
        long cRm = cRm();
        do {
            cRi = cRi();
            if (cRi >= cRm) {
                long cRj = cRj();
                if (cRi >= cRj) {
                    return null;
                }
                ff(cRj);
            }
        } while (!A(cRi, 1 + cRi));
        long fc = fc(cRi);
        E[] eArr = this.kuY;
        E a = a(eArr, fc);
        b(eArr, fc, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E fd;
        long cRm = cRm();
        do {
            long cRi = cRi();
            if (cRi >= cRm) {
                long cRj = cRj();
                if (cRi >= cRj) {
                    return null;
                }
                ff(cRj);
            }
            fd = fd(fc(cRi));
        } while (fd == null);
        return fd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cRi = cRi();
        while (true) {
            long cRj = cRj();
            long cRi2 = cRi();
            if (cRi == cRi2) {
                return (int) (cRj - cRi2);
            }
            cRi = cRi2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cRi() == cRj();
    }
}
