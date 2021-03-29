package d.b.n0.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f64161a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64162b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64163c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64164d;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f64165a;

        /* renamed from: b  reason: collision with root package name */
        public long f64166b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f64167c;

        /* renamed from: d  reason: collision with root package name */
        public int f64168d;

        /* renamed from: e  reason: collision with root package name */
        public int f64169e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64170f;

        /* renamed from: g  reason: collision with root package name */
        public int f64171g;

        /* renamed from: h  reason: collision with root package name */
        public int f64172h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f64167c), Integer.valueOf(this.f64171g), Boolean.valueOf(this.f64170f), Integer.valueOf(this.f64165a), Long.valueOf(this.f64166b), Integer.valueOf(this.f64172h), Integer.valueOf(this.f64168d), Integer.valueOf(this.f64169e));
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.f64161a = i;
        this.f64162b = i2;
        this.f64163c = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.f64164d = i4;
    }

    public int a(a aVar) {
        if (aVar.f64167c != null) {
            return aVar.f64168d - aVar.f64169e;
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

    public abstract void c(byte[] bArr, int i, int i2, a aVar);

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
        int i = aVar.f64168d;
        byte[] bArr2 = new byte[i];
        l(bArr2, 0, i, aVar);
        return bArr2;
    }

    public abstract void f(byte[] bArr, int i, int i2, a aVar);

    public byte[] g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        f(bArr, 0, bArr.length, aVar);
        f(bArr, 0, -1, aVar);
        int i = aVar.f64168d - aVar.f64169e;
        byte[] bArr2 = new byte[i];
        l(bArr2, 0, i, aVar);
        return bArr2;
    }

    public byte[] h(int i, a aVar) {
        byte[] bArr = aVar.f64167c;
        return (bArr == null || bArr.length < aVar.f64168d + i) ? m(aVar) : bArr;
    }

    public int i() {
        return 8192;
    }

    public long j(byte[] bArr) {
        int length = bArr.length;
        int i = this.f64161a;
        long j = (((length + i) - 1) / i) * this.f64162b;
        int i2 = this.f64163c;
        return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.f64164d) : j;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i, int i2, a aVar) {
        if (aVar.f64167c == null) {
            return aVar.f64170f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i2);
        System.arraycopy(aVar.f64167c, aVar.f64169e, bArr, i, min);
        int i3 = aVar.f64169e + min;
        aVar.f64169e = i3;
        if (i3 >= aVar.f64168d) {
            aVar.f64167c = null;
        }
        return min;
    }

    public final byte[] m(a aVar) {
        byte[] bArr = aVar.f64167c;
        if (bArr == null) {
            aVar.f64167c = new byte[i()];
            aVar.f64168d = 0;
            aVar.f64169e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f64167c = bArr2;
        }
        return aVar.f64167c;
    }
}
