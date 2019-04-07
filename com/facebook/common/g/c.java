package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean jAj;
    public static final boolean jAk;
    public static final boolean jAl;
    public static b jAm;
    private static boolean jAn;
    private static final byte[] jAo;
    private static final byte[] jAp;
    private static final byte[] jAq;
    private static final byte[] jAr;
    private static final byte[] jAs;

    static {
        jAj = Build.VERSION.SDK_INT <= 17;
        jAk = Build.VERSION.SDK_INT >= 14;
        jAl = cug();
        jAm = null;
        jAn = false;
        jAo = Ft("RIFF");
        jAp = Ft("WEBP");
        jAq = Ft("VP8 ");
        jAr = Ft("VP8L");
        jAs = Ft("VP8X");
    }

    public static b cuf() {
        b bVar;
        if (jAn) {
            return jAm;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        jAn = true;
        return bVar;
    }

    private static byte[] Ft(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cug() {
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
        return a(bArr, i + 12, jAs) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, jAq);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, jAr);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, jAs);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, jAs) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, jAo) && a(bArr, i + 8, jAp);
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
