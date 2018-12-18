package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean igK;
    public static final boolean igL;
    public static final boolean igM;
    public static b igN;
    private static boolean igO;
    private static final byte[] igP;
    private static final byte[] igQ;
    private static final byte[] igR;
    private static final byte[] igS;
    private static final byte[] igT;

    static {
        igK = Build.VERSION.SDK_INT <= 17;
        igL = Build.VERSION.SDK_INT >= 14;
        igM = bTD();
        igN = null;
        igO = false;
        igP = zh("RIFF");
        igQ = zh("WEBP");
        igR = zh("VP8 ");
        igS = zh("VP8L");
        igT = zh("VP8X");
    }

    public static b bTC() {
        b bVar;
        if (igO) {
            return igN;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        igO = true;
        return bVar;
    }

    private static byte[] zh(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean bTD() {
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
        return a(bArr, i + 12, igT) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean g(byte[] bArr, int i) {
        return a(bArr, i + 12, igR);
    }

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, igS);
    }

    public static boolean l(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, igT);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, igT) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean m(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, igP) && a(bArr, i + 8, igQ);
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
