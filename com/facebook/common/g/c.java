package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    public static final boolean ptO;
    public static final boolean ptP;
    public static final boolean ptQ;
    @Nullable
    public static b ptR;
    private static boolean ptS;
    private static final byte[] ptT;
    private static final byte[] ptU;
    private static final byte[] ptV;
    private static final byte[] ptW;
    private static final byte[] ptX;

    static {
        ptO = Build.VERSION.SDK_INT <= 17;
        ptP = Build.VERSION.SDK_INT >= 14;
        ptQ = euq();
        ptR = null;
        ptS = false;
        ptT = Zu("RIFF");
        ptU = Zu("WEBP");
        ptV = Zu("VP8 ");
        ptW = Zu("VP8L");
        ptX = Zu("VP8X");
    }

    @Nullable
    public static b eup() {
        b bVar;
        if (ptS) {
            return ptR;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        ptS = true;
        return bVar;
    }

    private static byte[] Zu(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean euq() {
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
        return b(bArr, i + 12, ptX) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, ptV);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, ptW);
    }

    public static boolean y(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, ptX);
    }

    public static boolean o(byte[] bArr, int i) {
        return b(bArr, i + 12, ptX) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean z(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, ptT) && b(bArr, i + 8, ptU);
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
