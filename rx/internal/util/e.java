package rx.internal.util;
/* loaded from: classes14.dex */
public final class e<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] qhz;
    int size;

    public e() {
        this(16, 0.75f);
    }

    public e(int i, float f) {
        this.loadFactor = f;
        int RT = rx.internal.util.a.h.RT(i);
        this.mask = RT - 1;
        this.maxSize = (int) (RT * f);
        this.qhz = (T[]) new Object[RT];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.qhz;
        int i = this.mask;
        int RS = RS(t.hashCode()) & i;
        T t3 = tArr[RS];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                RS = (RS + 1) & i;
                t2 = tArr[RS];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[RS] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.qhz;
        int i = this.mask;
        int RS = RS(t.hashCode()) & i;
        T t3 = tArr[RS];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(RS, tArr, i);
        }
        do {
            RS = (RS + 1) & i;
            t2 = tArr[RS];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(RS, tArr, i);
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
                int RS = RS(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= RS && RS > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < RS && RS <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public void terminate() {
        this.size = 0;
        this.qhz = (T[]) new Object[0];
    }

    void rehash() {
        T[] tArr = this.qhz;
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
                int RS = RS(tArr[length].hashCode()) & i2;
                if (tArr2[RS] != null) {
                    do {
                        RS = (RS + 1) & i2;
                    } while (tArr2[RS] != null);
                }
                tArr2[RS] = tArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.qhz = tArr2;
                return;
            }
        }
    }

    static int RS(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T[] eKW() {
        return this.qhz;
    }
}
