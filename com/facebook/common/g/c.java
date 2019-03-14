package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean jAP;
    public static final boolean jAQ;
    public static final boolean jAR;
    public static b jAS;
    private static boolean jAT;
    private static final byte[] jAU;
    private static final byte[] jAV;
    private static final byte[] jAW;
    private static final byte[] jAX;
    private static final byte[] jAY;

    static {
        jAP = Build.VERSION.SDK_INT <= 17;
        jAQ = Build.VERSION.SDK_INT >= 14;
        jAR = cun();
        jAS = null;
        jAT = false;
        jAU = FD("RIFF");
        jAV = FD("WEBP");
        jAW = FD("VP8 ");
        jAX = FD("VP8L");
        jAY = FD("VP8X");
    }

    public static b cum() {
        b bVar;
        if (jAT) {
            return jAS;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        jAT = true;
        return bVar;
    }

    private static byte[] FD(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cun() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (Build.VERSION.SDK_INT == 17) {
            byte[] decode = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(byte[] bArr, int i) {
        return a(bArr, i + 12, jAY) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, jAW);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, jAX);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, jAY);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, jAY) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, jAU) && a(bArr, i + 8, jAV);
    }

    private static boolean a(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
