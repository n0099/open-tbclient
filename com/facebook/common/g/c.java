package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean kdK;
    public static final boolean kdL;
    public static final boolean kdM;
    public static b kdN;
    private static boolean kdO;
    private static final byte[] kdP;
    private static final byte[] kdQ;
    private static final byte[] kdR;
    private static final byte[] kdS;
    private static final byte[] kdT;

    static {
        kdK = Build.VERSION.SDK_INT <= 17;
        kdL = Build.VERSION.SDK_INT >= 14;
        kdM = cGn();
        kdN = null;
        kdO = false;
        kdP = Il("RIFF");
        kdQ = Il("WEBP");
        kdR = Il("VP8 ");
        kdS = Il("VP8L");
        kdT = Il("VP8X");
    }

    public static b cGm() {
        b bVar;
        if (kdO) {
            return kdN;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        kdO = true;
        return bVar;
    }

    private static byte[] Il(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cGn() {
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
        return c(bArr, i + 12, kdT) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean i(byte[] bArr, int i) {
        return c(bArr, i + 12, kdR);
    }

    public static boolean j(byte[] bArr, int i) {
        return c(bArr, i + 12, kdS);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 21 && c(bArr, i + 12, kdT);
    }

    public static boolean k(byte[] bArr, int i) {
        return c(bArr, i + 12, kdT) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean o(byte[] bArr, int i, int i2) {
        return i2 >= 20 && c(bArr, i, kdP) && c(bArr, i + 8, kdQ);
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
