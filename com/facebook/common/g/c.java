package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    public static final boolean lKV;
    public static final boolean lKW;
    @Nullable
    public static b lKX;
    private static boolean lKY;
    private static final byte[] lKZ;
    private static final byte[] lLa;
    private static final byte[] lLb;
    private static final byte[] lLc;
    private static final byte[] lLd;
    public static final boolean sIsExtendedWebpSupported;

    static {
        lKV = Build.VERSION.SDK_INT <= 17;
        lKW = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        lKX = null;
        lKY = false;
        lKZ = OV("RIFF");
        lLa = OV("WEBP");
        lLb = OV("VP8 ");
        lLc = OV("VP8L");
        lLd = OV("VP8X");
    }

    @Nullable
    public static b dlC() {
        b bVar;
        if (lKY) {
            return lKX;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lKY = true;
        return bVar;
    }

    private static byte[] OV(String str) {
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

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, lLd) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, lLb);
    }

    public static boolean p(byte[] bArr, int i) {
        return b(bArr, i + 12, lLc);
    }

    public static boolean q(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lLd);
    }

    public static boolean q(byte[] bArr, int i) {
        return b(bArr, i + 12, lLd) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean r(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lKZ) && b(bArr, i + 8, lLa);
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
