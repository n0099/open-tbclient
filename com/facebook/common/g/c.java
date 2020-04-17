package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    public static final boolean lSp;
    public static final boolean lSq;
    public static final boolean lSr;
    @Nullable
    public static b lSs;
    private static boolean lSt;
    private static final byte[] lSu;
    private static final byte[] lSv;
    private static final byte[] lSw;
    private static final byte[] lSx;
    private static final byte[] lSy;

    static {
        lSp = Build.VERSION.SDK_INT <= 17;
        lSq = Build.VERSION.SDK_INT >= 14;
        lSr = dnx();
        lSs = null;
        lSt = false;
        lSu = Oc("RIFF");
        lSv = Oc("WEBP");
        lSw = Oc("VP8 ");
        lSx = Oc("VP8L");
        lSy = Oc("VP8X");
    }

    @Nullable
    public static b dnw() {
        b bVar;
        if (lSt) {
            return lSs;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lSt = true;
        return bVar;
    }

    private static byte[] Oc(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dnx() {
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

    public static boolean j(byte[] bArr, int i) {
        return b(bArr, i + 12, lSy) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean k(byte[] bArr, int i) {
        return b(bArr, i + 12, lSw);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, lSx);
    }

    public static boolean r(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lSy);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, lSy) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean s(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lSu) && b(bArr, i + 8, lSv);
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
