package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class c {
    public static final boolean lIq;
    public static final boolean lIr;
    @Nullable
    public static b lIs;
    private static boolean lIt;
    private static final byte[] lIu;
    private static final byte[] lIv;
    private static final byte[] lIw;
    private static final byte[] lIx;
    private static final byte[] lIy;
    public static final boolean sIsExtendedWebpSupported;

    static {
        lIq = Build.VERSION.SDK_INT <= 17;
        lIr = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        lIs = null;
        lIt = false;
        lIu = OH("RIFF");
        lIv = OH("WEBP");
        lIw = OH("VP8 ");
        lIx = OH("VP8L");
        lIy = OH("VP8X");
    }

    @Nullable
    public static b djN() {
        b bVar;
        if (lIt) {
            return lIs;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lIt = true;
        return bVar;
    }

    private static byte[] OH(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean isExtendedWebpSupported() {
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
        return b(bArr, i + 12, lIy) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, lIw);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, lIx);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lIy);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, lIy) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lIu) && b(bArr, i + 8, lIv);
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
