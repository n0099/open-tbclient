package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c {
    public static final boolean pAd;
    public static final boolean pAe;
    public static final boolean pAf;
    @Nullable
    public static b pAg;
    private static boolean pAh;
    private static final byte[] pAi;
    private static final byte[] pAj;
    private static final byte[] pAk;
    private static final byte[] pAl;
    private static final byte[] pAm;

    static {
        pAd = Build.VERSION.SDK_INT <= 17;
        pAe = Build.VERSION.SDK_INT >= 14;
        pAf = ete();
        pAg = null;
        pAh = false;
        pAi = Zz("RIFF");
        pAj = Zz("WEBP");
        pAk = Zz("VP8 ");
        pAl = Zz("VP8L");
        pAm = Zz("VP8X");
    }

    @Nullable
    public static b etd() {
        b bVar;
        if (pAh) {
            return pAg;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        pAh = true;
        return bVar;
    }

    private static byte[] Zz(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean ete() {
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
        return b(bArr, i + 12, pAm) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, pAk);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, pAl);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, pAm);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, pAm) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean y(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, pAi) && b(bArr, i + 8, pAj);
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
