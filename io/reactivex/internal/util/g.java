package io.reactivex.internal.util;
/* loaded from: classes4.dex */
public final class g<T> {
    final float loadFactor;
    T[] mXn;
    int mask;
    int maxSize;
    int size;

    public g() {
        this(16, 0.75f);
    }

    public g(int i, float f) {
        this.loadFactor = f;
        int MK = h.MK(i);
        this.mask = MK - 1;
        this.maxSize = (int) (MK * f);
        this.mXn = (T[]) new Object[MK];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.mXn;
        int i = this.mask;
        int MJ = MJ(t.hashCode()) & i;
        T t3 = tArr[MJ];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                MJ = (MJ + 1) & i;
                t2 = tArr[MJ];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[MJ] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.mXn;
        int i = this.mask;
        int MJ = MJ(t.hashCode()) & i;
        T t3 = tArr[MJ];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(MJ, tArr, i);
        }
        do {
            MJ = (MJ + 1) & i;
            t2 = tArr[MJ];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(MJ, tArr, i);
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
                int MJ = MJ(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= MJ && MJ > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < MJ && MJ <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    void rehash() {
        T[] tArr = this.mXn;
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
                int MJ = MJ(tArr[i3].hashCode()) & i2;
                if (tArr2[MJ] != null) {
                    do {
                        MJ = (MJ + 1) & i2;
                    } while (tArr2[MJ] != null);
                }
                tArr2[MJ] = tArr[i3];
                i4 = i5;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.mXn = tArr2;
                return;
            }
        }
    }

    static int MJ(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public Object[] dEl() {
        return this.mXn;
    }

    public int size() {
        return this.size;
    }
}
