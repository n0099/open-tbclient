package rx.internal.util;
/* loaded from: classes2.dex */
public final class f<T> {
    T[] iDc;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public f() {
        this(16, 0.75f);
    }

    public f(int i, float f) {
        this.loadFactor = f;
        int yE = rx.internal.util.a.h.yE(i);
        this.mask = yE - 1;
        this.maxSize = (int) (yE * f);
        this.iDc = (T[]) new Object[yE];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.iDc;
        int i = this.mask;
        int yA = yA(t.hashCode()) & i;
        T t3 = tArr[yA];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                yA = (yA + 1) & i;
                t2 = tArr[yA];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[yA] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.iDc;
        int i = this.mask;
        int yA = yA(t.hashCode()) & i;
        T t3 = tArr[yA];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return b(yA, tArr, i);
        }
        do {
            yA = (yA + 1) & i;
            t2 = tArr[yA];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return b(yA, tArr, i);
    }

    boolean b(int i, T[] tArr, int i2) {
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
                int yA = yA(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= yA && yA > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < yA && yA <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public void terminate() {
        this.size = 0;
        this.iDc = (T[]) new Object[0];
    }

    void rehash() {
        T[] tArr = this.iDc;
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
                int yA = yA(tArr[i3].hashCode()) & i2;
                if (tArr2[yA] != null) {
                    do {
                        yA = (yA + 1) & i2;
                    } while (tArr2[yA] != null);
                }
                tArr2[yA] = tArr[i3];
                i4 = i5;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.iDc = tArr2;
                return;
            }
        }
    }

    static int yA(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T[] ccO() {
        return this.iDc;
    }
}
