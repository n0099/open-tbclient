package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean jTa;
    public static final boolean jTb;
    public static final boolean jTc;
    public static b jTd;
    private static boolean jTe;
    private static final byte[] jTf;
    private static final byte[] jTg;
    private static final byte[] jTh;
    private static final byte[] jTi;
    private static final byte[] jTj;

    static {
        jTa = Build.VERSION.SDK_INT <= 17;
        jTb = Build.VERSION.SDK_INT >= 14;
        jTc = cCe();
        jTd = null;
        jTe = false;
        jTf = GO("RIFF");
        jTg = GO("WEBP");
        jTh = GO("VP8 ");
        jTi = GO("VP8L");
        jTj = GO("VP8X");
    }

    public static b cCd() {
        b bVar;
        if (jTe) {
            return jTd;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        jTe = true;
        return bVar;
    }

    private static byte[] GO(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cCe() {
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
        return a(bArr, i + 12, jTj) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, jTh);
    }

    public static boolean j(byte[] bArr, int i) {
        return a(bArr, i + 12, jTi);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, jTj);
    }

    public static boolean k(byte[] bArr, int i) {
        return a(bArr, i + 12, jTj) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, jTf) && a(bArr, i + 8, jTg);
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
