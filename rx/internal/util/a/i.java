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
        E[] eArr = this.ksF;
        long j = this.kBS;
        long cQx = cQx();
        long eZ = eZ(cQx);
        if (b(eArr, eZ) != null) {
            if (cQx - cQw() > j) {
                return false;
            }
            do {
            } while (b(eArr, eZ) != null);
            a(eArr, eZ, e);
            fb(1 + cQx);
            return true;
        }
        a(eArr, eZ, e);
        fb(1 + cQx);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cQw;
        long cQA = cQA();
        do {
            cQw = cQw();
            if (cQw >= cQA) {
                long cQx = cQx();
                if (cQw >= cQx) {
                    return null;
                }
                fc(cQx);
            }
        } while (!A(cQw, 1 + cQw));
        long eZ = eZ(cQw);
        E[] eArr = this.ksF;
        E a = a(eArr, eZ);
        b(eArr, eZ, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E fa;
        long cQA = cQA();
        do {
            long cQw = cQw();
            if (cQw >= cQA) {
                long cQx = cQx();
                if (cQw >= cQx) {
                    return null;
                }
                fc(cQx);
            }
            fa = fa(eZ(cQw));
        } while (fa == null);
        return fa;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cQw = cQw();
        while (true) {
            long cQx = cQx();
            long cQw2 = cQw();
            if (cQw == cQw2) {
                return (int) (cQx - cQw2);
            }
            cQw = cQw2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cQw() == cQx();
    }
}
