package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes19.dex */
public class c {
    public static final boolean pcI;
    public static final boolean pcJ;
    public static final boolean pcK;
    @Nullable
    public static b pcL;
    private static boolean pcM;
    private static final byte[] pcN;
    private static final byte[] pcO;
    private static final byte[] pcP;
    private static final byte[] pcQ;
    private static final byte[] pcR;

    static {
        pcI = Build.VERSION.SDK_INT <= 17;
        pcJ = Build.VERSION.SDK_INT >= 14;
        pcK = eqo();
        pcL = null;
        pcM = false;
        pcN = Zj("RIFF");
        pcO = Zj("WEBP");
        pcP = Zj("VP8 ");
        pcQ = Zj("VP8L");
        pcR = Zj("VP8X");
    }

    @Nullable
    public static b eqn() {
        b bVar;
        if (pcM) {
            return pcL;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        pcM = true;
        return bVar;
    }

    private static byte[] Zj(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean eqo() {
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
        return b(bArr, i + 12, pcR) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, pcP);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, pcQ);
    }

    public static boolean w(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, pcR);
    }

    public static boolean p(byte[] bArr, int i) {
        return b(bArr, i + 12, pcR) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, pcN) && b(bArr, i + 8, pcO);
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
