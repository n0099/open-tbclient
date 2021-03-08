package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class c {
    public static final boolean pCi;
    public static final boolean pCj;
    public static final boolean pCk;
    @Nullable
    public static b pCl;
    private static boolean pCm;
    private static final byte[] pCn;
    private static final byte[] pCo;
    private static final byte[] pCp;
    private static final byte[] pCq;
    private static final byte[] pCr;

    static {
        pCi = Build.VERSION.SDK_INT <= 17;
        pCj = Build.VERSION.SDK_INT >= 14;
        pCk = etn();
        pCl = null;
        pCm = false;
        pCn = ZF("RIFF");
        pCo = ZF("WEBP");
        pCp = ZF("VP8 ");
        pCq = ZF("VP8L");
        pCr = ZF("VP8X");
    }

    @Nullable
    public static b etm() {
        b bVar;
        if (pCm) {
            return pCl;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        pCm = true;
        return bVar;
    }

    private static byte[] ZF(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean etn() {
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
        return b(bArr, i + 12, pCr) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, pCp);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, pCq);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, pCr);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, pCr) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean y(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, pCn) && b(bArr, i + 8, pCo);
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
