package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes11.dex */
public class c {
    public static final boolean lES;
    public static final boolean lET;
    @Nullable
    public static b lEU;
    private static boolean lEV;
    private static final byte[] lEW;
    private static final byte[] lEX;
    private static final byte[] lEY;
    private static final byte[] lEZ;
    private static final byte[] lFa;
    public static final boolean sIsExtendedWebpSupported;

    static {
        lES = Build.VERSION.SDK_INT <= 17;
        lET = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        lEU = null;
        lEV = false;
        lEW = Ox("RIFF");
        lEX = Ox("WEBP");
        lEY = Ox("VP8 ");
        lEZ = Ox("VP8L");
        lFa = Ox("VP8X");
    }

    @Nullable
    public static b diM() {
        b bVar;
        if (lEV) {
            return lEU;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lEV = true;
        return bVar;
    }

    private static byte[] Ox(String str) {
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
        return b(bArr, i + 12, lFa) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, lEY);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, lEZ);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lFa);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, lFa) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean o(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lEW) && b(bArr, i + 8, lEX);
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
