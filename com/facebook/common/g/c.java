package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    public static final boolean kah;
    public static final boolean kai;
    public static final boolean kaj;
    public static b kak;
    private static boolean kal;
    private static final byte[] kam;
    private static final byte[] kan;
    private static final byte[] kao;
    private static final byte[] kap;
    private static final byte[] kaq;

    static {
        kah = Build.VERSION.SDK_INT <= 17;
        kai = Build.VERSION.SDK_INT >= 14;
        kaj = cFe();
        kak = null;
        kal = false;
        kam = HK("RIFF");
        kan = HK("WEBP");
        kao = HK("VP8 ");
        kap = HK("VP8L");
        kaq = HK("VP8X");
    }

    public static b cFd() {
        b bVar;
        if (kal) {
            return kak;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        kal = true;
        return bVar;
    }

    private static byte[] HK(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean cFe() {
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
        return a(bArr, i + 12, kaq) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean i(byte[] bArr, int i) {
        return a(bArr, i + 12, kao);
    }

    public static boolean j(byte[] bArr, int i) {
        return a(bArr, i + 12, kap);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return i2 >= 21 && a(bArr, i + 12, kaq);
    }

    public static boolean k(byte[] bArr, int i) {
        return a(bArr, i + 12, kaq) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean o(byte[] bArr, int i, int i2) {
        return i2 >= 20 && a(bArr, i, kam) && a(bArr, i + 8, kan);
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
