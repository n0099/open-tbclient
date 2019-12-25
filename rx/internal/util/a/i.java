package rx.internal.util.a;
/* loaded from: classes4.dex */
public final class i<E> extends m<E> {
    public i(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.mYL;
        long j = this.niT;
        long dEa = dEa();
        long gX = gX(dEa);
        if (b(eArr, gX) != null) {
            if (dEa - dEb() > j) {
                return false;
            }
            do {
            } while (b(eArr, gX) != null);
            a(eArr, gX, e);
            gZ(1 + dEa);
            return true;
        }
        a(eArr, gX, e);
        gZ(1 + dEa);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long dEb;
        long dGW = dGW();
        do {
            dEb = dEb();
            if (dEb >= dGW) {
                long dEa = dEa();
                if (dEb >= dEa) {
                    return null;
                }
                ha(dEa);
            }
        } while (!ah(dEb, 1 + dEb));
        long gX = gX(dEb);
        E[] eArr = this.mYL;
        E a = a(eArr, gX);
        b(eArr, gX, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E gY;
        long dGW = dGW();
        do {
            long dEb = dEb();
            if (dEb >= dGW) {
                long dEa = dEa();
                if (dEb >= dEa) {
                    return null;
                }
                ha(dEa);
            }
            gY = gY(gX(dEb));
        } while (gY == null);
        return gY;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dEb = dEb();
        while (true) {
            long dEa = dEa();
            long dEb2 = dEb();
            if (dEb == dEb2) {
                return (int) (dEa - dEb2);
            }
            dEb = dEb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dEb() == dEa();
    }
}
