package d.c.b;

import java.security.MessageDigest;
/* loaded from: classes5.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f65038a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String b(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i + i2 <= bArr.length) {
                int i3 = i2 * 2;
                char[] cArr = new char[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = bArr[i5 + i] & 255;
                    int i7 = i4 + 1;
                    char[] cArr2 = f65038a;
                    cArr[i4] = cArr2[i6 >> 4];
                    i4 = i7 + 1;
                    cArr[i7] = cArr2[i6 & 15];
                }
                return new String(cArr, 0, i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static String c(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    return a(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
