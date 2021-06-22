package d.a.t0.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f68454a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68455b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68456c;

    /* renamed from: d  reason: collision with root package name */
    public final int f68457d;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f68458a;

        /* renamed from: b  reason: collision with root package name */
        public long f68459b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f68460c;

        /* renamed from: d  reason: collision with root package name */
        public int f68461d;

        /* renamed from: e  reason: collision with root package name */
        public int f68462e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68463f;

        /* renamed from: g  reason: collision with root package name */
        public int f68464g;

        /* renamed from: h  reason: collision with root package name */
        public int f68465h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f68460c), Integer.valueOf(this.f68464g), Boolean.valueOf(this.f68463f), Integer.valueOf(this.f68458a), Long.valueOf(this.f68459b), Integer.valueOf(this.f68465h), Integer.valueOf(this.f68461d), Integer.valueOf(this.f68462e));
        }
    }

    public b(int i2, int i3, int i4, int i5) {
        this.f68454a = i2;
        this.f68455b = i3;
        this.f68456c = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.f68457d = i5;
    }

    public int a(a aVar) {
        if (aVar.f68460c != null) {
            return aVar.f68461d - aVar.f68462e;
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
        int i2 = aVar.f68461d;
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
        int i2 = aVar.f68461d - aVar.f68462e;
        byte[] bArr2 = new byte[i2];
        l(bArr2, 0, i2, aVar);
        return bArr2;
    }

    public byte[] h(int i2, a aVar) {
        byte[] bArr = aVar.f68460c;
        return (bArr == null || bArr.length < aVar.f68461d + i2) ? m(aVar) : bArr;
    }

    public int i() {
        return 8192;
    }

    public long j(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f68454a;
        long j = (((length + i2) - 1) / i2) * this.f68455b;
        int i3 = this.f68456c;
        return i3 > 0 ? j + ((((i3 + j) - 1) / i3) * this.f68457d) : j;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i2, int i3, a aVar) {
        if (aVar.f68460c == null) {
            return aVar.f68463f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i3);
        System.arraycopy(aVar.f68460c, aVar.f68462e, bArr, i2, min);
        int i4 = aVar.f68462e + min;
        aVar.f68462e = i4;
        if (i4 >= aVar.f68461d) {
            aVar.f68460c = null;
        }
        return min;
    }

    public final byte[] m(a aVar) {
        byte[] bArr = aVar.f68460c;
        if (bArr == null) {
            aVar.f68460c = new byte[i()];
            aVar.f68461d = 0;
            aVar.f68462e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f68460c = bArr2;
        }
        return aVar.f68460c;
    }
}
