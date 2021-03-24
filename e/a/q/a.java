package e.a.q;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f67438a = new char[64];

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f67439b;

    static {
        char c2 = 'A';
        int i = 0;
        while (c2 <= 'Z') {
            f67438a[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f67438a[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f67438a[i] = c4;
            c4 = (char) (c4 + 1);
            i++;
        }
        char[] cArr = f67438a;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        f67439b = new byte[128];
        int i2 = 0;
        while (true) {
            byte[] bArr = f67439b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            f67439b[f67438a[i3]] = (byte) i3;
        }
    }

    public static char[] a(byte[] bArr) {
        return b(bArr, bArr.length);
    }

    public static char[] b(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = ((i * 4) + 2) / 3;
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i) {
            int i8 = i6 + 1;
            int i9 = bArr[i6] & 255;
            if (i8 < i) {
                i2 = i8 + 1;
                i3 = bArr[i8] & 255;
            } else {
                i2 = i8;
                i3 = 0;
            }
            if (i2 < i) {
                i4 = bArr[i2] & 255;
                i2++;
            } else {
                i4 = 0;
            }
            int i10 = i9 >>> 2;
            int i11 = ((i9 & 3) << 4) | (i3 >>> 4);
            int i12 = ((i3 & 15) << 2) | (i4 >>> 6);
            int i13 = i4 & 63;
            int i14 = i7 + 1;
            char[] cArr2 = f67438a;
            cArr[i7] = cArr2[i10];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[i11];
            char c2 = com.alipay.sdk.encrypt.a.f1897h;
            cArr[i15] = i15 < i5 ? cArr2[i12] : com.alipay.sdk.encrypt.a.f1897h;
            int i16 = i15 + 1;
            if (i16 < i5) {
                c2 = f67438a[i13];
            }
            cArr[i16] = c2;
            i7 = i16 + 1;
            i6 = i2;
        }
        return cArr;
    }
}
