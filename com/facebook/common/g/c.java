package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c {
    public static final boolean nLi;
    public static final boolean nLj;
    public static final boolean nLk;
    @Nullable
    public static b nLl;
    private static boolean nLm;
    private static final byte[] nLn;
    private static final byte[] nLo;
    private static final byte[] nLp;
    private static final byte[] nLq;
    private static final byte[] nLr;

    static {
        nLi = Build.VERSION.SDK_INT <= 17;
        nLj = Build.VERSION.SDK_INT >= 14;
        nLk = dWN();
        nLl = null;
        nLm = false;
        nLn = VM("RIFF");
        nLo = VM("WEBP");
        nLp = VM("VP8 ");
        nLq = VM("VP8L");
        nLr = VM("VP8X");
    }

    @Nullable
    public static b dWM() {
        b bVar;
        if (nLm) {
            return nLl;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        nLm = true;
        return bVar;
    }

    private static byte[] VM(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean dWN() {
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

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, nLr) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, nLp);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, nLq);
    }

    public static boolean w(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, nLr);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, nLr) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, nLn) && b(bArr, i + 8, nLo);
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
