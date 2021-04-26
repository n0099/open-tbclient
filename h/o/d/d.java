package h.o.d;

import h.o.d.j.i;
/* loaded from: classes7.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final float f67943a;

    /* renamed from: b  reason: collision with root package name */
    public int f67944b;

    /* renamed from: c  reason: collision with root package name */
    public int f67945c;

    /* renamed from: d  reason: collision with root package name */
    public int f67946d;

    /* renamed from: e  reason: collision with root package name */
    public T[] f67947e;

    public d() {
        this(16, 0.75f);
    }

    public static int c(int i2) {
        int i3 = i2 * (-1640531527);
        return i3 ^ (i3 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f67947e;
        int i2 = this.f67944b;
        int c2 = c(t.hashCode()) & i2;
        T t3 = tArr[c2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                c2 = (c2 + 1) & i2;
                t2 = tArr[c2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[c2] = t;
        int i3 = this.f67945c + 1;
        this.f67945c = i3;
        if (i3 >= this.f67946d) {
            d();
        }
        return true;
    }

    public boolean b() {
        return this.f67945c == 0;
    }

    public void d() {
        T[] tArr = this.f67947e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.f67945c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int c2 = c(tArr[length].hashCode()) & i3;
                if (tArr2[c2] != null) {
                    do {
                        c2 = (c2 + 1) & i3;
                    } while (tArr2[c2] != null);
                }
                tArr2[c2] = tArr[length];
                i4 = i5;
            } else {
                this.f67944b = i3;
                this.f67946d = (int) (i2 * this.f67943a);
                this.f67947e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.f67947e;
        int i2 = this.f67944b;
        int c2 = c(t.hashCode()) & i2;
        T t3 = tArr[c2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(c2, tArr, i2);
        }
        do {
            c2 = (c2 + 1) & i2;
            t2 = tArr[c2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(c2, tArr, i2);
    }

    public boolean f(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f67945c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int c2 = c(t.hashCode()) & i3;
                if (i2 > i4) {
                    if (i2 >= c2 && c2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else if (i2 < c2 && c2 <= i4) {
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public void g() {
        this.f67945c = 0;
        this.f67947e = (T[]) new Object[0];
    }

    public T[] h() {
        return this.f67947e;
    }

    public d(int i2, float f2) {
        this.f67943a = f2;
        int b2 = i.b(i2);
        this.f67944b = b2 - 1;
        this.f67946d = (int) (f2 * b2);
        this.f67947e = (T[]) new Object[b2];
    }
}
