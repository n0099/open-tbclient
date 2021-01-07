package io.reactivex.internal.util;
/* loaded from: classes5.dex */
public final class g<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] qmb;
    int size;

    public g() {
        this(16, 0.75f);
    }

    public g(int i, float f) {
        this.loadFactor = f;
        int TA = h.TA(i);
        this.mask = TA - 1;
        this.maxSize = (int) (TA * f);
        this.qmb = (T[]) new Object[TA];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.qmb;
        int i = this.mask;
        int Tz = Tz(t.hashCode()) & i;
        T t3 = tArr[Tz];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                Tz = (Tz + 1) & i;
                t2 = tArr[Tz];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[Tz] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.qmb;
        int i = this.mask;
        int Tz = Tz(t.hashCode()) & i;
        T t3 = tArr[Tz];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(Tz, tArr, i);
        }
        do {
            Tz = (Tz + 1) & i;
            t2 = tArr[Tz];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(Tz, tArr, i);
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
                int Tz = Tz(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= Tz && Tz > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < Tz && Tz <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    void rehash() {
        T[] tArr = this.qmb;
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
                int Tz = Tz(tArr[length].hashCode()) & i2;
                if (tArr2[Tz] != null) {
                    do {
                        Tz = (Tz + 1) & i2;
                    } while (tArr2[Tz] != null);
                }
                tArr2[Tz] = tArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.qmb = tArr2;
                return;
            }
        }
    }

    static int Tz(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public Object[] eMf() {
        return this.qmb;
    }

    public int size() {
        return this.size;
    }
}
