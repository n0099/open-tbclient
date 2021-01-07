package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    public static final boolean ptV;
    public static final boolean ptW;
    public static final boolean ptX;
    @Nullable
    public static b ptY;
    private static boolean ptZ;
    private static final byte[] pua;
    private static final byte[] pub;
    private static final byte[] puc;
    private static final byte[] pud;
    private static final byte[] pue;

    static {
        ptV = Build.VERSION.SDK_INT <= 17;
        ptW = Build.VERSION.SDK_INT >= 14;
        ptX = eux();
        ptY = null;
        ptZ = false;
        pua = Zt("RIFF");
        pub = Zt("WEBP");
        puc = Zt("VP8 ");
        pud = Zt("VP8L");
        pue = Zt("VP8X");
    }

    @Nullable
    public static b euw() {
        b bVar;
        if (ptZ) {
            return ptY;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        ptZ = true;
        return bVar;
    }

    private static byte[] Zt(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean eux() {
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
        return b(bArr, i + 12, pue) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, puc);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, pud);
    }

    public static boolean y(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, pue);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, pue) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean z(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, pua) && b(bArr, i + 8, pub);
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
