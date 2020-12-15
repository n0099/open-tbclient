package rx.internal.util;
/* loaded from: classes12.dex */
public final class e<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] pIQ;
    int size;

    public e() {
        this(16, 0.75f);
    }

    public e(int i, float f) {
        this.loadFactor = f;
        int RR = rx.internal.util.a.h.RR(i);
        this.mask = RR - 1;
        this.maxSize = (int) (RR * f);
        this.pIQ = (T[]) new Object[RR];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.pIQ;
        int i = this.mask;
        int RQ = RQ(t.hashCode()) & i;
        T t3 = tArr[RQ];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                RQ = (RQ + 1) & i;
                t2 = tArr[RQ];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[RQ] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.pIQ;
        int i = this.mask;
        int RQ = RQ(t.hashCode()) & i;
        T t3 = tArr[RQ];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(RQ, tArr, i);
        }
        do {
            RQ = (RQ + 1) & i;
            t2 = tArr[RQ];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(RQ, tArr, i);
    }

    boolean a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.size--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int RQ = RQ(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= RQ && RQ > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < RQ && RQ <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public void terminate() {
        this.size = 0;
        this.pIQ = (T[]) new Object[0];
    }

    void rehash() {
        T[] tArr = this.pIQ;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = length;
        int i4 = this.size;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    i3--;
                } while (tArr[i3] == null);
                int RQ = RQ(tArr[i3].hashCode()) & i2;
                if (tArr2[RQ] != null) {
                    do {
                        RQ = (RQ + 1) & i2;
                    } while (tArr2[RQ] != null);
                }
                tArr2[RQ] = tArr[i3];
                i4 = i5;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.pIQ = tArr2;
                return;
            }
        }
    }

    static int RQ(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T[] eGa() {
        return this.pIQ;
    }
}
