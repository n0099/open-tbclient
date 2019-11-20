package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean kbc;
    public static final boolean kbd;
    public static final boolean kbe;
    public static b kbf;
    private static boolean kbg;
    private static final byte[] kbh;
    private static final byte[] kbi;
    private static final byte[] kbj;
    private static final byte[] kbk;
    private static final byte[] kbl;

    static {
        kbc = Build.VERSION.SDK_INT <= 17;
        kbd = Build.VERSION.SDK_INT >= 14;
        kbe = cDj();
        kbf = null;
        kbg = false;
        kbh = GC("RIFF");
        kbi = GC("WEBP");
        kbj = GC("VP8 ");
        kbk = GC("VP8L");
        kbl = GC("VP8X");
    }

    public static b cDi() {
        b bVar;
        if (kbg) {
            return kbf;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        kbg = true;
        return bVar;
    }

    private static byte[] GC(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cDj() {
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
        return c(bArr, i + 12, kbl) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean i(byte[] bArr, int i) {
        return c(bArr, i + 12, kbj);
    }

    public static boolean j(byte[] bArr, int i) {
        return c(bArr, i + 12, kbk);
    }

    public static boolean j(byte[] bArr, int i, int i2) {
        return i2 >= 21 && c(bArr, i + 12, kbl);
    }

    public static boolean k(byte[] bArr, int i) {
        return c(bArr, i + 12, kbl) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean k(byte[] bArr, int i, int i2) {
        return i2 >= 20 && c(bArr, i, kbh) && c(bArr, i + 8, kbi);
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
