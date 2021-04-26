package d.a.o0.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f63456a;

    /* renamed from: b  reason: collision with root package name */
    public final int f63457b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63458c;

    /* renamed from: d  reason: collision with root package name */
    public final int f63459d;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f63460a;

        /* renamed from: b  reason: collision with root package name */
        public long f63461b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f63462c;

        /* renamed from: d  reason: collision with root package name */
        public int f63463d;

        /* renamed from: e  reason: collision with root package name */
        public int f63464e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63465f;

        /* renamed from: g  reason: collision with root package name */
        public int f63466g;

        /* renamed from: h  reason: collision with root package name */
        public int f63467h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f63462c), Integer.valueOf(this.f63466g), Boolean.valueOf(this.f63465f), Integer.valueOf(this.f63460a), Long.valueOf(this.f63461b), Integer.valueOf(this.f63467h), Integer.valueOf(this.f63463d), Integer.valueOf(this.f63464e));
        }
    }

    public b(int i2, int i3, int i4, int i5) {
        this.f63456a = i2;
        this.f63457b = i3;
        this.f63458c = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.f63459d = i5;
    }

    public int a(a aVar) {
        if (aVar.f63462c != null) {
            return aVar.f63463d - aVar.f63464e;
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
        int i2 = aVar.f63463d;
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
        int i2 = aVar.f63463d - aVar.f63464e;
        byte[] bArr2 = new byte[i2];
        l(bArr2, 0, i2, aVar);
        return bArr2;
    }

    public byte[] h(int i2, a aVar) {
        byte[] bArr = aVar.f63462c;
        return (bArr == null || bArr.length < aVar.f63463d + i2) ? m(aVar) : bArr;
    }

    public int i() {
        return 8192;
    }

    public long j(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f63456a;
        long j = (((length + i2) - 1) / i2) * this.f63457b;
        int i3 = this.f63458c;
        return i3 > 0 ? j + ((((i3 + j) - 1) / i3) * this.f63459d) : j;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i2, int i3, a aVar) {
        if (aVar.f63462c == null) {
            return aVar.f63465f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i3);
        System.arraycopy(aVar.f63462c, aVar.f63464e, bArr, i2, min);
        int i4 = aVar.f63464e + min;
        aVar.f63464e = i4;
        if (i4 >= aVar.f63463d) {
            aVar.f63462c = null;
        }
        return min;
    }

    public final byte[] m(a aVar) {
        byte[] bArr = aVar.f63462c;
        if (bArr == null) {
            aVar.f63462c = new byte[i()];
            aVar.f63463d = 0;
            aVar.f63464e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f63462c = bArr2;
        }
        return aVar.f63462c;
    }
}
