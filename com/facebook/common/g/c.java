package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class c {
    public static final boolean mRB;
    public static final boolean mRC;
    public static final boolean mRD;
    @Nullable
    public static b mRE;
    private static boolean mRF;
    private static final byte[] mRG;
    private static final byte[] mRH;
    private static final byte[] mRI;
    private static final byte[] mRJ;
    private static final byte[] mRK;

    static {
        mRB = Build.VERSION.SDK_INT <= 17;
        mRC = Build.VERSION.SDK_INT >= 14;
        mRD = dCU();
        mRE = null;
        mRF = false;
        mRG = Rs("RIFF");
        mRH = Rs("WEBP");
        mRI = Rs("VP8 ");
        mRJ = Rs("VP8L");
        mRK = Rs("VP8X");
    }

    @Nullable
    public static b dCT() {
        b bVar;
        if (mRF) {
            return mRE;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        mRF = true;
        return bVar;
    }

    private static byte[] Rs(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dCU() {
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
        return b(bArr, i + 12, mRK) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, mRI);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, mRJ);
    }

    public static boolean t(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, mRK);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, mRK) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean u(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, mRG) && b(bArr, i + 8, mRH);
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
