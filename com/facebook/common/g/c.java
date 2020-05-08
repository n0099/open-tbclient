package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    private static final byte[] lSA;
    private static final byte[] lSB;
    private static final byte[] lSC;
    public static final boolean lSt;
    public static final boolean lSu;
    public static final boolean lSv;
    @Nullable
    public static b lSw;
    private static boolean lSx;
    private static final byte[] lSy;
    private static final byte[] lSz;

    static {
        lSt = Build.VERSION.SDK_INT <= 17;
        lSu = Build.VERSION.SDK_INT >= 14;
        lSv = dnu();
        lSw = null;
        lSx = false;
        lSy = Of("RIFF");
        lSz = Of("WEBP");
        lSA = Of("VP8 ");
        lSB = Of("VP8L");
        lSC = Of("VP8X");
    }

    @Nullable
    public static b dnt() {
        b bVar;
        if (lSx) {
            return lSw;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lSx = true;
        return bVar;
    }

    private static byte[] Of(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dnu() {
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
        return b(bArr, i + 12, lSC) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean k(byte[] bArr, int i) {
        return b(bArr, i + 12, lSA);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, lSB);
    }

    public static boolean r(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lSC);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, lSC) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean s(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lSy) && b(bArr, i + 8, lSz);
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
