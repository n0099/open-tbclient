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
        E[] eArr = this.jSa;
        long j = this.kbq;
        long cED = cED();
        long es = es(cED);
        if (b(eArr, es) != null) {
            if (cED - cEC() > j) {
                return false;
            }
            do {
            } while (b(eArr, es) != null);
            a(eArr, es, e);
            eu(1 + cED);
            return true;
        }
        a(eArr, es, e);
        eu(1 + cED);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long cEC;
        long cEG = cEG();
        do {
            cEC = cEC();
            if (cEC >= cEG) {
                long cED = cED();
                if (cEC >= cED) {
                    return null;
                }
                ev(cED);
            }
        } while (!z(cEC, 1 + cEC));
        long es = es(cEC);
        E[] eArr = this.jSa;
        E a = a(eArr, es);
        b(eArr, es, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E et;
        long cEG = cEG();
        do {
            long cEC = cEC();
            if (cEC >= cEG) {
                long cED = cED();
                if (cEC >= cED) {
                    return null;
                }
                ev(cED);
            }
            et = et(es(cEC));
        } while (et == null);
        return et;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEC = cEC();
        while (true) {
            long cED = cED();
            long cEC2 = cEC();
            if (cEC == cEC2) {
                return (int) (cED - cEC2);
            }
            cEC = cEC2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEC() == cED();
    }
}
