package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    public static final boolean lJe;
    public static final boolean lJf;
    @Nullable
    public static b lJg;
    private static boolean lJh;
    private static final byte[] lJi;
    private static final byte[] lJj;
    private static final byte[] lJk;
    private static final byte[] lJl;
    private static final byte[] lJm;
    public static final boolean sIsExtendedWebpSupported;

    static {
        lJe = Build.VERSION.SDK_INT <= 17;
        lJf = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        lJg = null;
        lJh = false;
        lJi = OU("RIFF");
        lJj = OU("WEBP");
        lJk = OU("VP8 ");
        lJl = OU("VP8L");
        lJm = OU("VP8X");
    }

    @Nullable
    public static b dle() {
        b bVar;
        if (lJh) {
            return lJg;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        lJh = true;
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
        return b(bArr, i + 12, lJm) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, lJk);
    }

    public static boolean p(byte[] bArr, int i) {
        return b(bArr, i + 12, lJl);
    }

    public static boolean q(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, lJm);
    }

    public static boolean q(byte[] bArr, int i) {
        return b(bArr, i + 12, lJm) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean r(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, lJi) && b(bArr, i + 8, lJj);
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
