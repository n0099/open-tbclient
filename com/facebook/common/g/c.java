package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    public static final boolean lJp;
    public static final boolean lJq;
    @Nullable
    public static b lJr;
    private static boolean lJs;
    private static final byte[] lJt;
    private static final byte[] lJu;
    private static final byte[] lJv;
    private static final byte[] lJw;
    private static final byte[] lJx;
    public static final boolean sIsExtendedWebpSupported;

    static {
        lJp = Build.VERSION.SDK_INT <= 17;
        lJq = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        lJr = null;
        lJs = false;
        lJt = OV("RIFF");
        lJu = OV("WEBP");
        lJv = OV("VP8 ");
        lJw = OV("VP8L");
        lJx = OV("VP8X");
    }

    @Nullable
    public static b dlf() {
        b bVar;
        if (lJs) {
            return lJr;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lJs = true;
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
        return b(bArr, i + 12, lJx) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, lJv);
    }

    public static boolean p(byte[] bArr, int i) {
        return b(bArr, i + 12, lJw);
    }

    public static boolean q(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lJx);
    }

    public static boolean q(byte[] bArr, int i) {
        return b(bArr, i + 12, lJx) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean r(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lJt) && b(bArr, i + 8, lJu);
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
