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
        E[] eArr = this.orZ;
        long j = this.oJa;
        long efj = efj();
        long hb = hb(efj);
        if (b(eArr, hb) != null) {
            if (efj - efk() > j) {
                return false;
            }
            do {
            } while (b(eArr, hb) != null);
            a(eArr, hb, e);
            hd(1 + efj);
            return true;
        }
        a(eArr, hb, e);
        hd(1 + efj);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long efk;
        long ekF = ekF();
        do {
            efk = efk();
            if (efk >= ekF) {
                long efj = efj();
                if (efk >= efj) {
                    return null;
                }
                he(efj);
            }
        } while (!Y(efk, 1 + efk));
        long hb = hb(efk);
        E[] eArr = this.orZ;
        E a = a(eArr, hb);
        b(eArr, hb, null);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        E hc;
        long ekF = ekF();
        do {
            long efk = efk();
            if (efk >= ekF) {
                long efj = efj();
                if (efk >= efj) {
                    return null;
                }
                he(efj);
            }
            hc = hc(hb(efk));
        } while (hc == null);
        return hc;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long efk = efk();
        while (true) {
            long efj = efj();
            long efk2 = efk();
            if (efk == efk2) {
                return (int) (efj - efk2);
            }
            efk = efk2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return efk() == efj();
    }
}
