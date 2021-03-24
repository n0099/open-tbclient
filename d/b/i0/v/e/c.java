package d.b.i0.v.e;

import android.graphics.BitmapFactory;
import android.util.Log;
/* loaded from: classes4.dex */
public class c {
    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int b(int i) {
        if (i == 6) {
            return 90;
        }
        if (i == 3) {
            return 180;
        }
        return i == 8 ? 270 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0066, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0067, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0068, code lost:
        if (r3 <= 8) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006a, code lost:
        r2 = d(r11, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0071, code lost:
        if (r2 == 1229531648) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
        if (r2 == 1296891946) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0078, code lost:
        android.util.Log.e("CameraExif", "Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007e, code lost:
        if (r2 != 1229531648) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
        r2 = d(r11, r1 + 4, 4, r6) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
        if (r2 < 10) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008d, code lost:
        if (r2 <= r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0090, code lost:
        r1 = r1 + r2;
        r3 = r3 - r2;
        r2 = d(r11, r1 - 2, 2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
        r4 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009a, code lost:
        if (r2 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:
        if (r3 < 12) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a6, code lost:
        if (d(r11, r1, 2, r6) != 274) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a8, code lost:
        r11 = d(r11, r1 + 8, 2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ae, code lost:
        if (r11 == 3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b1, code lost:
        if (r11 == 6) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b3, code lost:
        if (r11 == 8) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b5, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b9, code lost:
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bc, code lost:
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bf, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c5, code lost:
        android.util.Log.e("CameraExif", "Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ca, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00cb, code lost:
        android.util.Log.i("CameraExif", "Orientation not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(byte[] bArr) {
        int i;
        if (bArr == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 + 3 >= bArr.length) {
                break;
            }
            int i3 = i2 + 1;
            if ((bArr[i2] & 255) != 255) {
                break;
            }
            int i4 = bArr[i3] & 255;
            if (i4 != 255) {
                i3++;
                if (i4 != 216 && i4 != 1) {
                    if (i4 != 217 && i4 != 218) {
                        int d2 = d(bArr, i3, 2, false);
                        if (d2 >= 2 && (i = i3 + d2) <= bArr.length) {
                            if (i4 == 225 && d2 >= 8 && d(bArr, i3 + 2, 4, false) == 1165519206 && d(bArr, i3 + 6, 2, false) == 0) {
                                i2 = i3 + 8;
                                int i5 = d2 - 8;
                                break;
                            }
                            i2 = i;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i2 = i3;
        }
        Log.e("CameraExif", "Invalid length");
        return 0;
    }

    public static int d(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }
}
