package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c {
    public static final boolean oCB;
    public static final boolean oCC;
    public static final boolean oCD;
    @Nullable
    public static b oCE;
    private static boolean oCF;
    private static final byte[] oCG;
    private static final byte[] oCH;
    private static final byte[] oCI;
    private static final byte[] oCJ;
    private static final byte[] oCK;

    static {
        oCB = Build.VERSION.SDK_INT <= 17;
        oCC = Build.VERSION.SDK_INT >= 14;
        oCD = egL();
        oCE = null;
        oCF = false;
        oCG = Xz("RIFF");
        oCH = Xz("WEBP");
        oCI = Xz("VP8 ");
        oCJ = Xz("VP8L");
        oCK = Xz("VP8X");
    }

    @Nullable
    public static b egK() {
        b bVar;
        if (oCF) {
            return oCE;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        oCF = true;
        return bVar;
    }

    private static byte[] Xz(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean egL() {
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

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, oCK) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, oCI);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, oCJ);
    }

    public static boolean w(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, oCK);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, oCK) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, oCG) && b(bArr, i + 8, oCH);
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
