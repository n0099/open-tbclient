package d.b.q.e.c;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[][] f65275a = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};

    /* renamed from: d.b.q.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1778a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f65276a;

        public C1778a(byte[] bArr, int i) {
            this.f65276a = bArr;
        }

        public byte[] a() {
            return this.f65276a;
        }
    }

    public static int a(int i) {
        int i2 = i % 3;
        char c2 = 1;
        if (i2 == 1) {
            i += 2;
            c2 = 2;
        } else if (i2 == 2) {
            i++;
        } else {
            c2 = 0;
        }
        int i3 = (i / 3) * 2;
        return c2 > 0 ? i3 + 1 : i3;
    }

    public static C1778a b(byte[] bArr) {
        int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
        int i = length / 8;
        if (length % 8 > 0) {
            i++;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        int i3 = 8;
        for (int i4 = 0; i4 < bArr.length - 1; i4 += 2) {
            byte b2 = (byte) (((bArr[i4] * 3) + bArr[i4 + 1]) & 255);
            for (int i5 = 2; i5 >= 0; i5--) {
                if (i3 <= 0) {
                    i2++;
                    i3 = 8;
                }
                if (i2 >= i) {
                    break;
                }
                bArr2[i2] = (byte) ((bArr2[i2] << 1) | ((b2 >> i5) & 1));
                i3--;
            }
        }
        if (i3 > 0 && i2 < i) {
            bArr2[i2] = (byte) (bArr2[i2] << i3);
        }
        return new C1778a(bArr2, length);
    }

    public static byte[] c(byte[] bArr, int i) {
        int i2;
        byte b2;
        int i3 = i % 3;
        if (i3 == 1) {
            i2 = i + 2;
            b2 = 2;
        } else if (i3 == 2) {
            i2 = i + 1;
            b2 = 1;
        } else {
            i2 = i;
            b2 = 0;
        }
        int i4 = (i2 / 3) * 2;
        if (b2 > 0) {
            i4++;
        }
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        for (byte b3 : bArr) {
            for (int i7 = 7; i7 >= 0; i7--) {
                bArr2[i5] = (byte) ((bArr2[i5] << 1) | ((b3 >> i7) & 1));
                if (i6 % 3 == 2) {
                    byte[][] bArr3 = f65275a;
                    bArr2[i5 + 1] = bArr3[bArr2[i5]][1];
                    bArr2[i5] = bArr3[bArr2[i5]][0];
                    i5 += 2;
                }
                i6++;
                if (i6 == i) {
                    break;
                }
            }
            if (i6 == i) {
                break;
            }
        }
        if (b2 > 0) {
            bArr2[i5] = (byte) (bArr2[i5] << b2);
            byte[][] bArr4 = f65275a;
            bArr2[i5 + 1] = bArr4[bArr2[i5]][1];
            bArr2[i5] = bArr4[bArr2[i5]][0];
            bArr2[i5 + 2] = b2;
        }
        return bArr2;
    }
}
