package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean ijU;
    public static final boolean ijV;
    public static final boolean ijW;
    public static b ijX;
    private static boolean ijY;
    private static final byte[] ijZ;
    private static final byte[] ika;
    private static final byte[] ikb;
    private static final byte[] ikc;
    private static final byte[] ikd;

    static {
        ijU = Build.VERSION.SDK_INT <= 17;
        ijV = Build.VERSION.SDK_INT >= 14;
        ijW = bUu();
        ijX = null;
        ijY = false;
        ijZ = zk("RIFF");
        ika = zk("WEBP");
        ikb = zk("VP8 ");
        ikc = zk("VP8L");
        ikd = zk("VP8X");
    }

    public static b bUt() {
        b bVar;
        if (ijY) {
            return ijX;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        ijY = true;
        return bVar;
    }

    private static byte[] zk(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean bUu() {
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

    public static boolean f(byte[] bArr, int i) {
        return a(bArr, i + 12, ikd) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, ikb);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, ikc);
    }

    public static boolean l(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, ikd);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, ikd) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, ijZ) && a(bArr, i + 8, ika);
    }

    private static boolean a(byte[] bArr, int i, byte[] bArr2) {
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
