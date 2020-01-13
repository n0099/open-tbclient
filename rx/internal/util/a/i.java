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
        E[] eArr = this.nBf;
        long j = this.nRQ;
        long dIk = dIk();
        long hv = hv(dIk);
        if (b(eArr, hv) != null) {
            if (dIk - dIl() > j) {
                return false;
            }
            do {
            } while (b(eArr, hv) != null);
            a(eArr, hv, e);
            hx(1 + dIk);
            return true;
        }
        a(eArr, hv, e);
        hx(1 + dIk);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dIl;
        long dNx = dNx();
        do {
            dIl = dIl();
            if (dIl >= dNx) {
                long dIk = dIk();
                if (dIl >= dIk) {
                    return null;
                }
                hy(dIk);
            }
        } while (!am(dIl, 1 + dIl));
        long hv = hv(dIl);
        E[] eArr = this.nBf;
        E a = a(eArr, hv);
        b(eArr, hv, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hw;
        long dNx = dNx();
        do {
            long dIl = dIl();
            if (dIl >= dNx) {
                long dIk = dIk();
                if (dIl >= dIk) {
                    return null;
                }
                hy(dIk);
            }
            hw = hw(hv(dIl));
        } while (hw == null);
        return hw;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dIl = dIl();
        while (true) {
            long dIk = dIk();
            long dIl2 = dIl();
            if (dIl == dIl2) {
                return (int) (dIk - dIl2);
            }
            dIl = dIl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dIl() == dIk();
    }
}
