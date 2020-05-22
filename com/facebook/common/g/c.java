package com.facebook.common.g;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    public static final boolean mml;
    public static final boolean mmm;
    public static final boolean mmn;
    @Nullable
    public static b mmo;
    private static boolean mmp;
    private static final byte[] mmq;
    private static final byte[] mmr;
    private static final byte[] mms;
    private static final byte[] mmt;
    private static final byte[] mmu;

    static {
        mml = Build.VERSION.SDK_INT <= 17;
        mmm = Build.VERSION.SDK_INT >= 14;
        mmn = duN();
        mmo = null;
        mmp = false;
        mmq = PT("RIFF");
        mmr = PT("WEBP");
        mms = PT("VP8 ");
        mmt = PT("VP8L");
        mmu = PT("VP8X");
    }

    @Nullable
    public static b duM() {
        b bVar;
        if (mmp) {
            return mmo;
        }
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable th) {
            bVar = null;
        }
        mmp = true;
        return bVar;
    }

    private static byte[] PT(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static boolean duN() {
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
        return b(bArr, i + 12, mmu) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean l(byte[] bArr, int i) {
        return b(bArr, i + 12, mms);
    }

    public static boolean m(byte[] bArr, int i) {
        return b(bArr, i + 12, mmt);
    }

    public static boolean s(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, mmu);
    }

    public static boolean n(byte[] bArr, int i) {
        return b(bArr, i + 12, mmu) && ((bArr[i + 20] & 16) == 16);
    }

    public static boolean t(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, mmq) && b(bArr, i + 8, mmr);
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
