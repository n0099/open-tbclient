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
        E[] eArr = this.iCp;
        long j = this.iQT;
        long cga = cga();
        long dV = dV(cga);
        if (b(eArr, dV) != null) {
            if (cga - cfZ() > j) {
                return false;
            }
            do {
            } while (b(eArr, dV) != null);
            a(eArr, dV, e);
            dX(1 + cga);
            return true;
        }
        a(eArr, dV, e);
        dX(1 + cga);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cfZ;
        long cgd = cgd();
        do {
            cfZ = cfZ();
            if (cfZ >= cgd) {
                long cga = cga();
                if (cfZ >= cga) {
                    return null;
                }
                dY(cga);
            }
        } while (!u(cfZ, 1 + cfZ));
        long dV = dV(cfZ);
        E[] eArr = this.iCp;
        E a = a(eArr, dV);
        b(eArr, dV, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E dW;
        long cgd = cgd();
        do {
            long cfZ = cfZ();
            if (cfZ >= cgd) {
                long cga = cga();
                if (cfZ >= cga) {
                    return null;
                }
                dY(cga);
            }
            dW = dW(dV(cfZ));
        } while (dW == null);
        return dW;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cfZ = cfZ();
        while (true) {
            long cga = cga();
            long cfZ2 = cfZ();
            if (cfZ == cfZ2) {
                return (int) (cga - cfZ2);
            }
            cfZ = cfZ2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cfZ() == cga();
    }
}
