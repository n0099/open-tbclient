package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public class c {
    @Nullable
    public static b nlA;
    private static boolean nlB;
    private static final byte[] nlC;
    private static final byte[] nlD;
    private static final byte[] nlE;
    private static final byte[] nlF;
    private static final byte[] nlG;
    public static final boolean nlx;
    public static final boolean nly;
    public static final boolean nlz;

    static {
        nlx = Build.VERSION.SDK_INT <= 17;
        nly = Build.VERSION.SDK_INT >= 14;
        nlz = dOV();
        nlA = null;
        nlB = false;
        nlC = Uw("RIFF");
        nlD = Uw("WEBP");
        nlE = Uw("VP8 ");
        nlF = Uw("VP8L");
        nlG = Uw("VP8X");
    }

    @Nullable
    public static b dOU() {
        b bVar;
        if (nlB) {
            return nlA;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        nlB = true;
        return bVar;
    }

    private static byte[] Uw(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dOV() {
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
        return b(bArr, i + 12, nlG) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, nlE);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, nlF);
    }

    public static boolean u(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, nlG);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, nlG) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean v(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, nlC) && b(bArr, i + 8, nlD);
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
