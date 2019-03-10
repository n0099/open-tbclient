package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean jAX;
    public static final boolean jAY;
    public static final boolean jAZ;
    public static b jBa;
    private static boolean jBb;
    private static final byte[] jBc;
    private static final byte[] jBd;
    private static final byte[] jBe;
    private static final byte[] jBf;
    private static final byte[] jBg;

    static {
        jAX = Build.VERSION.SDK_INT <= 17;
        jAY = Build.VERSION.SDK_INT >= 14;
        jAZ = cuk();
        jBa = null;
        jBb = false;
        jBc = FF("RIFF");
        jBd = FF("WEBP");
        jBe = FF("VP8 ");
        jBf = FF("VP8L");
        jBg = FF("VP8X");
    }

    public static b cuj() {
        b bVar;
        if (jBb) {
            return jBa;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        jBb = true;
        return bVar;
    }

    private static byte[] FF(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cuk() {
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
        return a(bArr, i + 12, jBg) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, jBe);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, jBf);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, jBg);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, jBg) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, jBc) && a(bArr, i + 8, jBd);
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
