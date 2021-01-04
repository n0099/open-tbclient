package rx.internal.util.a;
/* loaded from: classes15.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.qlO;
        long j = this.qwh;
        long eLq = eLq();
        long jv = jv(eLq);
        if (b(eArr, jv) != null) {
            if (eLq - eLr() > j) {
                return false;
            }
            do {
            } while (b(eArr, jv) != null);
            a(eArr, jv, e);
            jx(1 + eLq);
            return true;
        }
        a(eArr, jv, e);
        jx(1 + eLq);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eLr;
        long eOv = eOv();
        do {
            eLr = eLr();
            if (eLr >= eOv) {
                long eLq = eLq();
                if (eLr >= eLq) {
                    return null;
                }
                jy(eLq);
            }
        } while (!X(eLr, 1 + eLr));
        long jv = jv(eLr);
        E[] eArr = this.qlO;
        E a2 = a(eArr, jv);
        b(eArr, jv, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E jw;
        long eOv = eOv();
        do {
            long eLr = eLr();
            if (eLr >= eOv) {
                long eLq = eLq();
                if (eLr >= eLq) {
                    return null;
                }
                jy(eLq);
            }
            jw = jw(jv(eLr));
        } while (jw == null);
        return jw;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eLr = eLr();
        while (true) {
            long eLq = eLq();
            long eLr2 = eLr();
            if (eLr == eLr2) {
                return (int) (eLq - eLr2);
            }
            eLr = eLr2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eLr() == eLq();
    }
}
