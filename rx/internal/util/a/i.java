package rx.internal.util.a;
/* loaded from: classes6.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.ntA;
        long j = this.nKE;
        long dLa = dLa();
        long gw = gw(dLa);
        if (b(eArr, gw) != null) {
            if (dLa - dLb() > j) {
                return false;
            }
            do {
            } while (b(eArr, gw) != null);
            a(eArr, gw, e);
            gy(1 + dLa);
            return true;
        }
        a(eArr, gw, e);
        gy(1 + dLa);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dLb;
        long dQu = dQu();
        do {
            dLb = dLb();
            if (dLb >= dQu) {
                long dLa = dLa();
                if (dLb >= dLa) {
                    return null;
                }
                gz(dLa);
            }
        } while (!V(dLb, 1 + dLb));
        long gw = gw(dLb);
        E[] eArr = this.ntA;
        E a = a(eArr, gw);
        b(eArr, gw, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gx;
        long dQu = dQu();
        do {
            long dLb = dLb();
            if (dLb >= dQu) {
                long dLa = dLa();
                if (dLb >= dLa) {
                    return null;
                }
                gz(dLa);
            }
            gx = gx(gw(dLb));
        } while (gx == null);
        return gx;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dLb = dLb();
        while (true) {
            long dLa = dLa();
            long dLb2 = dLb();
            if (dLb == dLb2) {
                return (int) (dLa - dLb2);
            }
            dLb = dLb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dLb() == dLa();
    }
}
