package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean ilc;
    public static final boolean ild;
    public static final boolean ile;
    public static b ilf;
    private static boolean ilg;
    private static final byte[] ilh;
    private static final byte[] ili;
    private static final byte[] ilj;
    private static final byte[] ilk;
    private static final byte[] ill;

    static {
        ilc = Build.VERSION.SDK_INT <= 17;
        ild = Build.VERSION.SDK_INT >= 14;
        ile = bVc();
        ilf = null;
        ilg = false;
        ilh = zA("RIFF");
        ili = zA("WEBP");
        ilj = zA("VP8 ");
        ilk = zA("VP8L");
        ill = zA("VP8X");
    }

    public static b bVb() {
        b bVar;
        if (ilg) {
            return ilf;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        ilg = true;
        return bVar;
    }

    private static byte[] zA(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean bVc() {
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
        return a(bArr, i + 12, ill) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, ilj);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, ilk);
    }

    public static boolean l(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, ill);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, ill) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, ilh) && a(bArr, i + 8, ili);
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
