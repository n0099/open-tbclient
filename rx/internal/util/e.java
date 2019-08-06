package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> {
    T[] kBl;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public e() {
        this(16, 0.75f);
    }

    public e(int i, float f) {
        this.loadFactor = f;
        int EX = rx.internal.util.a.h.EX(i);
        this.mask = EX - 1;
        this.maxSize = (int) (EX * f);
        this.kBl = (T[]) new Object[EX];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.kBl;
        int i = this.mask;
        int ET = ET(t.hashCode()) & i;
        T t3 = tArr[ET];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                ET = (ET + 1) & i;
                t2 = tArr[ET];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[ET] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.kBl;
        int i = this.mask;
        int ET = ET(t.hashCode()) & i;
        T t3 = tArr[ET];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(ET, tArr, i);
        }
        do {
            ET = (ET + 1) & i;
            t2 = tArr[ET];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(ET, tArr, i);
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
                int ET = ET(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= ET && ET > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < ET && ET <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public void terminate() {
        this.size = 0;
        this.kBl = (T[]) new Object[0];
    }

    void rehash() {
        T[] tArr = this.kBl;
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
                int ET = ET(tArr[i3].hashCode()) & i2;
                if (tArr2[ET] != null) {
                    do {
                        ET = (ET + 1) & i2;
                    } while (tArr2[ET] != null);
                }
                tArr2[ET] = tArr[i3];
                i4 = i5;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.kBl = tArr2;
                return;
            }
        }
    }

    static int ET(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T[] cQi() {
        return this.kBl;
    }
}
