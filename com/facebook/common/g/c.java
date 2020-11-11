package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c {
    public static final boolean oLU;
    public static final boolean oLV;
    public static final boolean oLW;
    @Nullable
    public static b oLX;
    private static boolean oLY;
    private static final byte[] oLZ;
    private static final byte[] oMa;
    private static final byte[] oMb;
    private static final byte[] oMc;
    private static final byte[] oMd;

    static {
        oLU = Build.VERSION.SDK_INT <= 17;
        oLV = Build.VERSION.SDK_INT >= 14;
        oLW = ekA();
        oLX = null;
        oLY = false;
        oLZ = Yd("RIFF");
        oMa = Yd("WEBP");
        oMb = Yd("VP8 ");
        oMc = Yd("VP8L");
        oMd = Yd("VP8X");
    }

    @Nullable
    public static b ekz() {
        b bVar;
        if (oLY) {
            return oLX;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        oLY = true;
        return bVar;
    }

    private static byte[] Yd(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean ekA() {
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
        return b(bArr, i + 12, oMd) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, oMb);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, oMc);
    }

    public static boolean w(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, oMd);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, oMd) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, oLZ) && b(bArr, i + 8, oMa);
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
