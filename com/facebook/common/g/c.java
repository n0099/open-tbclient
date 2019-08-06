package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean kbn;
    public static final boolean kbo;
    public static final boolean kbp;
    public static b kbq;
    private static boolean kbr;
    private static final byte[] kbs;
    private static final byte[] kbt;
    private static final byte[] kbu;
    private static final byte[] kbv;
    private static final byte[] kbw;

    static {
        kbn = Build.VERSION.SDK_INT <= 17;
        kbo = Build.VERSION.SDK_INT >= 14;
        kbp = cFz();
        kbq = null;
        kbr = false;
        kbs = HL("RIFF");
        kbt = HL("WEBP");
        kbu = HL("VP8 ");
        kbv = HL("VP8L");
        kbw = HL("VP8X");
    }

    public static b cFy() {
        b bVar;
        if (kbr) {
            return kbq;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        kbr = true;
        return bVar;
    }

    private static byte[] HL(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cFz() {
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

    public static boolean h(byte[] bArr, int i) {
        return a(bArr, i + 12, kbw) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, kbu);
    }

    public static boolean j(byte[] bArr, int i) {
        return a(bArr, i + 12, kbv);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, kbw);
    }

    public static boolean k(byte[] bArr, int i) {
        return a(bArr, i + 12, kbw) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean o(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, kbs) && a(bArr, i + 8, kbt);
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
