package d.a.q.e.c;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[][] f64105a = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};

    /* renamed from: d.a.q.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1782a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f64106a;

        public C1782a(byte[] bArr, int i2) {
            this.f64106a = bArr;
        }

        public byte[] a() {
            return this.f64106a;
        }
    }

    public static int a(int i2) {
        int i3 = i2 % 3;
        char c2 = 1;
        if (i3 == 1) {
            i2 += 2;
            c2 = 2;
        } else if (i3 == 2) {
            i2++;
        } else {
            c2 = 0;
        }
        int i4 = (i2 / 3) * 2;
        return c2 > 0 ? i4 + 1 : i4;
    }

    public static C1782a b(byte[] bArr) {
        int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
        int i2 = length / 8;
        if (length % 8 > 0) {
            i2++;
        }
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        int i4 = 8;
        for (int i5 = 0; i5 < bArr.length - 1; i5 += 2) {
            byte b2 = (byte) (((bArr[i5] * 3) + bArr[i5 + 1]) & 255);
            for (int i6 = 2; i6 >= 0; i6--) {
                if (i4 <= 0) {
                    i3++;
                    i4 = 8;
                }
                if (i3 >= i2) {
                    break;
                }
                bArr2[i3] = (byte) ((bArr2[i3] << 1) | ((b2 >> i6) & 1));
                i4--;
            }
        }
        if (i4 > 0 && i3 < i2) {
            bArr2[i3] = (byte) (bArr2[i3] << i4);
        }
        return new C1782a(bArr2, length);
    }

    public static byte[] c(byte[] bArr, int i2) {
        int i3;
        byte b2;
        int i4 = i2 % 3;
        if (i4 == 1) {
            i3 = i2 + 2;
            b2 = 2;
        } else if (i4 == 2) {
            i3 = i2 + 1;
            b2 = 1;
        } else {
            i3 = i2;
            b2 = 0;
        }
        int i5 = (i3 / 3) * 2;
        if (b2 > 0) {
            i5++;
        }
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        for (byte b3 : bArr) {
            for (int i8 = 7; i8 >= 0; i8--) {
                bArr2[i6] = (byte) ((bArr2[i6] << 1) | ((b3 >> i8) & 1));
                if (i7 % 3 == 2) {
                    byte[][] bArr3 = f64105a;
                    bArr2[i6 + 1] = bArr3[bArr2[i6]][1];
                    bArr2[i6] = bArr3[bArr2[i6]][0];
                    i6 += 2;
                }
                i7++;
                if (i7 == i2) {
                    break;
                }
            }
            if (i7 == i2) {
                break;
            }
        }
        if (b2 > 0) {
            bArr2[i6] = (byte) (bArr2[i6] << b2);
            byte[][] bArr4 = f64105a;
            bArr2[i6 + 1] = bArr4[bArr2[i6]][1];
            bArr2[i6] = bArr4[bArr2[i6]][0];
            bArr2[i6 + 2] = b2;
        }
        return bArr2;
    }
}
