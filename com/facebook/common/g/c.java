package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean jAE;
    public static final boolean jAF;
    public static final boolean jAG;
    public static b jAH;
    private static boolean jAI;
    private static final byte[] jAJ;
    private static final byte[] jAK;
    private static final byte[] jAL;
    private static final byte[] jAM;
    private static final byte[] jAN;

    static {
        jAE = Build.VERSION.SDK_INT <= 17;
        jAF = Build.VERSION.SDK_INT >= 14;
        jAG = cua();
        jAH = null;
        jAI = false;
        jAJ = FC("RIFF");
        jAK = FC("WEBP");
        jAL = FC("VP8 ");
        jAM = FC("VP8L");
        jAN = FC("VP8X");
    }

    public static b ctZ() {
        b bVar;
        if (jAI) {
            return jAH;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        jAI = true;
        return bVar;
    }

    private static byte[] FC(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cua() {
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
        return a(bArr, i + 12, jAN) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, jAL);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, jAM);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, jAN);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, jAN) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, jAJ) && a(bArr, i + 8, jAK);
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
