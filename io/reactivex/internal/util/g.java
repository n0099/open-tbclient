package io.reactivex.internal.util;
/* loaded from: classes3.dex */
public final class g<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] qkt;
    int size;

    public g() {
        this(16, 0.75f);
    }

    public g(int i, float f) {
        this.loadFactor = f;
        int Tk = h.Tk(i);
        this.mask = Tk - 1;
        this.maxSize = (int) (Tk * f);
        this.qkt = (T[]) new Object[Tk];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.qkt;
        int i = this.mask;
        int Tj = Tj(t.hashCode()) & i;
        T t3 = tArr[Tj];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                Tj = (Tj + 1) & i;
                t2 = tArr[Tj];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[Tj] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.qkt;
        int i = this.mask;
        int Tj = Tj(t.hashCode()) & i;
        T t3 = tArr[Tj];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(Tj, tArr, i);
        }
        do {
            Tj = (Tj + 1) & i;
            t2 = tArr[Tj];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(Tj, tArr, i);
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
                int Tj = Tj(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= Tj && Tj > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < Tj && Tj <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    void rehash() {
        T[] tArr = this.qkt;
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
                int Tj = Tj(tArr[length].hashCode()) & i2;
                if (tArr2[Tj] != null) {
                    do {
                        Tj = (Tj + 1) & i2;
                    } while (tArr2[Tj] != null);
                }
                tArr2[Tj] = tArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.qkt = tArr2;
                return;
            }
        }
    }

    static int Tj(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public Object[] eLB() {
        return this.qkt;
    }

    public int size() {
        return this.size;
    }
}
