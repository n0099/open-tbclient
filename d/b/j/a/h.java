package d.b.j.a;

import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f63638a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f63639b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63640c;

    /* renamed from: d  reason: collision with root package name */
    public int f63641d;

    /* renamed from: e  reason: collision with root package name */
    public int f63642e;

    public h() {
        this(0);
    }

    public h(int i) {
        this.f63638a = new int[4];
        this.f63639b = new byte[16];
        this.f63640c = i;
        f();
    }

    public static int a(byte[] bArr, int i) {
        return (int) (d(bArr, i, 4) & 4294967295L);
    }

    public static long d(byte[] bArr, int i, int i2) {
        if (i2 <= 8) {
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j |= (bArr[i + i3] & 255) << (i3 * 8);
            }
            return j;
        }
        throw new IllegalArgumentException("can't read more than eight bytes into a long value");
    }

    public void b(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f63641d += i2;
        int i3 = i + i2;
        int i4 = this.f63642e;
        if (i4 + i2 < 16) {
            System.arraycopy(bArr, i, this.f63639b, i4, i2);
            this.f63642e += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = 16 - i4;
            System.arraycopy(bArr, i, this.f63639b, i4, i5);
            e(this.f63639b, 0);
            i += i5;
        }
        int i6 = i3 - 16;
        while (i <= i6) {
            e(bArr, i);
            i += 16;
        }
        if (i < i3) {
            int i7 = i3 - i;
            this.f63642e = i7;
            System.arraycopy(bArr, i, this.f63639b, 0, i7);
        }
    }

    public long c() {
        int i = 0;
        int rotateLeft = (this.f63641d > 16 ? Integer.rotateLeft(this.f63638a[0], 1) + Integer.rotateLeft(this.f63638a[1], 7) + Integer.rotateLeft(this.f63638a[2], 12) + Integer.rotateLeft(this.f63638a[3], 18) : this.f63638a[2] + XXHash32.PRIME5) + this.f63641d;
        int i2 = this.f63642e - 4;
        while (i <= i2) {
            rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.f63639b, i) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
            i += 4;
        }
        while (i < this.f63642e) {
            rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f63639b[i] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
            i++;
        }
        int i3 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
        int i4 = (i3 ^ (i3 >>> 13)) * XXHash32.PRIME3;
        return (i4 ^ (i4 >>> 16)) & 4294967295L;
    }

    public final void e(byte[] bArr, int i) {
        int[] iArr = this.f63638a;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int rotateLeft = Integer.rotateLeft(i2 + (a(bArr, i) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft2 = Integer.rotateLeft(i3 + (a(bArr, i + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft3 = Integer.rotateLeft(i4 + (a(bArr, i + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft4 = Integer.rotateLeft(i5 + (a(bArr, i + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int[] iArr2 = this.f63638a;
        iArr2[0] = rotateLeft;
        iArr2[1] = rotateLeft2;
        iArr2[2] = rotateLeft3;
        iArr2[3] = rotateLeft4;
        this.f63642e = 0;
    }

    public final void f() {
        int[] iArr = this.f63638a;
        int i = this.f63640c;
        iArr[0] = i + XXHash32.PRIME1 + XXHash32.PRIME2;
        iArr[1] = XXHash32.PRIME2 + i;
        iArr[2] = i;
        iArr[3] = i - XXHash32.PRIME1;
    }
}
