package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes14.dex */
public class c {
    private static final byte[] ppA;
    private static final byte[] ppB;
    private static final byte[] ppC;
    private static final byte[] ppD;
    public static final boolean ppu;
    public static final boolean ppv;
    public static final boolean ppw;
    @Nullable
    public static b ppx;
    private static boolean ppy;
    private static final byte[] ppz;

    static {
        ppu = Build.VERSION.SDK_INT <= 17;
        ppv = Build.VERSION.SDK_INT >= 14;
        ppw = eqD();
        ppx = null;
        ppy = false;
        ppz = Ym("RIFF");
        ppA = Ym("WEBP");
        ppB = Ym("VP8 ");
        ppC = Ym("VP8L");
        ppD = Ym("VP8X");
    }

    @Nullable
    public static b eqC() {
        b bVar;
        if (ppy) {
            return ppx;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        ppy = true;
        return bVar;
    }

    private static byte[] Ym(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean eqD() {
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
        return b(bArr, i + 12, ppD) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, ppB);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, ppC);
    }

    public static boolean x(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, ppD);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, ppD) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean y(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, ppz) && b(bArr, i + 8, ppA);
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
