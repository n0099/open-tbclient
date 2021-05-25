package d.a.s0.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f64482a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64483b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64484c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64485d;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f64486a;

        /* renamed from: b  reason: collision with root package name */
        public long f64487b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f64488c;

        /* renamed from: d  reason: collision with root package name */
        public int f64489d;

        /* renamed from: e  reason: collision with root package name */
        public int f64490e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64491f;

        /* renamed from: g  reason: collision with root package name */
        public int f64492g;

        /* renamed from: h  reason: collision with root package name */
        public int f64493h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f64488c), Integer.valueOf(this.f64492g), Boolean.valueOf(this.f64491f), Integer.valueOf(this.f64486a), Long.valueOf(this.f64487b), Integer.valueOf(this.f64493h), Integer.valueOf(this.f64489d), Integer.valueOf(this.f64490e));
        }
    }

    public b(int i2, int i3, int i4, int i5) {
        this.f64482a = i2;
        this.f64483b = i3;
        this.f64484c = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.f64485d = i5;
    }

    public int a(a aVar) {
        if (aVar.f64488c != null) {
            return aVar.f64489d - aVar.f64490e;
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
        int i2 = aVar.f64489d;
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
        int i2 = aVar.f64489d - aVar.f64490e;
        byte[] bArr2 = new byte[i2];
        l(bArr2, 0, i2, aVar);
        return bArr2;
    }

    public byte[] h(int i2, a aVar) {
        byte[] bArr = aVar.f64488c;
        return (bArr == null || bArr.length < aVar.f64489d + i2) ? m(aVar) : bArr;
    }

    public int i() {
        return 8192;
    }

    public long j(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f64482a;
        long j = (((length + i2) - 1) / i2) * this.f64483b;
        int i3 = this.f64484c;
        return i3 > 0 ? j + ((((i3 + j) - 1) / i3) * this.f64485d) : j;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i2, int i3, a aVar) {
        if (aVar.f64488c == null) {
            return aVar.f64491f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i3);
        System.arraycopy(aVar.f64488c, aVar.f64490e, bArr, i2, min);
        int i4 = aVar.f64490e + min;
        aVar.f64490e = i4;
        if (i4 >= aVar.f64489d) {
            aVar.f64488c = null;
        }
        return min;
    }

    public final byte[] m(a aVar) {
        byte[] bArr = aVar.f64488c;
        if (bArr == null) {
            aVar.f64488c = new byte[i()];
            aVar.f64489d = 0;
            aVar.f64490e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f64488c = bArr2;
        }
        return aVar.f64488c;
    }
}
