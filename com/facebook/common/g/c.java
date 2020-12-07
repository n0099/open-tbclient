package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes19.dex */
public class c {
    public static final boolean pcG;
    public static final boolean pcH;
    public static final boolean pcI;
    @Nullable
    public static b pcJ;
    private static boolean pcK;
    private static final byte[] pcL;
    private static final byte[] pcM;
    private static final byte[] pcN;
    private static final byte[] pcO;
    private static final byte[] pcP;

    static {
        pcG = Build.VERSION.SDK_INT <= 17;
        pcH = Build.VERSION.SDK_INT >= 14;
        pcI = eqn();
        pcJ = null;
        pcK = false;
        pcL = Zj("RIFF");
        pcM = Zj("WEBP");
        pcN = Zj("VP8 ");
        pcO = Zj("VP8L");
        pcP = Zj("VP8X");
    }

    @Nullable
    public static b eqm() {
        b bVar;
        if (pcK) {
            return pcJ;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        pcK = true;
        return bVar;
    }

    private static byte[] Zj(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean eqn() {
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

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, pcP) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, pcN);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, pcO);
    }

    public static boolean w(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, pcP);
    }

    public static boolean p(byte[] bArr, int i) {
        return b(bArr, i + 12, pcP) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, pcL) && b(bArr, i + 8, pcM);
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
