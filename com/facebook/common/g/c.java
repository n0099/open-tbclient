package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public class c {
    public static final boolean nlP;
    public static final boolean nlQ;
    public static final boolean nlR;
    @Nullable
    public static b nlS;
    private static boolean nlT;
    private static final byte[] nlU;
    private static final byte[] nlV;
    private static final byte[] nlW;
    private static final byte[] nlX;
    private static final byte[] nlY;

    static {
        nlP = Build.VERSION.SDK_INT <= 17;
        nlQ = Build.VERSION.SDK_INT >= 14;
        nlR = dPe();
        nlS = null;
        nlT = false;
        nlU = Uw("RIFF");
        nlV = Uw("WEBP");
        nlW = Uw("VP8 ");
        nlX = Uw("VP8L");
        nlY = Uw("VP8X");
    }

    @Nullable
    public static b dPd() {
        b bVar;
        if (nlT) {
            return nlS;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        nlT = true;
        return bVar;
    }

    private static byte[] Uw(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dPe() {
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
        return b(bArr, i + 12, nlY) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, nlW);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, nlX);
    }

    public static boolean u(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, nlY);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, nlY) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean v(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, nlU) && b(bArr, i + 8, nlV);
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
