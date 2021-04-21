package d.b.q.g.a;

import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f65370a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f65371b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65372c;

    /* renamed from: d  reason: collision with root package name */
    public int f65373d;

    /* renamed from: e  reason: collision with root package name */
    public int f65374e;

    public g() {
        this(0);
    }

    public g(int i) {
        this.f65370a = new int[4];
        this.f65371b = new byte[16];
        this.f65372c = i;
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
        this.f65373d += i2;
        int i3 = i + i2;
        int i4 = this.f65374e;
        if (i4 + i2 < 16) {
            System.arraycopy(bArr, i, this.f65371b, i4, i2);
            this.f65374e += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = 16 - i4;
            System.arraycopy(bArr, i, this.f65371b, i4, i5);
            e(this.f65371b, 0);
            i += i5;
        }
        int i6 = i3 - 16;
        while (i <= i6) {
            e(bArr, i);
            i += 16;
        }
        if (i < i3) {
            int i7 = i3 - i;
            this.f65374e = i7;
            System.arraycopy(bArr, i, this.f65371b, 0, i7);
        }
    }

    public long c() {
        int i = 0;
        int rotateLeft = (this.f65373d > 16 ? Integer.rotateLeft(this.f65370a[0], 1) + Integer.rotateLeft(this.f65370a[1], 7) + Integer.rotateLeft(this.f65370a[2], 12) + Integer.rotateLeft(this.f65370a[3], 18) : this.f65370a[2] + XXHash32.PRIME5) + this.f65373d;
        int i2 = this.f65374e - 4;
        while (i <= i2) {
            rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.f65371b, i) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
            i += 4;
        }
        while (i < this.f65374e) {
            rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f65371b[i] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
            i++;
        }
        int i3 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
        int i4 = (i3 ^ (i3 >>> 13)) * XXHash32.PRIME3;
        return (i4 ^ (i4 >>> 16)) & 4294967295L;
    }

    public final void e(byte[] bArr, int i) {
        int[] iArr = this.f65370a;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int rotateLeft = Integer.rotateLeft(i2 + (a(bArr, i) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft2 = Integer.rotateLeft(i3 + (a(bArr, i + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft3 = Integer.rotateLeft(i4 + (a(bArr, i + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft4 = Integer.rotateLeft(i5 + (a(bArr, i + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int[] iArr2 = this.f65370a;
        iArr2[0] = rotateLeft;
        iArr2[1] = rotateLeft2;
        iArr2[2] = rotateLeft3;
        iArr2[3] = rotateLeft4;
        this.f65374e = 0;
    }

    public final void f() {
        int[] iArr = this.f65370a;
        int i = this.f65372c;
        iArr[0] = i + XXHash32.PRIME1 + XXHash32.PRIME2;
        iArr[1] = XXHash32.PRIME2 + i;
        iArr[2] = i;
        iArr[3] = i - XXHash32.PRIME1;
    }
}
