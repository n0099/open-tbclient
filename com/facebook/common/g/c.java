package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    public static final boolean lJc;
    public static final boolean lJd;
    @Nullable
    public static b lJe;
    private static boolean lJf;
    private static final byte[] lJg;
    private static final byte[] lJh;
    private static final byte[] lJi;
    private static final byte[] lJj;
    private static final byte[] lJk;
    public static final boolean sIsExtendedWebpSupported;

    static {
        lJc = Build.VERSION.SDK_INT <= 17;
        lJd = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        lJe = null;
        lJf = false;
        lJg = OU("RIFF");
        lJh = OU("WEBP");
        lJi = OU("VP8 ");
        lJj = OU("VP8L");
        lJk = OU("VP8X");
    }

    @Nullable
    public static b dlc() {
        b bVar;
        if (lJf) {
            return lJe;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lJf = true;
        return bVar;
    }

    private static byte[] OU(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean isExtendedWebpSupported() {
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

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, lJk) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, lJi);
    }

    public static boolean p(byte[] bArr, int i) {
        return b(bArr, i + 12, lJj);
    }

    public static boolean q(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lJk);
    }

    public static boolean q(byte[] bArr, int i) {
        return b(bArr, i + 12, lJk) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean r(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lJg) && b(bArr, i + 8, lJh);
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
