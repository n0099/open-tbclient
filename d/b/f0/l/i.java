package d.b.f0.l;

import androidx.exifinterface.media.ExifInterface;
/* loaded from: classes3.dex */
public class i {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = ((bArr[i2] & 255) + (bArr2[i4] & 255) + i3) & 255;
            byte b2 = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
            i2 = (i2 + 1) % bArr.length;
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
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = ((a2[i] & 255) + i2) & 255;
            byte b2 = a2[i];
            a2[i] = a2[i2];
            a2[i2] = b2;
            bArr3[i3] = (byte) (a2[((a2[i] & 255) + (a2[i2] & 255)) & 255] ^ bArr[i3]);
            bArr3[i3] = (byte) (bArr3[i3] ^ ExifInterface.START_CODE);
        }
        return bArr3;
    }
}
