package h.o.d;

import h.o.d.j.i;
/* loaded from: classes7.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final float f68623a;

    /* renamed from: b  reason: collision with root package name */
    public int f68624b;

    /* renamed from: c  reason: collision with root package name */
    public int f68625c;

    /* renamed from: d  reason: collision with root package name */
    public int f68626d;

    /* renamed from: e  reason: collision with root package name */
    public T[] f68627e;

    public d() {
        this(16, 0.75f);
    }

    public static int c(int i2) {
        int i3 = i2 * (-1640531527);
        return i3 ^ (i3 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f68627e;
        int i2 = this.f68624b;
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
        int i3 = this.f68625c + 1;
        this.f68625c = i3;
        if (i3 >= this.f68626d) {
            d();
        }
        return true;
    }

    public boolean b() {
        return this.f68625c == 0;
    }

    public void d() {
        T[] tArr = this.f68627e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.f68625c;
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
                this.f68624b = i3;
                this.f68626d = (int) (i2 * this.f68623a);
                this.f68627e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.f68627e;
        int i2 = this.f68624b;
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
        this.f68625c--;
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
        this.f68625c = 0;
        this.f68627e = (T[]) new Object[0];
    }

    public T[] h() {
        return this.f68627e;
    }

    public d(int i2, float f2) {
        this.f68623a = f2;
        int b2 = i.b(i2);
        this.f68624b = b2 - 1;
        this.f68626d = (int) (f2 * b2);
        this.f68627e = (T[]) new Object[b2];
    }
}
