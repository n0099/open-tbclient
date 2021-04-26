package d.a.g0.l;
/* loaded from: classes2.dex */
public class i {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) i2;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            i4 = ((bArr[i3] & 255) + (bArr2[i5] & 255) + i4) & 255;
            byte b2 = bArr2[i5];
            bArr2[i5] = bArr2[i4];
            bArr2[i4] = b2;
            i3 = (i3 + 1) % bArr.length;
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return d(bArr, bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return d(bArr, bArr2);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] a2 = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) & 255;
            i3 = ((a2[i2] & 255) + i3) & 255;
            byte b2 = a2[i2];
            a2[i2] = a2[i3];
            a2[i3] = b2;
            bArr3[i4] = (byte) (a2[((a2[i2] & 255) + (a2[i3] & 255)) & 255] ^ bArr[i4]);
            bArr3[i4] = (byte) (bArr3[i4] ^ 42);
        }
        return bArr3;
    }
}
