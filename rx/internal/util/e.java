package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> {
    T[] ksC;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public e() {
        this(16, 0.75f);
    }

    public e(int i, float f) {
        this.loadFactor = f;
        int Em = rx.internal.util.a.h.Em(i);
        this.mask = Em - 1;
        this.maxSize = (int) (Em * f);
        this.ksC = (T[]) new Object[Em];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.ksC;
        int i = this.mask;
        int Ei = Ei(t.hashCode()) & i;
        T t3 = tArr[Ei];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                Ei = (Ei + 1) & i;
                t2 = tArr[Ei];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[Ei] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.ksC;
        int i = this.mask;
        int Ei = Ei(t.hashCode()) & i;
        T t3 = tArr[Ei];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(Ei, tArr, i);
        }
        do {
            Ei = (Ei + 1) & i;
            t2 = tArr[Ei];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(Ei, tArr, i);
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
                int Ei = Ei(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= Ei && Ei > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < Ei && Ei <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public void terminate() {
        this.size = 0;
        this.ksC = (T[]) new Object[0];
    }

    void rehash() {
        T[] tArr = this.ksC;
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
                int Ei = Ei(tArr[i3].hashCode()) & i2;
                if (tArr2[Ei] != null) {
                    do {
                        Ei = (Ei + 1) & i2;
                    } while (tArr2[Ei] != null);
                }
                tArr2[Ei] = tArr[i3];
                i4 = i5;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.ksC = tArr2;
                return;
            }
        }
    }

    static int Ei(int i) {
        int i2 = (-1640531527) * i;
        return i2 ^ (i2 >>> 16);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T[] cLX() {
        return this.ksC;
    }
}
