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
        E[] eArr = this.qnw;
        long j = this.qxP;
        long eLU = eLU();
        long jy = jy(eLU);
        if (b(eArr, jy) != null) {
            if (eLU - eLV() > j) {
                return false;
            }
            do {
            } while (b(eArr, jy) != null);
            a(eArr, jy, e);
            jA(1 + eLU);
            return true;
        }
        a(eArr, jy, e);
        jA(1 + eLU);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long eLV;
        long eOZ = eOZ();
        do {
            eLV = eLV();
            if (eLV >= eOZ) {
                long eLU = eLU();
                if (eLV >= eLU) {
                    return null;
                }
                jB(eLU);
            }
        } while (!Y(eLV, 1 + eLV));
        long jy = jy(eLV);
        E[] eArr = this.qnw;
        E a2 = a(eArr, jy);
        b(eArr, jy, null);
        return a2;
    }

    @Override // java.util.Queue
    public E peek() {
        E jz;
        long eOZ = eOZ();
        do {
            long eLV = eLV();
            if (eLV >= eOZ) {
                long eLU = eLU();
                if (eLV >= eLU) {
                    return null;
                }
                jB(eLU);
            }
            jz = jz(jy(eLV));
        } while (jz == null);
        return jz;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long eLV = eLV();
        while (true) {
            long eLU = eLU();
            long eLV2 = eLV();
            if (eLV == eLV2) {
                return (int) (eLU - eLV2);
            }
            eLV = eLV2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return eLV() == eLU();
    }
}
