package d.a.p0.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f64143a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64144b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64145c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64146d;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f64147a;

        /* renamed from: b  reason: collision with root package name */
        public long f64148b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f64149c;

        /* renamed from: d  reason: collision with root package name */
        public int f64150d;

        /* renamed from: e  reason: collision with root package name */
        public int f64151e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64152f;

        /* renamed from: g  reason: collision with root package name */
        public int f64153g;

        /* renamed from: h  reason: collision with root package name */
        public int f64154h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f64149c), Integer.valueOf(this.f64153g), Boolean.valueOf(this.f64152f), Integer.valueOf(this.f64147a), Long.valueOf(this.f64148b), Integer.valueOf(this.f64154h), Integer.valueOf(this.f64150d), Integer.valueOf(this.f64151e));
        }
    }

    public b(int i2, int i3, int i4, int i5) {
        this.f64143a = i2;
        this.f64144b = i3;
        this.f64145c = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.f64146d = i5;
    }

    public int a(a aVar) {
        if (aVar.f64149c != null) {
            return aVar.f64150d - aVar.f64151e;
        }
        return 0;
    }

    public boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || k(b2)) {
                return true;
            }
        }
        return false;
    }

    public abstract void c(byte[] bArr, int i2, int i3, a aVar);

    public byte[] d(String str) {
        return e(d.b(str));
    }

    public byte[] e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        c(bArr, 0, bArr.length, aVar);
        c(bArr, 0, -1, aVar);
        int i2 = aVar.f64150d;
        byte[] bArr2 = new byte[i2];
        l(bArr2, 0, i2, aVar);
        return bArr2;
    }

    public abstract void f(byte[] bArr, int i2, int i3, a aVar);

    public byte[] g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        f(bArr, 0, bArr.length, aVar);
        f(bArr, 0, -1, aVar);
        int i2 = aVar.f64150d - aVar.f64151e;
        byte[] bArr2 = new byte[i2];
        l(bArr2, 0, i2, aVar);
        return bArr2;
    }

    public byte[] h(int i2, a aVar) {
        byte[] bArr = aVar.f64149c;
        return (bArr == null || bArr.length < aVar.f64150d + i2) ? m(aVar) : bArr;
    }

    public int i() {
        return 8192;
    }

    public long j(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f64143a;
        long j = (((length + i2) - 1) / i2) * this.f64144b;
        int i3 = this.f64145c;
        return i3 > 0 ? j + ((((i3 + j) - 1) / i3) * this.f64146d) : j;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i2, int i3, a aVar) {
        if (aVar.f64149c == null) {
            return aVar.f64152f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i3);
        System.arraycopy(aVar.f64149c, aVar.f64151e, bArr, i2, min);
        int i4 = aVar.f64151e + min;
        aVar.f64151e = i4;
        if (i4 >= aVar.f64150d) {
            aVar.f64149c = null;
        }
        return min;
    }

    public final byte[] m(a aVar) {
        byte[] bArr = aVar.f64149c;
        if (bArr == null) {
            aVar.f64149c = new byte[i()];
            aVar.f64150d = 0;
            aVar.f64151e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f64149c = bArr2;
        }
        return aVar.f64149c;
    }
}
