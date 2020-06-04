package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    private static final byte[] mnA;
    private static final byte[] mnB;
    private static final byte[] mnC;
    private static final byte[] mnD;
    private static final byte[] mnE;
    public static final boolean mnv;
    public static final boolean mnw;
    public static final boolean mnx;
    @Nullable
    public static b mny;
    private static boolean mnz;

    static {
        mnv = Build.VERSION.SDK_INT <= 17;
        mnw = Build.VERSION.SDK_INT >= 14;
        mnx = dvb();
        mny = null;
        mnz = false;
        mnA = PU("RIFF");
        mnB = PU("WEBP");
        mnC = PU("VP8 ");
        mnD = PU("VP8L");
        mnE = PU("VP8X");
    }

    @Nullable
    public static b dva() {
        b bVar;
        if (mnz) {
            return mny;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        mnz = true;
        return bVar;
    }

    private static byte[] PU(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dvb() {
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
        return b(bArr, i + 12, mnE) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, mnC);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, mnD);
    }

    public static boolean s(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, mnE);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, mnE) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean t(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, mnA) && b(bArr, i + 8, mnB);
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
