package f.b.x.i;
/* loaded from: classes7.dex */
public final class g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final float f68540a;

    /* renamed from: b  reason: collision with root package name */
    public int f68541b;

    /* renamed from: c  reason: collision with root package name */
    public int f68542c;

    /* renamed from: d  reason: collision with root package name */
    public int f68543d;

    /* renamed from: e  reason: collision with root package name */
    public T[] f68544e;

    public g() {
        this(16, 0.75f);
    }

    public static int c(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f68544e;
        int i = this.f68541b;
        int c2 = c(t.hashCode()) & i;
        T t3 = tArr[c2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                c2 = (c2 + 1) & i;
                t2 = tArr[c2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[c2] = t;
        int i2 = this.f68542c + 1;
        this.f68542c = i2;
        if (i2 >= this.f68543d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f68544e;
    }

    public void d() {
        T[] tArr = this.f68544e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f68542c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int c2 = c(tArr[length].hashCode()) & i2;
                if (tArr2[c2] != null) {
                    do {
                        c2 = (c2 + 1) & i2;
                    } while (tArr2[c2] != null);
                }
                tArr2[c2] = tArr[length];
                i3 = i4;
            } else {
                this.f68541b = i2;
                this.f68543d = (int) (i * this.f68540a);
                this.f68544e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.f68544e;
        int i = this.f68541b;
        int c2 = c(t.hashCode()) & i;
        T t3 = tArr[c2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(c2, tArr, i);
        }
        do {
            c2 = (c2 + 1) & i;
            t2 = tArr[c2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(c2, tArr, i);
    }

    public boolean f(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f68542c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int c2 = c(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= c2 && c2 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < c2 && c2 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public int g() {
        return this.f68542c;
    }

    public g(int i, float f2) {
        this.f68540a = f2;
        int a2 = h.a(i);
        this.f68541b = a2 - 1;
        this.f68543d = (int) (f2 * a2);
        this.f68544e = (T[]) new Object[a2];
    }
}
