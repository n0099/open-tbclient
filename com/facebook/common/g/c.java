package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean hXM;
    public static final boolean hXN;
    public static final boolean hXO;
    public static b hXP;
    private static boolean hXQ;
    private static final byte[] hXR;
    private static final byte[] hXS;
    private static final byte[] hXT;
    private static final byte[] hXU;
    private static final byte[] hXV;

    static {
        hXM = Build.VERSION.SDK_INT <= 17;
        hXN = Build.VERSION.SDK_INT >= 14;
        hXO = bSd();
        hXP = null;
        hXQ = false;
        hXR = yz("RIFF");
        hXS = yz("WEBP");
        hXT = yz("VP8 ");
        hXU = yz("VP8L");
        hXV = yz("VP8X");
    }

    public static b bSc() {
        b bVar;
        if (hXQ) {
            return hXP;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        hXQ = true;
        return bVar;
    }

    private static byte[] yz(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean bSd() {
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
        return a(bArr, i + 12, hXV) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, hXT);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, hXU);
    }

    public static boolean l(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, hXV);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, hXV) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, hXR) && a(bArr, i + 8, hXS);
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
