package rx.internal.util;
/* loaded from: classes6.dex */
public final class e<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] nqJ;
    int size;

    public e() {
        this(16, 0.75f);
    }

    public e(int i, float f) {
        this.loadFactor = f;
        int JL = rx.internal.util.a.h.JL(i);
        this.mask = JL - 1;
        this.maxSize = (int) (JL * f);
        this.nqJ = (T[]) new Object[JL];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.nqJ;
        int i = this.mask;
        int JK = JK(t.hashCode()) & i;
        T t3 = tArr[JK];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                JK = (JK + 1) & i;
                t2 = tArr[JK];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[JK] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.nqJ;
        int i = this.mask;
        int JK = JK(t.hashCode()) & i;
        T t3 = tArr[JK];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(JK, tArr, i);
        }
        do {
            JK = (JK + 1) & i;
            t2 = tArr[JK];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(JK, tArr, i);
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
                int JK = JK(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= JK && JK > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < JK && JK <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public void terminate() {
        this.size = 0;
        this.nqJ = (T[]) new Object[0];
    }

    void rehash() {
        T[] tArr = this.nqJ;
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
                int JK = JK(tArr[i3].hashCode()) & i2;
                if (tArr2[JK] != null) {
                    do {
                        JK = (JK + 1) & i2;
                    } while (tArr2[JK] != null);
                }
                tArr2[JK] = tArr[i3];
                i4 = i5;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.nqJ = tArr2;
                return;
            }
        }
    }

    static int JK(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T[] dPV() {
        return this.nqJ;
    }
}
