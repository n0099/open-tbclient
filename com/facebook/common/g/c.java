package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean kbT;
    public static final boolean kbU;
    public static final boolean kbV;
    public static b kbW;
    private static boolean kbX;
    private static final byte[] kbY;
    private static final byte[] kbZ;
    private static final byte[] kca;
    private static final byte[] kcb;
    private static final byte[] kcc;

    static {
        kbT = Build.VERSION.SDK_INT <= 17;
        kbU = Build.VERSION.SDK_INT >= 14;
        kbV = cDl();
        kbW = null;
        kbX = false;
        kbY = GC("RIFF");
        kbZ = GC("WEBP");
        kca = GC("VP8 ");
        kcb = GC("VP8L");
        kcc = GC("VP8X");
    }

    public static b cDk() {
        b bVar;
        if (kbX) {
            return kbW;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        kbX = true;
        return bVar;
    }

    private static byte[] GC(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cDl() {
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

    public static boolean h(byte[] bArr, int i) {
        return c(bArr, i + 12, kcc) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean i(byte[] bArr, int i) {
        return c(bArr, i + 12, kca);
    }

    public static boolean j(byte[] bArr, int i) {
        return c(bArr, i + 12, kcb);
    }

    public static boolean l(byte[] bArr, int i, int i2) {
        return i2 >= 21 && c(bArr, i + 12, kcc);
    }

    public static boolean k(byte[] bArr, int i) {
        return c(bArr, i + 12, kcc) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 20 && c(bArr, i, kbY) && c(bArr, i + 8, kbZ);
    }

    private static boolean c(byte[] bArr, int i, byte[] bArr2) {
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
