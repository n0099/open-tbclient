package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c {
    public static final boolean pzD;
    public static final boolean pzE;
    public static final boolean pzF;
    @Nullable
    public static b pzG;
    private static boolean pzH;
    private static final byte[] pzI;
    private static final byte[] pzJ;
    private static final byte[] pzK;
    private static final byte[] pzL;
    private static final byte[] pzM;

    static {
        pzD = Build.VERSION.SDK_INT <= 17;
        pzE = Build.VERSION.SDK_INT >= 14;
        pzF = esW();
        pzG = null;
        pzH = false;
        pzI = Zn("RIFF");
        pzJ = Zn("WEBP");
        pzK = Zn("VP8 ");
        pzL = Zn("VP8L");
        pzM = Zn("VP8X");
    }

    @Nullable
    public static b esV() {
        b bVar;
        if (pzH) {
            return pzG;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        pzH = true;
        return bVar;
    }

    private static byte[] Zn(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean esW() {
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

    public static boolean k(byte[] bArr, int i) {
        return b(bArr, i + 12, pzM) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, pzK);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, pzL);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, pzM);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, pzM) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean y(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, pzI) && b(bArr, i + 8, pzJ);
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
