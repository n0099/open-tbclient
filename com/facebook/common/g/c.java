package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static b hZA;
    private static boolean hZB;
    private static final byte[] hZC;
    private static final byte[] hZD;
    private static final byte[] hZE;
    private static final byte[] hZF;
    private static final byte[] hZG;
    public static final boolean hZx;
    public static final boolean hZy;
    public static final boolean hZz;

    static {
        hZx = Build.VERSION.SDK_INT <= 17;
        hZy = Build.VERSION.SDK_INT >= 14;
        hZz = bRy();
        hZA = null;
        hZB = false;
        hZC = yE("RIFF");
        hZD = yE("WEBP");
        hZE = yE("VP8 ");
        hZF = yE("VP8L");
        hZG = yE("VP8X");
    }

    public static b bRx() {
        b bVar;
        if (hZB) {
            return hZA;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        hZB = true;
        return bVar;
    }

    private static byte[] yE(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean bRy() {
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
        return a(bArr, i + 12, hZG) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, hZE);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, hZF);
    }

    public static boolean l(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, hZG);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, hZG) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, hZC) && a(bArr, i + 8, hZD);
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
