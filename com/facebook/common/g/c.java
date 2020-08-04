package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class c {
    public static final boolean mRD;
    public static final boolean mRE;
    public static final boolean mRF;
    @Nullable
    public static b mRG;
    private static boolean mRH;
    private static final byte[] mRI;
    private static final byte[] mRJ;
    private static final byte[] mRK;
    private static final byte[] mRL;
    private static final byte[] mRM;

    static {
        mRD = Build.VERSION.SDK_INT <= 17;
        mRE = Build.VERSION.SDK_INT >= 14;
        mRF = dCV();
        mRG = null;
        mRH = false;
        mRI = Rs("RIFF");
        mRJ = Rs("WEBP");
        mRK = Rs("VP8 ");
        mRL = Rs("VP8L");
        mRM = Rs("VP8X");
    }

    @Nullable
    public static b dCU() {
        b bVar;
        if (mRH) {
            return mRG;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        mRH = true;
        return bVar;
    }

    private static byte[] Rs(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dCV() {
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
        return b(bArr, i + 12, mRM) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, mRK);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, mRL);
    }

    public static boolean t(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, mRM);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, mRM) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean u(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, mRI) && b(bArr, i + 8, mRJ);
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
