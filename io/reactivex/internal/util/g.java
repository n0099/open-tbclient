package io.reactivex.internal.util;
/* loaded from: classes7.dex */
public final class g<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] nrT;
    int size;

    public g() {
        this(16, 0.75f);
    }

    public g(int i, float f) {
        this.loadFactor = f;
        int JN = h.JN(i);
        this.mask = JN - 1;
        this.maxSize = (int) (JN * f);
        this.nrT = (T[]) new Object[JN];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.nrT;
        int i = this.mask;
        int JM = JM(t.hashCode()) & i;
        T t3 = tArr[JM];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                JM = (JM + 1) & i;
                t2 = tArr[JM];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[JM] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.nrT;
        int i = this.mask;
        int JM = JM(t.hashCode()) & i;
        T t3 = tArr[JM];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(JM, tArr, i);
        }
        do {
            JM = (JM + 1) & i;
            t2 = tArr[JM];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(JM, tArr, i);
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
                int JM = JM(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= JM && JM > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < JM && JM <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    void rehash() {
        T[] tArr = this.nrT;
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
                int JM = JM(tArr[i3].hashCode()) & i2;
                if (tArr2[JM] != null) {
                    do {
                        JM = (JM + 1) & i2;
                    } while (tArr2[JM] != null);
                }
                tArr2[JM] = tArr[i3];
                i4 = i5;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.nrT = tArr2;
                return;
            }
        }
    }

    static int JM(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public Object[] dLl() {
        return this.nrT;
    }

    public int size() {
        return this.size;
    }
}
