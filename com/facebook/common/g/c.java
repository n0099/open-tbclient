package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class c {
    private static final byte[] lIA;
    private static final byte[] lIB;
    private static final byte[] lIC;
    private static final byte[] lID;
    public static final boolean lIv;
    public static final boolean lIw;
    @Nullable
    public static b lIx;
    private static boolean lIy;
    private static final byte[] lIz;
    public static final boolean sIsExtendedWebpSupported;

    static {
        lIv = Build.VERSION.SDK_INT <= 17;
        lIw = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        lIx = null;
        lIy = false;
        lIz = OH("RIFF");
        lIA = OH("WEBP");
        lIB = OH("VP8 ");
        lIC = OH("VP8L");
        lID = OH("VP8X");
    }

    @Nullable
    public static b djP() {
        b bVar;
        if (lIy) {
            return lIx;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lIy = true;
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
        return b(bArr, i + 12, lID) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, lIB);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, lIC);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lID);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, lID) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lIz) && b(bArr, i + 8, lIA);
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
