package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes17.dex */
public class c {
    public static final boolean nvP;
    public static final boolean nvQ;
    public static final boolean nvR;
    @Nullable
    public static b nvS;
    private static boolean nvT;
    private static final byte[] nvU;
    private static final byte[] nvV;
    private static final byte[] nvW;
    private static final byte[] nvX;
    private static final byte[] nvY;

    static {
        nvP = Build.VERSION.SDK_INT <= 17;
        nvQ = Build.VERSION.SDK_INT >= 14;
        nvR = dTc();
        nvS = null;
        nvT = false;
        nvU = UY("RIFF");
        nvV = UY("WEBP");
        nvW = UY("VP8 ");
        nvX = UY("VP8L");
        nvY = UY("VP8X");
    }

    @Nullable
    public static b dTb() {
        b bVar;
        if (nvT) {
            return nvS;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        nvT = true;
        return bVar;
    }

    private static byte[] UY(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dTc() {
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
        return b(bArr, i + 12, nvY) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean k(byte[] bArr, int i) {
        return b(bArr, i + 12, nvW);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, nvX);
    }

    public static boolean u(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, nvY);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, nvY) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean v(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, nvU) && b(bArr, i + 8, nvV);
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
