package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean jSZ;
    public static final boolean jTa;
    public static final boolean jTb;
    public static b jTc;
    private static boolean jTd;
    private static final byte[] jTe;
    private static final byte[] jTf;
    private static final byte[] jTg;
    private static final byte[] jTh;
    private static final byte[] jTi;

    static {
        jSZ = Build.VERSION.SDK_INT <= 17;
        jTa = Build.VERSION.SDK_INT >= 14;
        jTb = cCc();
        jTc = null;
        jTd = false;
        jTe = GO("RIFF");
        jTf = GO("WEBP");
        jTg = GO("VP8 ");
        jTh = GO("VP8L");
        jTi = GO("VP8X");
    }

    public static b cCb() {
        b bVar;
        if (jTd) {
            return jTc;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        jTd = true;
        return bVar;
    }

    private static byte[] GO(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cCc() {
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
        return a(bArr, i + 12, jTi) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, jTg);
    }

    public static boolean j(byte[] bArr, int i) {
        return a(bArr, i + 12, jTh);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, jTi);
    }

    public static boolean k(byte[] bArr, int i) {
        return a(bArr, i + 12, jTi) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, jTe) && a(bArr, i + 8, jTf);
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
