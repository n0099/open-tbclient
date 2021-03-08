package io.reactivex.internal.util;
/* loaded from: classes6.dex */
public final class g<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] qsG;
    int size;

    public g() {
        this(16, 0.75f);
    }

    public g(int i, float f) {
        this.loadFactor = f;
        int So = h.So(i);
        this.mask = So - 1;
        this.maxSize = (int) (So * f);
        this.qsG = (T[]) new Object[So];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.qsG;
        int i = this.mask;
        int Sn = Sn(t.hashCode()) & i;
        T t3 = tArr[Sn];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                Sn = (Sn + 1) & i;
                t2 = tArr[Sn];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[Sn] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.qsG;
        int i = this.mask;
        int Sn = Sn(t.hashCode()) & i;
        T t3 = tArr[Sn];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(Sn, tArr, i);
        }
        do {
            Sn = (Sn + 1) & i;
            t2 = tArr[Sn];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(Sn, tArr, i);
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
                int Sn = Sn(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= Sn && Sn > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < Sn && Sn <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    void rehash() {
        T[] tArr = this.qsG;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.size;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int Sn = Sn(tArr[length].hashCode()) & i2;
                if (tArr2[Sn] != null) {
                    do {
                        Sn = (Sn + 1) & i2;
                    } while (tArr2[Sn] != null);
                }
                tArr2[Sn] = tArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.qsG = tArr2;
                return;
            }
        }
    }

    static int Sn(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public Object[] eKv() {
        return this.qsG;
    }

    public int size() {
        return this.size;
    }
}
