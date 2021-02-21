package rx.internal.util;
/* loaded from: classes5.dex */
public final class e<T> {
    final float loadFactor;
    int mask;
    int maxSize;
    T[] qse;
    int size;

    public e() {
        this(16, 0.75f);
    }

    public e(int i, float f) {
        this.loadFactor = f;
        int Sp = rx.internal.util.a.h.Sp(i);
        this.mask = Sp - 1;
        this.maxSize = (int) (Sp * f);
        this.qse = (T[]) new Object[Sp];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.qse;
        int i = this.mask;
        int So = So(t.hashCode()) & i;
        T t3 = tArr[So];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                So = (So + 1) & i;
                t2 = tArr[So];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[So] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.qse;
        int i = this.mask;
        int So = So(t.hashCode()) & i;
        T t3 = tArr[So];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(So, tArr, i);
        }
        do {
            So = (So + 1) & i;
            t2 = tArr[So];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(So, tArr, i);
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
                int So = So(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= So && So > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < So && So <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public void terminate() {
        this.size = 0;
        this.qse = (T[]) new Object[0];
    }

    void rehash() {
        T[] tArr = this.qse;
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
                int So = So(tArr[length].hashCode()) & i2;
                if (tArr2[So] != null) {
                    do {
                        So = (So + 1) & i2;
                    } while (tArr2[So] != null);
                }
                tArr2[So] = tArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.qse = tArr2;
                return;
            }
        }
    }

    static int So(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T[] eNu() {
        return this.qse;
    }
}
