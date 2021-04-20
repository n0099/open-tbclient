package d.b.b.a.a.a.a;
/* loaded from: classes.dex */
public class a {
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

    public static b b(byte[] bArr) {
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
        return new b(bArr2, length);
    }
}
