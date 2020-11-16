package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class c {
    public static final boolean oNA;
    @Nullable
    public static b oNB;
    private static boolean oNC;
    private static final byte[] oND;
    private static final byte[] oNE;
    private static final byte[] oNF;
    private static final byte[] oNG;
    private static final byte[] oNH;
    public static final boolean oNy;
    public static final boolean oNz;

    static {
        oNy = Build.VERSION.SDK_INT <= 17;
        oNz = Build.VERSION.SDK_INT >= 14;
        oNA = eky();
        oNB = null;
        oNC = false;
        oND = XO("RIFF");
        oNE = XO("WEBP");
        oNF = XO("VP8 ");
        oNG = XO("VP8L");
        oNH = XO("VP8X");
    }

    @Nullable
    public static b ekx() {
        b bVar;
        if (oNC) {
            return oNB;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        oNC = true;
        return bVar;
    }

    private static byte[] XO(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean eky() {
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

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, oNH) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, oNF);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, oNG);
    }

    public static boolean w(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, oNH);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, oNH) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, oND) && b(bArr, i + 8, oNE);
    }

    private static boolean b(byte[] bArr, int i, byte[] bArr2) {
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
