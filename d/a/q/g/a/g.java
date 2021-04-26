package d.a.q.g.a;

import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f63689a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f63690b;

    /* renamed from: c  reason: collision with root package name */
    public final int f63691c;

    /* renamed from: d  reason: collision with root package name */
    public int f63692d;

    /* renamed from: e  reason: collision with root package name */
    public int f63693e;

    public g() {
        this(0);
    }

    public g(int i2) {
        this.f63689a = new int[4];
        this.f63690b = new byte[16];
        this.f63691c = i2;
        f();
    }

    public static int a(byte[] bArr, int i2) {
        return (int) (d(bArr, i2, 4) & 4294967295L);
    }

    public static long d(byte[] bArr, int i2, int i3) {
        if (i3 <= 8) {
            long j = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                j |= (bArr[i2 + i4] & 255) << (i4 * 8);
            }
            return j;
        }
        throw new IllegalArgumentException("can't read more than eight bytes into a long value");
    }

    public void b(byte[] bArr, int i2, int i3) {
        if (i3 <= 0) {
            return;
        }
        this.f63692d += i3;
        int i4 = i2 + i3;
        int i5 = this.f63693e;
        if (i5 + i3 < 16) {
            System.arraycopy(bArr, i2, this.f63690b, i5, i3);
            this.f63693e += i3;
            return;
        }
        if (i5 > 0) {
            int i6 = 16 - i5;
            System.arraycopy(bArr, i2, this.f63690b, i5, i6);
            e(this.f63690b, 0);
            i2 += i6;
        }
        int i7 = i4 - 16;
        while (i2 <= i7) {
            e(bArr, i2);
            i2 += 16;
        }
        if (i2 < i4) {
            int i8 = i4 - i2;
            this.f63693e = i8;
            System.arraycopy(bArr, i2, this.f63690b, 0, i8);
        }
    }

    public long c() {
        int i2 = 0;
        int rotateLeft = (this.f63692d > 16 ? Integer.rotateLeft(this.f63689a[0], 1) + Integer.rotateLeft(this.f63689a[1], 7) + Integer.rotateLeft(this.f63689a[2], 12) + Integer.rotateLeft(this.f63689a[3], 18) : this.f63689a[2] + XXHash32.PRIME5) + this.f63692d;
        int i3 = this.f63693e - 4;
        while (i2 <= i3) {
            rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.f63690b, i2) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
            i2 += 4;
        }
        while (i2 < this.f63693e) {
            rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f63690b[i2] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
            i2++;
        }
        int i4 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
        int i5 = (i4 ^ (i4 >>> 13)) * XXHash32.PRIME3;
        return (i5 ^ (i5 >>> 16)) & 4294967295L;
    }

    public final void e(byte[] bArr, int i2) {
        int[] iArr = this.f63689a;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int rotateLeft = Integer.rotateLeft(i3 + (a(bArr, i2) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft2 = Integer.rotateLeft(i4 + (a(bArr, i2 + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft3 = Integer.rotateLeft(i5 + (a(bArr, i2 + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft4 = Integer.rotateLeft(i6 + (a(bArr, i2 + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int[] iArr2 = this.f63689a;
        iArr2[0] = rotateLeft;
        iArr2[1] = rotateLeft2;
        iArr2[2] = rotateLeft3;
        iArr2[3] = rotateLeft4;
        this.f63693e = 0;
    }

    public final void f() {
        int[] iArr = this.f63689a;
        int i2 = this.f63691c;
        iArr[0] = i2 + XXHash32.PRIME1 + XXHash32.PRIME2;
        iArr[1] = XXHash32.PRIME2 + i2;
        iArr[2] = i2;
        iArr[3] = i2 - XXHash32.PRIME1;
    }
}
