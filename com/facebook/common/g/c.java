package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    public static final boolean mJA;
    @Nullable
    public static b mJB;
    private static boolean mJC;
    private static final byte[] mJD;
    private static final byte[] mJE;
    private static final byte[] mJF;
    private static final byte[] mJG;
    private static final byte[] mJH;
    public static final boolean mJy;
    public static final boolean mJz;

    static {
        mJy = Build.VERSION.SDK_INT <= 17;
        mJz = Build.VERSION.SDK_INT >= 14;
        mJA = dzI();
        mJB = null;
        mJC = false;
        mJD = QH("RIFF");
        mJE = QH("WEBP");
        mJF = QH("VP8 ");
        mJG = QH("VP8L");
        mJH = QH("VP8X");
    }

    @Nullable
    public static b dzH() {
        b bVar;
        if (mJC) {
            return mJB;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        mJC = true;
        return bVar;
    }

    private static byte[] QH(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dzI() {
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
        return b(bArr, i + 12, mJH) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, mJF);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, mJG);
    }

    public static boolean s(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, mJH);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, mJH) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean t(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, mJD) && b(bArr, i + 8, mJE);
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
