package d.b.o0.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f65142a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65143b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65144c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65145d;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f65146a;

        /* renamed from: b  reason: collision with root package name */
        public long f65147b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f65148c;

        /* renamed from: d  reason: collision with root package name */
        public int f65149d;

        /* renamed from: e  reason: collision with root package name */
        public int f65150e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65151f;

        /* renamed from: g  reason: collision with root package name */
        public int f65152g;

        /* renamed from: h  reason: collision with root package name */
        public int f65153h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f65148c), Integer.valueOf(this.f65152g), Boolean.valueOf(this.f65151f), Integer.valueOf(this.f65146a), Long.valueOf(this.f65147b), Integer.valueOf(this.f65153h), Integer.valueOf(this.f65149d), Integer.valueOf(this.f65150e));
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.f65142a = i;
        this.f65143b = i2;
        this.f65144c = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.f65145d = i4;
    }

    public int a(a aVar) {
        if (aVar.f65148c != null) {
            return aVar.f65149d - aVar.f65150e;
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
        int i = aVar.f65149d;
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
        int i = aVar.f65149d - aVar.f65150e;
        byte[] bArr2 = new byte[i];
        l(bArr2, 0, i, aVar);
        return bArr2;
    }

    public byte[] h(int i, a aVar) {
        byte[] bArr = aVar.f65148c;
        return (bArr == null || bArr.length < aVar.f65149d + i) ? m(aVar) : bArr;
    }

    public int i() {
        return 8192;
    }

    public long j(byte[] bArr) {
        int length = bArr.length;
        int i = this.f65142a;
        long j = (((length + i) - 1) / i) * this.f65143b;
        int i2 = this.f65144c;
        return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.f65145d) : j;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i, int i2, a aVar) {
        if (aVar.f65148c == null) {
            return aVar.f65151f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i2);
        System.arraycopy(aVar.f65148c, aVar.f65150e, bArr, i, min);
        int i3 = aVar.f65150e + min;
        aVar.f65150e = i3;
        if (i3 >= aVar.f65149d) {
            aVar.f65148c = null;
        }
        return min;
    }

    public final byte[] m(a aVar) {
        byte[] bArr = aVar.f65148c;
        if (bArr == null) {
            aVar.f65148c = new byte[i()];
            aVar.f65149d = 0;
            aVar.f65150e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f65148c = bArr2;
        }
        return aVar.f65148c;
    }
}
